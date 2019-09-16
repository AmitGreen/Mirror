//  Copyright (c) 2018-2019 Amit Green.  All rights reserved.


package link.crystal.Capital.Support;


import java.lang.String;
import link.crystal.Capital.Core.Capital_StringMap;
import link.crystal.Capital.Core.Zone;
import link.crystal.Capital.Format.ParseFormat;
import link.crystal.Capital.Inspection.Inspection;
import link.crystal.Capital.Interface.Inspectable;
import link.crystal.Capital.Interface.MessageFormattable;


public final class  Storehouse_MessageFormattable
    extends         Capital_StringMap<Inspection,         MessageFormattable<?>>
//  extends         HashMap                      <String, MessageFormattable<?>>
//  extends         AbstractHashMap              <String, MessageFormattable<?>>
//  extends         Object
    implements      Inspectable      <Inspection>//,
{
    private static final Inspection     inspection = Inspection.create("Storehouse_MessageFormattable");


    //
    //  Private static
    //
    private static final int                        initial_capacity = 1009;


    //
    //  Constructor & Factory
    //
    private                             Storehouse_MessageFormattable(final Zone z, final int initial_capacity)
    {
        super(z, initial_capacity);
    }


    public static final Storehouse_MessageFormattable   create__ALLY__Zone(final Zone z)
    {
        return new Storehouse_MessageFormattable(z, Storehouse_MessageFormattable.initial_capacity);
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
