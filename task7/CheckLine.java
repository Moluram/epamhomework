package com.moluram.task7;

import com.moluram.task7.checker.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Class serve for checking given line on various tests
 * @author Moluram
 * @version 1.0
 */
public class CheckLine {
  /**
   * Value for ContainMoreThanNWords
   */
  static private final int VALUE_FOR_TEST = 5;

  private Properties property = new Properties();

  /**
   * List of used checkers
   */
  private List<Checker> listOfCheckers = new ArrayList<>();

  public CheckLine() {
    createListOfCheckers();
    FileInputStream fis;
    try {
      fis = new FileInputStream("src/com/moluram/task7/outputStrings.properties");
      property.load(fis);
    } catch (IOException e) {
      System.err.println("ОШИБКА: Файл свойств отсуствует!");
    }
  }

  /**
   * Run all the test on given parameter
   * @param param - given parameter
   */
  public void checkLineOnVariousTests(String param) {
    for (Checker checker: listOfCheckers) {
      try {
        System.out.println(property.getProperty(
                checker.getClass().getSimpleName() + checker.check(param)));
      } catch (NotEnoughWordsException e) {
        System.out.println("Not enough words for test: " + checker.getClass().getSimpleName());
      }
    }
  }

  /**
   * Creates list of existing checkers
   */
  private void createListOfCheckers() {
    listOfCheckers.add(new ContainOnlyOneWordOfMaxLength());
    listOfCheckers.add(new ContainWordPalindrome());
    listOfCheckers.add(new ContainWordFromDictionary());
    listOfCheckers.add(new ContainWordOfLength4ThatNextToMaxLengthWord());
    listOfCheckers.add(new ContainOnlyDigits());
    listOfCheckers.add(new ContainMoreThanNWords(VALUE_FOR_TEST));
    listOfCheckers.add(new DoNotContainDigits());
  }
}
