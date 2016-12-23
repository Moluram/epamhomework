package com.moluram.task7;

import com.moluram.task7.checker.CheckLine;

import java.util.Scanner;

/**
 * Class serve to check line from user input on various test
 * @author Moluram
 * @version 1.0
 */
public class CheckNumber {
  /**
   * Takes line from user input and send it to various tests
   * @param args - arguments from command line
   */
  public static void main(String[] args) {
    String line = new Scanner(System.in).nextLine().replace(","," ");
    CheckLine checkLine = new CheckLine();
    checkLine.checkLineOnVariousTests(line);
  }
}
