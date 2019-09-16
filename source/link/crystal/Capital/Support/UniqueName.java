//  Copyright (c) 2018-2019 Amit Green.  All rights reserved.


package link.crystal.Capital.Support;


import java.lang.String;
import link.crystal.Capital.Core.Capital_StringBuilder;
import link.crystal.Capital.Core.Inspectable_Object;
import link.crystal.Capital.Core.Zone;
import link.crystal.Capital.Inspection.Inspection;
import link.crystal.Capital.Interface.Inspectable;


public final class  UniqueName
    extends         Inspectable_Object<Inspection>
//  extends         Object
    implements      Inspectable       <Inspection>//,
{
    private static final Inspection     inspection = Inspection.create("UniqueName");


    //
    //  Members
    //
    private final String                prefix;
    private /*:*/ int                   value;


    //
    //  Constructor & Factory
    //
    protected                           UniqueName(final String prefix)
    {
        this.prefix = prefix;
        this.value  = 1;
    }


    public static final UniqueName      create(final String prefix)
    {
        final Zone                      z               = Zone.current_zone();
        final String                    interned_prefix = z.intern_permenant_string(prefix);

        return new UniqueName(prefix);
    }


    //
    //  Interface Inspectable
    //
    @Override
    public final Inspection         inspect()
    {
        return /*static*/ this.inspection;
    }


    @Override
    public final void                   portray(final Capital_StringBuilder builder)
    {
        builder.append("<UniqueName ");
        builder.java_quote(this.prefix);
        builder.append(" ", this.value,">");
    }


    //
    //  Ally
    //
    public final void                   skip_value__ALLY__UnitTest(final int value)
    {
        assert fact(this.value < value, "this.value < value");

        this.value = value;
    }


    public final int                    value__ALLY__UnitTest()
    {
        return this.value;
    }


    //
    //  Public
    //
    public final String                 next()
    {
        final int                       value = this.value;

        assert fact(value >= 0, "this.value<{}> >= 0", value);

        this.value = value + 1;

        return this.prefix + Integer.toString(value);
    }
}
