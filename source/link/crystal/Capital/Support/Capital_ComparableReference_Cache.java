//  Copyright (c) 2018-2019 Amit Green.  All rights reserved.


package link.crystal.Capital.Support;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import link.crystal.Capital.Core.Capital_Map;
import link.crystal.Capital.Core.Capital_StringBuilder;
import link.crystal.Capital.Core.Zone;
import link.crystal.Capital.Inspection.Capital_Reference_Inspection;
import link.crystal.Capital.Inspection.Inspection;
import link.crystal.Capital.Interface.Capital_ComparableReference_Interface;
import link.crystal.Capital.Interface.Capital_Referenceable_Interface;
import link.crystal.Capital.Interface.Inspectable;


public abstract class   Capital_ComparableReference_Cache<
                            INSPECTION        extends Inspection,
                            CLIENT            extends Capital_Referenceable_Interface<CLIENT_INSPECTION>,
                            CLIENT_INSPECTION extends Inspection,
                            REFERENCE         extends Capital_ComparableReference_Interface<
                                                          ? extends Capital_Reference_Inspection,
                                                          CLIENT,
                                                          CLIENT_INSPECTION//,
                                                      >//,
                        >
    extends             Capital_Map<INSPECTION, REFERENCE, REFERENCE>
//  extends             HashMap                <REFERENCE, REFERENCE>
//  extends             AbstractHashMap        <REFERENCE, REFERENCE>
//  extends             Object
    implements          Inspectable<INSPECTION>//,
{
    //
    //  Constructor
    //
    protected                           Capital_ComparableReference_Cache(final Zone z, final int initial_capacity)
    {
        super(z, initial_capacity);
    }


    //
    //  Interface Inspectable
    //
    //
    public abstract INSPECTION          inspect();


    @Override
    public final void                   portray(final Capital_StringBuilder builder)
    {
        builder.append("<", this.inspect().simple_class_name, " total<", this.size(), ">>");
    }


    //
    //  Abstract Capital_Map
    //
    public final void                   dump(final String name)
    {
        final String                    simple_class_name = this.inspect().simple_class_name;

        /*:*/ List<REFERENCE>           keys = new ArrayList<REFERENCE>(this.keySet());

        Collections.sort(keys);

        final int                       total = keys.size();

        trace("Dump of {} {}", simple_class_name, name);
        trace("      size: " + Integer.toString(total));

        for (/*:*/ int                  i = 0; i < total; i ++) {
            final REFERENCE             k = keys.get(i);

            trace("  {}", k);
        }

        trace("End of dump of {} {}", simple_class_name, name);
    }
}
