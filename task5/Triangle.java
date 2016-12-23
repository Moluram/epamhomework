package com.moluram.task5;

import java.math.BigDecimal;

/**
 * Serves for determining the type of triangle
 * @author Moluram
 * @version 1.0
 */
public class Triangle {
  private static String EQUIVALENT = "Equilateral";
  private static String ISOSCELES = "Isosceles";
  private static String NORMAL = "Normal";
  private static int BIG_DECIMAL_COMPARE_VALUE_FOR_EQUIVALENT = 0;
  private static int BIG_DECIMAL_COMPARE_VALUE_FOR_LESS = -1;

  /**
   * Takes 3 parameters as arguments from command line and calls for type of the triangle with side
   * lengths equal to the parameters
   * @param args - arguments from the command line
   */
  public static void main(String[] args) {
    try {
      BigDecimal a = new BigDecimal(args[0]);
      BigDecimal b = new BigDecimal(args[1]);
      BigDecimal c = new BigDecimal(args[2]);
      System.out.println(whatIsThisTriangle(a, b, c));
    } catch (TriangleDoesNotExist e) {
      System.out.println("Triangle does not exist");
    } catch (ArrayIndexOutOfBoundsException e) {
      System.out.println("You must enter 3 lengths of the triangle as arguments of the command line");
    } catch (NumberFormatException e) {
      System.out.println("The number must consist only of digits");
    }
  }

  /**
   * Determines the type of the triangle
   * Returns type of the triangle as String
   * @param a - length of triangle side
   * @param b - length of triangle side
   * @param c - length of triangle side
   * @return String
   */
  private static String whatIsThisTriangle(BigDecimal a, BigDecimal b, BigDecimal c)
          throws TriangleDoesNotExist {
    if (a.compareTo(b.add(c)) != BIG_DECIMAL_COMPARE_VALUE_FOR_LESS
            || b.compareTo(a.add(c)) != BIG_DECIMAL_COMPARE_VALUE_FOR_LESS
            || c.compareTo(a.add(b)) != BIG_DECIMAL_COMPARE_VALUE_FOR_LESS) {
      throw new TriangleDoesNotExist();
    }
    if ((a.compareTo(b) == BIG_DECIMAL_COMPARE_VALUE_FOR_EQUIVALENT)
            && (b.compareTo(c) == BIG_DECIMAL_COMPARE_VALUE_FOR_EQUIVALENT)) {
      return EQUIVALENT;
    }
    if ((a.compareTo(b) == BIG_DECIMAL_COMPARE_VALUE_FOR_EQUIVALENT)
            || (a.compareTo(c) == BIG_DECIMAL_COMPARE_VALUE_FOR_EQUIVALENT)
            || (b.compareTo(c) == BIG_DECIMAL_COMPARE_VALUE_FOR_EQUIVALENT)) {
      return ISOSCELES;
    }
    return NORMAL;
  }

  /**
   *  Throws when triangle does not exist
   */
  private static class TriangleDoesNotExist extends Exception {}
}

