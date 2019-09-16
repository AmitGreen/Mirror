//  Copyright (c) 2018-2019 Amit Green.  All rights reserved.


package link.crystal.Capital.Format;


import link.crystal.Capital.Core.Zone;
import link.crystal.Capital.Format.ArgumentSegmentFormatter;
import link.crystal.Capital.Format.SegmentFormatter_Inspection;
import link.crystal.Capital.Inspection.World_Inspection;
import link.crystal.Capital.Interface.Inspectable;


public abstract class   ArgumentSegmentFormatter_Inspection<ARGUMENT_SEGMENT extends ArgumentSegmentFormatter>
    extends             SegmentFormatter_Inspection
//  extends             Inspection
//  extends             Inspectable_Object<World_Inspection>
//  extends             Object
    implements          Inspectable       <World_Inspection>//,
{
    //
    //  Constructor & Factory
    //
    protected                           ArgumentSegmentFormatter_Inspection(final String simple_class_name)
    {
        super(simple_class_name);
    }


    //
    //  Abstract
    //
    public abstract ARGUMENT_SEGMENT    conjure_argument_segment(final Zone z, final int argument_index);
}
