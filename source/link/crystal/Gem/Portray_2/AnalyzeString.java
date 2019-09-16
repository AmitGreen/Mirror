//  Copyright (c) 2018-2019 Amit Green.  All rights reserved.


package link.crystal.Gem.Portray_2;


import java.lang.Character;
import java.lang.String;
import link.crystal.Capital.Core.Capital_Object;
import link.crystal.Capital.Inspection.Inspection;
import link.crystal.Capital.Interface.Inspectable;
import link.crystal.Gem.Portray_1.AsciiTable;
import link.crystal.Gem.Portray_2.EphemeralStringState;
import link.crystal.Gem.Portray_1.PortrayString;
import link.crystal.Gem.Portray_2.OverallStringState;


//
//  How to combine OverallStringState with EphemeralStringState.
//
//      1.  Do we want a raw string?  (And can we do a raw string?)
//
//          1A. Do we prefer Apostrophe?
//
//                  Then use the `OverallStringState.RA` to choose either:
//
//                      `EphemeralStringState.RA` OR
//                      `EphemeralStringState.RQ`
//
//                  Normally it will pick the `.RA` member;
//
//                      Only Exception:
//
//                          When the string starts with an apostrophe `'`, then it will pick the `.RQ` member
//                          (so the string is quoted with `"` if possible).
//
//          1B.  Do we prefer quotation marks?
//
//                  Then use the `OverallStringState.RQ` to choose either:
//
//                      `EphemeralStringState.RA` OR
//                      `EphemeralStringState.RQ`
//
//                  Normally it will pick the `.RA` member;
//
//                      Only Exception:
//
//                          When the string starts with a quotation mark `"`, then it will pick the `.RA` member
//                          (so the string is quoted with `'` if possible).
//
//      2.  Are we going to do a normal string?
//
//          2A. Do we prefer Apostrophe?
//
//                  Then use `OverallStringState.PA` to choose either:
//
//                      `EphemeralStringState.PC` OR
//                      `EphemeralStringState.PS` OR
//
//                          -- OR -- (if there is a backslash in the string)
//
//                      `EphemeralStringState.KC` OR
//                      `EphemeralStringState.KS` OR
//
//                  Normally it will pick the `.PC` or `.KC` member;
//
//                      Only Exception:
//
//                          When the string starts with an apostrophe `'`, then it will pick the `.PS` or `.KS` member
//                          (so the string is quoted with `"` if possible).
//
//          2A. Do we prefer Quotation Mark?
//
//                  Then use `OverallStringState.PQ` to choose either:
//
//                      `EphemeralStringState.PC` OR
//                      `EphemeralStringState.PS` OR
//
//                          -- OR -- (if there is a backslash in the string)
//
//                      `EphemeralStringState.KC` OR
//                      `EphemeralStringState.KS` OR
//
//                  Normally it will pick the `.PS` or `.KS` member;
//
//                      Only Exception:
//
//                          When the string starts with a quotation mark `"`, then it will pick the `.PC` or `.KC` member
//                          (so the string is quoted with `'` if possible).
//
public abstract class   AnalyzeString
    extends             Capital_Object
