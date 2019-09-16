//  Copyright (c) 2018-2019 Amit Green.  All rights reserved.


package link.crystal.Capital.World;


import java.lang.Comparable;
import link.crystal.Capital.Core.Inspectable_Object;
import link.crystal.Capital.Core.Capital_StringBuilder;
import link.crystal.Capital.Inspection.Comparable_Inspection;
import link.crystal.Capital.Interface.Capital_Comparable;
import link.crystal.Capital.Interface.Capital_Referenceable_Interface;
import link.crystal.Capital.Interface.Inspectable;


public final class  World_String
    extends         Inspectable_Object             <Comparable_Inspection>
//  extends         Object
    implements      Capital_Comparable             <Comparable_Inspection>,
                    Capital_Referenceable_Interface<Comparable_Inspection>,
                    Comparable<Capital_Comparable<? extends Comparable_Inspection>>,    //  Via Capital_Comparable
                    Inspectable                    <Comparable_Inspection>//,
{
    private static final Comparable_Inspection  inspection = Comparable_Inspection.create(
            "World_String",
            Comparable_Inspection.CLASS_ORDER__World_String//,
        );


    //
    //  Members
    //
    private /*:*/ String                world_name;
    public  final String                s;


    //
    //  Constructor & Factory
    //
    protected                           World_String(final String s)
    {
        this.world_name = null;
        this.s          = s;
    }


    public static final World_String    create__ALLY__Capital(final String s)
    {
        return new World_String(s);
    }


    //
    //  Interface java.lang.Comparable
    //
    @Override
    public final int                    compareTo(final Capital_Comparable<? extends Comparable_Inspection> that)
    {
        final int                       class_compare = (
                Comparable_Inspection.CLASS_ORDER__World_String - that.inspect().class_order
            );

        if (class_compare != 0) {
            return class_compare;
        }

        final World_String             that_2 = (World_String) that;

        return this.s.compareTo(that_2.s);
    }


    //
    //  Interface Capital_Comparable
    //
    //<empty>


    //
    //  Interface Inspectable
    //
    @Override
    public final Comparable_Inspection  inspect()
    {
        return /*static*/ this.inspection;
    }


    @Override
    public final void                   portray(final Capital_StringBuilder builder)
    {
        builder.append("<");
        builder.java_quote(this.s);
        builder.append(">");
    }
}
