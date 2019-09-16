//  Copyright (c) 2018-2019 Amit Green.  All rights reserved.


package link.crystal.Capital.Inspection;


import java.lang.Comparable;
import link.crystal.Capital.Core.Capital_StringBuilder;
import link.crystal.Capital.Core.Zone;
import link.crystal.Capital.Format.ArgumentSegmentFormatter;
import link.crystal.Capital.Inspection.Comparable_Inspection;
import link.crystal.Capital.Inspection.World_Inspection;
import link.crystal.Capital.Interface.Capital_Comparable;
import link.crystal.Capital.Interface.Inspectable;


public final class  Capital_Reference_Inspection
    extends         Comparable_Inspection
//  extends         Inspection
//  extends         Inspectable_Object<World_Inspection>
//  extends         Object
    implements      Capital_Comparable<World_Inspection>,
                    Comparable<Capital_Comparable<? extends Comparable_Inspection>>,    //  Via Capital_Comparable
                    Inspectable       <World_Inspection>//,
{
    private static final World_Inspection   inspection = World_Inspection.create("Capital_Reference_Inspection");


    //
    //  Members
    //
    public final boolean                is_enduring_reference;
    public final boolean                is_phantom_reference;
    public final boolean                is_weak_reference;


    //
    //  Constructor & Factory
    //
    private                             Capital_Reference_Inspection(
            final String                        simple_class_name,
            final int                           class_order,
        /*  final boolean                       is_world_inspection = false,  */
            final boolean                       is_enduring_reference,
            final boolean                       is_phantom_reference,
            final boolean                       is_weak_reference//,
        )
    {
        super(simple_class_name, class_order, false);

        this.is_enduring_reference = is_enduring_reference;
        this.is_phantom_reference  = is_phantom_reference;
        this.is_weak_reference     = is_weak_reference;
    }


    public static final Capital_Reference_Inspection    create(
            final String                        simple_class_name,
            final int                           class_order,
        /*  final boolean                       is_world_inspection = false,  */
            final String                        reference_type//,
        )
    {
        final boolean                   is_enduring_reference = reference_type.equals("enduring");
        final boolean                   is_phantom_reference  = reference_type.equals("phantom");
        final boolean                   is_weak_reference     = reference_type.equals("weak");

        assert fact (
                (
                        (
                              (is_enduring_reference ? 1 : 0)
                            + (is_phantom_reference  ? 1 : 0)
                            + (is_weak_reference     ? 1 : 0)
                        )
                    == 1
                ),
                "one & exactly one of is_{enduring,phantom,weak}_reference must be set"//,
            );

        final Zone                      z = Zone.current_zone();

        final String                    interned__simple_class_name = z.intern_permenant_string(simple_class_name);

        return new Capital_Reference_Inspection(
                   interned__simple_class_name,
                   class_order,
               /*  is_world_inspection = false,  */
                   is_enduring_reference,
                   is_phantom_reference,
                   is_weak_reference//,
               );
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


    @Override
    public final void                   portray(final Capital_StringBuilder builder)
    {
        this.portray_prefix(builder);

        if (this.is_enduring_reference) {
            builder.append("; is_enduring_reference");
        }

        if (this.is_weak_reference) {
            builder.append("; is_weak_reference");
        }

        builder.append(">");
    }
}
