//  Copyright (c) 2018-2019 Amit Green.  All rights reserved.


package link.crystal.Capital.Interface;


import java.lang.String;
import link.crystal.Capital.Core.Zone;


//
//  NOTE:
//      Interface `Storehouse_String__Interface` does *NOT* extend `Inspectable` since it is used for
//      `Temporary_Storehouse_String` (which must *NOT* be `Inspectable` -- to avoid class initialiation loops).
//
public interface    Storehouse_String__Interface
{
    //
    //  Interface <me>
    //
    public void                         dump                   (final String name);
    public String                       intern_permenant_string(final Zone z, final String s);
}
