//  Copyright (c) 2018-2019 Amit Green.  All rights reserved.


package link.crystal.Capital.Support;


import java.lang.Comparable;
import link.crystal.Capital.Core.Capital_StringBuilder;
import link.crystal.Capital.Core.Inspectable_Object;
import link.crystal.Capital.Inspection.Comparable_Inspection;
import link.crystal.Capital.Inspection.Capital_Reference_Inspection;
import link.crystal.Capital.Interface.Capital_Comparable;
import link.crystal.Capital.Interface.Capital_ComparableReference_Interface;
import link.crystal.Capital.Interface.Capital_Reference_Interface;
import link.crystal.Capital.Interface.Inspectable;
import link.crystal.Capital.World.World_String;


public final class  World_String_EnduringReference
    extends         Inspectable_Object               <Capital_Reference_Inspection>
//  extends         Object
    implements      Capital_ComparableReference_Interface<Capital_Reference_Inspection, World_String, Comparable_Inspection>,
                    Capital_Reference_Interface          <Capital_Reference_Inspection>,    //  Via Capital_ComparableReference_Interface
                    Capital_Comparable                   <Capital_Reference_Inspection>,    //  Via Capital_ComparableReference_Interface
                    Comparable<Capital_Comparable<? extends Comparable_Inspection>>,        //  Via Capital_Comparable
                    Inspectable                          <Capital_Reference_Inspection>//,
{
    private static final Capital_Reference_Inspection   inspection = Capital_Reference_Inspection.create(
            "World_String_EnduringReference",
            Comparable_Inspection.CLASS_ORDER__WORLD_STRING_REFERENCE,
            "enduring"//,
        );


    //
    //  Members
    //
    public final World_String           client;


    //
    //  Constructor
    //
    private                             World_String_EnduringReference(final World_String client)
    {
        this.client = client;
    }


    public static final World_String_EnduringReference  create__ALLY__Capital(final World_String client)
    {
        return new World_String_EnduringReference(client);
    }


    //
    //  Ancestor Object
    //
    //  NOTE:
    //      Do not need to override `.equals` -- as `World_String_EnduringReference` are unique (and thus can use
    //      `Object.equals` which uses identity as the equal test).
    //
    @Override
    public final int                    hashCode()
    {
        return this.client.s.hashCode();
    }


    //
    //  NOTE:
    //      Only need to compare to another `World_String_EnduringReference`, by using the identity test `==`` as
    //      `World_String_EnduringReference` instances are unique.
    //
    //  HOWEVER:
    //      Do need to compare to a `World_String_WeakReference` (since might be replacing it in the cache).
    //
    @Override
    public final boolean                equals(final Object that)
    {
        if (this == that) {
            return true;
        }

        if ( ! (that instanceof World_String_WeakReference)) {
            return false;
        }

        World_String_WeakReference      that_2 = (World_String_WeakReference) that;

        return this.client.s.equals(that_2.s);
    }


    //
    //  Interface java.lang.Comparable
    //
    @Override
    public final int                    compareTo(final Capital_Comparable<? extends Comparable_Inspection> that)
    {
        final Comparable_Inspection     that_inspection = that.inspect();

        final int                       class_compare = (
                Comparable_Inspection.CLASS_ORDER__WORLD_STRING_REFERENCE - that_inspection.class_order
            );

        if (class_compare != 0) {
            return class_compare;
        }

        //
        //  SINCE:
        //      `that` has a class order of `Comparable_Inspection.CLASS_ORDER__WORLD_STRING_REFERENCE`
        //
        //  THEREFORE:
        //      `that_inspection` is of type `Capital_Reference_Inspection`
        //
        final Capital_Reference_Inspection  that__reference_inspection = (
                (Capital_Reference_Inspection) that_inspection
            );

        if (that__reference_inspection.is_enduring_reference) {
            final World_String_EnduringReference    that_2 = (World_String_EnduringReference) that;

            return this.client.s.compareTo(that_2.client.s);
        }

        assert fact(that__reference_inspection.is_weak_reference, "fact(that__reference_inspection.is_weak_reference)");

        final World_String_WeakReference    that_2 = (World_String_WeakReference) that;

        return this.client.s.compareTo(that_2.s);
    }


    //
    //  Interface Capital_Comparable
    //
    //<empty>


    //
    //  Interface Capital_ComparableReference_Interface
    //
    @Override
    public World_String                 client_OR_enqueue()
    {
        return this.client;
    }


    //
    //  Interface Capital_Reference_Interface
    //
    //<empty>


    //
    //  Interface Inspectable
    //
    public Capital_Reference_Inspection     inspect()
    {
        return /*static*/ this.inspection;
    }


    @Override
    public final void                   portray(final Capital_StringBuilder builder)
    {
        builder.append("<World_String_EnduringReference ");
        builder.portray(client);
        builder.append(">");
    }
}
