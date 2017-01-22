package com.moluram.task11.TestTransport;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.time.LocalTime;

/**
 * Represents a single result
 */
public class Result {
  /**
   * Type of transport for the result
   */
  private final Class typeOfTransport;
  private final BigDecimal time;
  private final BigDecimal cost;

  /**
   * Constructor for a single unchangeable result
   * @param typeOfTransport - Class - type of transport
   * @param time - BigDecimal - time for a route
   * @param cost - BigDecimal - cost for a route
   */
  public Result(Class typeOfTransport, BigDecimal time, BigDecimal cost) {
    this.typeOfTransport = typeOfTransport;
    this.time = time;
    this.cost = cost;
  }

  /**
   * Getters
   */
  public Class getTypeOfTransport() {
    return typeOfTransport;
  }

  public BigDecimal getTime() {
    return time;
  }

  public BigDecimal getCost() {
    return cost;
  }
}
