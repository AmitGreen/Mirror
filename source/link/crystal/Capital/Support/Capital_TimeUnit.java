//  Copyright (c) 2018-2019 Amit Green.  All rights reserved.


package link.crystal.Capital.Support;


import java.lang.InterruptedException;
import java.util.concurrent.TimeUnit;
import link.crystal.Capital.Core.Capital_Object;


public abstract class   Capital_TimeUnit
    extends             Capital_Object
//  extends             Object
{
    public static final void            test()
    {
        trace("TimeUnit: {}", TimeUnit.class);
        trace("TimeUnit.SECONDS: {}", TimeUnit.SECONDS);

        trace("Sleeping for 1 second ...");

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            trace(" ... Sleep interrupted: {}", e);
        }
    }
}
