//  Copyright (c) 2018-2019 Amit Green.  All rights reserved.


package link.crystal.Capital.Support;


import link.crystal.Capital.Core.Zone;
import link.crystal.Capital.Inspection.Comparable_Inspection;
import link.crystal.Capital.Inspection.Capital_Reference_Inspection;
import link.crystal.Capital.Inspection.Inspection;
import link.crystal.Capital.Interface.Capital_ComparableReference_Interface;
import link.crystal.Capital.Interface.Inspectable;
import link.crystal.Capital.Support.Capital_ComparableReference_Cache;
import link.crystal.Capital.Support.World_String_WeakReference;
import link.crystal.Capital.World.World_String;


public final class  World_String_Cache
    extends         Capital_ComparableReference_Cache<
                        Inspection,
                        World_String,
                        Comparable_Inspection,
                        Capital_ComparableReference_Interface<
                            ? extends Capital_Reference_Inspection,
                            World_String,
                            Comparable_Inspection//,
                        >//,
                    >
//  extends         Capital_Map    <Inspection, Capital_ComparableReference_Interface<?, ?, ?>, ...>
//  extends         HashMap        <Inspection, Capital_ComparableReference_Interface<?, ?, ?>, ...>
//  extends         AbstractHashMap<Inspection, Capital_ComparableReference_Interface<?, ?, ?>, ...>
//  extends         Object
    implements      Inspectable    <Inspection>//,
{
    private static final Inspection     inspection = Inspection.create_cache("World_String_Cache");


    //
    //  Static members
    //
    private static final int            initial_capacity = 1009;


    //
    //  Constructor
    //
    private                             World_String_Cache(final Zone z, final int initial_capacity)
    {
        super(z, initial_capacity);
    }


    public static final World_String_Cache  create__ALLY__Capital()
    {
        final Zone                      z = Zone.current_zone();

        return new World_String_Cache(z, World_String_Cache.initial_capacity);
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
