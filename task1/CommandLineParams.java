package com.moluram.task1;

/**
 *Class prints all command line arguments in reverse order.
 * @author Moluram
 * @version 1.0
 */
public class CommandLineParams {
  /**
   * Takes all command line arguments and print them to console
   * @param args - arguments from command line
   */
  public static void main(String[] args) {
    for (int i = args.length - 1; i >= 0; i--) {
      System.out.println("The argument " + i + " = " + args[i]);
    }
  }

}
