//  Copyright (c) 2018-2019 Amit Green.  All rights reserved.


package link.crystal.Capital.Support;


import java.lang.Comparable;
import java.lang.ref.WeakReference;
import link.crystal.Capital.Core.Capital_Global;
import link.crystal.Capital.Core.Capital_StringBuilder;
import link.crystal.Capital.Exception.ExceptionFunctions;
import link.crystal.Capital.Inspection.Comparable_Inspection;
import link.crystal.Capital.Inspection.Capital_Reference_Inspection;
import link.crystal.Capital.Inspection.Inspection;
import link.crystal.Capital.Interface.Capital_Comparable;
import link.crystal.Capital.Interface.Capital_ComparableReference_Interface;
import link.crystal.Capital.Interface.Capital_QueueableReference_Interface;
import link.crystal.Capital.Interface.Capital_Referenceable_Interface;
import link.crystal.Capital.Interface.Capital_Reference_Interface;
import link.crystal.Capital.Interface.Inspectable;
import link.crystal.Capital.Support.Capital_ReferenceQueue;


public abstract class   Capital_WeakReference<
                            INSPECTION        extends Capital_Reference_Inspection,
                            CLIENT            extends Capital_Referenceable_Interface<CLIENT_INSPECTION>,
                            CLIENT_INSPECTION extends Inspection//,
                        >
    extends             WeakReference<CLIENT>
//  extends             Reference    <CLIENT>
//  extends             Object
    implements          Capital_ComparableReference_Interface<INSPECTION, CLIENT, CLIENT_INSPECTION>,
                        Capital_QueueableReference_Interface <INSPECTION>,
                        Capital_Reference_Interface          <INSPECTION>,      //  Via Gem_*Reference_Interface
                        Capital_Comparable                   <INSPECTION>,      //  Via Capital_ComparableReference_Interface
                        Comparable<Capital_Comparable<? extends Comparable_Inspection>>,    //  Via Capital_Comparable
                        Inspectable                          <INSPECTION>//,
{
    //
    //  Constructor
    //
    protected                           Capital_WeakReference(
            final CLIENT                    client,
            final Capital_ReferenceQueue    reference_queue//,
        )
    {
        super(client, reference_queue);
    }


    //
    //  Interface java.lang.Comparable
    //
    public abstract int                 compareTo(Capital_Comparable<? extends Comparable_Inspection> that);


    //
    //  Interface Capital_Comparable
    //
    //<empty>


    //
    //  Interface Inspectable
    //
    public abstract INSPECTION          inspect();
    public abstract void                portray(final Capital_StringBuilder builder);


    //
    //  Interface Capital_ComparableReference_Interface
    //
    @Override
    public final CLIENT                 client_OR_enqueue()
    {
        final CLIENT                    r = this.get();

        if (r != null) {
            return r;
        }

        this.enqueue();
        return null;
    }


    //
    //  Interface Capital_QueueableReference_Interface
    //
    public abstract void                reap();


    //
    //  Interface Capital_Reference_Interface
    //
    //<empty>


    //
    //  Public (ASSERT)
    //
    public static final boolean         fact(boolean condition, final String format)
    {
        if (condition) {
            return true;
        }

        ExceptionFunctions.ASSERTION_FAILED(2, format);

        return false;
    }


    //
    //  Public (ERRORS)
    //
    public static final void            INVALID_ROUTINE()
    {
        ExceptionFunctions.RUNTIME(2, "invalid routine");
    }


    public static final void            RUNTIME(final String error_message, final Object ... arguments)
    {
        ExceptionFunctions.RUNTIME(2, error_message, arguments);
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
