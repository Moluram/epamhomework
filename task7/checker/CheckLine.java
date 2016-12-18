package com.moluram.task7.checker;

/**
 * Class serve for checking given line on various tests
 * @author Moluram
 * @version 1.0
 */
public class CheckLine {
  private ContainWordFromDictionary containWordFromDictionary = new ContainWordFromDictionary();
  private ContainOnlyDigits containOnlyDigits = new ContainOnlyDigits();
  private ContainMoreThan5Words containMoreThan5Words = new ContainMoreThan5Words();
  private DoNotContainDigits doNotContainDigits = new DoNotContainDigits();

  /**
   * Checks whether the given string consist of digits calling ContainOnlyDigits instance for check
   * Return answer
   * @param line - line for check
   * @return boolean
   */
  public boolean forContainOnlyDigits(String line) {
    return containOnlyDigits.check(line);
  }

  /**
   * Checks whether the given string contain more than 5 word through calling ContainMoreThan5Words
   * instance for check
   * Return answer
   * @param line - line for check
   * @return boolean
   */
  public boolean forContainMoreThan5Words(String line) {
    return containMoreThan5Words.check(line);
  }

  /**
   * Checks whether the given string do not contain digits through calling DoNotContainDigits
   * instance for check
   * Return answer
   * @param line - line for check
   * @return boolean
   */
  public boolean forDoNotContainDigits(String line) {
    return doNotContainDigits.check(line);
  }

  /**
   * Checks whether the given string contain word from dictionary through calling
   * ContainWordFromDictionary instance for check
   * Return answer
   * @param line - line for check
   * @return boolean
   */
  public boolean forContainWordFromDictionary(String line) {
    return containWordFromDictionary.check(line);
  }
}
