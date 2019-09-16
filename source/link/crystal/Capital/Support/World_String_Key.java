//  Copyright (c) 2018-2019 Amit Green.  All rights reserved.


package link.crystal.Capital.Support;


import link.crystal.Capital.Core.Inspectable_Object;
import link.crystal.Capital.Core.Capital_StringBuilder;
import link.crystal.Capital.Core.Zone;
import link.crystal.Capital.Inspection.Inspection;
import link.crystal.Capital.Interface.Inspectable;
import link.crystal.Capital.Support.World_String_WeakReference;
import link.crystal.Capital.World.World_String;


public final class  World_String_Key
    extends         Inspectable_Object<Inspection>
//  extends         Object
    implements      Inspectable       <Inspection>//,
{
    private static final Inspection     inspection = Inspection.create("World_String_Key");


    //
    //  Members
    //
    private final Zone                  z;
    private /*:*/ int                   pulp;
    public  /*:*/ String                s;


    //
    //  Constructor, Factory, & Recycle
    //
    protected                           World_String_Key(final Zone z)
    {
        this.z = z;
        this.s = null;
    }


    public static final World_String_Key    create__ALLY__Zone(final Zone z)
    {
        return new World_String_Key(z);
    }


    public final void                   recycle(final String s)
    {
        this.pulp = s.hashCode();
        this.s    = s;
    }


    //
    //  Abstract object
    //
    @Override
    public final int                    hashCode()
    {
        return this.pulp;
    }


    @Override
    public final boolean                equals(final Object that)
    {
        if ( ! (that instanceof World_String_WeakReference)) {
            return false;
        }

        World_String_WeakReference      weak_reference = (World_String_WeakReference) that;

        return this.s.equals(weak_reference.s);
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
        builder.append("<World_String_Key ");
        builder.java_quote(this.s);
        builder.append(">");
    }
}
