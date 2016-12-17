package com.moluram.task7.checker;

import java.util.regex.*;

/**
 * Class serves for determine is sent line consist only of digits
 * @author Moluram
 * @version 1.0
 */
class ContainOnlyDigits implements Checker{
  /**
   * Checks whether the given string consists only of digits
   * Return answer
   * @param line - line for testing
   * @return boolean
   */
  public boolean check(String line){
    String pattern = "[^0-9]";
    Pattern p = Pattern.compile(pattern);
    Matcher m = p.matcher(line.replace(" ", ""));
    return !m.find();
  }
}
