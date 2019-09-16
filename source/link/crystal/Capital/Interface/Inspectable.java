//  Copyright (c) 2018-2019 Amit Green.  All rights reserved.


package link.crystal.Capital.Interface;


import java.lang.String;
import link.crystal.Capital.Core.Capital_StringBuilder;
import link.crystal.Capital.Inspection.Inspection;


public interface    Inspectable<INSPECTION extends Inspection>
{
    //
    //  Interface <me>
    //
    public INSPECTION                   inspect();
    public void                         portray(final Capital_StringBuilder builder);
}
