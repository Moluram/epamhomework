package com.moluram.task11.TestTransport;

/**
 * Represent a two-dimensional point
 */
class Point {
  private Long X;
  private Long Y;

  Point(Long x, Long y) {
    X = x;
    Y = y;
  }

  Long X() {
    return X;
  }

  Long Y() {
    return Y;
  }
}