//  extends             Object
{
    //
    //  Array indexes
    //
    public static final int                     RA =  1;        //  Raw String with '
    public static final int                     RQ =  2;        //  Raw String with "
    public static final int                     KC =  3;        //  Backslash & '''
    public static final int                     KS =  4;        //  Backslash & """
    public static final int                     PC =  5;        //  Normal & '''
    public static final int                     PS =  6;        //  Normal & """

    public static final int                     KA =  7;        //  Backslash & '
    public static final int                     KQ =  8;        //  Backslash & "
    public static final int                     PA =  9;        //  Normal & '
    public static final int                     PQ = 10;        //  Normal & "
    public static final int                     RC = 11;        //  Raw String with '''
    public static final int                     RS = 12;        //  Raw String with """

    public static final String[]                index_names = new String[] {
            "0",
            "RA", "RQ", "KC", "KS", "PC", "PS",
            "KA", "KQ", "PA", "PQ", "RC", "RS",
        };


    //
    //   States (overall)
    //
    //       A = Starts with '
    //       E = Empty
    //       G = General
    //       K = Backslash
    //       L = Lemon (Unprintable)
    //       Q = Starts with "
    //
    private static final OverallStringState     AG = OverallStringState.create("AG");
    private static final OverallStringState     AK = OverallStringState.create("AK");
    private static final OverallStringState     AL = OverallStringState.create("AL");
    private static final OverallStringState     EE = OverallStringState.create("EE");
    private static final OverallStringState     GG = OverallStringState.create("GG");
    private static final OverallStringState     GK = OverallStringState.create("GK");
    private static final OverallStringState     GL = OverallStringState.create("GL");
    private static final OverallStringState     QG = OverallStringState.create("QG");
    private static final OverallStringState     QK = OverallStringState.create("QK");
    private static final OverallStringState     QL = OverallStringState.create("QL");


    //
    //  States ('has' & ending)
    //
    //      A = '
    //      B = ''
    //      C = '''
    //
    //      K = \
    //      N = normal
    //
    //      Q = "
    //      R = ""
    //      S = """
    //
    private static final EphemeralStringState   state(final String debug_name)
    {
        return EphemeralStringState.create(debug_name);
    }


    private static final EphemeralStringState   A_A  = state("A_A");    //  Has '; ends in '
    private static final EphemeralStringState   A_B  = state("A_B");    //  Has '; ends in ''
    private static final EphemeralStringState   A_K  = state("A_K");    //  Has '; ends in \
    private static final EphemeralStringState   A_N  = state("A_N");    //  Has '

    private static final EphemeralStringState   AQ_A = state("AQ_A");   //  Has ' & "; ends in '
    private static final EphemeralStringState   AQ_B = state("AQ_B");   //  Has ' & "; ends in ''
    private static final EphemeralStringState   AQ_K = state("AQ_K");   //  Has ' & "; ends in \
    private static final EphemeralStringState   AQ_N = state("AQ_N");   //  Has ' & "
    private static final EphemeralStringState   AQ_Q = state("AQ_Q");   //  Has ' & "; ends in "
    private static final EphemeralStringState   AQ_R = state("AQ_R");   //  Has ' & "; ends in ""

    private static final EphemeralStringState   AS_A = state("AS_A");   //  Has ' & """; ends in '
    private static final EphemeralStringState   AS_B = state("AS_B");   //  Has ' & """; ends in ''
    private static final EphemeralStringState   AS_K = state("AS_K");   //  Has ' & """; ends in \
    private static final EphemeralStringState   AS_N = state("AS_N");   //  Has ' & """
    private static final EphemeralStringState   AS_Q = state("AS_Q");   //  Has ' & """; ends in "   or \"
    private static final EphemeralStringState   AS_R = state("AS_R");   //  Has ' & """; ends in ""
    private static final EphemeralStringState   AS_S = state("AS_S");   //  Has ' & """; ends in """

    private static final EphemeralStringState   C_A  = state("C_A");    //  Has '''; ends in '
    private static final EphemeralStringState   C_B  = state("C_B");    //  Has '''; ends in ''
    private static final EphemeralStringState   C_C  = state("C_C");    //  Has '''; ends in '''
    private static final EphemeralStringState   C_K  = state("C_K");    //  Has '''; ends in \
    private static final EphemeralStringState   C_N  = state("C_N");    //  Has '''

    private static final EphemeralStringState   CQ_A = state("CQ_A");   //  Has ''' & "; ends in '
    private static final EphemeralStringState   CQ_B = state("CQ_B");   //  Has ''' & "; ends in ''
    private static final EphemeralStringState   CQ_C = state("CQ_C");   //  Has ''' & "; ends in '''
    private static final EphemeralStringState   CQ_K = state("CQ_K");   //  Has ''' & "; ends in \
    private static final EphemeralStringState   CQ_N = state("CQ_N");   //  Has ''' & "
    private static final EphemeralStringState   CQ_Q = state("CQ_Q");   //  Has ''' & "; ends in "
    private static final EphemeralStringState   CQ_R = state("CQ_R");   //  Has ''' & "; ends in ""

    private static final EphemeralStringState   CS_A = state("CS_A");   //  Has ''' & """; ends in '
    private static final EphemeralStringState   CS_B = state("CS_B");   //  Has ''' & """; ends in ''
    private static final EphemeralStringState   CS_C = state("CS_C");   //  Has ''' & """; ends in '''
    private static final EphemeralStringState   CS_N = state("CS_N");   //  Has ''' & """
    private static final EphemeralStringState   CS_Q = state("CS_Q");   //  Has ''' & """; ends in "
    private static final EphemeralStringState   CS_R = state("CS_R");   //  Has ''' & """; ends in ""
    private static final EphemeralStringState   CS_S = state("CS_S");   //  Has ''' & """; ends in """

    private static final EphemeralStringState   N_K  = state("N_K");    //  normal; ends in \
    private static final EphemeralStringState   N_N  = state("N_N");    //  normal

    private static final EphemeralStringState   Q_K  = state("Q_K");    //  Has "; ends in \
    private static final EphemeralStringState   Q_N  = state("Q_N");    //  Has "
    private static final EphemeralStringState   Q_Q  = state("Q_Q");    //  Has "; ends in "
    private static final EphemeralStringState   Q_R  = state("Q_R");    //  Has "; ends in ""

    private static final EphemeralStringState   S_K  = state("S_K");    //  Has """: ends in \
    private static final EphemeralStringState   S_N  = state("S_N");    //  Has """
    private static final EphemeralStringState   S_Q  = state("S_Q");    //  Has """; ends in "
    private static final EphemeralStringState   S_R  = state("S_R");    //  Has """; ends in ""
    private static final EphemeralStringState   S_S  = state("S_S");    //  Has """; ends in """


    private static final boolean        finish()
    {
        final OverallStringState        x = null;

        //            '    G    \    L    "  ra  rq  pc  ps, K  L
        AG.overall(AG, AG, AK, AL, AG, RQ,  x, PS,  x, x, x);
        AK.overall(AK, AK, AK, AL, AK, RQ,  x, KS,  x, 7, x);
        AL.overall(AL, AL, AL, AL, AL, 0,   x, KS,  x, x, 7);
        EE.overall(AG, GG, GK, GL, QG, RA, RQ, PC, PS, x, x);
        GG.overall(GG, GG, GK, GL, GG, RA, RQ, PC, PS, x, x);
        GK.overall(GK, GK, GK, GL, GK, RA, RQ, KC, KS, 7, x);
        GL.overall(GL, GL, GL, GL, GL, 0,   x, KC, KS, x, 7);
        QG.overall(QG, QG, QK, QL, QG, RA,  x, PC,  x, x, x);
        QK.overall(QK, QK, QK, QL, QK, RA,  x, KC,  x, 7, x);
        QL.overall(QL, QL, QL, QL, QL, 0,   x, KC,  x, x, 7);

        //          '     \     N     "     ra  rq  kc  ks  pc  ps, F3
        A_A  .setup(A_B,  A_K,  A_N,  AQ_Q, RQ,  x, KQ,  x, PQ,  x,  x);    //  Has '; ends in '
        A_B  .setup(C_C,  A_K,  A_N,  AQ_Q, RQ,  x, KQ,  x, PQ,  x,  x);    //  Has '; ends in ''
        A_K  .setup(A_N,  A_N,  A_N,  A_N,   0,  x, KQ,  x,  0,  x,  x);    //  Has '; ends in \
        A_N  .setup(A_A,  A_K,  A_N,  AQ_Q, RQ,  x, KQ,  x, PQ,  x,  x);    //  Has '

        //          '     \     N     "     ra  rq  kc  ks  pc  ps, F3
        AQ_A .setup(AQ_B, AQ_K, AQ_N, AQ_Q, RS,  x, KS,  x, KS,  x,  x);    //  Has ' & "; ends in '
        AQ_B .setup(CQ_C, AQ_K, AQ_N, AQ_Q, RS,  x, KS,  x, KS,  x,  x);    //  Has ' & "; ends in ''
        AQ_K .setup(AQ_N, AQ_N, AQ_N, AQ_N,  0,  x, KC, KS,  0,  x,  x);    //  Has ' & "; ends in \
        AQ_N .setup(AQ_A, AQ_K, AQ_N, AQ_Q, RC, RS, KC, KS, PC, PS,  x);    //  Has ' & "
        AQ_Q .setup(AQ_A, AQ_K, AQ_N, AQ_R, RC,  x, KC,  x, KC,  x,  x);    //  Has ' & "; ends in "
        AQ_R .setup(AQ_A, AQ_K, AQ_N, AS_S, RC,  x, KC,  x, KC,  x,  x);    //  Has ' & "; ends in ""

        //          '     \     N     "     ra  rq  kc  ks  pc  ps, F3
        AS_A .setup(AS_B, AS_K, AS_N, AS_Q,  0,  x, KS,  x, KS,  x,  x);    //  Has ' & """; ends in '
        AS_B .setup(CS_C, AS_K, AS_N, AS_Q,  0,  x, KS,  x, KS,  x,  x);    //  Has ' & """; ends in ''
        AS_K .setup(AS_N, AS_N, AS_N, AS_N,  0,  x, KC,  x,  0,  x,  x);    //  Has ' & """; ends in \
        AS_N .setup(AS_A, AS_K, AS_N, AS_Q, RC,  x, KC,  x, PC,  x,  x);    //  Has ' & """
        AS_Q .setup(AS_A, AS_K, AS_N, AS_R, RC,  x, KC,  x, KC,  x,  x);    //  Has ' & """; ends in "
        AS_R .setup(AS_A, AS_K, AS_N, AS_S, RC,  x, KC,  x, KC,  x,  x);    //  Has ' & """; ends in ""
        AS_S .setup(AS_A, AS_K, AS_N, AS_R, RC,  x, KC,  x, KC,  x,  1);    //  Has ' & """; ends in """

        //          '     \     N     "     ra  rq  kc  ks  pc  ps, F3
        C_A  .setup(C_B,  C_K,  C_N,  CQ_Q, RQ,  x, KQ,  x, PQ,  x,  x);    //  Has '''; ends in '
        C_B  .setup(C_C,  C_K,  C_N,  CQ_Q, RQ,  x, KQ,  x, PQ,  x,  x);    //  Has '''; ends in ''
        C_C  .setup(C_B,  C_K,  C_N,  CQ_Q, RQ,  x, KQ,  x, PQ,  x, -1);    //  Has '''; ends in '''
        C_K  .setup(C_N,  C_N,  C_N,  C_N,   0,  x, KQ,  x,  0,  x,  x);    //  Has '''; ends in \
        C_N  .setup(C_A,  C_K,  C_N,  CQ_Q, RQ,  x, KQ,  x, PQ,  x,  x);    //  Has '''

        //          '     \     N     "     ra  rq  kc  ks  pc  ps, F3
        CQ_A .setup(CQ_B, CQ_K, CQ_N, CQ_Q, RS,  x, KS,  x, PS,  x,  x);    //  Has ''' & "; ends in '
        CQ_B .setup(CQ_C, CQ_K, CQ_N, CQ_Q, RS,  x, KS,  x, PS,  x,  x);    //  Has ''' & "; ends in ''
        CQ_C .setup(CQ_B, CQ_K, CQ_N, CQ_Q, RS,  x, KS,  x, PS,  x, -1);    //  Has ''' & "; ends in '''
        CQ_K .setup(CQ_N, CQ_N, CQ_N, CQ_N,  0,  x, KS,  x,  0,  x,  x);    //  Has ''' & "; ends in \
        CQ_N .setup(CQ_A, CQ_K, CQ_N, CQ_Q, RS,  x, KS,  x, PS,  x,  x);    //  Has ''' & "
        CQ_Q .setup(CQ_A, CQ_K, CQ_N, CQ_R,  0,  x, KC,  x, KC,  x,  x);    //  Has ''' & "; ends in "
        CQ_R .setup(CQ_A, CQ_K, CQ_N, CS_S,  0,  x, KC,  x, KC,  x,  x);    //  Has ''' & "; ends in ""

        //          '     \     N     "     ra  rq  kc  ks  pc  ps, F3
        CS_A .setup(CS_B, CS_N, CS_N, CS_Q,  0,  x, KS, x,  KS,  x,  x);    //  Has ''' & """; ends in '
        CS_B .setup(CS_C, CS_N, CS_N, CS_Q,  0,  x, KS, x,  KS,  x,  x);    //  Has ''' & """; ends in ''
        CS_C .setup(CS_B, CS_N, CS_N, CS_Q,  0,  x, KS, x,  KS,  x, -1);    //  Has ''' & """; ends in '''
        CS_N .setup(CS_A, CS_N, CS_N, CS_Q,  0,  x, KC, KS, PC, PS,  x);    //  Has ''' & """
        CS_Q .setup(CS_A, CS_N, CS_N, CS_R,  0,  x, KC, x,  KC,  x,  x);    //  Has ''' & """; ends in "
        CS_R .setup(CS_A, CS_N, CS_N, CS_S,  0,  x, KC, x,  KC,  x,  x);    //  Has ''' & """; ends in ""
        CS_S .setup(CS_A, CS_N, CS_N, CS_R,  0,  x, KC, x,  KC,  x,  1);    //  Has ''' & """; ends in """

        //          '     \     N     "     ra  rq  kc  ks  pc  ps, F3
        N_K  .setup(N_N,  N_N,  N_N,  N_N,   0,  x, KA, KS,  0,  x,  x);    //  normal; ends in \
        N_N  .setup(A_A,  N_K,  N_N,  Q_Q,  RA, RQ, KA, KS, PC, PS,  x);    //  normal

        //          '     \     N     "     ra  rq  kc  ks  pc  ps, F3
        Q_K  .setup(Q_N,  Q_N,  Q_N,  Q_N,   0,  x, KA,  x,  0,  x,  x);    //  Has "; ends in \
        Q_N  .setup(AQ_A, Q_K,  Q_N,  Q_Q,  RA,  x, KA,  x, PA,  x,  x);    //  Has "
        Q_Q  .setup(AQ_A, Q_K,  Q_N,  Q_R,  RA,  x, KA,  x, PA,  x,  x);    //  Has "; ends in "
        Q_R  .setup(AQ_A, Q_K,  Q_N,  S_S,  RA,  x, KA,  x, PA,  x,  x);    //  Has "; ends in ""

        //          '     \     N     "     ra  rq  kc  ks  pc  ps, F3
        S_K  .setup(S_N,  S_N,  S_N,  S_N,   0,  x, KA,  x,  0,  x,  x);    //   Has """: ends in \
        S_N  .setup(AS_A, S_K,  S_N,  S_Q,  RA,  x, KA,  x, PA,  x,  x);    //   Has """
        S_Q  .setup(AS_A, S_K,  S_N,  S_R,  RA,  x, KA,  x, PA,  x,  x);    //   Has """; ends in "
        S_R  .setup(AS_A, S_K,  S_N,  S_S,  RA,  x, KA,  x, PA,  x,  x);    //   Has """; ends in ""
        S_S  .setup(AS_A, S_K,  S_N,  S_R,  RA,  x, KA,  x, PA,  x,  1);    //   Has """; ends in """

        EphemeralStringState.remove_cache__ALLY__AnalyzeString();

        return true;
    }


    private static final boolean        finished = finish();


    public static String                analyze_python_string(final String s)
    {
        /*:*/ OverallStringState        overall = AnalyzeString.EE;
        final AsciiTable[]              table   = AsciiTable.table;

        final int                       total = s.length();

        /*:*/ int                       code_point = 0;
        /*:*/ int                       i          = 0;
        /*:*/ AsciiTable                glyph      = null;

        for (;;) {
            if (i == total) {
//              trace("{+}: completed: {} -- going to call {}",
//                    overall,
//                    PortrayString.normal_with_apostrophe.abbreviation);

                return PortrayString.normal_with_apostrophe.portray_string(s);
            }

            code_point = s.codePointAt(i);

            if (code_point >= 128) {
                i += Character.charCount(code_point);
                break;
            }

            i ++;

            glyph = table[code_point];

            if ( ! glyph.is_boring_printable) {
                break;
            }

            overall = AnalyzeString.GG;
        }

        /*:*/ int                   favorite;
        /*:*/ EphemeralStringState  state;
        /*:*/ EphemeralStringState  raw_state;

        if (code_point == 34) {                                         //  34 = ordinal('"')
            overall  = overall.Q;
            favorite = 1;

            raw_state =
                state = AnalyzeString.Q_Q;
        } else if (code_point == 39) {                                  //  39 = ordinal("'")
            overall   = overall.A;
            favorite  = -1;

            raw_state =
                state = AnalyzeString.A_A;
        } else if (code_point == 92) {                                  //  92 = ordinal('\\')
            overall   = overall.K;
            favorite  = 0;
            raw_state = AnalyzeString.N_K;
            state     = AnalyzeString.N_N;
        } else {
            overall   = overall.L;
            favorite  = 0;

            raw_state =
                state = AnalyzeString.N_N;
        }

        /*:*/ int                   C = 0;
        /*:*/ int                   S = 0;

        while (i < total) {
            code_point = s.codePointAt(i);

            if (code_point >= 128) {
                overall   = overall.L;
                state     = state.N;
                raw_state = raw_state.N;

                i += Character.charCount(code_point);
                continue;
            }

            i ++;

            glyph = table[code_point];

            if (glyph.is_boring_printable) {
                overall   = overall.G;
                state     = state.N;
                raw_state = raw_state.N;
                continue;
            }

            if (code_point == 34) {                                     //  34 = ordinal('"')
                overall   = overall.Q;
                state     = state.Q;
                raw_state = raw_state.Q;
                favorite += 1;
                S        -= state.favorite_3;
                continue;
            }

            if (code_point == 39) {                                     //  39 = ordinal("'")
                overall   = overall.A;
                state     = state.A;
                raw_state = raw_state.A;
                favorite -= 1;
                C        += state.favorite_3;
                continue;
            }

            if (code_point == 92) {                                     //  92 = ordinal('\\')
                overall   = overall.K;
                raw_state = raw_state.K;
                state     = state.N;
                continue;
            }

            overall   = overall.L;
            raw_state = raw_state.N;
            state     = state.N;
        }

        if (false) {
            trace("{+}:  overall:  {p}", overall);
            trace("{+}: favorite:  {p}", favorite);
            trace("{+}:    state:  {p}", state);
            trace("{+}:raw_state:  {p}", raw_state);
            trace("{+}:        C:  {p}", C);
            trace("{+}:        S:  {p}", S);
        }

        if ( ( (S == C) && (favorite >= 0) ) || (S > C) ) {
            //
            //  Prefer apostrophe `'`
            //
            if (overall.is_K) {
                final PortrayString     raw = raw_state.portray_functions[overall.ra];      //  ra * raw

                if (raw.is_valid) {
//                  trace("{+}: Going to call: {}", raw.abbreviation);

                    return raw.portray_string(s);
                }
            }

            final PortrayString         normal = state.portray_functions[overall.pa];       //  pa * normal

//          trace("{+}: Going to call: {}", normal.abbreviation);

            return normal.portray_string(s);
        }

        //
        //  Prefer apostrophe `"`
        //
        if (overall.is_K) {
            final PortrayString     raw = raw_state.portray_functions[overall.rq];          //  rq * raw

            if (raw.is_valid) {
//              trace("{+}: Going to call: {}", raw.abbreviation);

                return raw.portray_string(s);
            }
        }

        final PortrayString         normal = state.portray_functions[overall.pq];           //  pq * normal

//      trace("{+}: Going to call: {}", normal.abbreviation);

        return normal.portray_string(s);
    }


    public static String                analyze_raw_string(final String s)
    {
        /*:*/ OverallStringState        overall = AnalyzeString.EE;
        final AsciiTable[]              table   = AsciiTable.table;

        final int                       total = s.length();

        /*:*/ int                       code_point = 0;
        /*:*/ int                       i          = 0;
        /*:*/ AsciiTable                glyph      = null;

        for (;;) {
            if (i == total) {
//              trace("{+}: completed: {} -- going to call {}",
//                   overall, PortrayString.raw_with_apostrophe.abbreviation);

                return PortrayString.raw_with_apostrophe.portray_string(s);
            }

            code_point = s.codePointAt(i);

            if (code_point >= 128) {
                i += Character.charCount(code_point);
                break;
            }

            i ++;

            glyph = table[code_point];

            if ( ! glyph.is_boring_printable) {
                break;
            }

            overall = AnalyzeString.GG;
        }

        /*:*/ int                   favorite;
        /*:*/ EphemeralStringState  state;
        /*:*/ EphemeralStringState  raw_state;

        if (code_point == 34) {                                         //  34 = ordinal('"')
            overall  = overall.Q;
            favorite = 1;

            raw_state =
                state = AnalyzeString.Q_Q;
        } else if (code_point == 39) {                                  //  39 = ordinal("'")
            overall   = overall.A;
            favorite  = -1;

            raw_state =
                state = AnalyzeString.A_A;
        } else if (code_point == 92) {                                  //  92 = ordinal('\\')
            overall   = overall.K;
            favorite  = 0;
            raw_state = AnalyzeString.N_K;
            state     = AnalyzeString.N_N;
        } else {
            overall   = overall.L;
            favorite  = 0;

            raw_state =
                state = AnalyzeString.N_N;
        }

        /*:*/ int                   C = 0;
        /*:*/ int                   S = 0;

        while (i < total) {
            code_point = s.codePointAt(i);

            if (code_point >= 128) {
                overall   = overall.L;
                state     = state.N;
                raw_state = raw_state.N;

                i += Character.charCount(code_point);
                continue;
            }

            i ++;

            glyph = table[code_point];

            if (glyph.is_boring_printable) {
                overall   = overall.G;
                state     = state.N;
                raw_state = raw_state.N;
                continue;
            }

            if (code_point == 34) {                                     //  34 = ordinal('"')
                overall   = overall.Q;
                state     = state.Q;
                raw_state = raw_state.Q;
                favorite += 1;
                S        -= state.favorite_3;
                continue;
            }

            if (code_point == 39) {                                     //  39 = ordinal("'")
                overall   = overall.A;
                state     = state.A;
                raw_state = raw_state.A;
                favorite -= 1;
                C        += state.favorite_3;
                continue;
            }

            if (code_point == 92) {                                     //  92 = ordinal('\\')
                overall   = overall.K;
                raw_state = raw_state.K;
                state     = state.N;
                continue;
            }

            overall   = overall.L;
            raw_state = raw_state.N;
            state     = state.N;
        }

        if (false) {
            trace("{+}:         s:  {p}", s);
            trace("{+}:   overall:  {p}", overall);
            trace("{+}:  favorite:  {p}", favorite);
            trace("{+}:     state:  {p}", state);
            trace("{+}: raw_state:  {p}", raw_state);
            trace("{+}:         C:  {p}", C);
            trace("{+}:         S:  {p}", S);
        }

        if ( ( (S == C) && (favorite >= 0) ) || (S > C) ) {
            //
            //  Prefer apostrophe `'`
            //
            final int           raw_index = overall.ra;

            if (raw_index >= 0) {
                final PortrayString     raw = raw_state.portray_functions[raw_index];       //  ra * raw

                if (raw.is_valid) {
//                  trace("{+}: Going to call: {}", raw.abbreviation);

                    return raw.portray_string(s);
                }
            }

            final PortrayString         normal = state.portray_functions[overall.pa];       //  pa * normal

//          trace("{+}: Going to call: {}", normal.abbreviation);

            return normal.portray_string(s);
        }

        //
        //  Prefer apostrophe `"`
        //
        final int           raw_index = overall.rq;

        if (raw_index >= 0) {
            final PortrayString     raw = raw_state.portray_functions[raw_index];           //  rq * raw

            if (raw.is_valid) {
//              trace("{+}: Going to call: {}", raw.abbreviation);

                return raw.portray_string(s);
            }
        }

        final PortrayString         normal = state.portray_functions[overall.pq];           //  pq * normal

//      trace("{+}: Going to call: {}", normal.abbreviation);

        return normal.portray_string(s);
    }


    //
    //  Public (debug)
    //
    public static final void            dump()
    {
        trace("Dump of AnalyzeString");

        if (false) {
            OverallStringState.portray_header("member ");
            trace("AG:  {p}", AnalyzeString.AG);
            trace("AK:  {p}", AnalyzeString.AK);
            trace("AL:  {p}", AnalyzeString.AL);
            trace("EE:  {p}", AnalyzeString.EE);
            trace("GG:  {p}", AnalyzeString.GG);
            trace("GK:  {p}", AnalyzeString.GK);
            trace("GL:  {p}", AnalyzeString.GL);
            trace("QG:  {p}", AnalyzeString.QG);
            trace("QK:  {p}", AnalyzeString.QK);
            trace("QL:  {p}", AnalyzeString.QL);
        }

        trace("---");

        if (true) {
            EphemeralStringState.portray_header(" member  ");
            trace("   A_A:  {p}", AnalyzeString.A_A);
            trace("   A_B:  {p}", AnalyzeString.A_B);
            trace("   A_K:  {p}", AnalyzeString.A_K);
            trace("   A_N:  {p}", AnalyzeString.A_N);
            trace("---");
            trace("  AQ_A:  {p}", AnalyzeString.AQ_A);
            trace("  AQ_B:  {p}", AnalyzeString.AQ_B);
            trace("  AQ_K:  {p}", AnalyzeString.AQ_K);
            trace("  AQ_N:  {p}", AnalyzeString.AQ_N);
            trace("  AQ_Q:  {p}", AnalyzeString.AQ_Q);
            trace("  AQ_R:  {p}", AnalyzeString.AQ_R);
            trace("---");
            trace("  AS_A:  {p}", AnalyzeString.AS_A);
            trace("  AS_B:  {p}", AnalyzeString.AS_B);
            trace("  AS_K:  {p}", AnalyzeString.AS_K);
            trace("  AS_N:  {p}", AnalyzeString.AS_N);
            trace("  AS_Q:  {p}", AnalyzeString.AS_Q);
            trace("  AS_R:  {p}", AnalyzeString.AS_R);
            trace("  AS_S:  {p}", AnalyzeString.AS_S);
            trace("---");
            trace("   C_A:  {p}", AnalyzeString.C_A);
            trace("   C_B:  {p}", AnalyzeString.C_B);
            trace("   C_C:  {p}", AnalyzeString.C_C);
            trace("   C_K:  {p}", AnalyzeString.C_K);
            trace("   C_N:  {p}", AnalyzeString.C_N);
            trace("---");
            trace("  CQ_A:  {p}", AnalyzeString.CQ_A);
            trace("  CQ_B:  {p}", AnalyzeString.CQ_B);
            trace("  CQ_C:  {p}", AnalyzeString.CQ_C);
            trace("  CQ_K:  {p}", AnalyzeString.CQ_K);
            trace("  CQ_N:  {p}", AnalyzeString.CQ_N);
            trace("  CQ_Q:  {p}", AnalyzeString.CQ_Q);
            trace("  CQ_R:  {p}", AnalyzeString.CQ_R);
            trace("---");
            trace("  CS_A:  {p}", AnalyzeString.CS_A);
            trace("  CS_B:  {p}", AnalyzeString.CS_B);
            trace("  CS_C:  {p}", AnalyzeString.CS_C);
            trace("  CS_N:  {p}", AnalyzeString.CS_N);
            trace("  CS_Q:  {p}", AnalyzeString.CS_Q);
            trace("  CS_R:  {p}", AnalyzeString.CS_R);
            trace("  CS_S:  {p}", AnalyzeString.CS_S);
            trace("---");
            trace("   N_K:  {p}", AnalyzeString.N_K);
            trace("   N_N:  {p}", AnalyzeString.N_N);
            trace("---");
            trace("   Q_K:  {p}", AnalyzeString.Q_K);
            trace("   Q_N:  {p}", AnalyzeString.Q_N);
            trace("   Q_Q:  {p}", AnalyzeString.Q_Q);
            trace("   Q_R:  {p}", AnalyzeString.Q_R);
            trace("---");
            trace("   S_K:  {p}", AnalyzeString.S_K);
            trace("   S_N:  {p}", AnalyzeString.S_N);
            trace("   S_Q:  {p}", AnalyzeString.S_Q);
            trace("   S_R:  {p}", AnalyzeString.S_R);
            trace("   S_S:  {p}", AnalyzeString.S_S);
        }

        trace("End of dump of AnalyzeString");
    }


    //
    //  Public (Unit Test)
    //
    public static final void            show_analyze_string(final String s)
    {
        trace("analysis of {p}: {}", s, analyze_python_string(s));
    }
}
