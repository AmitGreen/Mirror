//  Copyright (c) 2018-2019 Amit Green.  All rights reserved.


package link.crystal.Capital.Support;


import java.lang.String;
import link.crystal.Capital.Core.Capital_StringBuilder;
import link.crystal.Capital.Core.Inspectable_Object;
import link.crystal.Capital.Core.Zone;
import link.crystal.Capital.Inspection.Inspection;
import link.crystal.Capital.Interface.Inspectable;


public abstract class   Storehouse_SmallList<STOREHOUSE extends Storehouse_SmallList, ELEMENT extends Inspectable_Object>
    extends             Inspectable_Object<Inspection>
//  extends             Object
    implements          Inspectable       <Inspection>//,
{
    //
    //  Members
    //
    protected final Zone                z;
    protected final ELEMENT[]           segment_many;


    //
    //  Constructor & Factory
    //
    protected                           Storehouse_SmallList(final Zone z, final ELEMENT[] segment_many)
    {
        this.z            = z;
        this.segment_many = segment_many;
    }


    //
    //  Interface Inspectable
    //
    @Override
    public final void                   portray(final Capital_StringBuilder builder)
    {
        builder.append("<", this.inspect().simple_class_name, " size<", this.segment_many.length, ">>");
    }


    //
    //  Public
    //
    public final void                   insert(final Zone z, final int argument_index, final ELEMENT segment)
    {
        assert fact(this.z == z, "this.z == z");

        final ELEMENT[]                 segment_many = this.segment_many;

        final int                       segment_allocated = segment_many.length;

        assert fact_between(0, argument_index, segment_allocated - 1);
        assert fact_null   (segment_many[argument_index], "segment_many[argument_index]");

        segment_many[argument_index] = segment;
    }


    public final ELEMENT                lookup(final Zone Z, final int argument_index)
    {
        assert fact(this.z == z, "this.z == z");

        final ELEMENT[]                 segment_many = this.segment_many;

        final int                       segment_allocated = segment_many.length;

        assert fact_between(0, argument_index, segment_allocated - 1);

        return this.segment_many[argument_index];
    }


    public final void                   dump()
    {
        final Inspection                inspection = this.inspect();

        final String                    simple_class_name = inspection.simple_class_name;

        final ELEMENT[]                 segment_many = this.segment_many;

        final int                       segment_allocated = segment_many.length;

        trace("Dump of {}", simple_class_name);
        trace("  size:  {}", segment_allocated);

        for (/*:*/ int                  i       = 0; i < segment_allocated; i ++) {
            final ELEMENT               segment = segment_many[i];

            if (segment == null) {
                continue;
            }

            trace("  {}:  {}", i, segment);
        }

        trace("End of dump of {}", simple_class_name);
    }
}
