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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Point point = (Point) o;

    if (X != null ? !X.equals(point.X) : point.X != null) return false;
    return Y != null ? Y.equals(point.Y) : point.Y == null;
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
