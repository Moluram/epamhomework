package com.moluram.task11.TestTransport;

import com.moluram.task11.Transports.Transport;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Moluram on 05.01.2017.
 */
public class TransportTest {
  private final List<Result> listOfResults = new ArrayList<>();
  /**
   * Round scale.
   * There is no need for more than hundred 'cause of columns in result view
   */
  private static final int ROUND_SCALE = 100;
  private Route routeForTest;

  public TransportTest (Route routeForTest) {
    this.routeForTest = routeForTest;
  }

  public void startTestOnTransports (List<Transport> transportList) {
    BigDecimal time;
    BigDecimal cost;
    for (Transport transport: transportList) {
      time = routeForTest.getRouteLength().divide(new BigDecimal(
                transport.getVelocity()), ROUND_SCALE, RoundingMode.HALF_UP);
      cost = time.multiply(new BigDecimal(transport.getConsumption()));
      listOfResults.add(new Result(transport.getClass(), time, cost));
    }
  }

  public List<Result> getResults() {
    return listOfResults;
  }
}
