package com.moluram.task10;

import com.moluram.task10.TestFolder.HtmlParser;
import com.moluram.task10.TestFolder.Printer;
import com.moluram.task10.TestFolder.TestFolder;

/**
 * Class execute implementation of the program.
 */
public class Main {
  private static final String CATALOG_NAME = ".";
  private static final String NAME_OF_FILE_WHERE_TO_PRINT = "result.html";

  /**
   * Runs tests and print them in html form to the file
   * @param args - arguments from the command line
   */
  public static void main(String[] args) {
    TestFolder testFolder = new TestFolder(CATALOG_NAME);
    testFolder.checkCurrentDirectory();
    Printer printer = new Printer();
    HtmlParser htmlParser = new HtmlParser();
    printer.printInFile(htmlParser.getResultsInHtmlTableForm(
        testFolder.getResultsOfCheck()), NAME_OF_FILE_WHERE_TO_PRINT);
  }
}
