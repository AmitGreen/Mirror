//  Copyright (c) 2018-2019 Amit Green.  All rights reserved.


package link.crystal.Mirror;


import link.crystal.Capital.Core.Capital_StringBuilder;
import link.crystal.Capital.Core.Inspectable_Object;
import link.crystal.Capital.Core.Zone;
import link.crystal.Capital.Inspection.Inspection;
import link.crystal.Capital.Interface.Inspectable;


public abstract class   MirrorProxy<PROXY extends MirrorProxy, CLIENT extends Object>
    extends             Inspectable_Object<Inspection>
//  extends             Object
    implements          Inspectable       <Inspection>//,
{
    //
    //  Members
    //
    protected final Zone                z;
    protected final String              proxy_name;
    protected /*:*/ CLIENT              client;


    //
    //  Constructor
    //
    protected                           MirrorProxy(final String proxy_name)
    {
        assert fact_pointer(proxy_name, "proxy_nme");

        this.z          = Zone.current_zone();
        this.proxy_name = proxy_name;
        this.client     = null;
    }


    protected final void                initialize_client(final CLIENT client)
    {
        assert fact_pointer(this.z,          "this.z");
        assert fact_pointer(this.proxy_name, "this.proxy_nme");
        assert fact_null   (this.client,     "this.client");

        this.client = client;
    }

    
    //
    //  Allies
    //
    public final static<PROXY extends MirrorProxy, CLIENT> CLIENT   client__ALLY__mirror(
            MirrorProxy<PROXY, CLIENT>                                  proxy//,
        )
    {
        if (proxy == null) {
            return null;
        }

        assert fact_pointer(proxy.client, "proxy.client");

        return proxy.client;
    }


    public final String                 proxy_name__ALLY__mirror()
    {
        return this.proxy_name;
    }


    //
    //  Interface Inspectable
    //
    public abstract Inspection          inspect();


    @Override
    public final void                   portray(final Capital_StringBuilder builder)
    {
        final Inspection                inspection = this.inspect();

        builder.append("<", inspection.simple_class_name, " ", this.proxy_name, ">");
    }
}
