package edu.vt.cs5044;

import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * A basic system to track the energy usage of an experimental electric shuttle bus as it operates.
 * The dedicated route is perfectly straight, and consists of equal length blocks, numbered
 * sequentially from negative numbers in one direction to positive numbers in the other direction,
 * with block zero in the middle of the route. There is a recharging station located at block zero.
 *
 * The shuttle makes a series of non-stop trips between locations. Passengers may board and/or exit
 * the shuttle while it is stopped. No energy is used while the shuttle is stopped, nor while the
 * shuttle is empty. Energy usage is based upon the distance of each trip, and how many passengers
 * are on board during the trip. Trips are considered either long or short, depending on a
 * configurable distance limit.
 *
 * Short trips, up to the prevailing limit, use energy at a single fixed rate for the entire trip.
 * Long trips, longer than the prevailing limit, use energy at two different rates. For the short
 * portion of the trip, the usage is the same as for a short trip. For the remainder of the
 * distance, the trip uses energy at a different rate, and may travel faster or slower per block.
 *
 * ACADEMIC NOTE: Use only primitive types int and double, with all fields stored as int type.
 *
 * ACADEMIC NOTE: You may NOT use any methods of the Math class, except as explicitly specified in
 * the comments below.
 *
 * ACADEMIC NOTE: You may NOT use any of the following: branches; loops; conditionals; arrays; or
 * collections. We haven't yet covered any of these topics well enough quite yet, and it's also a
 * great exercise to produce a solution without them anyway.
 *
 * Template and Comments © 2022 Prof. Oliva (for Spring 2022)
 * @author James Smith (Jfs8888@vt.edu)
 * @version Project 1
 *
 */


public class ShuttleBatteryMonitor {
    private int shuttleShortRate;
    private int shuttleShortLimit;
    private int shuttleLongRate;
    private int shuttleChargeCapacity;
    private int currentShuttleCharge;
    private int currentPassengerCount;
    private int currentShuttleLocation;
    private double totalTrips;
    private double totalUsage;

    /**
     * Construct a new instance of the monitor with the specified configuration. The shuttle begins
     * at block zero, with no passengers on board, and the battery fully charged to capacity.
     *
     * ACADEMIC NOTE: You may safely assume all parameter values will be non-negative.
     *
     * @param shortRate usage rate, per block per passenger, during short trips
     * @param shortLimit maximum number of blocks that comprise a short trip
     * @param longRate usage rate, per block per passenger, for portion of travel beyond short trip
     * @param chargeCapacity maximum amount of energy stored in the battery (greater than zero)
     */
    public ShuttleBatteryMonitor(int shortRate, int shortLimit, int longRate, int chargeCapacity) {
        shuttleShortRate = shortRate;
        shuttleShortLimit = shortLimit;
        shuttleLongRate = longRate;
        shuttleChargeCapacity = chargeCapacity;
        currentShuttleCharge = chargeCapacity;
        currentPassengerCount = 0;
        totalUsage = 0;
    }

    /**
     * Repeatable code meant to aid with the TravelTo methods
     *
     * Takes the parameters and calculates it based off short limit
     * and long rates depending on what the destination is.  The logic behind this is
     * figuring out
     *
     * @param destination block number for the end of this trip
     * @param shortLimit max number of blocks that comprise a short trip (this trip only)
     * @param longRate usage rate, per block per passenger, for portion of travel beyond
     *        short trip (this trip only)
     */
    private void travelHelper(int destination, int shortLimit, int longRate) {
        int currentDistance = Math.abs(currentShuttleLocation - destination);
        currentShuttleLocation = destination;
        int tripDistance = currentDistance - shortLimit;
        int testLongDistance = Math.max(0, tripDistance);
        currentShuttleCharge -= testLongDistance * currentPassengerCount * longRate;
        totalUsage += testLongDistance * currentPassengerCount * longRate;
        int testShortDistance = Math.min(currentDistance, shortLimit);
        currentShuttleCharge -= testShortDistance * currentPassengerCount * shuttleShortRate;
        totalUsage += testShortDistance * currentPassengerCount * shuttleShortRate;
        totalTrips++;
    }
    /**
     * Indicates travel of the shuttle to the specified block number.
     *
     * Any distance up to the short limit uses energy at the normal rate. Any distance beyond the
     * short limit uses energy at the long trip rate.
     *
     * ACADEMIC NOTE: You may use Math.abs(), Math.min(), and/or Math.max() for your calculations.
     * However, you may NOT use any branches or conditionals
     *
     * @param destination block number for the end of this trip
     */
    public void travelTo(int destination) {
        travelHelper(destination, shuttleShortLimit, shuttleLongRate);
    }
    /**
     * Indicates travel of the shuttle to the specified block number. Any distance up to the short
     * limit uses energy at the normal rate. Any distance beyond the short limit uses energy at the
     * long trip rate.
     *
     * ACADEMIC NOTE: You may use Math.abs(), Math.min(), and/or Math.max() for your calculations.
     * However, you may NOT use any branches or conditionals
     *
     * @param destination block number for the end of this trip
     * @param shortLimitOverride max number of blocks that comprise a short trip (this trip only)
     * @param longRateOverride usage rate, per block per passenger, for portion of travel beyond
     * short trip (this trip only)
     */

