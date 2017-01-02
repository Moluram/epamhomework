package com.moluram.task9;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Class which store Servers
 */
public class DataBaseOfServers {
  private static final String REGEX_VALUE_FOR_SPLIT = " ";
  private final List<Server> listOfServers = new LinkedList<>();

  /**
   * Create an object of Database with list of Servers from dictionary file
   * @param nameOfTheDictionaryFileOfServers - file where to take servers
   * @throws DictionaryFileDidntFoundException - when dictionary file didnt found
   */
  public DataBaseOfServers (String nameOfTheDictionaryFileOfServers)
      throws DictionaryFileDidntFoundException {
    addServersFromDictionaryFile(nameOfTheDictionaryFileOfServers);
  }

  /**
   * Create an object of Database with list of Servers from string array
   */
  public DataBaseOfServers (String[] arrayOfAddress) {
    addServersFromStringArray(arrayOfAddress);
  }

  /**
   * Create an object of Database with list of Servers from dictionary file and from string array
   * @param nameOfTheDictionaryFileOfServers - file where to take servers
   * @throws DictionaryFileDidntFoundException - when dictionary file didnt found
   */
  public DataBaseOfServers (String[] arrayOfAddress, String nameOfTheDictionaryFileOfServers)
      throws DictionaryFileDidntFoundException {
    addServersFromDictionaryFile(nameOfTheDictionaryFileOfServers);
    addServersFromStringArray(arrayOfAddress);
  }

  /**
   * Return list of existing Servers
   * @return - List<Server>
   */
  public List<Server> getListOfServers() {
    return listOfServers;
  }

  /**
   * Add servers from string array
   * @param arrayOfAddress - array with addresses
   */
  private void addServersFromStringArray(String[] arrayOfAddress) {
    for (String serverAddress: arrayOfAddress) {
      try {
        listOfServers.add(new Server(serverAddress));
      } catch (Server.WrongInputException ignored) {}
    }
  }

  /**
   * Add servers from dictionary
   * @param dictionaryOfServersFileName - name of dictionary file
   * @throws DictionaryFileDidntFoundException - whether dictionary didn't found
   */
  private void addServersFromDictionaryFile (String dictionaryOfServersFileName)
      throws DictionaryFileDidntFoundException {
    File fileI = new File(dictionaryOfServersFileName);
    try {
      try (BufferedReader in = new BufferedReader(new FileReader(fileI.getAbsoluteFile()))) {
        String[] addresses;
        while (in.ready()) {
          addresses = in.readLine().split(REGEX_VALUE_FOR_SPLIT);
          for (String serverAddress: addresses) {
            try {
              listOfServers.add(new Server(serverAddress));
            } catch (Server.WrongInputException ignored) {}
          }
        }
      }
    } catch(IOException e) {
      throw new DictionaryFileDidntFoundException();
    }
  }

  /**
   * Throws whether dictionary didn't found
   */
  public class DictionaryFileDidntFoundException extends Exception {}
}
