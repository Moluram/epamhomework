package com.moluram.task11.Transports;

/**
 * Abstract class for transport with seats
 */
public abstract class TransportWithSeats extends Transport {
  /**
   * Statistic percentage of consumption per passenger in liters
   */
  private static final double STATISTIC_PERCENTAGE_FOR_EACH_PASSENGER = 0.05;

  /**
   * Represent a 100% consumption
   */
  private static final float NORMAL_CONSUMPTION = 1;

  /**
   * Number of passengers for a transport
   */
  private Long numberOfPassengers;

  TransportWithSeats(Long velocity, double consumption, Long numberOfPassengers) {
    super(velocity, consumption);
    this.numberOfPassengers = numberOfPassengers;
  }

  /**
   * Returns consumption considering number of passengers
   * @return double - consumption
   */
  @Override
  public double getConsumption() {
    return super.getConsumption() * (NORMAL_CONSUMPTION + (STATISTIC_PERCENTAGE_FOR_EACH_PASSENGER * this.numberOfPassengers));
  }

  /**
   * Simple getters and setters
   */
  public Long getNumberOfPassengers() {
    return numberOfPassengers;
  }

  public void setNumberOfPassengers(Long numberOfPassengers) {
    this.numberOfPassengers = numberOfPassengers;
  }
}
