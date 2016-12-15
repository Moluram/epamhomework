package com.moluram.task2;

import java.util.Scanner;

/**
 * Program which accepts name from command line and prints line "Hello, {name}"
 */
public class HelloName {

  /**Function with all functionality*/
  public static void main(String[] args) {
    String name = new Scanner(System.in).nextLine();
    System.out.println("Hello, " + name);
  }
}
