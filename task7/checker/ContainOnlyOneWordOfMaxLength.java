package com.moluram.task7.checker;

/**
 * Class serves for determine is sent line contain only one word of max length
 * @author Moluram
 * @version 1.0
 */
class ContainOnlyOneWordOfMaxLength implements Checker {
  /**
   * Checks whether the given string contain only one word of max length
   * Prints the answer
   * @param line - line for testing
   */
  public void check(String line) {
    String[] words = line.split(" ");
    if (words.length < 2) {
      return;
    }
    if (findCountOfWordWithMaxLength(words, findMaxLength(words)) > 1) {
      System.out.println("Does not contain only one word of max length");
    } else {
      System.out.println("Contain only one word of max length");
    }
  }

  /**
   * Finds max length of words from given array of strings
   * @param words - array of words
   * @return int - maxLength
   */
  private int findMaxLength(String[] words) {
    int maxLength = 0;
    for (String word : words) {
      if (word.length() > maxLength) {
        maxLength = word.length();
      }
    }
    return maxLength;
  }

  /**
   * Finds count of words with max length in given array
   * @param words - array of words
   * @param maxLength - max length of the words from "words" array
   * @return int - count of words with max length
   */
  private int findCountOfWordWithMaxLength(String[] words, int maxLength) {
    int counter = 0;
    for (String word : words) {
      if (word.length() == maxLength) {
        counter++;
        maxLength = word.length();
      }
    }
    return counter;
  }
}

