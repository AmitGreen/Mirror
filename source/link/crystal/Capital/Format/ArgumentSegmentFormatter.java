//  Copyright (c) 2018-2019 Amit Green.  All rights reserved.


package link.crystal.Capital.Format;


import java.lang.String;
import link.crystal.Capital.Core.Capital_StringBuilder;
import link.crystal.Capital.Core.Zone;
import link.crystal.Capital.Format.ArgumentSegmentFormatter_Inspection;
import link.crystal.Capital.Format.MessageFormatter_Base;
import link.crystal.Capital.Interface.Inspectable;
import link.crystal.Capital.Interface.MessageFormattable;
import link.crystal.Capital.Interface.SegmentFormattable;


public abstract class   ArgumentSegmentFormatter<INSPECTION extends ArgumentSegmentFormatter_Inspection>
    extends             MessageFormatter_Base   <INSPECTION>
//  extends             Inspectable_Object      <INSPECTION>
//  extends             Object
    implements          MessageFormattable      <INSPECTION>,
                        SegmentFormattable      <INSPECTION>,
                        Inspectable             <INSPECTION>//,
{
    //
    //  Members
    //
    protected final int                 argument_index;


    //
    //  Constructor
    //
    protected                           ArgumentSegmentFormatter(final int argument_index)
    {
        this.argument_index = argument_index;
    }


    //
    //  Interface Inspectable
    //
    public abstract INSPECTION          inspect();


    //
    //  Interface MessageFormattable
    //
    public abstract void                augment(final Capital_StringBuilder builder, int depth, final Object v);

    public abstract void                augment_1_plus(
            final Capital_StringBuilder     builder,
            final int                       depth,
            final Object                    v,
            final Object ...                other_arguments//,
        );


    //
    //  Interface SegmentFormattable
    //
    public abstract void                choose(final Capital_StringBuilder builder, final int depth);
    public abstract void                choose(final Capital_StringBuilder builder, final int depth, final Object v);

    public abstract void                choose(
            final Capital_StringBuilder     builder,
            final int                       depth,
            final Object                    v,
            final Object                    w//,
        );

    public abstract void                choose(
            final Capital_StringBuilder     builder,
            final int                       depth,
            final Object                    v,
            final Object                    w,
            final Object                    x//,
        );

    public abstract void                choose(
            final Capital_StringBuilder     builder,
            final int                       depth,
            final Object                    v,
            final Object                    w,
            final Object                    x,
            final Object                    y//,
        );

    public abstract void                choose(
            final Capital_StringBuilder     builder,
            final int                       depth,
            final Object                    v,
            final Object                    w,
            final Object                    x,
            final Object                    y4,
            final Object                    y5//,
        );

    public abstract void                choose(
            Capital_StringBuilder           builder,
            int                             depth,
            Object                          v,
            Object                          w,
            Object                          x,
            Object                          y4,
            Object                          y5,
            Object                          y6//,
        );

    public abstract void                choose(
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
        );


    //
    //  Interface Inspectable
    //
    @Override
    public final void                   portray(final Capital_StringBuilder builder)
    {
        builder.append("<", this.inspect().simple_class_name, " ", this.argument_index, ">");
    }
}
