//  Copyright (c) 2018-2019 Amit Green.  All rights reserved.


package link.crystal.Capital.Support;


import java.lang.String;
import link.crystal.Capital.Core.Capital_StringMap;
import link.crystal.Capital.Core.Zone;
import link.crystal.Capital.Format.AdornmentSegmentFormatter;
import link.crystal.Capital.Inspection.Inspection;
import link.crystal.Capital.Interface.Inspectable;


public final class  Storehouse_AdornmentSegmentFormatter
    extends         Capital_StringMap<Inspection,         AdornmentSegmentFormatter>
//  extends         Capital_Map      <Inspection, String, AdornmentSegmentFormatter>
//  extends         HashMap                      <String, AdornmentSegmentFormatter>
//  extends         AbstractHashMap              <String, AdornmentSegmentFormatter>
//  extends         Object
    implements      Inspectable      <Inspection>//,
{
    private static final Inspection     inspection = Inspection.create("Storehouse_AdornmentSegmentFormatter");


    //
    //  Static members
    //
    private static final int            initial_capacity = 1009;


    //
    //  Constructor & Factory
    //
    private                             Storehouse_AdornmentSegmentFormatter(final Zone z, final int initial_capacity)
    {
        super(z, initial_capacity);
    }


    public static final Storehouse_AdornmentSegmentFormatter    create__ALLY__Zone(final Zone z)
    {
        return new Storehouse_AdornmentSegmentFormatter(z, Storehouse_AdornmentSegmentFormatter.initial_capacity);
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
