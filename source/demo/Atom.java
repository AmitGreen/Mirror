//  Copyright (c) 2019 Amit Green.  All rights reserved.


package demo;


import link.crystal.Capital.Core.Capital_Object;


public final class  Atom
    extends         Capital_Object
//  extends         Object
{
    //
    //  Members
    //
    private final String                atom_name;
    private final Integer               atom_protons;
    private final Integer               atom_neutrons;
    private final Integer               atom_electrons;


    //
    //  Constructor
    //
    public                              Atom(
            final String                    atom_name,
            final Integer                   atom_protons,
            final Integer                   atom_neutrons,
            final Integer                   atom_electrons//,
        )
    {
        this.atom_name      = atom_name;
        this.atom_protons   = atom_protons;
        this.atom_neutrons  = atom_neutrons;
        this.atom_electrons = atom_electrons;
    }


    //
    //  Public
    //
    public final Integer                electrons()
    {
        return this.atom_electrons;
    }


    public final String                 name()
    {
        return this.atom_name;
    }


    public final String                 representation()
    {
        return arrange("<Atom {}; protons {}, neutrons {}, electrons {}>",
                       this.atom_name,
                       this.atom_protons,
                       this.atom_neutrons,
                       this.atom_electrons);
    }
}
