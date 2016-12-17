package com.moluram.task5;

import java.math.BigDecimal;

/**
 * Serves for determining the type of triangle
 * @author Moluram
 * @version 1.0
 */
public class Triangle {
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
      print(whatIsThisTriangle(a,b,c));
    } catch (ArrayIndexOutOfBoundsException e) {
      print("You must enter 3 lengths of the triangle as arguments of the command line");
    } catch (NumberFormatException e) {
      print("The number must consist only of digits");
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
  private static String whatIsThisTriangle(BigDecimal a, BigDecimal b, BigDecimal c){
    if ((a.compareTo(b) == 0) && (b.compareTo(c) == 0)) {
      return "Equilateral";
    }
    if ((a.compareTo(b) == 0) || (a.compareTo(c) == 0) || (b.compareTo(c) == 0)){
      return "Isosceles";
    }
    return "Normal";
  }

  /**
   * Prints to the console value
   * @param value - printed value
   */
  private static void print(String value){
    System.out.println(value);
  }
}

