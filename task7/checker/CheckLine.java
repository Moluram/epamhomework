package com.moluram.task7.checker;

import java.util.ArrayList;
import java.util.List;

/**
 * Class serve for checking given line on various tests
 * @author Moluram
 * @version 1.0
 */
public class CheckLine {
  private List<Checker> listOfCheckers = new ArrayList<>();

  public CheckLine(){
    createListOfCheckers();
  }

  public void checkLineOnVariousTests(String checkedLine){
    for (Checker checker: listOfCheckers) {
      checker.check(checkedLine);
    }
  }

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
