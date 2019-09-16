//  Copyright (c) 2018-2019 Amit Green.  All rights reserved.


package link.crystal.Capital.Exception;


import java.lang.RuntimeException;
import link.crystal.Capital.Core.Capital_StringBuilder;
import link.crystal.Capital.Core.Zone;
import link.crystal.Capital.Inspection.Inspection;
import link.crystal.Capital.Interface.Inspectable;


public final class      AssertionError
    extends             RuntimeException
    implements          Inspectable<Inspection>//,
{
    private static final Inspection     inspection = Inspection.create("AssertionError");


    //
    //  Members
    //
    public final Zone                   z;


    //
    //  Constructor & Factory
    //
    private                             AssertionError(final Zone z, final String error_message)
    {
        super(error_message);

        this.z = z;
    }


    public static final AssertionError  create(final Zone z, final String error_message)
    {
        return new AssertionError(z, error_message);
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
        builder.append("<AssertionError ");
        builder.java_quote(this.getMessage());
        builder.append(">");
    }
}
