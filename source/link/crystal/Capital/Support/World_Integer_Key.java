//  Copyright (c) 2018-2019 Amit Green.  All rights reserved.


package link.crystal.Capital.Support;


import link.crystal.Capital.Core.Capital_StringBuilder;
import link.crystal.Capital.Core.Inspectable_Object;
import link.crystal.Capital.Core.Zone;
import link.crystal.Capital.Inspection.Inspection;
import link.crystal.Capital.Interface.Inspectable;
import link.crystal.Capital.Support.World_Integer_WeakReference;
import link.crystal.Capital.World.World_Integer;


public final class  World_Integer_Key
    extends         Inspectable_Object<Inspection>
//  extends         Object
    implements      Inspectable       <Inspection>//,
{
    private static final Inspection     inspection = Inspection.create("World_Integer_Key");


    //
    //  Members
    //
    private final Zone                  z;
    public  /*:*/ int                   value;


    //
    //  Constructor, Factory, & Recycle
    //
    protected                           World_Integer_Key(final Zone z)
    {
        this.z     = z;
        this.value = 0;
    }


    public static final World_Integer_Key   create__ALLY__Zone(final Zone z)
    {
        return new World_Integer_Key(z);
    }


    public final void                   recycle(final int value)
    {
        this.value = value;
    }


    //
    //  Abstract object
    //
    @Override
    public final int                    hashCode()
    {
        return this.value;
    }


    @Override
    public final boolean                equals(final Object that)
    {
        if ( ! (that instanceof World_Integer_WeakReference)) {
            return false;
        }

        World_Integer_WeakReference     weak_reference = (World_Integer_WeakReference) that;

        return this.value == weak_reference.value;
    }


    //
    //  Interface Inspectable
    //
    @Override
    public final Inspection             inspect()
    {
        return /*static*/ this.inspection;
    }


    public final void                   portray(final Capital_StringBuilder builder)
    {
        builder.append("<World_Integer_Key ", this.value, ">");
    }
}
