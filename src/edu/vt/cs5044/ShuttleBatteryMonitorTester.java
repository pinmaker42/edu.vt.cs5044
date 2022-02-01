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

        // TODO: Place your additional test cases here...
    }
}
