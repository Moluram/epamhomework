package com.moluram.task7;

/**
 * Created by Moluram on 16.12.2016.
 */
public final class ContainMoreThan5Words {
  private ContainMoreThan5Words(){}

  public static boolean check(String line){
    String[] words = line.split(" ");
    int counter = 0;
    for (String word: words) {
        if(word.length()!=0){
          counter++;
      }
    }
    if(counter <= 5) {
      return false;
    }else {
      return true;
    }
  }

}
