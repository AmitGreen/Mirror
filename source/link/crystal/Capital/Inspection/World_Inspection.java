//  Copyright (c) 2018-2019 Amit Green.  All rights reserved.


package link.crystal.Capital.Inspection;


import java.lang.Comparable;
import link.crystal.Capital.Core.Zone;
import link.crystal.Capital.Format.ArgumentSegmentFormatter;
import link.crystal.Capital.Inspection.Comparable_Inspection;
import link.crystal.Capital.Interface.Capital_Comparable;
import link.crystal.Capital.Interface.Inspectable;


public final class  World_Inspection
    extends         Comparable_Inspection
//  extends         Inspection
//  extends         Inspectable_Object<World_Inspection>
//  extends         Object
    implements      Capital_Comparable<World_Inspection>,
                    Comparable<Capital_Comparable<? extends Comparable_Inspection>>,    //  Via Capital_Comparable
                    Inspectable       <World_Inspection>//,
{
    private static final World_Inspection   inspection = World_Inspection.create("World_Inspection");


    //
    //  Constructor & Factory
    //
    private                             World_Inspection(final String simple_class_name)
    {
        super(
                simple_class_name,
                Comparable_Inspection.CLASS_ORDER__INSPECTION,
                /*is_world_inspection=*/ true//,
            );
    }


    public static final World_Inspection    create(final String simple_class_name)
    {
        final Zone                      z = Zone.current_zone();

        final String                    interned__simple_class_name = z.intern_permenant_string(simple_class_name);

        return new World_Inspection(interned__simple_class_name);
    }


    //
    //  Interface java.lang.Comparable
    //
    //<public inherited int         compareTo(Capital_Comparable<? extends Comparable_Inspection> that);>


    //
    //  Interface Capital_Comparable
    //
    //<empty>


    //
    //  Interface Inspectable
    //
    @Override
    public final World_Inspection       inspect()
    {
        return /*static*/ this.inspection;
    }
}
