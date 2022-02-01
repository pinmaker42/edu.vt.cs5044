package edu.vt.cs5044;

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
 */
public class ShuttleBatteryMonitor {

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
        // TODO: Your implementation goes here
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
        // TODO: Your implementation goes here
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
        // TODO: Your implementation goes here
    }

    /**
     * Travel to origin then recharge the battery to its full capacity.
     *
     * The shuttle travels to the charging station at block zero, where it then stops to charge its
     * battery to full capacity.
     */
    public void recharge() {
        // TODO: Your implementation goes here
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
        // TODO: Your implementation goes here
    }

    /**
     * Get the current location (block number).
     *
     * @return current block number
     */
    public int getLocation() {
        // TODO: Your implementation goes here
        return 0; // TODO: Replace this placeholder
    }

    /**
     * Get the current number of passengers.
     *
     * @return the current passenger count
     */
    public int getPassengerCount() {
        // TODO: Your implementation goes here
        return 0; // TODO: Replace this placeholder
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
        // TODO: Your implementation goes here
        return 0; // TODO: Replace this placeholder
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
        // TODO: Your implementation goes here
        return 0; // TODO: Replace this placeholder
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
        // TODO: Your implementation goes here
        return 0; // TODO: Replace this placeholder
    }

}
