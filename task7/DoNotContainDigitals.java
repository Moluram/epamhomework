package com.moluram.task7;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Moluram on 16.12.2016.
 */
public final class DoNotContainDigitals {
  private DoNotContainDigitals(){}

  public static boolean check(String line){
    String pattern = "[0-9]";
    Pattern p = Pattern.compile(pattern);
    Matcher m = p.matcher(line);
    if(m.find()){
      return false;
    }
    return true;
  }
}
