package com.moluram.task1;

/**
 *Program which print all command line attributes in reverse order.
 */
public class CommandLineParams {

  /**Function with all functionality*/
  public static void main(String[] args) {
    for(int i = args.length - 1; i >= 0; i--) {
      System.out.println("The argument " + i + " = " + args[i]);
    }
  }

}
