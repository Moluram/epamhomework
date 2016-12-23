package com.moluram.task7.checker;

/**
 * Interfaces for classes which wants to check string line
 */
public interface Checker {
  /**
   * Main function for checkers
   * Prints the result of check
   * @param line - checked line
   */
  boolean check(String line) throws NotEnoughWordsException;
}
