package com.moluram.task7.checker;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class serves for determine is sent line contain digits
 * @author Moluram
 * @version 1.0
 */
public class DoNotContainDigits implements Checker {
  /**
   * Checks whether the given line contain digits
   * @param line - checked line
   * @return boolean - answer of the check
   */
  public boolean check(String line) {
    String pattern = "[0-9]";
    Pattern p = Pattern.compile(pattern);
    Matcher m = p.matcher(line);
    return !m.find();
  }
}
