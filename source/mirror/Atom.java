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


public final class  Atom
    extends         MirrorProxy<Atom, demo.Atom>
//  extends         Inspectable_Object<Inspection>
//  extends         Object
    implements      Inspectable<Inspection>//,
{
    private static final Inspection     inspection = Inspection.create("mirror.Atom");
    private static final UniqueName     unique_name = UniqueName.create("atom#");


    private static final Pattern        construct_pattern = Pattern.compile(
              "Atom.construct"
            + " (?<proxy>atom#[1-9][0-9]*)"
            + " \"(?<name>[^\"]+)\""
            + " (?<protons>0|[1-9][0-9]*)"
            + " (?<neutrons>0|[1-9][0-9]*)"
            + " (?<electrons>0|[1-9][0-9]*)"
        );

    private static final Pattern        electron_pattern = Pattern.compile(
              "Atom.electrons"
            + " (?<proxy>atom#[1-9][0-9]*)"
            + " => (?<result>0|[1-9][0-9]*)"
        );

    private static final Pattern        name_pattern = Pattern.compile(
              "Atom.name"
            + " (?<proxy>atom#[1-9][0-9]*)"
            + " => \"(?<result>[^\"]*)\""
        );

    private static final Pattern        representation_pattern = Pattern.compile(
              "Atom.representation"
            + " (?<proxy>atom#[1-9][0-9]*)"
            + " => \"(?<result>[^\"]*)\""
        );


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
        super(unique_name.next());

        final Zone                      z = Zone.current_zone();

        final String                    replay = z.replay();

        if (replay != null) {
            final Matcher               matcher = construct_pattern.matcher(replay);

            if ( ! matcher.matches()) {
                RUNTIME("Invalid replay line for Atom.construct: {p}", replay);
            }

            final String                replay_proxy     =                  matcher.group("proxy");
            final String                replay_name      =                  matcher.group("name");
            final Integer               replay_protons   = Integer.parseInt(matcher.group("protons"));
            final Integer               replay_neutrons  = Integer.parseInt(matcher.group("neutrons"));
            final Integer               replay_electrons = Integer.parseInt(matcher.group("electrons"));

            assert fact(this.proxy_name.equals(replay_proxy),
                        "proxy_name<{p}> == replay_proxy<{p}>",
                        proxy_name,
                        replay_proxy);
                    
            assert fact(atom_name.equals(replay_name),
                        "atom_name<{p}> == replay_name<{p}>",
                        atom_name,
                        replay_name);

            assert fact(atom_protons == replay_protons,
                        "atom_protons<{}>  == replay_protons<{}>",
                        atom_protons,
                        replay_protons);

            assert fact(atom_neutrons == replay_neutrons,
                        "atom_neutrons<{}>  == replay_neutrons<{}>",
                        atom_neutrons,
                        replay_neutrons);

            assert fact(atom_electrons == replay_electrons,
                        "atom_electrons<{}>  == replay_electrons<{}>",
                        atom_electrons,
                        replay_electrons);

            return;
        }

        z.record("Atom.construct {} {p} {} {} {}",
                 this.proxy_name,
                 atom_name,
                 atom_protons,
                 atom_neutrons,
                 atom_electrons);

        final demo.Atom                 client = new demo.Atom(
                                                         atom_name,
                                                         atom_protons,
                                                         atom_neutrons,
                                                         atom_electrons//,
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
        final Zone                      z      = Zone.current_zone();

        final String                    replay = z.replay();

        if (replay != null) {
            final Matcher               matcher = electron_pattern.matcher(replay);

            if ( ! matcher.matches()) {
                RUNTIME("Invalid replay line for Atom.electron: {p}", replay);
            }

            final String                replay_proxy  =                  matcher.group("proxy");
            final Integer               replay_result = Integer.parseInt(matcher.group("result"));

            assert fact(this.proxy_name.equals(replay_proxy),
                        "proxy_name<{p}> == replay_proxy<{p}>",
                        proxy_name,
                        replay_proxy);

            trace("< Atom.electron {} => {p}", this.proxy_name, replay_result);

            return replay_result;
        }

        final demo.Atom                 client = this.client;

        final Integer                   result = client.electrons();

        z.record("Atom.electrons {} => {}", this.proxy_name, result);

        return result;
    }


    public final String                 name()
    {
        final Zone                      z      = Zone.current_zone();

        final String                    replay = z.replay();

        if (replay != null) {
            final Matcher               matcher = name_pattern.matcher(replay);

            if ( ! matcher.matches()) {
                RUNTIME("Invalid replay line for Atom.name: {p}", replay);
            }

            final String                replay_proxy  = matcher.group("proxy");
            final String                replay_result = matcher.group("result");

            assert fact(this.proxy_name.equals(replay_proxy),
                        "proxy_name<{p}> == replay_proxy<{p}>",
                        proxy_name,
                        replay_proxy);

            trace("< Atom.name {} => {p}", this.proxy_name, replay_result);

            return replay_result;
        }

        final demo.Atom                 client = this.client;

        final String                    result = client.name();

        z.record("Atom.name {} => {p}", this.proxy_name, result);

        return result;
    }


    public final String                 representation()
    {
        final Zone                      z      = Zone.current_zone();

        final String                    replay = z.replay();

        if (replay != null) {
            final Matcher               matcher = representation_pattern.matcher(replay);

            if ( ! matcher.matches()) {
                RUNTIME("Invalid replay line for Atom.representation: {p}", replay);
            }

            final String                replay_proxy  = matcher.group("proxy");
            final String                replay_result = matcher.group("result");

            assert fact(this.proxy_name.equals(replay_proxy),
                        "proxy_name<{p}> == replay_proxy<{p}>",
                        proxy_name,
                        replay_proxy);

            trace("< Atom.representation {} => {p}", this.proxy_name, replay_result);

            return replay_result;
        }

        final demo.Atom                 client = this.client;

        final String                    result = client.representation();

        z.record("Atom.representation {} => {p}", this.proxy_name, result);

        return result;
    }
}
