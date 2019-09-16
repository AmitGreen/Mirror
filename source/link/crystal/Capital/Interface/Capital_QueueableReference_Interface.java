//  Copyright (c) 2018-2019 Amit Green.  All rights reserved.


package link.crystal.Capital.Interface;


import link.crystal.Capital.Core.Capital_StringBuilder;
import link.crystal.Capital.Inspection.Capital_Reference_Inspection;
import link.crystal.Capital.Inspection.Inspection;
import link.crystal.Capital.Interface.Capital_Reference_Interface;
import link.crystal.Capital.Interface.Inspectable;


public interface    Capital_QueueableReference_Interface<INSPECTION extends Capital_Reference_Inspection>
    extends         Capital_Reference_Interface<INSPECTION>,
                    Inspectable                <INSPECTION>//,
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
    public void                         reap();
}
