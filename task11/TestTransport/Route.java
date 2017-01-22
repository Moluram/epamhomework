package com.moluram.task11.TestTransport;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Class represents a route for transport
 */
public class Route {
  private static final int FIRST_ELEMENT = 0;
  private static final String BIG_DECIMAL_DEFAULT_VALUE = "0";
  private static final String REGEX_VALUE_FOR_SPLIT = " ";
  private static final String EMPTY_STRING = "";

  /**
   * List of checkpoints
   */
  private List<Point> pointList = new ArrayList<>();

  /**
   * Route length
   */
  private BigDecimal routeLength = new BigDecimal(BIG_DECIMAL_DEFAULT_VALUE);


  /**
   * Constructor which takes name of file where to get route
   * @param fileName - name of route file
   * @throws DictionaryFileDidntFoundException - whether the file didn't exists
   */
  public Route(String fileName)
      throws DictionaryFileDidntFoundException, DictionaryContainNonOnlyDigits, SimilarStartAndEndException {
    getRouteLengthFromFile(fileName);
    setRouteLength();
  }

  public BigDecimal getRouteLength() {
    return routeLength;
  }

  /**
   * Gets checkpoints from a file
   * @param fileName - name of a file
   * @throws DictionaryFileDidntFoundException - whether the file didn't exists
   */
  private void getRouteLengthFromFile(String fileName)
      throws DictionaryFileDidntFoundException, DictionaryContainNonOnlyDigits, SimilarStartAndEndException {
    File fileI = new File(fileName);
    try {
      try (BufferedReader in = new BufferedReader(new FileReader(fileI.getAbsoluteFile()))) {
        boolean swtch = true;
        String[] points;
        Long X = null;
        while (in.ready()) {
          points = in.readLine().split(REGEX_VALUE_FOR_SPLIT);
          for (String pointPath: points) {
            if (!pointPath.equals(EMPTY_STRING)) {
              if (swtch) {
                X = Long.parseLong(pointPath);
                swtch = false;
              } else {
                pointList.add(new Point(X, Long.parseLong(pointPath)));
                swtch = true;
                X = null;
              }
            }
          }
        }
      }
      if (pointList.get(FIRST_ELEMENT).equals(pointList.get(pointList.size() - 1))) {
        throw new SimilarStartAndEndException();
      }
    } catch (IOException e) {
      throw new DictionaryFileDidntFoundException();
    } catch (NumberFormatException e) {
      throw new DictionaryContainNonOnlyDigits();
    }
  }

  /**
   * Calculates the route length from a list of checkpoints
   */
  private void setRouteLength() {
    Point pointOne = pointList.get(FIRST_ELEMENT);
    for (int i = 1; i < pointList.size(); i++) {
      Point pointTwo = pointList.get(i);
      routeLength = routeLength.add(new BigDecimal(getDistanceBetweenPoints(pointOne, pointTwo)));
      pointOne = pointTwo;
    }
  }

  /**
   * Calculates distance between two points
   * @param pointOne
   * @param pointTwo
   * @return - double value of distance
   */
  private double getDistanceBetweenPoints(Point pointOne, Point pointTwo) {
    return Math.sqrt(Math.pow(pointTwo.X() - pointOne.X(), 2) + Math.pow(pointTwo.Y() - pointOne.Y(), 2));
  }

  /**
   * Throws whether the file didn't exists
   */
  public class DictionaryFileDidntFoundException extends IOException {}

  /**
   * Throws whether the dictionary contain non only digits
   */
  public class DictionaryContainNonOnlyDigits extends NumberFormatException { }

  /**
   * Throws whether the start and end of the route similar
   */
  public class SimilarStartAndEndException extends Throwable {
  }
}