    public void travelTo(int destination, int shortLimitOverride, int longRateOverride) {
        travelHelper(destination, shortLimitOverride, longRateOverride);
    }

    /**
     * Travel to origin then recharge the battery to its full capacity.
     *
     * The shuttle travels to the charging station at block zero, where it then stops to charge its
     * battery to full capacity.
     */
    public void recharge() {
        travelHelper(0, shuttleShortLimit, shuttleLongRate);
        currentShuttleCharge = shuttleChargeCapacity;
    }

    /**
     * Load (or unload) passengers.
     *
     * This method indicates a net change in the passenger count, due to passengers boarding and/or
     * exiting the shuttle while it is stopped. A negative value indicates the shuttle now contains
     * fewer passengers than it did before. This method may be called multiple times while the
     * shuttle is stopped, in which case the effects are cumulative.
     *
     * ACADEMIC NOTE: You may safely assume the passenger count will never go below zero.
     *
     * @param netAddedPassengers net count of passengers added to the shuttle
     */
    public void loadPassengers(int netAddedPassengers) {
        currentPassengerCount = currentPassengerCount + netAddedPassengers;
    }

    /**
     * Get the current location (block number).
     *
     * @return current block number
     */
    public int getLocation() {
        return currentShuttleLocation;
    }

    /**
     * Get the current number of passengers.
     *
     * @return the current passenger count
     */
    public int getPassengerCount() {
        return currentPassengerCount;
    }

    /**
     * Get the charge remaining, as a percentage of the battery capacity.
     *
     * The estimate should be calculated at double precision, but the return value must be rounded
     * DOWN (truncated) to the nearest multiple of 0.1. For example, if the estimated value is
     * 12.999 percent remaining, the return value should be exactly 12.9 (to double precision).
     *
     * @return truncated percentage of energy remaining in the batteries.
     */
    public double getChargeRemaining() {
        double currentShuttlePercentCharge =
                (currentShuttleCharge / (double)shuttleChargeCapacity) * 100.0;
        DecimalFormat correctNumber = new DecimalFormat("##.#");
        correctNumber.setRoundingMode(RoundingMode.FLOOR);
        currentShuttlePercentCharge =
                Double.parseDouble(correctNumber.format(currentShuttlePercentCharge));
        return currentShuttlePercentCharge;
    }

    /**
     * Get the average amount of energy usage require for each trip.
     *
     * The estimate should be calculated at double precision, but the return value must be rounded
     * DOWN (truncated) to the nearest multiple of 0.1. For example, if the estimated value is
     * 345.678, the return value should be exactly 345.6 (to double precision).
     *
     * ACADEMIC NOTE: You may assume this method won't be called until after the first trip.
     *
     * @return truncated average amount of energy used per trip.
     */
    public double getAverageUsagePerTrip() {
        double remainingCharge = totalUsage / totalTrips;
        DecimalFormat correctNumber = new DecimalFormat("###.#");
        correctNumber.setRoundingMode(RoundingMode.FLOOR);
        remainingCharge = Double.parseDouble(correctNumber.format(remainingCharge));
        return remainingCharge;
    }

    /**
     * Estimate the number of trips that can be taken with the remaining battery charge.
     *
     * The estimate is based upon the truncated usage per trip (according to getAverageUsagePerTrip)
     * and the actual charge remaining, rounded DOWN (truncated) to the nearest integer. For
     * example, if the estimated value is 23.57, the return value should be exactly 23.
     *
     * ACADEMIC NOTE: You may assume this method won't be called until after the first energy usage.
     *
     * @return truncated number of trips remaining with available battery charge.
     *
     */
    public int getEstimatedTripsRemaining() {
        double estimatedTrips = currentShuttleCharge / getAverageUsagePerTrip();
        return (int)estimatedTrips;
    }

}
