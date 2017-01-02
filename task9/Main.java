package com.moluram.task9;

/**
 * Created by Moluram on 02.01.2017.
 */
public class Main {
  public static void main(String[] args) {
    try {
      DataBaseOfServers dataBaseOfServers = new DataBaseOfServers(args, "server.txt");
      Interviewer interviewer = new Interviewer(dataBaseOfServers);
      interviewer.interviewServers();
      interviewer.getResultsInHtmlFormFile("results.html");
    } catch (DataBaseOfServers.DictionaryFileDidntFoundException e) {
      System.out.println("Dictionary file didn't found!");
    }
  }
}
