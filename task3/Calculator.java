package com.moluram.task3;

import java.math.BigDecimal;
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
      isConsistOfDigits(args[0]);
      isConsistOfDigits(args[1]);
      BigDecimal x = new BigDecimal(args[0]);
      BigDecimal y = new BigDecimal(args[1]);
      System.out.println(x + " + " + y + " = " + (x.add(y)));
      System.out.println(x + " - " + y + " = " + (x.subtract(y)));
      System.out.println(x + " * " + y + " = " + (x.multiply(y)));
      System.out.println(x + " / " + y + " = " + (x.divide(y, 17, BigDecimal.ROUND_HALF_UP)));
    } catch (ArrayIndexOutOfBoundsException e){
      System.out.println("You need to enter two numbers as arguments of the command line");
    } catch (NumberFormatException e){
      System.out.println("The numbers must consist only of digits");
    }
  }

  /**
   * Checks whether the argument contains characters other than numbers.
   * @param arg - argument for check
   */
  private static void isConsistOfDigits(String arg) {
    String pattern = "[^0-9]\\s";
    Pattern p = Pattern.compile(pattern);
    Matcher m = p.matcher(arg);
    if (m.find()){
      throw new NumberFormatException();
    }
  }
}
