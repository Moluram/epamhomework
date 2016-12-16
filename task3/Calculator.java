package com.moluram.task3;

/**
 * Class serve for calculations between two parameters.
 * @author Moluram
 * @version 1.0
 */
public class Calculator {
  /**
   * Take 2 numbers from command line and performs arithmetic operations on them
   * @param args - attributes from command line
   */
  public static void main(String[] args) {
    try {
      Double x = parseDoubleWithDefault(args[0], 0);
      Double y = parseDoubleWithDefault(args[1], 0);
      System.out.println(x + " + " + y + " = " + (x+y));
      System.out.println(x + " - " + y + " = " + (x-y));
      System.out.println(x + " * " + y + " = " + (x*y));
      System.out.println(x + " / " + y + " = " + (x/y));
    } catch (ArrayIndexOutOfBoundsException e){
      System.out.println("You need to enter two numbers as arguments of the command line");
    } catch (NumberFormatException e){
      System.out.println("The number must consist only of digits");
    }
  }

  private static Double parseDoubleWithDefault(String s, double def) {
    try {
      return Double.parseDouble(s);
    } catch (NumberFormatException e) {
      return def;
    }
  }
}
