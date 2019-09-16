//  Copyright (c) 2018-2019 Amit Green.  All rights reserved.


package link.crystal.Mirror.UnitTest;


import link.crystal.Capital.Core.Inspectable_Object;
import link.crystal.Capital.Core.Capital_Global;
import link.crystal.Capital.Core.Zone;
import link.crystal.Capital.Inspection.Inspection;
import link.crystal.Capital.Interface.Inspectable;
import link.crystal.Gem.Portray_1.AsciiTable;
import link.crystal.Gem.Portray_1.BuildStringState;
import link.crystal.Gem.Portray_1.PortrayString;
import link.crystal.Gem.Portray_2.AnalyzeString;
import link.crystal.Capital.Support.Storehouse_AdornmentSegmentFormatter;
import link.crystal.Capital.Support.Storehouse_MessageFormattable;
import link.crystal.Capital.Support.Storehouse_PortraySegmentFormatter;
import link.crystal.Capital.Support.Storehouse_String;
import link.crystal.Gem.UnitTest.UnitTest_Gem;
import link.crystal.Gem.UnitTest.UnitTest_PortrayString;
import link.crystal.Mirror.UnitTest.UnitTest_Java;
import link.crystal.Mirror.UnitTest.UnitTest_Mirror;


public final class  UnitTest
    extends         Inspectable_Object<Inspection>
//  extends         Object
    implements      Inspectable       <Inspection>//,
{
    private static final Inspection     inspection = Inspection.create("UnitTest");


    //
    //  Members
    //
    public final Zone                   z;


    //
    //  Constructor & Factory
    //
    private                             UnitTest(final Zone z)
    {
        this.z = z;
    }


    private static UnitTest             create(final Zone z)
    {
        return new UnitTest(z);
    }


    //
    //  Private (tests)
    //
    private final boolean               test_development()
    {
        final Zone                      z = this.z;

        return UnitTest_Gem.create(z).test_string();
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
    public static final void            unit_test(final String ... arguments)
    {
        final Zone                      z = Zone.current_zone();

        if (arguments.length == 0) {
            //UnitTest_PortrayString.create(z).test_portray_string();
            UnitTest_Gem.create(z).test_analyze_string();
            UnitTest_Gem.create(z).test_arrange();
            UnitTest_Gem.create(z).test_string();
            //UnitTest_Mirror.create(z).test_shape();

            //UnitTest.create(z).test_development();
        } else {
            final int                   arguments_total = arguments.length;

            if (arguments_total > 1) {
                RUNTIME("{} arguments given (expected 0 or 1)", arguments_total);
            }

            final String                name = (arguments_total == 0 ? "development" : arguments[0]);

            if (name.equals("development")) {
                UnitTest.create(z).test_development();
            } else if (name.equals("shape")) {
                UnitTest_Mirror.create(z).test_shape();
            } else {
                RUNTIME("unknown unit test: {p}", name);
            }
        }

        if (true) {
            //AsciiTable.dump();
            //AnalyzeString.dump();
            //BuildStringState.dump();

            //Capital_Global.dump();
            //Capital_Global.inspection_cache.dump("Capital_Global.inspection_cache");

            //PortrayString.dump();


            //Storehouse_AdornmentSegmentFormatter.singleton.dump("Storehouse_AdornmentSegmentFormatter.singleton");
            //Storehouse_MessageFormattable                 .dump(z);
            //Storehouse_PortraySegmentFormatter  .singleton.dump(z);

            //z.storehouse_string.dump("z.storehouse_string");

            //z.dump();
        }
    }
}
