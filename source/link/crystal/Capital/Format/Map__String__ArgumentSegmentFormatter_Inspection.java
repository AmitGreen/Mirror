//  Copyright (c) 2018-2019 Amit Green.  All rights reserved.


package link.crystal.Capital.Format;


import java.lang.String;
import link.crystal.Capital.Core.Capital_StringMap;
import link.crystal.Capital.Core.Zone;
import link.crystal.Capital.Format.ArgumentSegmentFormatter_Inspection;
import link.crystal.Capital.Format.NormalSegmentFormatter;
import link.crystal.Capital.Format.PortraySegmentFormatter;
import link.crystal.Capital.Format.StringSegmentFormatter;
import link.crystal.Capital.Inspection.Inspection;
import link.crystal.Capital.Interface.Inspectable;


public final class  Map__String__ArgumentSegmentFormatter_Inspection
    extends         Capital_StringMap<Inspection,         ArgumentSegmentFormatter_Inspection>
//  extends         Capital_Map      <Inspection, String, ArgumentSegmentFormatter_Inspection>
//  extends         HashMap                      <String, ArgumentSegmentFormatter_Inspection>
//  extends         AbstractHashMap              <String, ArgumentSegmentFormatter_Inspection>
//  extends         Object
    implements      Inspectable      <Inspection>//,
{
    private static final Inspection     inspection = (
            Inspection.create("Map__String__ArgumentSegmentFormatter_Inspection")
        );


    //
    //  Static members
    //
    private static final int            initial_capacity = 11;



    //
    //  Constructor & Factory
    //
    private                             Map__String__ArgumentSegmentFormatter_Inspection(
            final Zone                          z,
            final int                           initial_capacity//,
        )
    {
        super(z, initial_capacity);
    }


    public static final Map__String__ArgumentSegmentFormatter_Inspection    CREATE_AND_POPULATE(final Zone z)
    {
        Map__String__ArgumentSegmentFormatter_Inspection    r = (
                new Map__String__ArgumentSegmentFormatter_Inspection(
                    z,
                    Map__String__ArgumentSegmentFormatter_Inspection.initial_capacity//,
                )
            );

        r.put("",  NormalSegmentFormatter .inspection);
        r.put("p", PortraySegmentFormatter.inspection);
        r.put("s", StringSegmentFormatter .inspection);

        return r;
    }


    //
    //  Interface Inspectable
    //
    @Override
    public final Inspection             inspect()
    {
        return /*static*/ this.inspection;
    }
}
