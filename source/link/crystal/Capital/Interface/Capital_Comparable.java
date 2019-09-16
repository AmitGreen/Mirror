//  Copyright (c) 2018-2019 Amit Green.  All rights reserved.


package link.crystal.Capital.Interface;


import java.lang.Comparable;
import link.crystal.Capital.Core.Capital_StringBuilder;
import link.crystal.Capital.Inspection.Comparable_Inspection;
import link.crystal.Capital.Interface.Inspectable;


public interface    Capital_Comparable<INSPECTION extends Comparable_Inspection>
    extends         Comparable<Capital_Comparable<? extends Comparable_Inspection>>,
                    Inspectable       <INSPECTION>//,
{
    //
    //  Interface java.lang.Comparable
    //
    @Override                           //  NOTE: Different `that`
    public int                          compareTo(final Capital_Comparable<? extends Comparable_Inspection> that);


    //
    //  Interface Inspectable
    //
    @Override
    public INSPECTION                   inspect();                      //  NOTE: Different `INSPECTION`

    public void                         portray(final Capital_StringBuilder builder);


    //
    //  Interface <me>
    //
    //  NOTE:
    //      None -- This interface is only used for clarity to indicate something is a "Gem Comparable";
    //      and the type of the first argument to `compareTo` is `Capital_Comparable<? extends Comparable_Inspection>`
    //      (See decleration above in `Interface java.lang.Comparable` for `compareTo`)
    //
}
