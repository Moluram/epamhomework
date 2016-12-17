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
    if (checkLine.forContainMoreThan5Words(line)) {
      print("Contains more than 5 words");
    }
    if (checkLine.forContainOnlyDigits(line)) {
      print("Contain only digits");
    }
    if (checkLine.forContainWordFromDictionary(line)) {
      print("Contain word from dictionary");
    }
    if (checkLine.forDoNotContainDigits(line)) {
      print("Do not contain digits");
    }
  }

  /**
   * Prints to the console value
   * @param value - printed value
   */
  private static void print(String value){
    System.out.println(value);
  }
}
