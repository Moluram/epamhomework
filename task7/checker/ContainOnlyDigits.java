package com.moluram.task7.checker;

import java.util.regex.*;

/**
 * Class serves for determine is sent line consist only of digits
 * @author Moluram
 * @version 1.0
 */
class ContainOnlyDigits implements Checker {
  /**
   * Checks whether the given string consists only of digits
   * Prints the answer
   * @param line - line for testing
   */
  public void check(String line) {
    String pattern = "[^0-9]";
    Pattern p = Pattern.compile(pattern);
    Matcher m = p.matcher(line);
    if(!m.find()){
      System.out.println("Contain only digits");
    }else {
      System.out.println("Do not contain only digits");
    }
  }
}
