package com.moluram.task3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class serve for calculations between two parameters.
 * @author Moluram
 * @version 1.0
 */
public class Calculator {
  /**
   * Takes 2 numbers from command line and performs arithmetic operations on them
   * @param args - arguments from command line
   */
  public static void main(String[] args) {
    try {
      if (isConsistOfDigits(args[0]) &
        isConsistOfDigits(args[1])){
        System.out.println("The number must consist only of digits");
      } else {
        Double x = parseDoubleWithDefault(args[0], 0);
        Double y = parseDoubleWithDefault(args[1], 0);
        System.out.println(x + " + " + y + " = " + (x + y));
        System.out.println(x + " - " + y + " = " + (x - y));
        System.out.println(x + " * " + y + " = " + (x * y));
        System.out.println(x + " / " + y + " = " + (x / y));
      }
    } catch (ArrayIndexOutOfBoundsException e){
      System.out.println("You need to enter two numbers as arguments of the command line");
    }
  }

  /**
   * Checks whether the argument contains characters other than numbers.
   * @param arg - argument for check
   * @return boolean
   */
  private static boolean isConsistOfDigits(String arg) {
    String pattern = "[^0-9]\\s";
    Pattern p = Pattern.compile(pattern);
    Matcher m = p.matcher(arg);
    if(m.find()){
      return false;
    }
    return true;
  }

  /**
   * Returns Double equivalent of the given line. Default value comes into if exception will be
   * thrown.
   * @param value - number in string form
   * @param def - default value
   * @return Double
   */
  private static Double parseDoubleWithDefault(String value, double def) {
    try {
      return Double.parseDouble(value);
    } catch (NumberFormatException e) {
      return def;
    }
  }
}
