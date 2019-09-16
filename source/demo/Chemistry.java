//  Copyright (c) 2019 Amit Green.  All rights reserved.


package demo;


import mirror.Atom;
import mirror.Molecule;
import link.crystal.Capital.Core.Capital_Object;

public final class  Chemistry
    extends         Capital_Object
//  extends         Object
{
    //
    //  Public
    //
    public static final void            main(final String[] arguments)
    {
        Atom                            hydrogen = new Atom("hydrogen", 1, 0, 1);
        Atom                            oxygen   = new Atom("oxygen",   8, 8, 8);

        trace("{+}: created: {}", hydrogen.representation());
        trace("{+}: created: {}", oxygen  .representation());

        Molecule                        dioxygen = new Molecule("dioxygen", oxygen, oxygen, null);
        Molecule                        water    = new Molecule("water",    oxygen, hydrogen, hydrogen);

        trace("{+}: created: {}", dioxygen.representation());
        trace("{+}: created: {}", water.representation());

        trace("{+}: {} has {} electrons", dioxygen.name(), dioxygen.electrons());
        trace("{+}: {} has {} electrons", water.name(),    water.electrons());
    }
}
