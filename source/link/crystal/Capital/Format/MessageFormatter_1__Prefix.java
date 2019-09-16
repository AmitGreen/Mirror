//  Copyright (c) 2018-2019 Amit Green.  All rights reserved.


package link.crystal.Capital.Format;


import java.lang.String;
import link.crystal.Capital.Core.Capital_StringBuilder;
import link.crystal.Capital.Core.Zone;
import link.crystal.Capital.Format.MessageFormatter_Base;
import link.crystal.Capital.Inspection.Inspection;
import link.crystal.Capital.Interface.Inspectable;
import link.crystal.Capital.Interface.MessageFormattable;


public final class  MessageFormatter_1__Prefix
    extends         MessageFormatter_Base<Inspection>
//  extends         Inspectable_Object   <Inspection>
//  extends         Object
    implements      MessageFormattable   <Inspection>,
                    Inspectable          <Inspection>//,
{
    private static final Inspection     inspection = Inspection.create("MessageFormatter_1__Prefix");


    //
    //  Members
    //
    private final String                prefix;


    //
    //  Constructor & Factory
    //
    private                             MessageFormatter_1__Prefix(final String prefix)
    {
        this.prefix = prefix;
    }


    public static final MessageFormatter_1__Prefix  create(final Zone z, final String prefix)
    {
        final String                    interned__prefix = z.intern_permenant_string(prefix);

        return new MessageFormatter_1__Prefix(interned__prefix);
    }


    //
    //  Interface Inspectable
    //
    @Override
    public final Inspection             inspect()
    {
        return /*static*/ this.inspection;
    }


    @Override
    public final void                   portray(final Capital_StringBuilder builder)
    {
        builder.append("<MessageFormatter_1__Prefix ");
        builder.java_quote(this.prefix);
        builder.append(">");
    }


    //
    //  Interface MessageFormattable
    //
    @Override
    public final void                   augment(final Capital_StringBuilder builder, int depth, final Object v)
    {
        builder.append(this.prefix);
        builder.portray(v);
    }


    @Override
    public final void                   augment_1_plus(
            final Capital_StringBuilder     builder,
            final int                       depth,
            final Object                    v,
            final Object ...                other_arguments//,
        )
    {
        if (other_arguments.length != 0) {
            RUNTIME("{p} argument{} given (expected 0)",
                    other_arguments.length,
                    (other_arguments.length == 1 ? "" : "s"));
        }

        builder.append(this.prefix);
        builder.portray(v);
    }
}
