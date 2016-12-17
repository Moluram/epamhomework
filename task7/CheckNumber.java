package com.moluram.task7;

import java.util.Scanner;

/**
 * Created by Moluram on 16.12.2016.
 */
public class CheckNumber {
  public static void main(String[] args) {
    String line = new Scanner(System.in).nextLine().replace(","," ");
    if (ContainMoreThan5Words.check(line)) {
      print("Contains more than 5 words");
    }
    if (ContainOnlyDigitals.check(line)) {
      print("Contain only digits");
    }
    if (ContainWordFromDictionary.check(line)) {
      print("Contain word from dictionary");
    }
    if (DoNotContainDigitals.check(line)) {
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
