package com.moluram.task8;

import com.moluram.task8.cases.Case;

import java.math.BigDecimal;
import java.util.*;

/**
 * Class serve for answer the questions of the user representing in the enter
 */
public class Console {
  private static final String REGEX_VALUE_FOR_SPLIT = " ";
  private static final String CASE_EXIT = "exit";
  private static final int FIRST_WORD = 0;
  private List<Case> listOfCases;

  /**
   * Constructor which except list of using cases for this object
   * @param listOfCases - list of cases
   */
  public Console(List<Case> listOfCases){
    this.listOfCases = listOfCases;
  }

  /**
   * Main function. Start the work of the object.
   * Takes users input and send it to different cases
   */
  void start() {
    printsExistingCases();
    Scanner in = new Scanner(System.in);
    String[] line = new Scanner(System.in).nextLine().split(REGEX_VALUE_FOR_SPLIT);
    while (!line[FIRST_WORD].equals(CASE_EXIT)) {
      for (Case cases: listOfCases) {
        if (cases.isFits(line)) {
          System.out.println(cases.execute(line));
          break;
        }
      }
      line = in.nextLine().split(REGEX_VALUE_FOR_SPLIT);
    }
  }

  private void printsExistingCases() {
    for (Case cases: listOfCases) {
      System.out.println(cases.availableVariants());
    }
    System.out.println(CASE_EXIT);
  }
}
