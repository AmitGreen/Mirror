//  Copyright (c) 2018-2019 Amit Green.  All rights reserved.


package mirror;


import java.lang.Integer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import link.crystal.Capital.Core.Zone;
import link.crystal.Capital.Inspection.Inspection;
import link.crystal.Capital.Interface.Inspectable;
import link.crystal.Capital.Support.UniqueName;
import link.crystal.Mirror.MirrorProxy;
import mirror.Atom;


public final class  Molecule
    extends         MirrorProxy<Molecule, demo.Molecule>
//  extends         Inspectable_Object<Inspection>
//  extends         Object
    implements      Inspectable<Inspection>//,
{
    private static final Inspection     inspection = Inspection.create("mirror.Molecule");
    private static final UniqueName     unique_name = UniqueName.create("molecule#");



    private static final Pattern        construct_pattern = Pattern.compile(
              "Molecule.construct"
            + " (?<proxy>molecule#[1-9][0-9]*)"
            + " \"(?<name>[^\"]+)\""
            + " (?<atom1>atom#[1-9][0-9]*)"
            + " (?<atom2>atom#[1-9][0-9]*)"
            + " (?<atom3>null|atom#[1-9][0-9]*)"
        );

    private static final Pattern        electron_pattern = Pattern.compile(
              "Molecule.electrons"
            + " (?<proxy>molecule#[1-9][0-9]*)"
            + " => (?<result>0|[1-9][0-9]*)"
        );

    private static final Pattern        name_pattern = Pattern.compile(
              "Molecule.name"
            + " (?<proxy>molecule#[1-9][0-9]*)"
            + " => \"(?<result>[^\"]*)\""
        );

    private static final Pattern        representation_pattern = Pattern.compile(
              "Molecule.representation"
            + " (?<proxy>molecule#[1-9][0-9]*)"
            + " => \"(?<result>[^\"]*)\""
        );


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
        super(unique_name.next());

        final String                    proxy_name_1 = molecule_atom_1.proxy_name__ALLY__mirror();
        final String                    proxy_name_2 = molecule_atom_2.proxy_name__ALLY__mirror();
        final String                    proxy_name_3 = (
                    (molecule_atom_3 == null ? "null" : molecule_atom_3.proxy_name__ALLY__mirror())
                );

        final String                    replay = z.replay();

        if (replay != null) {
            final Matcher               matcher = construct_pattern.matcher(replay);

            if ( ! matcher.matches()) {
                RUNTIME("Invalid replay line for Molecule.construct: {p}", replay);
            }

            final String                replay_proxy  = matcher.group("proxy");
            final String                replay_name   = matcher.group("name");
            final String                replay_atom_1 = matcher.group("atom1");
            final String                replay_atom_2 = matcher.group("atom2");
            final String                replay_atom_3 = matcher.group("atom3");

            assert fact(this.proxy_name.equals(replay_proxy),
                        "proxy_name<{p}> == replay_proxy<{p}>",
                        proxy_name,
                        replay_proxy);
                    
            assert fact(molecule_name.equals(replay_name),
                        "molecule_name<{p}> == replay_name<{p}>",
                        molecule_name,
                        replay_name);

            assert fact(proxy_name_1.equals(replay_atom_1),
                        "proxy_name_1<{}>  == replay_atom_1<{}>",
                        proxy_name_1,
                        replay_atom_1);

            assert fact(proxy_name_2.equals(replay_atom_2),
                        "proxy_name_2<{}>  == replay_atom_2<{}>",
                        proxy_name_2,
                        replay_atom_2);

            assert fact(proxy_name_3.equals(replay_atom_3),
                        "proxy_name_3<{}>  == replay_atom_3<{}>",
                        proxy_name_3,
                        replay_atom_3);

            return;
        }

        z.record("Molecule.construct {} {p} {} {} {}",
                 this.proxy_name,
                 molecule_name,
                 proxy_name_1,
                 proxy_name_2,
                 proxy_name_3);

        final demo.Atom                 client_1 = (
                MirrorProxy.<Atom, demo.Atom>client__ALLY__mirror(molecule_atom_1)
            );

        final demo.Atom                 client_2 = (
                MirrorProxy.<Atom, demo.Atom>client__ALLY__mirror(molecule_atom_2)
            );

        final demo.Atom                 client_3 = (
                MirrorProxy.<Atom, demo.Atom>client__ALLY__mirror(molecule_atom_3)
            );


        final demo.Molecule                 client = new demo.Molecule(
                                                         molecule_name,
                                                         client_1,
                                                         client_2,
                                                         client_3//,
                                                     );

        initialize_client(client);
    }


    //
    //  Interface Inspectable
    //
    @Override
    public final Inspection             inspect()
    {
        return /*static*/ this.inspection;
    }


    //
    //  Public
    //
    public final Integer                electrons()
    {
        final demo.Molecule             client = this.client;

        final String                    replay = z.replay();

        if (replay != null) {
            final Matcher               matcher = electron_pattern.matcher(replay);

            if ( ! matcher.matches()) {
                RUNTIME("Invalid replay line for Molecule.electron: {p}", replay);
            }

            final String                replay_proxy  =                  matcher.group("proxy");
            final Integer               replay_result = Integer.parseInt(matcher.group("result"));

            assert fact(this.proxy_name.equals(replay_proxy),
                        "proxy_name<{p}> == replay_proxy<{p}>",
                        proxy_name,
                        replay_proxy);

            trace("< Molecule.electron {} => {p}", this.proxy_name, replay_result);

            return replay_result;
        }


        final Integer                   result = client.electrons();

        z.record("Molecule.electrons {} => {}", this.proxy_name, result);

        return result;
    }


    public final String                 name()
    {
        final demo.Molecule             client = this.client;

        final String                    replay = z.replay();

        if (replay != null) {
            final Matcher               matcher = name_pattern.matcher(replay);

            if ( ! matcher.matches()) {
                RUNTIME("Invalid replay line for Molecule.name: {p}", replay);
            }

            final String                replay_proxy  = matcher.group("proxy");
            final String                replay_result = matcher.group("result");

            assert fact(this.proxy_name.equals(replay_proxy),
                        "proxy_name<{p}> == replay_proxy<{p}>",
                        proxy_name,
                        replay_proxy);

            trace("< Molecule.name {} => {p}", this.proxy_name, replay_result);

            return replay_result;
        }

        final String                    result = client.name();

        z.record("Molecule.name {} => {p}", this.proxy_name, result);

        return result;
    }


    public final String                 representation()
    {
        final demo.Molecule             client = this.client;

        final String                    replay = z.replay();

        if (replay != null) {
            final Matcher               matcher = representation_pattern.matcher(replay);

            if ( ! matcher.matches()) {
                RUNTIME("Invalid replay line for Molecule.representation: {p}", replay);
            }

            final String                replay_proxy  = matcher.group("proxy");
            final String                replay_result = matcher.group("result");

            assert fact(this.proxy_name.equals(replay_proxy),
                        "proxy_name<{p}> == replay_proxy<{p}>",
                        proxy_name,
                        replay_proxy);

            trace("< Molecule.representation {} => {p}", this.proxy_name, replay_result);

            return replay_result;
        }

        final String                    result = client.representation();

        z.record("Molecule.representation {} => {p}", this.proxy_name, result);

        return result;
    }
}
