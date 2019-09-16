//  Copyright (c) 2018-2019 Amit Green.  All rights reserved.


package link.crystal.Capital.UnitTest;


import java.lang.ref.PhantomReference;
import link.crystal.Capital.Core.Capital_Global;
import link.crystal.Capital.Core.Capital_StringBuilder;
import link.crystal.Capital.Inspection.Comparable_Inspection;
import link.crystal.Capital.Inspection.Capital_Reference_Inspection;
import link.crystal.Capital.Interface.Capital_QueueableReference_Interface;
import link.crystal.Capital.Interface.Capital_Reference_Interface;
import link.crystal.Capital.Interface.Inspectable;
import link.crystal.Capital.Support.Capital_ReferenceQueue;
import link.crystal.Capital.Support.World_String_WeakReference;
import link.crystal.Capital.World.World_String;


public final class  World_String_WeakReference_PhantomReference
    extends         PhantomReference<World_String_WeakReference>
//  extends         Reference       <World_String_WeakReference>
//  extends         Object
    implements      Capital_QueueableReference_Interface<Capital_Reference_Inspection>,
                    Capital_Reference_Interface         <Capital_Reference_Inspection>, //  Via Capital_QueueableReference_Interface
                    Inspectable                         <Capital_Reference_Inspection>//,
{
    private static final Capital_Reference_Inspection   inspection = Capital_Reference_Inspection.create(
            "World_String_WeakReference_PhantomReference",
            Comparable_Inspection.CLASS_ORDER__NONE,
            "phantom"//,
        );


    //
    //  Members
    //
    public final String                 s;


    //
    //  Constructor
    //
    private                             World_String_WeakReference_PhantomReference(
            final World_String_WeakReference    client,
            final Capital_ReferenceQueue        reference_queue,
            final String                        s//,
        )
    {
        super(client, reference_queue);

        this.s          = s;
    }


    public static final World_String_WeakReference_PhantomReference     create__ALLY__Capital(
            final World_String_WeakReference    client,
            final Capital_ReferenceQueue        reference_queue//,
        )
    {
        final String                    s = client.s;

        return new World_String_WeakReference_PhantomReference(client, reference_queue, s);
    }


    //
    //  Interface Capital_QueueableReference_Interface
    //
    @Override
    public final void                   reap()
    {
        trace("=== REAP ===: {}", this);
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
        builder.append("<World_String_WeakReference_PhantomReference ");
        builder.java_quote(this.s);
        builder.append(">");
    }


    //
    //  Public (line)
    //
    public static final void            trace()
    {
        Capital_Global.trace();
    }


    public static final void            trace(final String format)
    {
        Capital_Global.trace(2, format);
    }


    public static final void            trace(final String format, final Object v)
    {
        Capital_Global.trace(2, format, v);
    }


    public static final void            trace(final String format, final Object v, final Object ... other_arguments)
    {
        Capital_Global.trace_1_plus(2, format, v, other_arguments);
    }
}
