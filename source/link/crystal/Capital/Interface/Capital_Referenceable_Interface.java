//  Copyright (c) 2018-2019 Amit Green.  All rights reserved.


package link.crystal.Capital.Interface;


import java.lang.Comparable;
import link.crystal.Capital.Core.Capital_StringBuilder;
import link.crystal.Capital.Inspection.Inspection;
import link.crystal.Capital.Interface.Inspectable;


//
//  NOTE:
//      Saying that something `Capital_Referenceable_Interface` does not currently really say anything....
//
//      For now, this interface is only used for clarity to indicate something can be "referenced".
//
//      In the future, methods might be added ... in which case this interface becomes significant.
//
public interface    Capital_Referenceable_Interface<INSPECTION extends Inspection>
    extends         Inspectable                    <INSPECTION>//,
{
    //
    //  Interface Inspectable
    //
    public INSPECTION                   inspect();
    public void                         portray(final Capital_StringBuilder builder);


    //
    //  Interface <me>
    //
}
