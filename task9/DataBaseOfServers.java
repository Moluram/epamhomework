package com.moluram.task9;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Created by Moluram on 02.01.2017.
 */
public class DataBaseOfServers {
  private final List<Server> listOfServers = new LinkedList<>();

  public DataBaseOfServers (String nameOfTheDictionaryFileOfServers)
      throws DictionaryFileDidntFoundException {
    addServersFromDictionaryFile(nameOfTheDictionaryFileOfServers);
  }

  public DataBaseOfServers (String[] arrayOfAddress) {
    addServersFromStringArray(arrayOfAddress);
  }

  public DataBaseOfServers (String[] arrayOfAddress, String nameOfTheDictionaryFileOfServers)
      throws DictionaryFileDidntFoundException {
    addServersFromDictionaryFile(nameOfTheDictionaryFileOfServers);
    addServersFromStringArray(arrayOfAddress);
  }

  public List<Server> getListOfServers() {
    return listOfServers;
  }

  private void addServersFromStringArray(String[] arrayOfAddress) {
    for (String serverAddress: arrayOfAddress) {
      try {
        listOfServers.add(new Server(serverAddress));
      } catch (Server.WrongInputException ignored) {}
    }
  }

  private void addServersFromDictionaryFile (String dictionaryOfServersFileName)
      throws DictionaryFileDidntFoundException {
    File fileI = new File(dictionaryOfServersFileName);
    try {
      try (BufferedReader in = new BufferedReader(new FileReader(fileI.getAbsoluteFile()))) {
        String[] addresses;
        while (in.ready()) {
          addresses = in.readLine().split(" ");
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

  public class DictionaryFileDidntFoundException extends Exception {}
}
