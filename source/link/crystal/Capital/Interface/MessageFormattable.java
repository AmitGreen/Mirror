//  Copyright (c) 2018-2019 Amit Green.  All rights reserved.


package link.crystal.Capital.Interface;


import java.lang.Object;
import java.lang.String;
import link.crystal.Capital.Core.Capital_StringBuilder;
import link.crystal.Capital.Inspection.Inspection;
import link.crystal.Capital.Interface.Inspectable;


public interface    MessageFormattable<INSPECTION extends Inspection>
    extends         Inspectable       <INSPECTION>//,
{
    //
    //  Interface Inspectable
    //
    public INSPECTION                   inspect();
    public void                         portray(final Capital_StringBuilder builder);


    //
    //  Interface <me>
    //
    String                              augment(final int depth);
    String                              augment(final int depth, final Object v);

    void                                augment(final Capital_StringBuilder builder, final int depth);
    void                                augment(final Capital_StringBuilder builder, final int depth, final Object v);

    void                                augment(
            final Capital_StringBuilder     builder,
            final int                       depth,
            final Object                    v,
            final Object                    w//,
        );

    void                                augment(
            final Capital_StringBuilder     builder,
            final int                       depth,
            final Object                    v,
            final Object                    w,
            final Object                    x//,
        );

    void                                augment(
            final Capital_StringBuilder     builder,
            final int                       depth,
            final Object                    v,
            final Object                    w,
            final Object                    x,
            final Object                    y//,
        );

    void                                augment(
            final Capital_StringBuilder     builder,
            final int                       depth,
            final Object                    v,
            final Object                    w,
            final Object                    x,
            final Object                    y4,
            final Object                    y5//,
        );

    void                                augment(
            final Capital_StringBuilder     builder,
            final int                       depth,
            final Object                    v,
            final Object                    w,
            final Object                    x,
            final Object                    y4,
            final Object                    y5,
            final Object                    y6//,
        );

    void                                augment(
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

    void                                augment_1_plus(
            final Capital_StringBuilder     builder,
            final int                       depth,
            final Object                    v,
            final Object ...                other_arguments//,
        );
}
