package com.moluram.task7.checker;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class serves for determine is sent line contain digits
 * @author Moluram
 * @version 1.0
 */
class DoNotContainDigits implements Checker {
  /**
   * Checks whether the given line contain digits
   * Prints the answer
   * @param line - checked line
   */
  public void check(String line) {
    String pattern = "[0-9]";
    Pattern p = Pattern.compile(pattern);
    Matcher m = p.matcher(line.replace(" ",""));
    if(!m.find()){
      System.out.println("Do not contain digits");
    } else {
      System.out.println("Contain digits");
    }
  }
}
