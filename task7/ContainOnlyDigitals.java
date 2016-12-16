package com.moluram.task7;

import java.util.regex.*;
/**
 * Created by Moluram on 16.12.2016.
 */
public final class ContainOnlyDigitals {
  private ContainOnlyDigitals(){}

  public static boolean check(String line){
    String pattern = "[^0-9]\\s";
    Pattern p = Pattern.compile(pattern);
    Matcher m = p.matcher(line);
    if(m.find()){
      return false;
    }
    return true;
  }
}
