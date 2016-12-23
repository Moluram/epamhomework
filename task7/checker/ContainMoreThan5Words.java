package com.moluram.task7.checker;

/**
 * Class serve to answer the question :
 * Is this line contain more than 5 words?
 * @author Moluram
 * @version 1.0
 */
class ContainMoreThan5Words implements Checker {
  /**
   * Checks whether the given string contain more than five words
   * Prints the answer
   * @param line - line for check
   */
  public void check(String line) {
    String[] words = line.split(" ");
    int counter = 0;
    for (String word: words) {
        if (word.length() != 0) {
          counter++;
      }
    }
    if (counter > 5) {
      System.out.println("Contains more than 5 words");
    } else {
      System.out.println("Contains less than 5 words");
    }
  }

}
