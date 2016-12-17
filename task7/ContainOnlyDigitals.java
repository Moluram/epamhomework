package com.moluram.task7;

import java.util.regex.*;
/**
 * Created by Moluram on 16.12.2016.
 */
final class ContainOnlyDigitals {
  private ContainOnlyDigitals(){}

  static boolean check(String line){
    String pattern = "[^0-9]";
    Pattern p = Pattern.compile(pattern);
    Matcher m = p.matcher(line.replace(" ", ""));
    return !m.find();
  }
}
