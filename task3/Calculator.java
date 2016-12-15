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
      int x = Integer.parseInt(args[0]);
      int y = Integer.parseInt(args[1]);
      System.out.println(x + " + " + y + " = " + (x + y));
      System.out.println(x + " - " + y + " = " + (x - y));
      System.out.println(x + " * " + y + " = " + (x * y));
      System.out.println(x + " / " + y + " = " + ((float) x / y));
    }catch (ArrayIndexOutOfBoundsException e){
      System.out.println("*.class <1st number> <2nd number>");
    }catch (NumberFormatException e){
      System.out.println("The number must consist only of digits");
    }
  }
}
