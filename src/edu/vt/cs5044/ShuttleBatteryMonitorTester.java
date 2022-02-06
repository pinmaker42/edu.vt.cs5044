package edu.vt.cs5044;

//CHECKSTYLE:OFF
@SuppressWarnings("javadoc")
public class ShuttleBatteryMonitorTester {

    public static void main(String... args) {
        System.out.println("P1 Tester (Spring 2022)");

        ShuttleBatteryMonitor sbm = new ShuttleBatteryMonitor(9, 8, 12, 4500);
        sbm.travelTo(5);
        sbm.loadPassengers(3);
        sbm.travelTo(9);
        sbm.loadPassengers(1);
        sbm.loadPassengers(1);
        sbm.travelTo(18);

        System.out.println();
        System.out.println("Sample Test Case - Part 1");
        System.out.println("sbm(9,8,12,4500)t(5)l(3)t(9)l(1)l(1)t(18)");
        System.out.println("Loc     expected: 18;    actual: " + sbm.getLocation());
        System.out.println("#Pass   expected: 5;     actual: " + sbm.getPassengerCount());
        System.out.println("%Charge expected: 88.2;  actual: " + sbm.getChargeRemaining());
        System.out.println("U/T     expected: 176.0; actual: " + sbm.getAverageUsagePerTrip());
        System.out.println("#Trips  expected: 22;    actual: " + sbm.getEstimatedTripsRemaining());

        sbm.loadPassengers(-4);
        sbm.travelTo(-3, 5, 9);
        sbm.recharge();
        sbm.travelTo(-3);
        sbm.loadPassengers(-1);

        System.out.println();
        System.out.println("Sample Test Case - Part 2 ");
        System.out.println("sbm(9,8,12,4500)t(5)l(3)t(9)l(1)l(1)t(18)l(-4)t(-3,5,9)r()t(-3)l(-1)");
        System.out.println("Loc     expected: -3;    actual: " + sbm.getLocation());
        System.out.println("#Pass   expected: 0;     actual: " + sbm.getPassengerCount());
        System.out.println("%Charge expected: 99.4;  actual: " + sbm.getChargeRemaining());
        System.out.println("U/T     expected: 128.5; actual: " + sbm.getAverageUsagePerTrip());
        System.out.println("#Trips  expected: 34;    actual: " + sbm.getEstimatedTripsRemaining());

        ShuttleBatteryMonitor shuttleEnterprise = new ShuttleBatteryMonitor(9, 8, 12, 4500);
        shuttleEnterprise.travelTo(5);
        shuttleEnterprise.loadPassengers(10);
        shuttleEnterprise.travelTo(9);
        shuttleEnterprise.loadPassengers(0);
        shuttleEnterprise.loadPassengers(0);
        shuttleEnterprise.travelTo(18);

        System.out.println();
        System.out.println("Sample Test Case - Part 3");
        System.out.println("shuttleEnterprise(9,8,12,4500)t(5)l(10)t(9)l(0)l(0)t(18)");
        System.out.println("Loc     expected: 18;    actual: " + shuttleEnterprise.getLocation());
        System.out.println("#Pass   expected: 10;     actual: " + shuttleEnterprise.getPassengerCount());
        System.out.println("%Charge expected: 73.3;  actual: " + shuttleEnterprise.getChargeRemaining());
        System.out.println("U/T     expected: 400.0; actual: " + shuttleEnterprise.getAverageUsagePerTrip());
        System.out.println("#Trips  expected: 8;    actual: " + shuttleEnterprise.getEstimatedTripsRemaining());

        shuttleEnterprise.recharge();
        shuttleEnterprise.loadPassengers(-10);
        shuttleEnterprise.travelTo(100);
        shuttleEnterprise.travelTo(-100);

        System.out.println();
        System.out.println("Sample Test Case - Part 4");
        System.out.println("shuttleEnterprise(9,8,12,4500)t(5)l(10)t(9)l(0)l(0)t(18)");
        System.out.println("Loc     expected: -100;    actual: " + shuttleEnterprise.getLocation());
        System.out.println("#Pass   expected: 0;     actual: " + shuttleEnterprise.getPassengerCount());
        System.out.println("%Charge expected: 100.0;  actual: " + shuttleEnterprise.getChargeRemaining());
        System.out.println("U/T     expected: 520.0; actual: " + shuttleEnterprise.getAverageUsagePerTrip());
        System.out.println("#Trips  expected: 8;    actual: " + shuttleEnterprise.getEstimatedTripsRemaining());

        ShuttleBatteryMonitor shuttleVoyager = new ShuttleBatteryMonitor(9, 8, 12, 4500);
        shuttleVoyager.travelTo(5);
        shuttleVoyager.loadPassengers(0);
        shuttleVoyager.travelTo(9);
        shuttleVoyager.loadPassengers(0);
        shuttleVoyager.loadPassengers(0);
        shuttleVoyager.travelTo(18);

        System.out.println();
        System.out.println("Sample Test Case - Part 5");
        System.out.println("shuttleVoyager(9,8,12,4500)t(5)l(10)t(9)l(0)l(0)t(18)");
        System.out.println("Loc     expected: 18;    actual: " + shuttleVoyager.getLocation());
        System.out.println("#Pass   expected: 0;     actual: " + shuttleVoyager.getPassengerCount());
        System.out.println("%Charge expected: 100.0;  actual: " + shuttleVoyager.getChargeRemaining());
        System.out.println("U/T     expected: 0.0; actual: " + shuttleVoyager.getAverageUsagePerTrip());
        System.out.println("#Trips  expected: 2147483647;    actual: " + shuttleVoyager.getEstimatedTripsRemaining());

        shuttleVoyager.recharge();
        shuttleVoyager.recharge();
        shuttleVoyager.recharge();
        shuttleVoyager.loadPassengers( 100);
        shuttleVoyager.travelTo(10,5,20);
        shuttleVoyager.recharge();
        shuttleVoyager.recharge();
        shuttleVoyager.recharge();

        System.out.println();
        System.out.println("Sample Test Case - Part 6");
        System.out.println("shuttleVoyager(9,8,12,4500)t(5)l(10)t(9)l(0)l(0)t(18)");
        System.out.println("Loc     expected: 0;    actual: " + shuttleVoyager.getLocation());
        System.out.println("#Pass   expected: 100;     actual: " + shuttleVoyager.getPassengerCount());
        System.out.println("%Charge expected: 100.0;  actual: " + shuttleVoyager.getChargeRemaining());
        System.out.println("U/T     expected: 2410.0; actual: " + shuttleVoyager.getAverageUsagePerTrip());
        System.out.println("#Trips  expected: 1;    actual: " + shuttleVoyager.getEstimatedTripsRemaining());
    }
}
