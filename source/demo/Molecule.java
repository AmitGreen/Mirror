//  Copyright (c) 2019 Amit Green.  All rights reserved.


package demo;


import demo.Atom;
import link.crystal.Capital.Core.Capital_Object;


public final class  Molecule
    extends         Capital_Object
//  extends         Object
{
    //
    //  Members
    //
    private final String                molecule_name;
    private final Atom                  molecule_atom_1;
    private final Atom                  molecule_atom_2;
    private final Atom                  molecule_atom_3;


    //
    //  Constructor
    //
    public                              Molecule(
            final String                    molecule_name,
            final Atom                      molecule_atom_1,
            final Atom                      molecule_atom_2,
            final Atom                      molecule_atom_3//,
        )
    {
        this.molecule_name   = molecule_name;
        this.molecule_atom_1 = molecule_atom_1;
        this.molecule_atom_2 = molecule_atom_2;
        this.molecule_atom_3 = molecule_atom_3;
    }


    //
    //  Public
    //
    public final Integer                electrons()
    {
        Integer                         electrons = 0;

        trace("{+}: Calculating number of electrons for {}", this.representation());
        trace("{+}:   {} has {} electrons", this.molecule_atom_1.name(), this.molecule_atom_1.electrons());
        trace("{+}:   {} has {} electrons", this.molecule_atom_2.name(), this.molecule_atom_2.electrons());

        electrons += this.molecule_atom_1.electrons();
        electrons += this.molecule_atom_2.electrons();

        if (this.molecule_atom_3 != null) {
            electrons += this.molecule_atom_3.electrons();

            trace("{+}:   {} has {} electrons", this.molecule_atom_3.name(), this.molecule_atom_3.electrons());
        }

        trace("{+}: Calculated total electrons: {}", electrons);

        return electrons;
    }


    public final String                 name()
    {
        return this.molecule_name;
    }


    public final String                 representation()
    {
        if (this.molecule_atom_3 == null) {
            return arrange("<Molecule {}: {} + {}", 
                           this.molecule_name,
                           this.molecule_atom_1.name(),
                           this.molecule_atom_2.name());
        }

        return arrange("<Molecule {}: {} + {} + {}", 
                       this.molecule_name,
                       this.molecule_atom_1.name(),
                       this.molecule_atom_2.name(),
                       this.molecule_atom_3.name());
    }
}
