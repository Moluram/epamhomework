package com.moluram.task7.checker;

/**
 * Class serves for determine is sent line contain palindrome word
 * @author Moluram
 * @version 1.0
 */
public class ContainWordPalindrome implements Checker {
  /**
   * Checks whether the given string contain palindrome word
   * @param line - line for check
   * @return boolean - answer of the check
   */
  public boolean check(String line) {
    for (String word: line.split(",| ")) {
      if (word.length() > 0 && new StringBuilder(word).reverse().toString().equals(word)) {
        return true;
      }
    }
    return false;
  }
}
