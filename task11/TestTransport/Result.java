package com.moluram.task11.TestTransport;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.time.LocalTime;

/**
 * Created by Moluram on 11.01.2017.
 */
public class Result {
  private final Class typeOfTransport;
  private final BigDecimal time;
  private final BigDecimal cost;

  public Result(Class typeOfTransport, BigDecimal time, BigDecimal cost) {
    this.typeOfTransport = typeOfTransport;
    this.time = time;
    this.cost = cost;
  }

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
