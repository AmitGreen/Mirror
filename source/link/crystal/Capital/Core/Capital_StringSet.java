//  Copyright (c) 2018-2019 Amit Green.  All rights reserved.


package link.crystal.Capital.Core;


import java.lang.String;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import link.crystal.Capital.Core.Capital_Map;
import link.crystal.Capital.Core.Capital_StringBuilder;
import link.crystal.Capital.Core.Zone;
import link.crystal.Capital.Inspection.Inspection;
import link.crystal.Capital.Interface.Inspectable;


public abstract class   Capital_StringSet<INSPECTION extends Inspection>
    extends             Capital_Map      <INSPECTION, String, String>
//  extends             HashMap                    <String, String>
//  extends             AbstractHashMap            <String, String>
//  extends             Object
    implements          Inspectable      <INSPECTION>//,
{
    //
    //  Constructor
    //
    protected                           Capital_StringSet(final Zone z, final int initial_capacity)
    {
        super(z, initial_capacity);
    }


    //
    //  Interface Inspectable
    //
    @Override
    public final void                   portray(final Capital_StringBuilder builder)
    {
        builder.append("<", this.inspect().simple_class_name, " size<", this.size(), ">>");
    }


    //
    //  Public
    //
    public final void                   dump(final String name)
    {
        final String                    simple_class_name = this.inspect().simple_class_name;

        final List<String>              keys = new ArrayList<String>(this.keySet());

        Collections.sort(keys);

        final int                       total = keys.size();

        trace("Dump of {} {}", simple_class_name, name);
        trace("      size: {}", total);

        for (/*:*/ int                  i = 0; i < total; i ++) {
            final String                k = keys.get(i);

            trace("  {p}", k);
        }

        trace("End of dump of {} {}", simple_class_name, name);
    }
}
