package com.moluram.task8.cases;

/**
 * Representing interface for case
 */
public interface Case {
  /**
   * Checks whether this case is which user wants
   * @param line - line from input
   * @return - boolean answer
   */
  boolean isFits(String[] line);

  /**
   * Starts the implementation of this case
   * @param line - line form user input
   * @return - line to output
   */
  String execute(String[] line);

  /**
   * Return available variants of using this case
   * @return - line to output
   */
  String availableVariants();
}
