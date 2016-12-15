package com.moluram.task1;

/**
 *Class prints all command line attributes in reverse order.
 */
public class CommandLineParams {

  /**Take all command line attributes and print them to console*/
  public static void main(String[] args) {
    for(int i = args.length - 1; i >= 0; i--) {
      System.out.println("The argument " + i + " = " + args[i]);
    }
  }

}
