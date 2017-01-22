package com.moluram.task11.TestTransport;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Exports string value
 */
public class Printer {
  /**
   * Prints String value to the file
   * @param value - printed value
   * @param nameOfFileToPrint - where to print
   */
  public void printInFile(String value, String nameOfFileToPrint) {
    File file = new File(nameOfFileToPrint);
    try {
      if(!file.exists()){
        file.createNewFile();
      }
      try (PrintWriter out = new PrintWriter(file.getAbsoluteFile())) {
        out.print(value);
      }
    } catch(IOException e) {
      throw new RuntimeException(e);
    }
  }
}
