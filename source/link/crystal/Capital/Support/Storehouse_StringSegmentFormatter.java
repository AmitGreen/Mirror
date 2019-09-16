//  Copyright (c) 2018-2019 Amit Green.  All rights reserved.


package link.crystal.Capital.Support;


import java.lang.String;
import link.crystal.Capital.Core.Zone;
import link.crystal.Capital.Format.StringSegmentFormatter;
import link.crystal.Capital.Inspection.Inspection;
import link.crystal.Capital.Interface.Inspectable;
import link.crystal.Capital.Support.Storehouse_SmallList;


public final class  Storehouse_StringSegmentFormatter
    extends         Storehouse_SmallList<Storehouse_StringSegmentFormatter, StringSegmentFormatter>
//  extends         Inspectable_Object<Inspection>
//  extends         Object
    implements      Inspectable       <Inspection>//,
{
    private static final Inspection     inspection = Inspection.create("Storehouse_StringSegmentFormatter");


    //
    //  Static members
    //
    public static final int             initial_capacity = 100;


    //
    //  Constructor & Factory
    //
    private                             Storehouse_StringSegmentFormatter(
            final Zone                          z,
            final StringSegmentFormatter[]      segment_many//,
        )
    {
        super(z, segment_many);
    }


    public static final Storehouse_StringSegmentFormatter   create__ALLY__Zone(final Zone z)
    {
        final StringSegmentFormatter[]     segment_many = (
                new StringSegmentFormatter[Storehouse_StringSegmentFormatter.initial_capacity]
            );

        return new Storehouse_StringSegmentFormatter(z, segment_many);
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
