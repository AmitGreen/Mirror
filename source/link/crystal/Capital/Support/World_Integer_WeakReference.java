//  Copyright (c) 2018-2019 Amit Green.  All rights reserved.


package link.crystal.Capital.Support;


import java.lang.Comparable;
import java.lang.ref.WeakReference;
import link.crystal.Capital.Core.Capital_StringBuilder;
import link.crystal.Capital.Core.Capital_Global;
import link.crystal.Capital.Inspection.Comparable_Inspection;
import link.crystal.Capital.Inspection.Capital_Reference_Inspection;
import link.crystal.Capital.Interface.Capital_Comparable;
import link.crystal.Capital.Interface.Capital_ComparableReference_Interface;
import link.crystal.Capital.Interface.Capital_Reference_Interface;
import link.crystal.Capital.Interface.Inspectable;
import link.crystal.Capital.Support.Capital_ReferenceQueue;
import link.crystal.Capital.Support.Capital_WeakReference;
import link.crystal.Capital.World.World_Integer;


public final class  World_Integer_WeakReference
    extends     Capital_WeakReference  <Capital_Reference_Inspection, World_Integer, Comparable_Inspection>
//  extends     WeakReference                                        <World_Integer>
//  extends     Reference                                            <World_Integer>
//  extends     Object
    implements  Capital_ComparableReference_Interface<Capital_Reference_Inspection, World_Integer, Comparable_Inspection>,
                Capital_Reference_Interface          <Capital_Reference_Inspection>,    //  Via Capital_ComparableReference_Interface
                Capital_Comparable                   <Capital_Reference_Inspection>,    //  Via Capital_ComparableReference_Interface
                Comparable<Capital_Comparable<? extends Comparable_Inspection>>,        //  Via Capital_Comparable
                Inspectable                          <Capital_Reference_Inspection>//,
{
    private static final Capital_Reference_Inspection   inspection = Capital_Reference_Inspection.create(
            "World_Integer_WeakReference",
            Comparable_Inspection.CLASS_ORDER__WORLD_INTEGER_REFERENCE,
            "weak"//,)
        );


    //
    //  Members
    //
    private       String                world_name;
    public  final int                   value;


    //
    //  Constructor
    //
    private                             World_Integer_WeakReference(
            final World_Integer             client,
            final Capital_ReferenceQueue    reference_queue,
            final int                       value//,
        )
    {
        super(client, reference_queue);

        this.world_name = null;
        this.value      = value;
    }


    public static final World_Integer_WeakReference     create__ALLY__Capital(
            final World_Integer             client,
            final Capital_ReferenceQueue    reference_queue//,
        )
    {
        final int                       value = client.value;

        return new World_Integer_WeakReference(client, reference_queue, value);
    }


    //
    //  Ancestor Object
    //
    @Override
    public final int                    hashCode()
    {
        return this.value;
    }


    //
    //  NOTE:
    //      Only need to compare to another `World_Integer_WeakReference`, by using the identity test `==`` as
    //      `World_Integer_WeakReference` instances are unique.
    //
    //  HOWEVER:
    //      Do need to compare to a `World_Integer_WeakReference` (since might be replaced by it in the cache).
    //
    @Override
    public final boolean                equals(final Object that)
    {
        if (this == that) {
            return true;
        }

        if ( ! (that instanceof World_Integer_EnduringReference)) {
            return false;
        }

        World_Integer_EnduringReference     that_2 = (World_Integer_EnduringReference) that;

        return this.value == that_2.client.value;
    }


    //
    //  Interface java.lang.Comparable
    //
    @Override
    public final int                    compareTo(final Capital_Comparable<? extends Comparable_Inspection> that)
    {
        final Comparable_Inspection     that_inspection = that.inspect();

        final int                       class_compare = (
                Comparable_Inspection.CLASS_ORDER__WORLD_INTEGER_REFERENCE - that_inspection.class_order
            );

        if (class_compare != 0) {
            return class_compare;
        }

        //
        //  SINCE:
        //      `that` has a class order of `Comparable_Inspection.CLASS_ORDER__WORLD_INTEGER_REFERENCE`
        //
        //  THEREFORE:
        //      `that_inspection` is of type `Capital_Reference_Inspection`
        //
        final Capital_Reference_Inspection  that__reference_inspection = (
                (Capital_Reference_Inspection) that_inspection
            );

        if (that__reference_inspection.is_enduring_reference) {
            final World_Integer_EnduringReference   that_2 = (World_Integer_EnduringReference) that;

            return this.value - that_2.client.value;
        }

        assert fact(that__reference_inspection.is_weak_reference, "fact(that__reference_inspection.is_weak_reference)");

        final World_Integer_WeakReference   that_2 = (World_Integer_WeakReference) that;

        return this.value - that_2.value;
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
                  World_Integer,
                  Comparable_Inspection
              >                         previous = Capital_Global.integer_cache.remove(this);

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
        final World_Integer             client = this.get();

        if (client == null) {
            builder.append("<World_Integer_WeakReference exhausted; ", this.value, ">");
            return;
        }

        builder.append("<World_Integer_WeakReference ");
        builder.portray(client);
        builder.append(">");
    }
}
