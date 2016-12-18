package com.moluram.task7.checker;

/**
 * Interfaces for classes which wants to check string line
 */
interface Checker {
  /**
   * Main function for checkers
   * Return result of check
   * @param line - checked line
   * @return boolean
   */
  boolean check(String line);
}
