package com.moluram.task7.checker;

/**
 * Class serve to answer the question :
 * Is this line contain more than 5 words?
 * @author Moluram
 * @version 1.0
 */
class ContainMoreThan5Words implements Checker{
  /**
   * Checks whether the given string contain more than five words
   * Return answer
   * @param line - line for check
   * @return boolean
   */
  public boolean check(String line){
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
