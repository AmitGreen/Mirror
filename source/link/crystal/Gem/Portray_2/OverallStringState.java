//  Copyright (c) 2018-2019 Amit Green.  All rights reserved.


package link.crystal.Gem.Portray_2;


import java.lang.String;
import link.crystal.Capital.Core.Inspectable_Object;
import link.crystal.Capital.Core.Capital_StringBuilder;
import link.crystal.Capital.Inspection.Inspection;
import link.crystal.Capital.Interface.Inspectable;
import link.crystal.Gem.Portray_1.AnalyzeString;


public final class      OverallStringState
    extends             Inspectable_Object<Inspection>
//  extends             Object
    implements          Inspectable       <Inspection>//,
{
    private static final Inspection     inspection = Inspection.create("OverallStringState");


    //
    //  Members
    //
    public final String                 debug_name;
    public /*:*/ OverallStringState     A;
    public /*:*/ OverallStringState     G;
    public /*:*/ OverallStringState     K;
    public /*:*/ OverallStringState     L;
    public /*:*/ OverallStringState     Q;
    public /*:*/ int                    ra;
    public /*:*/ int                    rq;
    public /*:*/ int                    pa;
    public /*:*/ int                    pq;
    public /*:*/ boolean                is_K;
    public /*:*/ boolean                is_L;


    //
    //  Constructor, Factory, & Overall initialization
    //
    private                             OverallStringState(final String debug_name)
    {
        this.debug_name = debug_name;

    //  this.A          = vacant
    //  this.G          = vacant
    //  this.K          = vacant
    //  this.L          = vacant
    //  this.Q          = vacant
    //  this.ra         = vacant
    //  this.rq         = vacant
    //  this.pa         = vacant
    //  this.pq         = vacant
    //  this.is_K       = vacant
    //  this.is_L       = vacant
    }


    public static final OverallStringState  create(final String debug_name)
    {
        return new OverallStringState(debug_name);
    }


    public final void                   overall(
            final OverallStringState            A,
            final OverallStringState            G,
            final OverallStringState            K,
            final OverallStringState            L,
            final OverallStringState            Q,
            final Object                        ra,
            final Object                        rq,
            final Object                        pa,
            final Object                        pq,
            final Object                        is_K,
            final Object                        is_L//,
        )
    {
        assert fact_pointer(A, "A");
        assert fact_pointer(G, "G");
        assert fact_pointer(K, "K");
        assert fact_pointer(L, "L");
        assert fact_pointer(Q, "Q");

        if (ra != null) {
            assert fact_between(0, (Integer) ra, 6);
        }

        if (rq != null) {
            assert fact_between(0, (Integer) ra, 6);
        }

        if (pa != null) {
            assert fact_between(0, (Integer) pa, 6);
        }

        if (pq != null) {
            assert fact_between(0, (Integer) pq, 6);
        }

        if (is_K == null) {
            assert fact( ! this.debug_name.contains("K"), "this.debug_name does NOT contain a 'K'");
        } else {
            assert fact(((Integer) is_K) == 7,            "((Integer) is_K) == 7");
            assert fact(this.debug_name.contains("K"),    "this.debug_name contains a 'K'");
        }

        if (is_L == null) {
            assert fact( ! this.debug_name.contains("L"), "this.debug_name does NOT contain an 'L'");
        } else {
            assert fact(((Integer) is_L) == 7,            "((Integer) is_L) == 7");
            assert fact(this.debug_name.contains("L"),    "this.debug_name contains an 'L'");
        }


        final int                       ra_value    = (ra == null ? -1       : (Integer) ra);
        final int                       rq_value    = (rq == null ? ra_value : (Integer) rq);
        final int                       pa_value    = (pa == null ? -1       : (Integer) pa);
        final int                       pq_value    = (pq == null ? pa_value : (Integer) pq);
        final boolean                   is_K__value = (is_K != null);
        final boolean                   is_L__value = (is_L != null);

        this.A    = A;
        this.G    = G;
        this.K    = K;
        this.L    = L;
        this.Q    = Q;
        this.ra   = ra_value - 1;
        this.rq   = rq_value - 1;
        this.pa   = pa_value - 1;
        this.pq   = pq_value - 1;
        this.is_K = is_K__value;
        this.is_L = is_L__value;
    }


    //
    //  Interface Inspectable
    //
    //  NOTE:
    //      Also includes helper function `portray_header` which is not part of `Interface Inspectable`.
    //
    @Override
    public final Inspection             inspect()
    {
        return /*static*/ this.inspection;
    }


    @Override
    public final void                   portray(final Capital_StringBuilder builder)
    {
        final OverallStringState        A  = this.A;
        final OverallStringState        G  = this.G;
        final OverallStringState        K  = this.K;
        final OverallStringState        L  = this.L;
        final OverallStringState        Q  = this.Q;
        final int                       ra = this.ra + 1;
        final int                       rq = this.rq + 1;
        final int                       pa = this.pa + 1;
        final int                       pq = this.pq + 1;

        final String[]                  index_names = AnalyzeString.index_names;

        builder.augment("<OverallStringState {}; {} {} {} {} {}; {} {} {} {}; {} {}>",
                        String.format("%2s", this.debug_name),
                        String.format("%2s", (A  == null ? "." : A.debug_name)),
                        String.format("%2s", (G  == null ? "." : G.debug_name)),
                        String.format("%2s", (K  == null ? "." : K.debug_name)),
                        String.format("%2s", (L  == null ? "." : L.debug_name)),
                        String.format("%2s", (Q  == null ? "." : Q.debug_name)),
                        String.format("%2s", (ra == -1   ? "." : index_names[ra])),
                        String.format("%2s", (rq == -1   ? "." : index_names[rq])),
                        String.format("%2s", (pa == -1   ? "." : index_names[pa])),
                        String.format("%2s", (pq == -1   ? "." : index_names[pq])),
                        (this.is_K    ? "K" : "."),
                        (this.is_L    ? "L" : "."));
    }


    static public final void            portray_header(final String prefix)
    {
        trace("{} -------------- name;  A  G  K  L  Q; ra rq pa pq; K L", prefix);
    }
}
