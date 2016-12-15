package com.moluram.tasks13;

import java.util.Scanner;

/**
 * Created by Moluram on 15.12.2016.
 */
public class Calculator {
  public static void main(String[] args) {
    int x = new Scanner(System.in).nextInt();
    int y = new Scanner(System.in).nextInt();
    System.out.println(x + " + " + y + " = " + (x + y));
    System.out.println(x + " - " + y + " = " + (x - y));
    System.out.println(x + " * " + y + " = " + (x * y));
    System.out.println(x + " / " + y + " = " + ((float)x / y));
  }
}
