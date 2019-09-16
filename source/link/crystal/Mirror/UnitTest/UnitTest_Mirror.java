//  Copyright (c) 2018-2019 Amit Green.  All rights reserved.


package link.crystal.Mirror.UnitTest;


import link.crystal.Capital.Core.Inspectable_Object;
import link.crystal.Capital.Core.Zone;
import link.crystal.Capital.Inspection.Inspection;
import link.crystal.Capital.Interface.Inspectable;
import link.crystal.Mock.Shape;


public final class  UnitTest_Mirror
    extends         Inspectable_Object<Inspection>
//  extends         Object
    implements      Inspectable<Inspection>//,
{
    private static final Inspection     inspection = Inspection.create("UnitTest_Mirror");


    //
    //  Members
    //
    public final Zone                   z;


    //
    //  Constructor & Factory
    //
    private                             UnitTest_Mirror(final Zone z)
    {
        this.z = z;
    }


    public static final UnitTest_Mirror     create(final Zone z)
    {
        return new UnitTest_Mirror(z);
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
    //  Public (Unit tests)
    //
    public final boolean                test_shape()
    {
        final Shape                     circle = Shape.create(z, "circle");

        assert false;

        circle.skew();

        return true;
    }
}
