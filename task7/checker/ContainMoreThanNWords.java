package com.moluram.task7.checker;

/**
 * Class serve to answer the question :
 * Is this line contain more than N words?
 * @author Moluram
 * @version 1.0
 */
public class ContainMoreThanNWords implements Checker {
  /**
   * Number of words
   */
  private int n = 0;

  public ContainMoreThanNWords(int N) {
    this.n = N;
  }

  /**
   * Checks whether the given string contain more than five words
   * @param line - line for check
   * @return boolean - answer of the check
   */
  public boolean check(String line) {
    String[] words = line.split(",| ");
    int counter = 0;
    for (String word: words) {
        if (word.length() != 0) {
          counter++;
      }
    }
    return counter > n;
  }

}
