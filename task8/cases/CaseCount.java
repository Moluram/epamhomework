package com.moluram.task8.cases;

import com.moluram.task8.App;

/**
 * Class represent case in which user wants to know about count of different types products or about count of all
 * products
 */
public class CaseCount implements Case {
  private static final String LINE_CASE_COUNT = "count";
  private static final String LINE_CASE_COUNT_ALL = "all";
  private static final String LINE_CASE_COUNT_TYPES = "types";
  private static final String OUTPUT_LINE_FOR_CASE_COUNT_TYPES = "Count of types: ";
  private static final String OUTPUT_LINE_FOR_CASE_COUNT_ALL = "Count of all products: ";
  private static final String AVAILABLE_VARIANTS = "count all \ncount <type>";

  private static final int SECOND_WORD = 1;
  private static final int FIRST_WORD = 0;

  /**
   * Represents the messages for the Exceptions
   */
  private static final String ARRAY_INDEX_OUT_OF_BOUNDS_EXCEPTION_MESSAGE = "Wrong input for the case. Not enough arguments";
  private static final String ERROR_ENTER_FOR_CASE = "Wrong input for the case. Incorrect arguments";

  /**
   * Parameter contain object of business logic for this case
   */
  private final App app;

  /**
   * Constructor which sets the business logic
   * @param app - object of business logic
   */
  public CaseCount (App app) {
    this.app = app;
  }

  /**
   * Returns string of available console inputs
   * @return string
   */
  public String availableVariants() {
    return AVAILABLE_VARIANTS;
  }

  /**
   * Checks whether this case is which user wants
   * @param line - line from input
   * @return - boolean answer
   */
  public boolean isFits(String[] line) {
    try {
      return line[FIRST_WORD].equals(LINE_CASE_COUNT);
    } catch (ArrayIndexOutOfBoundsException e) {
      return false;
    }
  }

  /**
   * Starts the implementation of this case
   * @param line - line form user input
   * @return - line to output
   */
  public String execute(String[] line) {
    try {
      switch (line[SECOND_WORD]) {
        case LINE_CASE_COUNT_TYPES:
          return countOfTypes();

        case LINE_CASE_COUNT_ALL:
          return countOfAllProducts();

        default:
          return ERROR_ENTER_FOR_CASE;
      }
    } catch (ArrayIndexOutOfBoundsException e) {
      return ARRAY_INDEX_OUT_OF_BOUNDS_EXCEPTION_MESSAGE;
    }
  }

  /**
   * Return the amount of types in the application
   * @return - amount of types
   */
  private String countOfTypes() {
    return OUTPUT_LINE_FOR_CASE_COUNT_TYPES + app.getAmountOfTypes();
  }

  /**
   * Return the amount of all products in the application
   * @return - amount of all products
   */
  private String countOfAllProducts() {
    return OUTPUT_LINE_FOR_CASE_COUNT_ALL + app.getAmountOfProducts();
  }
}
