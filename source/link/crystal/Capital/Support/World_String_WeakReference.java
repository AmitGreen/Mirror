//  Copyright (c) 2018-2019 Amit Green.  All rights reserved.


package link.crystal.Capital.Support;


import java.lang.Comparable;
import java.lang.ref.WeakReference;
import link.crystal.Capital.Core.Capital_Global;
import link.crystal.Capital.Core.Capital_StringBuilder;
import link.crystal.Capital.Inspection.Comparable_Inspection;
import link.crystal.Capital.Inspection.Capital_Reference_Inspection;
import link.crystal.Capital.Interface.Capital_Comparable;
import link.crystal.Capital.Interface.Capital_ComparableReference_Interface;
import link.crystal.Capital.Interface.Capital_Referenceable_Interface;
import link.crystal.Capital.Interface.Capital_Reference_Interface;
import link.crystal.Capital.Interface.Inspectable;
import link.crystal.Capital.Support.Capital_ReferenceQueue;
import link.crystal.Capital.Support.Capital_WeakReference;
import link.crystal.Capital.World.World_String;


//
//  NOTE:
//      The *ONLY* reason that `World_String_WeakReference` implements interface `Capital_Referenceable_Interface` is
//      for debugging.
//
//      This allows the creation of `World_String_WeakReference_PhantomReference` (which needs a
//      `Capital_Referenceable_Interface` [for use with `Capital_ReferenceQueue`]) for debugging purposes.
//
public final class  World_String_WeakReference
    extends         Capital_WeakReference                <Capital_Reference_Inspection, World_String, Comparable_Inspection>
//  extends         WeakReference                                                      <World_String>
//  extends         Reference                                                          <World_String>
//  extends         Object
    implements      Capital_ComparableReference_Interface<Capital_Reference_Inspection, World_String, Comparable_Inspection>,
                    Capital_Referenceable_Interface      <Capital_Reference_Inspection>,
                    Capital_Reference_Interface          <Capital_Reference_Inspection>,    //  Via Capital_ComparableReference_Interface
                    Capital_Comparable                   <Capital_Reference_Inspection>,    //  Via Capital_ComparableReference_Interface
                    Comparable<Capital_Comparable<? extends Comparable_Inspection>>,        //  Via Capital_Comparable
                    Inspectable                          <Capital_Reference_Inspection>//,
{
    private static final Capital_Reference_Inspection   inspection = Capital_Reference_Inspection.create(
            "World_String_WeakReference",
            Comparable_Inspection.CLASS_ORDER__WORLD_STRING_REFERENCE,
            "weak"//,
        );


    //
    //  Members
    //
    private /*:*/ String                world_name;
    public  final int                   pulp;
    public  final String                s;


    //
    //  Constructor
    //
    private                             World_String_WeakReference(
            final World_String              client,
            final Capital_ReferenceQueue    reference_queue,
            final int                       pulp,
            final String                    s//,
        )
    {
        super(client, reference_queue);

        this.world_name = null;
        this.pulp       = pulp;
        this.s          = s;
    }


    public static final World_String_WeakReference  create__ALLY__Capital(
            final World_String              client,
            final Capital_ReferenceQueue    reference_queue//,
        )
    {
        final String                    s = client.s;

        final int                       pulp = s.hashCode();

        return new World_String_WeakReference(client, reference_queue, pulp, s);
    }


    //
    //  Ancestor Object
    //
    //  NOTE:
    //      Do not need to override `.equals` -- as World_String_WeakReference are unique (and thus can use
    //      `Object.equals` which uses identity as the equal test).
    //
    @Override
    public final int                    hashCode()
    {
        return this.pulp;
    }


    //
    //  NOTE:
    //      Only need to compare to another `World_String_WeakReference`, by using the identity test `==`` as
    //      `World_String_WeakReference` instances are unique.
    //
    //  HOWEVER:
    //      Do need to compare to a `World_String_WeakReference` (since might be replaced by it in the cache).
    //
    @Override
    public final boolean                equals(final Object that)
    {
        if (this == that) {
            return true;
        }

        if ( ! (that instanceof World_String_EnduringReference)) {
            return false;
        }

        World_String_EnduringReference  that_2 = (World_String_EnduringReference) that;

        return this.s.equals(that_2.client.s);
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

            return this.s.compareTo(that_2.client.s);
        }

        assert fact(that__reference_inspection.is_weak_reference, "fact(that__reference_inspection.is_weak_reference)");

        final World_String_WeakReference    that_2 = (World_String_WeakReference) that;

        return this.s.compareTo(that_2.s);
    }


    //
    //  Interface Capital_Comparable
    //
    //<empty>


    //
    //  Interface Capital_QueueableReference_Interface
    //
    @Override
    public final void                   reap()
    {
        final Capital_ComparableReference_Interface<
                  ? extends Comparable_Inspection,
                  World_String,
                  Comparable_Inspection
              >                         previous = Capital_Global.string_cache.remove(this);

        if (previous != this) {
            RUNTIME("failed to remove {}", this);
        }
    }


    //
    //  Interface Capital_Reference_Interface
    //
    //<empty>


    //
    //  Interface Inspectable
    //
    @Override
    public Capital_Reference_Inspection     inspect()
    {
        return /*static*/ this.inspection;
    }


    @Override
    public final void                   portray(final Capital_StringBuilder builder)
    {
        World_String                    client = this.get();

        if (client == null) {
            builder.append("<World_String_WeakReference exhausted; ", this.s, ">");
            return;
        }

        builder.append("<World_String_WeakReference ");
        builder.portray(client);
        builder.append(">");
    }
}
