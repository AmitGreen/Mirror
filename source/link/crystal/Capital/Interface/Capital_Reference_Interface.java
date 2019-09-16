//  Copyright (c) 2018-2019 Amit Green.  All rights reserved.


package link.crystal.Capital.Interface;


import link.crystal.Capital.Core.Capital_StringBuilder;
import link.crystal.Capital.Inspection.Capital_Reference_Inspection;
import link.crystal.Capital.Interface.Inspectable;


public interface    Capital_Reference_Interface<INSPECTION extends Capital_Reference_Inspection>
    extends         Inspectable                <INSPECTION>//,
{
    //
    //  Interface Inspectable
    //
    @Override                           //  NOTE: Different `INSPECTION`
    public INSPECTION                   inspect();

    public void                         portray(final Capital_StringBuilder builder);


    //
    //  Interface <me>
    //
    //<empty>
}
