//  Copyright (c) 2018-2019 Amit Green.  All rights reserved.


package link.crystal.Capital.Support;


import java.lang.String;
import link.crystal.Capital.Core.Capital_StringSet;
import link.crystal.Capital.Core.Zone;
import link.crystal.Capital.Inspection.Inspection;
import link.crystal.Capital.Interface.Inspectable;
import link.crystal.Capital.Interface.Storehouse_String__Interface;


public final class  Storehouse_String
    extends         Capital_StringSet<Inspection>
//  extends         Capital_Map      <Inspection, String, String>
//  extends         HashMap                      <String, String>
//  extends         AbstractHashMap              <String, String>
//  extends         Object
    implements      Storehouse_String__Interface,
                    Inspectable      <Inspection>//,
{
    private static final Inspection     inspection = Inspection.create("Storehouse_String");


    //
    //  Private static
    //
    private static final int            initial_capacity = 1009;



    //
    //  Constructor & Factory
    //
    private                             Storehouse_String(final Zone z, final int initial_capacity)
    {
        super(z, initial_capacity);
    }


    public static final Storehouse_String   create__ALLY__Zone(final Zone z)
    {
        return new Storehouse_String(z, Storehouse_String.initial_capacity);
    }


    //
    //  Interface Inspectable
    //
    @Override
    public final Inspection             inspect()
    {
        return /*static*/ this.inspection;
    }


    //
    //  Interface Storehouse_String__Interface
    //
    public final String                 intern_permenant_string(final Zone z, final String s)
    {
        assert fact        (this.z == z, "this.z == z");
        assert fact_pointer(s, "s");

        final String                    previous = this.putIfAbsent(s, s);

        if (previous != null) {
            return previous;
        }

        return s;
    }


    public final void                   insert_permenant_string(final Zone z, final String s)
    {
        this.insert(z, s, s);
    }
}
