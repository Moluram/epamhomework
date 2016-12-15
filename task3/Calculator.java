package com.moluram.task3;

import java.util.Scanner;

/**
 * Calculator which accepts from the command line 2 numbers and prints to the console their sum,
 * difference, multiplication and quotient.
 */
public class Calculator {

  /**All functionality are there*/
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
      System.out.println("The number should costate only of digits");
    }
  }
}
