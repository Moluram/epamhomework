package com.moluram.task7.checker;

/**
 * Class serves for determine is sent line contain only one word of max length
 * @author Moluram
 * @version 1.0
 */
public class ContainOnlyOneWordOfMaxLength implements Checker {
  /**
   * Checks whether the given string contain only one word of max length
   * @param line - line for testing
   * @return boolean - answer of the check
   */
  public boolean check(String line) throws NotEnoughWordsException {
    String[] words = line.split(" ");
    if (words.length < 2) {
      throw new NotEnoughWordsException();
    }
    return !(findCountOfWordWithMaxLength(words, findMaxLength(words)) > 1);
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

