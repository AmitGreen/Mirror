//  Copyright (c) 2018-2019 Amit Green.  All rights reserved.


package link.crystal.Capital.Core;


import java.lang.Object;
import java.lang.System;
import link.crystal.Capital.Core.Capital_Global;
import link.crystal.Capital.Exception.ExceptionFunctions;


public abstract class   Capital_Object
    extends             Object
{
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


    public static final boolean         fact(boolean condition, final String format, final Object v)
    {
        if (condition) {
            return true;
        }

        ExceptionFunctions.ASSERTION_FAILED(2, format, v);

        return false;
    }


    public static final boolean         fact_between(final int start, final int v, final int end)
    {
        if (start <= v && v <= end) {
            return true;
        }

        ExceptionFunctions.ASSERT(2, "{} is not between {} and {}", v, start, end);

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


    public static final void            RUNTIME(final String error_message, final Object ... arguments)
    {
        ExceptionFunctions.RUNTIME(2, error_message, arguments);
    }


    //
    //  Public (arrange)
    //
    public static final String          arrange(final String format)
    {
        return Capital_Global.arrange(2, format);
    }


    public static final String          arrange(final String format, final Object v)
    {
        return Capital_Global.arrange(2, format, v);
    }


    public static final String          arrange(final String format, final Object v, final Object w)
    {
        return Capital_Global.arrange(2, format, v, w);
    }


    public static final String          arrange(final String format, final Object v, final Object w, final Object x)
    {
        return Capital_Global.arrange(2, format, v, w, x);
    }


    public static final String          arrange(
            final String                        format,
            final Object                        v,
            final Object                        w,
            final Object                        x,
            final Object                        y//
        )
    {
        return Capital_Global.arrange(2, format, v, w, x, y);
    }


    public static final String          arrange(
            final String                        format,
            final Object                        v,
            final Object                        w,
            final Object                        x,
            final Object                        y4,
            final Object                        y5//,
        )
    {
        return Capital_Global.arrange(2, format, v, w, x, y4, y5);
    }


    public static final String          arrange(
            final String                        format,
            final Object                        v,
            final Object                        w,
            final Object                        x,
            final Object                        y4,
            final Object                        y5,
            final Object                        y6//,
        )
    {
        return Capital_Global.arrange(2, format, v, w, x, y4, y5, y6);
    }


    public static final String          arrange(
            final String                        format,
            final Object                        v,
            final Object                        w,
            final Object                        x,
            final Object                        y4,
            final Object                        y5,
            final Object                        y6,
            final Object                        y7,
            final Object ...                    other_arguments//,
        )
    {
        return Capital_Global.arrange(2, format, v, w, x, y4, y5, y6, y7, other_arguments);
    }


    //
    //  Public (trace)
    //
    //@overrideable
    public static void                  trace()
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


    public static final void            trace(final String format, final Object v, final Object w)
    {
        Capital_Global.trace(2, format, v, w);
    }


    public static final void            trace(final String format, final Object v, final Object w, final Object x)
    {
        Capital_Global.trace(2, format, v, w, x);
    }


    public static final void            trace(
            final String                        format,
            final Object                        v,
            final Object                        w,
            final Object                        x,
            final Object                        y//,
        )
    {
        Capital_Global.trace(2, format, v, w, x, y);
    }


    public static final void            trace(
            final String                        format,
            final Object                        v,
            final Object                        w,
            final Object                        x,
            final Object                        y4,
            final Object                        y5//,
        )
    {
        Capital_Global.trace(2, format, v, w, x, y4, y5);
    }


    public static final void            trace(
            final String                        format,
            final Object                        v,
            final Object                        w,
            final Object                        x,
            final Object                        y4,
            final Object                        y5,
            final Object                        y6//,
        )
    {
        Capital_Global.trace(2, format, v, w, x, y4, y5, y6);
    }


    public static final void            trace(
            final String                        format,
            final Object                        v,
            final Object                        w,
            final Object                        x,
            final Object                        y4,
            final Object                        y5,
            final Object                        y6,
            final Object                        y7,
            final Object ...                    other_arguments//,
        )
    {
        Capital_Global.trace(2, format, v, w, x, y4, y5, y6, y7, other_arguments);
    }
}
