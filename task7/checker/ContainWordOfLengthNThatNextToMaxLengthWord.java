package com.moluram.task7.checker;

/**
 * Class serves for determine is sent line contain word with length 4 that next to max length word
 * @author Moluram
 * @version 1.0
 */
public class ContainWordOfLengthNThatNextToMaxLengthWord implements Checker {
  /**
   * Number N for test
   */
  private int n = 0;

  /**
   * Small shift for not to go beyond the bounds of the array
   */
  private static final int SMALL_SHIFT = 1;

  /**
   * Checks whether the given string contain only one word of max length
   * @param line - line for testing
   * @return boolean - answer of the check
   */
  public boolean check(String line) throws NotEnoughWordsException {
    String[] words = line.split(",| ");
    if (words.length < 2) {
      throw new NotEnoughWordsException();
    }
    return isContainWordOfLengthNThatNextToMaxLengthWord(words, findMaxLength(words));
  }

  public ContainWordOfLengthNThatNextToMaxLengthWord(int N) {
    this.n = N;
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
   * Finds answer  for the question:
   * Is that array contain word of length N that nex to max length word
   * @param words - array of words
   * @param maxLength - max length of the words from "words" array
   * @return boolean - answer to the question
   */
  private boolean isContainWordOfLengthNThatNextToMaxLengthWord(String[] words, int maxLength) {
    for (int i = 0; i < words.length - SMALL_SHIFT; i++) {
      if (words[i].length() == maxLength && words[i+1].length() == n) {
        return true;
      }
    }
    return false;
  }
}
