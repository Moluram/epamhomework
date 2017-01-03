package com.moluram.task9;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Moluram on 02.01.2017.
 */
public class Interviewer {
  private static final String FILE_FORMAT = ".html";
  private static final int FIRST_RESULT = 0;
  private static final int BOUND_FOR_RANDOM = 100;

  /**
   * Database of all existing servers
   */
  private final DataBaseOfServers dataBaseOfServers;

  /**
   * List of tests results
   */
  private List<Result> listOfResults = new ArrayList<>();

  /**
   * Constructor which sets database for an object
   * @param dataBaseOfServers - database where store all servers
   */
  public Interviewer(DataBaseOfServers dataBaseOfServers) {
    this.dataBaseOfServers = dataBaseOfServers;
  }

  /**
   * Saves results in html file in html table format
   * @param nameOfFileToCreate - Name of the html file to create or name of the existing file
   */
  public void getResultsInHtmlFormFile(String nameOfFileToCreate) {
    File file = new File(nameOfFileToCreate + FILE_FORMAT);
    try {
      if(!file.exists()){
        file.createNewFile();
      }
      PrintWriter out = new PrintWriter(file.getAbsoluteFile());
      try {
        out.print(new HtmlParser().parseToTablePage(listOfResults, getMax(listOfResults)));
      } finally {
        out.close();
      }
    } catch(IOException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * Finds result with max response
   * @param listOfResults - list of results of tests
   * @return - result with max response
   */
  private Result getMax(List<Result> listOfResults) {
    try {
      Result maxResult = listOfResults.get(FIRST_RESULT);
      for (Result result: listOfResults) {
        if (result.getResponse() > maxResult.getResponse()) {
          maxResult = result;
        }
      }
      return maxResult;
    } catch (IndexOutOfBoundsException e) {
      return null;
    }
  }

  /**
   * Starts the test of servers
   */
  public void interviewServers() {
    Random rnd = new Random();
    for (Server server: dataBaseOfServers.getListOfServers()) {
      listOfResults.add(new Result(server, Math.abs(rnd.nextInt(BOUND_FOR_RANDOM))));
    }
  }
}
