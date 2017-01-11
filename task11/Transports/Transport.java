package com.moluram.task11.Transports;

/**
 * Created by Moluram on 05.01.2017.
 */
public abstract class Transport {
  private Long velocity;
  private double consumption;

  Transport(Long velocity, double consumption) {
    this.velocity = velocity;
    this.consumption = consumption;
  }

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
