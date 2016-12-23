package com.moluram.task7.checker;

/**
 * Class serves for determine is sent line contain palindrome word
 * @author Moluram
 * @version 1.0
 */
class ContainWordPalindrome implements Checker{
  /**
   * Checks whether the given string contain palindrome word
   * Prints the answer
   * @param line - line for check
   */
  public void check(String line) {
    for (String word: line.split(" ")) {
      if (word.length() > 0 && new StringBuilder(word).reverse().toString().equals(word)) {
        System.out.println("Contain palindrome word");
        return;
      }
    }
    System.out.println("Do not contain palindrome word");
  }
}
