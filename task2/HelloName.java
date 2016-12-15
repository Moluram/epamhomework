package com.moluram.task2;

/**
 * Class serve for print string "Hello, NAME",
 * where name is taken from command line attributes.
 * @author Moluram
 * @version 1.0
 */
public class HelloName {
  /**
   * Take NAME from command line attributes and print
   * line "Hello, NAME" to console.
   * @param args - attributes from command line
   */
  public static void main(String[] args) {
    try {
      String name = args[0];
      System.out.println("Hello, " + name);
    }catch (ArrayIndexOutOfBoundsException e) {
      System.out.println("*.class <name>");
    }
  }
}
