//  Copyright (c) 2018-2019 Amit Green.  All rights reserved.


package link.crystal.Capital.Format;


import java.lang.StackTraceElement;
import java.lang.String;
import link.crystal.Capital.Core.Capital_StringBuilder;
import link.crystal.Capital.Core.Zone;
import link.crystal.Capital.Format.MessageFormatter_Base;
import link.crystal.Capital.Format.SegmentFormatter_Inspection;
import link.crystal.Capital.Interface.Inspectable;
import link.crystal.Capital.Interface.MessageFormattable;
import link.crystal.Capital.Interface.SegmentFormattable;


public final class  MethodNameSegmentFormatter
    extends         MessageFormatter_Base<SegmentFormatter_Inspection>
//  extends         Inspectable_Object   <SegmentFormatter_Inspection>
//  extends         Object
    implements      MessageFormattable   <SegmentFormatter_Inspection>,
                    SegmentFormattable   <SegmentFormatter_Inspection>,
                    Inspectable          <SegmentFormatter_Inspection>//,
{
    private static final SegmentFormatter_Inspection    inspection = (
            SegmentFormatter_Inspection.create("MethodNameSegmentFormatter")
        );


    //
    //  Constructor & Factory
    //
    private                             MethodNameSegmentFormatter()
    {
    }


    public static final MethodNameSegmentFormatter  create__ALLY__Capital()
    {
        return new MethodNameSegmentFormatter();
    }


    //
    //  Interface Inspectable
    //
    @Override
    public final SegmentFormatter_Inspection    inspect()
    {
        return /*static*/ this.inspection;
    }


    //
    //  Interface MessageFormattable
    //
    @Override
    public final void                   augment(final Capital_StringBuilder builder, int depth)
    {
        this.method_name(builder, depth + 1);
    }


    //
    //  Interface SegmentFormattable
    //
    public final void                   choose(final Capital_StringBuilder builder, int depth)
    {
        this.method_name(builder, depth + 1);
    }


    public final void                   choose(final Capital_StringBuilder builder, int depth, final Object v)
    {
        this.method_name(builder, depth + 1);
    }


    public final void                   choose(
            final Capital_StringBuilder     builder,
            final int                       depth,
            final Object                    v,
            final Object                    w//,
        )
    {
        this.method_name(builder, depth + 1);
    }


    public final void                   choose(
            final Capital_StringBuilder      builder,
            final int                        depth,
            final Object                     v,
            final Object                     w,
            final Object                    x//,
        )
    {
        this.method_name(builder, depth + 1);
    }


    public final void                   choose(
            final Capital_StringBuilder     builder,
            final int                       depth,
            final Object                    v,
            final Object                    w,
            final Object                    x,
            final Object                    y//,
        )
    {
        this.method_name(builder, depth + 1);
    }


    public final void                   choose(
            final Capital_StringBuilder     builder,
            final int                       depth,
            final Object                    v,
            final Object                    w,
            final Object                    x,
            final Object                    y4,
            final Object                    y5//,
        )
    {
        this.method_name(builder, depth + 1);
    }


    public final void                   choose(
            final Capital_StringBuilder     builder,
            final int                       depth,
            final Object                    v,
            final Object                    w,
            final Object                    x,
            final Object                    y4,
            final Object                    y5,
            final Object                    y6//,
        )
    {
        this.method_name(builder, depth + 1);
    }


    public final void                   choose(
            final Capital_StringBuilder     builder,
            final int                       depth,
            final Object                    v,
            final Object                    w,
            final Object                    x,
            final Object                    y4,
            final Object                    y5,
            final Object                    y6,
            final Object                    y7,
            final Object ...                other_arguments//,
        )
    {
        this.method_name(builder, depth + 1);
    }


    //
    //  public
    //
    public static final void            method_name(final Capital_StringBuilder builder, int depth)
    {
        final Zone                      z = builder.z;

        final StackTraceElement[]       stack_trace_many = z.zone_thread.getStackTrace();

        final int                       total = stack_trace_many.length;

        if (false) {
            output("MethodNameSegmentFormatter.method_name: total<" + Integer.toString(total) + ">");

            for (/*:*/ int              i = 0; i < total; i ++) {
                final StackTraceElement     stack_trace = stack_trace_many[i];
                /*:*/ String                class_name  = stack_trace.getClassName();
                final int                   dot_index   = class_name.lastIndexOf(46);                   //  46 = '.'

                if (false) {
                    if (dot_index != -1) {
                        class_name = class_name.substring(dot_index + 1);
                    }
                }

                output((
                              "  "
                            + Integer.toString(i)
                            + ": "
                            + class_name
                            + "."
                            + stack_trace.getMethodName()
                            + "@"
                            + Integer.toString(stack_trace.getLineNumber())
                    ));
            }
        }

        //
        //  NOTE:
        //      The stack trace includes `Thread.GetStackTrace` as element 0.
        //
        //      So add `1` to `depth`
        //
        depth += 1;

        if (depth < total) {
            final StackTraceElement     stack_trace = stack_trace_many[depth];
            /*:*/ String                class_name  = stack_trace.getClassName();
            final int                   dot_index   = class_name.lastIndexOf(46);                   //  46 = '.'

            if (dot_index != -1) {
                class_name = class_name.substring(dot_index + 1);
            }

            builder.append(class_name, ".", stack_trace.getMethodName(), "@", stack_trace.getLineNumber());
            return;
        }

        builder.append("???.???@???");
    }
}
