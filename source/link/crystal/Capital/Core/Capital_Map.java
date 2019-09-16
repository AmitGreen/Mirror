//  Copyright (c) 2019 Amit Green.  All rights reserved.


package link.crystal.Capital.Core;


import java.util.HashMap;
import link.crystal.Capital.Core.Capital_Global;
import link.crystal.Capital.Core.Capital_StringBuilder;
import link.crystal.Capital.Core.Zone;
import link.crystal.Capital.Exception.ExceptionFunctions;
import link.crystal.Capital.Inspection.Inspection;
import link.crystal.Capital.Interface.Inspectable;


public abstract class   Capital_Map <INSPECTION extends Inspection, K, V>
    extends             HashMap                                    <K, V>
//  extends             AbstractHashMap                            <K, V>
//  extends             Object
    implements          Inspectable<INSPECTION>//,
{
    //
    //  Members
    //
    protected final Zone                z;


    //
    //  Constructor
    //
    protected                           Capital_Map(final Zone z, final int initial_capacity)
    {
        super(initial_capacity);

        this.z = z;
    }


    //
    //  Interface Inspectable
    //
    public abstract INSPECTION          inspect();
    public abstract void                portray(final Capital_StringBuilder builder);


    //
    //  Abstract
    //
    public abstract void                dump(final String name);


    //
    //  Public (ASSERT)
    //
    public static final boolean         fact(boolean condition, final String format)
    {
        if (condition) {
            return true;
        }

        ExceptionFunctions.ASSERTION_FAILED(2, "assertion failed: {}", format);

        return false;
    }


    public static final boolean         fact_null(final Object p, final String name)
    {
        if (p == null) {
            return true;
        }

        ExceptionFunctions.ASSERT(2, "`{}` is not null", name);

        return false;
    }


    public static final boolean         fact_pointer(final Object p, final String name)
    {
        if (p != null) {
            return true;
        }

        final Zone                      z = Zone.current_zone();

        ExceptionFunctions.ASSERT(2, "`{}` is null", name);

        return false;
    }


    //
    //  Public (ERRORS)
    //
    public static final void            INVALID_ROUTINE()
    {
        ExceptionFunctions.RUNTIME(2, "invalid routine");
    }


    public final void                   RUNTIME(final String error_message, final Object ... arguments)
    {
        ExceptionFunctions.RUNTIME(2, error_message, arguments);
    }


    //
    //  Public (trace)
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


    //
    //  Public (other)
    //
    public final V                      lookup(final Zone z, final K k)
    {
        assert fact        (this.z == z, "this.z == z");
        assert fact_pointer(k, "k");

        return this.get(k);
    }


    public final void                   insert(final Zone z, final K k, final V v)
    {
        assert fact        (this.z == z, "this.z == z");
        assert fact_pointer(k, "k");
        assert fact_pointer(v, "v");

        final V                         previous = this.putIfAbsent(k, v);

        if (previous != null) {
            RUNTIME("previous value for {} already exists: {}", k, v);
        }
    }


    public static final void            output(final String s)
    {
        Capital_Global.output(s);
    }
}
