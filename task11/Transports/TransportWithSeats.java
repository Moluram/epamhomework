package com.moluram.task11.Transports;

/**
 * Created by Moluram on 05.01.2017.
 */
public abstract class TransportWithSeats extends Transport {
  private static final double STATISTIC_PERCENTAGE_FOR_EACH_PASSENGER = 0.05;
  private static final float NORMAL_CONSUMPTION = 1;
  private Long numberOfPassengers;

  TransportWithSeats(Long velocity, double consumption, Long numberOfPassengers) {
    super(velocity, consumption);
    this.numberOfPassengers = numberOfPassengers;
  }

  @Override
  public double getConsumption() {
    return super.getConsumption() * (NORMAL_CONSUMPTION + (STATISTIC_PERCENTAGE_FOR_EACH_PASSENGER * this.numberOfPassengers));
  }

  public Long getNumberOfPassengers() {
    return numberOfPassengers;
  }

  public void setNumberOfPassengers(Long numberOfPassengers) {
    this.numberOfPassengers = numberOfPassengers;
  }
}
