//  Copyright (c) 2019 Amit Green.  All rights reserved.


package link.crystal.Capital.Core;


import java.io.PrintStream;
import java.lang.Object;
import java.lang.System;
import link.crystal.Capital.Core.Capital_Object;
import link.crystal.Capital.Core.Capital_StringBuilder;
import link.crystal.Capital.Core.Zone;
import link.crystal.Capital.Format.MethodNameSegmentFormatter;
import link.crystal.Capital.Format.ParseFormat;
import link.crystal.Capital.Inspection.Comparable_Inspection;
import link.crystal.Capital.Interface.MessageFormattable;
import link.crystal.Capital.Support.Capital_ReferenceQueue;
import link.crystal.Capital.Support.Inspection_Cache;
import link.crystal.Capital.Support.World_Integer_Cache;
import link.crystal.Capital.Support.World_String_Cache;
import link.crystal.Gem.UnitTest.UnitTest_Gem;


public abstract class   Capital_Global
    extends             Capital_Object
//  extends             Object
{
    //
    //  Static types
    //
    public static final Class<Capital_StringBuilder[]>  Capital_StringBuilder$array$class = (
            Capital_StringBuilder[].class
        );

    public static final Class<Integer>              Integer$class = Integer.class;
    public static final Class<String>               String$class  = String.class;
    public static final Class<Thread>               Thread$class  = Thread.class;


    //
    //  Public static
    //
    public static final PrintStream                 standard_output = System.out;


    //
    //  NOTE:
    //      To avoid class initialization loops all the following CANNOT be initialized here.
    //
    //      Each of the following must be initializated when first used
    //      (i.e.: after other class initializations have run)
    //
    //  HENCE:
    //      None of the following can be declared as `final` either ...
    //
    public static /*boot-final*/        World_Integer_Cache         integer_cache                  /* = null */ ;
    public static /*boot-final*/        World_String_Cache          string_cache                   /* = null */ ;
    public static /*boot-final*/        Inspection_Cache            inspection_cache               /* = null */ ;
    public static /*boot-final*/        MethodNameSegmentFormatter  message_name_segment_formatter /* = null */ ;
    public static /*boot-final*/        Capital_ReferenceQueue      reference_queue                /* = null */ ;


    //
    //  Public Statis (Unit Test)
    //
    public static UnitTest_Gem          unit_test = null;


    //
    //  Ally
    //
    public static final void            boot__ALLY__Zone(final Zone z)
    {
        assert fact_null(Capital_Global.integer_cache,    "Capital_Global.integer_cache");
        assert fact_null(Capital_Global.string_cache,     "Capital_Global.string_cache");
        assert fact_null(Capital_Global.inspection_cache, "Capital_Global.inspection_cache");

        assert fact_null(
                Capital_Global.message_name_segment_formatter,
                "Capital_Global.message_name_segment_formatter"
            );

        assert fact_null(Capital_Global.reference_queue, "Capital_Global.reference_queue");

        final Inspection_Cache              inspection_cache = Inspection_Cache.create__ALLY__Capital(z);

        Capital_Global.integer_cache                  = World_Integer_Cache.create__ALLY__Capital();
        Capital_Global.string_cache                   = World_String_Cache .create__ALLY__Capital();
        Capital_Global.inspection_cache               = inspection_cache;
        Capital_Global.message_name_segment_formatter = MethodNameSegmentFormatter.create__ALLY__Capital();
        Capital_Global.reference_queue                = Capital_ReferenceQueue    .create__ALLY__Capital();

        inspection_cache.boot__ALLY__Zone(z);
    }


    public static final void                store_unit_test__ALLY__UnitTest(final UnitTest_Gem unit_test)
    {
        assert fact_null   (Capital_Global.unit_test, "Capital_Global.unit_test");
        assert fact_pointer(unit_test,                "unit_test");

        Capital_Global.unit_test = unit_test;
    }


    //
    //  Public (arrange)
    //
    public static final String          arrange(final int depth, final String format)
    {
        final Zone                      z = Zone.current_zone();

        final MessageFormattable<?>     formattable = ParseFormat.parse_format(z, format);

        return formattable.augment(depth + 1);
    }


    public static final String          arrange(final int depth, final String format, final Object v)
    {
        final Zone                      z = Zone.current_zone();

        final MessageFormattable<?>     formattable = ParseFormat.parse_format(z, format);

        return formattable.augment(depth + 1, v);
    }


    public static final String          arrange(final int depth, final String format, final Object v, final Object w)
    {
        final Zone                      z = Zone.current_zone();

        final MessageFormattable<?>     formattable = ParseFormat.parse_format(z, format);

        final Capital_StringBuilder     builder = z.summon_StringBuilder();

        formattable.augment(builder, depth + 1, v, w);

        return builder.finish_AND_recycle();
    }


    public static final String          arrange(
            final int                           depth,
            final String                        format,
            final Object                        v,
            final Object                        w,
            final Object                        x//,
        )
    {
        final Zone                      z = Zone.current_zone();

        final MessageFormattable<?>     formattable = ParseFormat.parse_format(z, format);

        final Capital_StringBuilder     builder = z.summon_StringBuilder();

        formattable.augment(builder, depth + 1, v, w, x);

        return builder.finish_AND_recycle();
    }


    public static final String          arrange(
            final int                           depth,
            final String                        format,
            final Object                        v,
            final Object                        w,
            final Object                        x,
            final Object                        y//
        )
    {
        final Zone                      z = Zone.current_zone();

        final MessageFormattable<?>     formattable = ParseFormat.parse_format(z, format);

        final Capital_StringBuilder     builder = z.summon_StringBuilder();

        formattable.augment(builder, depth + 1, v, w, x, y);

        return builder.finish_AND_recycle();
    }


    public static final String          arrange(
            final int                           depth,
            final String                        format,
            final Object                        v,
            final Object                        w,
            final Object                        x,
            final Object                        y4,
            final Object                        y5//,
        )
    {
        final Zone                      z = Zone.current_zone();

        final MessageFormattable<?>     formattable = ParseFormat.parse_format(z, format);

        final Capital_StringBuilder     builder = z.summon_StringBuilder();

        formattable.augment(builder, depth + 1, v, w, x, y4, y5);

        return builder.finish_AND_recycle();
    }


    public static final String          arrange(
            final int                           depth,
            final String                        format,
            final Object                        v,
            final Object                        w,
            final Object                        x,
            final Object                        y4,
            final Object                        y5,
            final Object                        y6//,
        )
    {
        final Zone                      z = Zone.current_zone();

        final MessageFormattable<?>     formattable = ParseFormat.parse_format(z, format);

        final Capital_StringBuilder     builder = z.summon_StringBuilder();

        formattable.augment(builder, depth + 1, v, w, x, y4, y5, y6);

        return builder.finish_AND_recycle();
    }


    public static final String          arrange(
            final int                           depth,
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
        final Zone                      z = Zone.current_zone();

        final MessageFormattable<?>     formattable = ParseFormat.parse_format(z, format);

        final Capital_StringBuilder     builder = z.summon_StringBuilder();

        formattable.augment(builder, depth + 1, v, w, x, y4, y5, y6, y7, other_arguments);

        return builder.finish_AND_recycle();
    }


    //
    //  Public (trace)
    //
    public static final void            trace()
    {
        standard_output.println();
    }


    public static final void            trace(final int depth, final String format)
    {
        final Zone                      z = Zone.current_zone();

        final MessageFormattable<?>     formattable = ParseFormat.parse_format(z, format);

        standard_output.println(formattable.augment(depth + 1));
    }


    public static final void            trace(final int depth, final String format, final Object v)
    {
        final Zone                      z = Zone.current_zone();

        final MessageFormattable<?>     formattable = ParseFormat.parse_format(z, format);

        standard_output.println(formattable.augment(depth + 1, v));
    }


    public static final void            trace(final int depth, final String format, final Object v, final Object w)
    {
        final Zone                      z = Zone.current_zone();

        final MessageFormattable<?>     formattable = ParseFormat.parse_format(z, format);

        final Capital_StringBuilder     builder = z.summon_StringBuilder();

        formattable.augment(builder, depth + 1, v, w);

        standard_output.println(builder.finish_AND_recycle());
    }


    public static final void            trace(
            final int                           depth,
            final String                        format,
            final Object                        v,
            final Object                        w,
            final Object                        x//,
        )
    {
        final Zone                      z = Zone.current_zone();

        final MessageFormattable<?>     formattable = ParseFormat.parse_format(z, format);

        final Capital_StringBuilder     builder = z.summon_StringBuilder();

        formattable.augment(builder, depth + 1, v, w, x);

        standard_output.println(builder.finish_AND_recycle());
    }


    public static final void            trace(
            final int                           depth,
            final String                        format,
            final Object                        v,
            final Object                        w,
            final Object                        x,
            final Object                        y//,
        )
    {
        final Zone                      z = Zone.current_zone();

        final MessageFormattable<?>     formattable = ParseFormat.parse_format(z, format);

        Capital_StringBuilder           builder = z.summon_StringBuilder();

        formattable.augment(builder, depth + 1, v, w, x, y);

        standard_output.println(builder.finish_AND_recycle());
    }


    public static final void            trace(
            final int                           depth,
            final String                        format,
            final Object                        v,
            final Object                        w,
            final Object                        x,
            final Object                        y4,
            final Object                        y5//,
        )
    {
        final Zone                      z = Zone.current_zone();

        final MessageFormattable<?>     formattable = ParseFormat.parse_format(z, format);

        final Capital_StringBuilder     builder = z.summon_StringBuilder();

        formattable.augment(builder, depth + 1, v, w, x, y4, y5);

        standard_output.println(builder.finish_AND_recycle());
    }


    public static final void            trace(
            final int                           depth,
            final String                        format,
            final Object                        v,
            final Object                        w,
            final Object                        x,
            final Object                        y4,
            final Object                        y5,
            final Object                        y6//,
        )
    {
        final Zone                      z = Zone.current_zone();

        final MessageFormattable<?>     formattable = ParseFormat.parse_format(z, format);

        final Capital_StringBuilder     builder = z.summon_StringBuilder();

        formattable.augment(builder, depth + 1, v, w, x, y4, y5, y6);

        standard_output.println(builder.finish_AND_recycle());
    }


    public static final void            trace(
            final int                           depth,
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
        final Zone                      z = Zone.current_zone();

        final MessageFormattable<?>     formattable = ParseFormat.parse_format(z, format);

        final Capital_StringBuilder     builder = z.summon_StringBuilder();

        formattable.augment(builder, depth + 1, v, w, x, y4, y5, y6, y7, other_arguments);

        standard_output.println(builder.finish_AND_recycle());
    }


    public static final void            trace_1_plus(
            final int                           depth,
            final String                        format,
            final Object                        v,
            final Object ...                    other_arguments//,
        )
    {
        final Zone                      z = Zone.current_zone();

        final MessageFormattable<?>     formattable = ParseFormat.parse_format(z, format);

        final Capital_StringBuilder     builder = z.summon_StringBuilder();

        formattable.augment_1_plus(builder, depth + 1, v, other_arguments);

        standard_output.println(builder.finish_AND_recycle());
    }


    //
    //  Public (dump)
    //
    public static final void            dump()
    {
        trace("Dump of Capital_Global");
        trace("  standard_output: {p}", Capital_Global.standard_output);
        trace("---");
        trace("                   integer_cache: {p}", Capital_Global.integer_cache);
        trace("                    string_cache: {p}", Capital_Global.string_cache);
        trace("                inspection_cache: {p}", Capital_Global.inspection_cache);
        trace("  message_name_segment_formatter: {p}", Capital_Global.message_name_segment_formatter);
        trace("                 reference_queue: {p}", Capital_Global.reference_queue);
        trace("End of dump of Capital_Global");
    }


    //
    //  Public (other)
    //
    public static final MethodNameSegmentFormatter  conjure_MethodNameSegmentFormatter()
    {
        final MethodNameSegmentFormatter        message_name_segment_formatter = (
                Capital_Global.message_name_segment_formatter
            );

        assert fact_pointer(message_name_segment_formatter, "message_name_segment_formatter");

        return message_name_segment_formatter;
    }


    public static final int             limit_to_between(final int minimum, final int v, final int maximum)
    {
        if (v < minimum) {
            return minimum;
        }

        if (v > maximum) {
            return maximum;
        }

        return v;
    }


    public static final void            output(final String s)
    {
        standard_output.println(s);
    }
}
