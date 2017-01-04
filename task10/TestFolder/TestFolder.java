package com.moluram.task10.TestFolder;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Class tests folder on types of files and their size.
 */
public class TestFolder {
  private static final String TYPE_FILE = "FILE";
  private static final String TYPE_DIR = "DIR";
  private static final String PATTERN_FOR_DATE = "MM.dd.yyyy";

  /**
   * Name of catalog to test
   */
  private String  catalogName;

  /**
   * List of results of tests
   */
  private List<Result> resultsOfCheck = new ArrayList<>();

  /**
   * Constructor sets catalog for test
   * @param catalogName - catalog for test
   */
  public TestFolder(String catalogName) {
    this.catalogName = catalogName;
  }

  /**
   * Tests established directory
   */
  public void checkCurrentDirectory() {
    resultsOfCheck.clear();
    File folder = new File(catalogName);
    File[] listOfFiles = folder.listFiles();
    SimpleDateFormat sdf = new SimpleDateFormat(PATTERN_FOR_DATE);
    assert listOfFiles != null;
    for (File file : listOfFiles) {
      if (file.isFile()) {
        resultsOfCheck.add(new Result(file.getName(),
            TYPE_FILE, sdf.format(file.lastModified()), file.length()));
      } else {
        resultsOfCheck.add(new Result(file.getName(),
            TYPE_DIR, sdf.format(file.lastModified()), getLengthOFDir(file)));
      }
    }
  }

  /**
   * Return the size of the given directory or file
   * @param folder - file or folder to start
   * @return - Long - size of file
   */
  private Long getLengthOFDir(File folder) {
    Long length = 0L;
    File[] listOfFiles = folder.listFiles();
    if (listOfFiles != null) {
      for (File file : listOfFiles) {
        length += getLengthOFDir(file);
      }
    }
    return folder.length() + length;
  }

  /**
   * Return results of tests
   * @return List<Result> - results of tests
   */
  public List<Result> getResultsOfCheck() {
    return resultsOfCheck;
  }
}
