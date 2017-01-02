package com.moluram.task8.cases;

import com.moluram.task8.App;

/**
 *  Class represent case in which user wants to add products in database
 */
public class CaseAdd implements Case{
  private static final String LINE_CASE_ADD = "add";
  private static final int FIRST_WORD = 1;
  private static final int SECOND_WORD = 2;
  private static final int THIRD_WORD = 3;
  private static final String AVAILABLE_VARIANTS = "add <type> <name> <amount> <cost per unit>";

  /**
   * Returns string of available console inputs
   * @return string
   */
  public String availableVariants() {
    return AVAILABLE_VARIANTS;
  }

  private static final int FOURTH_WORD = 4;
  private static final String NOT_ENOUGH_WORDS_EXCEPTION_MESSAGE = "Not enough words for case";

  /**
   * Parameter contain object of business logic for this case
   */
  private final App app;

  /**
   * Constructor which sets the business logic
   * @param app - object of business logic
   */
  public CaseAdd (App app) {
    this.app = app;
  }

  /**
   * Starts the implementation of this case
   * @param line - line form user input
   * @return - line to output
   */
  public String execute(String[] line) {
    try {
      return app.addProduct(line[FIRST_WORD], line[SECOND_WORD], line[THIRD_WORD], line[FOURTH_WORD]);
    } catch (ArrayIndexOutOfBoundsException e) {
      return NOT_ENOUGH_WORDS_EXCEPTION_MESSAGE;
    }
  }


  /**
   * Checks whether this case is which user wants
   * @param line - line from input
   * @return - boolean answer
   */
  public boolean isFits(String[] line) {
    try {
      return line[0].equals(LINE_CASE_ADD);
    } catch (ArrayIndexOutOfBoundsException e) {
      return false;
    }
  }
}
