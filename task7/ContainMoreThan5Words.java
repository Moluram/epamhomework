package com.moluram.task7;

/**
 * Created by Moluram on 16.12.2016.
 */
final class ContainMoreThan5Words {
  private ContainMoreThan5Words(){}

  static boolean check(String line){
    String[] words = line.split(" ");
    int counter = 0;
    for (String word: words) {
        if (word.length()!=0) {
          counter++;
      }
    }
    return counter > 5;
  }

}
