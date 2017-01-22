package com.moluram.task11.Transports;

/**
 * Abstract class for all vehicles
 */
public abstract class Transport {
  /**
   * Transport velocity
   */
  private Long velocity;

  /**
   * Transport consumption
   */
  private double consumption;

  Transport(Long velocity, double consumption) {
    this.velocity = velocity;
    this.consumption = consumption;
  }

  /**
   * Getters and setters
   */
  public Long getVelocity() {
    return velocity;
  }

  public void setVelocity(Long velocity) {
    this.velocity = velocity;
  }

  public double getConsumption() {
    return consumption;
  }

  public void setConsumption(Long consumption) {
    this.consumption = consumption;
  }
}
