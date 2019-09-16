//  Copyright (c) 2018-2019 Amit Green.  All rights reserved.


package link.crystal.Capital.Support;


import java.lang.String;
import link.crystal.Capital.Core.Zone;
import link.crystal.Capital.Format.NormalSegmentFormatter;
import link.crystal.Capital.Inspection.Inspection;
import link.crystal.Capital.Interface.Inspectable;
import link.crystal.Capital.Support.Storehouse_SmallList;


public final class  Storehouse_NormalSegmentFormatter
    extends         Storehouse_SmallList<Storehouse_NormalSegmentFormatter, NormalSegmentFormatter>
//  extends         Inspectable_Object<Inspection>
//  extends         Object
    implements      Inspectable       <Inspection>//,
{
    private static final Inspection     inspection = Inspection.create("Storehouse_NormalSegmentFormatter");


    //
    //  Static members
    //
    public static final int             initial_capacity = 100;


    //
    //  Constructor & Factory
    //
    private                             Storehouse_NormalSegmentFormatter(
            final Zone                          z,
            final NormalSegmentFormatter[]      segment_many//,
        )
    {
        super(z, segment_many);
    }


    public static final Storehouse_NormalSegmentFormatter   create__ALLY__Zone(final Zone z)
    {
        final NormalSegmentFormatter[]  segment_many = (
                new NormalSegmentFormatter[Storehouse_NormalSegmentFormatter.initial_capacity]
            );

        return new Storehouse_NormalSegmentFormatter(z, segment_many);
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
