//  Copyright (c) 2018-2019 Amit Green.  All rights reserved.


package link.crystal.Capital.Interface;


import java.lang.Comparable;
import link.crystal.Capital.Core.Capital_StringBuilder;
import link.crystal.Capital.Inspection.Comparable_Inspection;
import link.crystal.Capital.Inspection.Capital_Reference_Inspection;
import link.crystal.Capital.Inspection.Inspection;
import link.crystal.Capital.Interface.Capital_Comparable;
import link.crystal.Capital.Interface.Capital_Referenceable_Interface;
import link.crystal.Capital.Interface.Capital_Reference_Interface;
import link.crystal.Capital.Interface.Inspectable;


//
//  NOTE:
//      This interface is needed for `Capital_ComparableReference_Cache` which needs interfaces for both:
//
//          1.  Comparable (used in `Capital_ComparableReference_Cache.dump`); and
//          2.  References (used in `Gem.conjure_{,enduring_}{integer,string}`).
//
public interface    Capital_ComparableReference_Interface<
                        INSPECTION        extends Capital_Reference_Inspection,
                        CLIENT            extends Capital_Referenceable_Interface<CLIENT_INSPECTION>,
                        CLIENT_INSPECTION extends Inspection//,
                    >
    extends         Capital_Reference_Interface<INSPECTION>,
                    Capital_Comparable         <INSPECTION>,
                    Comparable<Capital_Comparable<? extends Comparable_Inspection>>,    //  Via Capital_Comparable
                    Inspectable                <INSPECTION>//,
{
    //
    //  Interface java.lang.Comparable
    //
    public int                          compareTo(final Capital_Comparable<? extends Comparable_Inspection> that);


    //
    //  Interface Capital_Comparable
    //
    //<empty>


    //
    //  Interface Inspectable
    //
    @Override                           //  NOTE: Different `INSPECTION`
    public INSPECTION                   inspect();

    public void                         portray(final Capital_StringBuilder builder);


    //
    //  Interface <me>
    //
    public CLIENT                       client_OR_enqueue();
}
