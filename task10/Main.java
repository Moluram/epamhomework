package com.moluram.task10;

/**
 * Created by Moluram on 03.01.2017.
 */
public class Main {
  public static final String CATALOG_NAME = ".";
  private static final String NAME_OF_FILE_WHERE_TO_PRINT = "result.html";

  public static void main(String[] args) {
    TestFolder testFolder = new TestFolder(CATALOG_NAME);
    testFolder.checkCurrentDirectory();
    Printer printer = new Printer();
    HtmlParser htmlParser = new HtmlParser();
    printer.printInFile(htmlParser.getResultsInHtmlTableForm(
        testFolder.getResultsOfCheck()), NAME_OF_FILE_WHERE_TO_PRINT);
  }
}
