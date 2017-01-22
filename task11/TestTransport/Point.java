package com.moluram.task11.TestTransport;

/**
 * Represents a two-dimensional point
 */
class Point {
  private Long X;
  private Long Y;

  Point(Long x, Long y) {
    X = x;
    Y = y;
  }

  /**
   * Getters for X and Y
   * @return Long value
   */
  Long X() {
    return X;
  }

  Long Y() {
    return Y;
  }
}
