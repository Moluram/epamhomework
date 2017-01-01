package com.moluram.task8.cases;

import com.moluram.task8.App;

/**
 *  Class represent case in which user wants to know about average price for all products in the application or for
 *  given type of products
 */
public class CaseAveragePrice implements Case {
  private static final String LINE_CASE_AVERAGE = "average";
  private static final String LINE_CASE_PRICE = "price";
  private static final String OUTPUT_LINE_FOR_CASE_AVERAGE_PRICE_OF_PRODUCTS = "Average price of products : ";
  private static final String OUTPUT_LINE_FOR_CASE_AVERAGE_PRICE_OF_TYPES = "Average price of types : ";
  private static final String ARITHMETIC_EXCEPTION_MESSAGE = "Objects do not exist";
  private static final String AVAILABLE_VARIANTS = "average price \naverage price <type>";

  /**
   * Returns string of available console inputs
   * @return string
   */
  public String availableVariants() {
    return AVAILABLE_VARIANTS;
  }

  /**
   * Parameter contain object of business logic for this case
   */
  private final App app;

  /**
   * Constructor which sets the business logic
   * @param app - object of business logic
   */
  public CaseAveragePrice (App app) {
    this.app = app;
  }

  /**
   * Starts the implementation of this case
   * @param line - line form user input
   * @return - line to output
   */
  public String execute(String[] line) {
    try {
      if (line.length < 3) {
        return OUTPUT_LINE_FOR_CASE_AVERAGE_PRICE_OF_PRODUCTS + app.getAveragePriceOfProducts();
      } else {
        return OUTPUT_LINE_FOR_CASE_AVERAGE_PRICE_OF_TYPES + app.getAveragePriceOfType(line[2]);
      }
    } catch (ArithmeticException e) {
      return ARITHMETIC_EXCEPTION_MESSAGE;
    }
  }

  /**
   * Checks whether this case is which user wants
   * @param line - line from input
   * @return - boolean answer
   */
  public boolean isFits(String[] line) {
    try {
      return line[0].equals(LINE_CASE_AVERAGE) && line[1].equals(LINE_CASE_PRICE);
    } catch (ArrayIndexOutOfBoundsException e) {
      return false;
    }
  }
}
