package com.moluram.task7.checker;

/**
 * Created by Moluram on 17.12.2016.
 */
public class CheckLine {
  private ContainWordFromDictionary containWordFromDictionary = new ContainWordFromDictionary();
  private ContainOnlyDigits containOnlyDigits = new ContainOnlyDigits();
  private ContainMoreThan5Words containMoreThan5Words = new ContainMoreThan5Words();
  private DoNotContainDigits doNotContainDigits = new DoNotContainDigits();

  public boolean forContainOnlyDigits(String line) {
    return containOnlyDigits.check(line);
  }

  public boolean forContainMoreThan5Words(String line) {
    return containMoreThan5Words.check(line);
  }

  public boolean forDoNotContainDigits(String line) {
    return doNotContainDigits.check(line);
  }

  public boolean forContainWordFromDictionary(String line) {
    return containWordFromDictionary.check(line);
  }
}
