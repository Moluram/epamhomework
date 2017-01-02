package com.moluram.task8;

import com.moluram.task8.cases.Case;
import com.moluram.task8.cases.CaseAdd;
import com.moluram.task8.cases.CaseAveragePrice;
import com.moluram.task8.cases.CaseCount;

import java.util.ArrayList;
import java.util.List;

/**
 * Class serve for starting class Console
 */
public class Main {
  /**
   * Parameter contain unique object of business logic for all application
   */
  private static final App app = new App();

  /**
   * Create and starts object of the class Console
   * @param args - arguments of the command line - ignored
   */
  public static void main(String[] args) {
    new Console(createListOfCases()).start();
  }

  /**
   * Creates and returns a list of the using cases for object of the class Console
   * @return - list of using cases
   */
  private static List<Case> createListOfCases() {
    List<Case> listOfCases = new ArrayList<>();
    listOfCases.add(new CaseAdd(app));
    listOfCases.add(new CaseAveragePrice(app));
    listOfCases.add(new CaseCount(app));
    return listOfCases;
  }
}
