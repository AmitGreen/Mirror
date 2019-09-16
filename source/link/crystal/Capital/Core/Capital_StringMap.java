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


public abstract class   Capital_StringMap<INSPECTION extends Inspection, V>
    extends             Capital_Map      <INSPECTION, String,            V>
//  extends             HashMap                      <String,            V>
//  extends             AbstractHashMap              <String,            V>
//  extends             Object
    implements          Inspectable      <INSPECTION>//,
{
    //
    //  Constructor
    //
    protected                           Capital_StringMap(final Zone z, final int initial_capacity)
    {
        super(z, initial_capacity);
    }


    //
    //  Interface Inspectable
    //
    @Override
    public final void                   portray(final Capital_StringBuilder builder)
    {
        final Inspection                inspection = this.inspect();

        builder.append("<", inspection.simple_class_name, " size<", this.size(), ">>");
    }


    //
    //  Public
    //
    public /*overrideable*/ void        dump(final String name)
    {
        final Inspection                inspection = this.inspect();

        final String                    simple_class_name = inspection.simple_class_name;

        final List<String>              keys = new ArrayList<String>(this.keySet());

        Collections.sort(keys);

        final int                       total = keys.size();

        trace("Dump of {} {}", simple_class_name, name);
        trace("  size: {}", total);

        for (/*:*/ int                  i = 0; i < total; i ++) {
            final String                k = keys.get(i);
            final V                     v = this.get(k);

            trace("  {}: {}", String.format("%40s", z.quote_string(k)), v);
        }

        trace("End of dump of {} {}", simple_class_name, name);
    }


    public final V                      find(final String k)
    {
        assert fact_pointer(k, "k");

        final V                         r = this.get(k);

        if (r == null) {
            RUNTIME("cannot find key {}", k);
        }

        return r;
    }
}
