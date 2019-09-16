//  Copyright (c) 2019 Amit Green.  All rights reserved.


package link.crystal.Alpha;


import link.crystal.Capital.Core.Inspectable_Object;
import link.crystal.Capital.Core.Capital_StringBuilder;
import link.crystal.Capital.Core.Zone;
import link.crystal.Capital.Inspection.Inspection;
import link.crystal.Capital.Interface.Inspectable;


public final class  Shape
    extends         Inspectable_Object<Inspection>
//  extends         Object
    implements      Inspectable       <Inspection>//,
{
    private static final Inspection     inspection = Inspection.create("Shape");


    //
    //  Members
    //
    public final String                 shape_name;


    //
    //  Constructor & Factory
    //
    private                             Shape(final String shape_name)
    {
        this.shape_name = shape_name;
    }


    public static final Shape           create(final Zone z, final String shape_name)
    {
        return new Shape(shape_name);
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
        builder.append("<Shape ", this.shape_name, ">");
    }


    //
    //  Public
    //
    public final void                   skew()
    {
        trace("Shape.skew: " + this.shape_name);
    }
}
