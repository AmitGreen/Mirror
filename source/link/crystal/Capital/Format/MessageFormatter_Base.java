//  Copyright (c) 2018-2019 Amit Green.  All rights reserved.


package link.crystal.Capital.Format;


import java.lang.String;
import link.crystal.Capital.Core.Inspectable_Object;
import link.crystal.Capital.Core.Capital_StringBuilder;
import link.crystal.Capital.Core.Zone;
import link.crystal.Capital.Inspection.Inspection;
import link.crystal.Capital.Interface.Inspectable;
import link.crystal.Capital.Interface.MessageFormattable;


public abstract class   MessageFormatter_Base<INSPECTION extends Inspection>
    extends             Inspectable_Object   <INSPECTION>
//  extends             Object
    implements          MessageFormattable   <INSPECTION>,
                        Inspectable          <INSPECTION>//,
{
    //
    //  Interface MessageFormattable
    //
    @Override
    public /*overrideable*/ String      augment(final int depth)
    {
        final Zone                      z = Zone.current_zone();

        final Capital_StringBuilder     builder = z.summon_StringBuilder();

        this.augment(builder, depth + 1);

        return builder.finish_AND_recycle();
    }


    @Override
    public /*overrideable*/ String      augment(final int depth, final Object v)
    {
        final Zone                      z = Zone.current_zone();

        final Capital_StringBuilder     builder = z.summon_StringBuilder();

        this.augment(builder, depth + 1, v);

        return builder.finish_AND_recycle();
    }


    @Override
    public /*overrideable*/ void        augment(final Capital_StringBuilder builder, int depth)
    {
        final INSPECTION                inspection = this.inspect();

        RUNTIME("invalid routine (derived class: {})", inspection.simple_class_name);
    }


    @Override
    public /*overrideable*/ void        augment(final Capital_StringBuilder builder, int depth, final Object v)
    {
        final INSPECTION                inspection = this.inspect();

        RUNTIME("invalid routine (derived class: {})", inspection.simple_class_name);
    }


    @Override
    public /*overrideable*/ void        augment(
            final Capital_StringBuilder     builder,
            final int                       depth,
            final Object                    v,
            final Object                    w//,
        )
    {
        INVALID_ROUTINE();
    }


    @Override
    public /*overrideable*/ void        augment(
            final Capital_StringBuilder     builder,
            final int                       depth,
            final Object                    v,
            final Object                    w,
            final Object                    x//,
        )
    {
        INVALID_ROUTINE();
    }


    @Override
    public /*overrideable*/ void        augment(
            final Capital_StringBuilder     builder,
            final int                       depth,
            final Object                    v,
            final Object                    w,
            final Object                    x,
            final Object                    y//,
        )
    {
        INVALID_ROUTINE();
    }


    @Override
    public /*overrideable*/ void        augment(
            final Capital_StringBuilder     builder,
            final int                       depth,
            final Object                    v,
            final Object                    w,
            final Object                    x,
            final Object                    y4,
            final Object                    y5//,
        )
    {
        INVALID_ROUTINE();
    }


    @Override
    public /*overrideable*/ void        augment(
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
        INVALID_ROUTINE();
    }


    @Override
    public /*overrideable*/ void        augment(
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
        INVALID_ROUTINE();
    }


    @Override
    public /*overrideable*/ void        augment_1_plus(
            final Capital_StringBuilder     builder,
            final int                       depth,
            final Object                    v,
            final Object ...                other_arguments//,
        )
    {
        INVALID_ROUTINE();
    }
}
