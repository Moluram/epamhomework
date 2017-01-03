package com.moluram.task10;

import sun.util.calendar.BaseCalendar;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Moluram on 03.01.2017.
 */
public class TestFolder {
  private static final String TYPE_FILE = "FILE";
  private static final String TYPE_DIR = "DIR";
  private static final String PATTERN_FOR_DATE = "MM.dd.yyyy";
  private String  catalogName;
  private List<Result> resultsOfCheck = new ArrayList<>();

  public TestFolder(String catalogName) {
    this.catalogName = catalogName;
  }

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

  public List<Result> getResultsOfCheck() {
    return resultsOfCheck;
  }
}
