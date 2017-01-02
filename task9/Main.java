package com.moluram.task9;

/**
 * Class serve for executing Interviewer object
 */
public class Main {
  private static final String ERROR_MESSAGE_FOR_DICTIONARY_FILE_DIDNT_FOUND = "Dictionary file didn't found!";
  private static final String NAME_OF_FILE_TO_CREATE = "results";
  private static final String NAME_OF_THE_DICTIONARY_FILE = "server.txt";

  /**
   * Takes arguments from command line, send them to DataBase constructor and executing Interviewer
   * @param args - arguments from command line
   */
  public static void main(String[] args) {
    try {
      DataBaseOfServers dataBaseOfServers = new DataBaseOfServers(args, NAME_OF_THE_DICTIONARY_FILE);
      Interviewer interviewer = new Interviewer(dataBaseOfServers);
      interviewer.interviewServers();
      interviewer.getResultsInHtmlFormFile(NAME_OF_FILE_TO_CREATE);
    } catch (DataBaseOfServers.DictionaryFileDidntFoundException e) {
      System.out.println(ERROR_MESSAGE_FOR_DICTIONARY_FILE_DIDNT_FOUND);
    }
  }
}
