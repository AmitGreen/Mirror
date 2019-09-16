//  Copyright (c) 2018-2019 Amit Green.  All rights reserved.


package link.crystal.Mock;


import link.crystal.Capital.Core.Zone;
import link.crystal.Capital.Inspection.Inspection;
import link.crystal.Capital.Interface.Inspectable;
import link.crystal.Capital.Support.UniqueName;
import link.crystal.Mirror.MirrorProxy;


public final class  Shape
    extends         MirrorProxy<Shape, link.crystal.Alpha.Shape>
//  extends         Inspectable_Object<Inspection>
//  extends         Object
    implements      Inspectable<Inspection>//,
{
    private static final Inspection     inspection  = Inspection.create("Mock.Shape");
    private static final UniqueName     unique_name = UniqueName.create("shape#");


    //
    //  Constructor & Factory
    //
    private                             Shape(final Zone z, final link.crystal.Alpha.Shape client)
    {
        super(unique_name.next());
        initialize_client(client);
    }


    public static final Shape           create(final Zone z, final String shape_name)
    {
        final Class<link.crystal.Alpha.Shape>   meta = link.crystal.Alpha.Shape.class;

        final link.crystal.Alpha.Shape  client = link.crystal.Alpha.Shape.create(z, shape_name);

        return new Shape(z, client);
    }


    //
    //  Interface Inspectable
    //
    @Override
    public final Inspection             inspect()
    {
        return /*static*/ this.inspection;
    }


    //
    //  Public
    //
    public final void                   skew()
    {
        final link.crystal.Alpha.Shape  client = this.client;

        trace("Mirror.skew");

        client.skew();
    }
}
