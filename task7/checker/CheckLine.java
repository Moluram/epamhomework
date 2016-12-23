package com.moluram.task7.checker;

import java.util.ArrayList;
import java.util.List;

/**
 * Class serve for checking given line on various tests
 * @author Moluram
 * @version 1.0
 */
public class CheckLine <T>{
  /**
   * List of used checkers
   */
  private List<Checker> listOfCheckers = new ArrayList<>();

  public CheckLine(){
    createListOfCheckers();
  }

  /**
   * Run all the test on given parameter, but before it casting to String
   * @param param - given parameter
   */
  public void checkLineOnVariousTests(T param){
    for (Checker checker: listOfCheckers) {
      checker.check(param.toString());
    }
  }

  /**
   * Creates list of existing checkers
   */
  private void createListOfCheckers(){
    listOfCheckers.add(new ContainOnlyOneWordOfMaxLength());
    listOfCheckers.add(new ContainWordPalindrome());
    listOfCheckers.add(new ContainWordFromDictionary());
    listOfCheckers.add(new ContainWordOfLength4ThatNextToMaxLengthWord());
    listOfCheckers.add(new ContainOnlyDigits());
    listOfCheckers.add(new ContainMoreThan5Words());
    listOfCheckers.add(new DoNotContainDigits());
  }
}
