//  Copyright (c) 2018-2019 Amit Green.  All rights reserved.


package link.crystal.Capital.Inspection;


import java.lang.Comparable;
import link.crystal.Capital.Core.Capital_StringBuilder;
import link.crystal.Capital.Core.Zone;
import link.crystal.Capital.Format.ArgumentSegmentFormatter;
import link.crystal.Capital.Inspection.Inspection;
import link.crystal.Capital.Inspection.World_Inspection;
import link.crystal.Capital.Interface.Capital_Comparable;
import link.crystal.Capital.Interface.Inspectable;


public /*:*/ class  Comparable_Inspection
    extends         Inspection
//  extends         Inspectable_Object<World_Inspection>
//  extends         Object
    implements      Capital_Comparable<World_Inspection>,
                    Comparable<Capital_Comparable<? extends Comparable_Inspection>>,    //  Via Capital_Comparable
                    Inspectable       <World_Inspection>//,
{
    //
    //  Class Order magic values
    //
    public static final int CLASS_ORDER__NONE                    = 0;
    public static final int CLASS_ORDER__INSPECTION              = 1;
    public static final int CLASS_ORDER__Mirror_String           = 2;
    public static final int CLASS_ORDER__World_Integer           = 3;
    public static final int CLASS_ORDER__WORLD_INTEGER_REFERENCE = 4;
    public static final int CLASS_ORDER__World_String            = 5;
    public static final int CLASS_ORDER__WORLD_STRING_REFERENCE  = 6;

    public static final int CLASS_ORDER__Maximum                 = 6;


    //
    //  Static inspection
    //
    private static final World_Inspection   inspection = World_Inspection.create("Comparable_Inspection");


    //
    //  Members
    //
    public final int                    class_order;
    public final boolean                is_world_inspection;        //  NOTE: Not currently used


    //
    //  Constructor & Factory
    //
    protected                           Comparable_Inspection(
            final String                    simple_class_name,
            final int                       class_order,
            final boolean                   is_world_inspection//,
        )
    {
        super(simple_class_name, /*is_cache=*/ false);

        this.class_order         = class_order;
        this.is_world_inspection = is_world_inspection;
    }


    public static final Comparable_Inspection   create(final String simple_class_name, final int class_order)
    {
        assert fact_between(0, class_order, Comparable_Inspection.CLASS_ORDER__Maximum);

        final Zone                      z = Zone.current_zone();

        final String                    interned__simple_class_name = z.intern_permenant_string(simple_class_name);

        return new Comparable_Inspection(
                   interned__simple_class_name,
                   class_order,
                   /*is_world_inspection=*/  false//,
               );
    }


    //
    //  Interface java.lang.Comparable
    //
    //<public inherited int         compareTo(Capital_Comparable<? extends Comparable_Inspection> that);>


    //
    //  Interface Capital_Comparable (and java.lang.Comparable)
    //
    //<empty>


    //
    //  Interface Inspectable
    //
    //  NOTE:
    //      Includes extra helper function `portray_prefix` which is *NOT* part of `Interface Inspectable`
    //
    @Override
    public /*overrideable*/ World_Inspection    inspect()
    {
        return /*static*/ this.inspection;
    }


    @Override
    public final void                   portray_prefix(final Capital_StringBuilder builder)
    {
        super.portray_prefix(builder);

        if (this.is_world_inspection) {
            builder.append("; is_world_inspection");
        }
    }


    @Override
    public /*overrideable*/ void        portray(final Capital_StringBuilder builder)
    {
        this.portray_prefix(builder);
        builder.append(">");
    }
}
