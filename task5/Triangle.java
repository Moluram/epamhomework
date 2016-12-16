package com.moluram.task5;

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
      double a = parseDoubleWithDefault(args[0], 0);
      double b = parseDoubleWithDefault(args[1], 0);
      double c = parseDoubleWithDefault(args[2], 0);
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
  private static String whatIsThisTriangle(double a, double b, double c){
    if(a == b && b == c) {
      return "Equilateral";
    }
    if((a == b) || (b == c) || (a == c)){
      return "Isosceles";
    }
    return "Normal";
  }

  /**
   * Return Double equivalent of the given line.
   * @param value - number in string form
   * @param def - default value comes into if exception will be thrown
   * @return Double
   */
  private static Double parseDoubleWithDefault(String value, double def) {
    try {
      return Double.parseDouble(value);
    } catch (NumberFormatException e) {
      return def;
    }
  }

  /**
   * Prints to the console value
   * @param value - printed value
   */
  private static void print(String value){
    System.out.println(value);
  }
}

