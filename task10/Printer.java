package com.moluram.task10;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Moluram on 03.01.2017.
 */
public class Printer {
  public void printInFile(String resultsInHtmlTableForm, String nameOfFileToPrint) {
    File file = new File(nameOfFileToPrint);
    try {
      if(!file.exists()){
        file.createNewFile();
      }
      try (PrintWriter out = new PrintWriter(file.getAbsoluteFile())) {
        out.print(resultsInHtmlTableForm);
      }
    } catch(IOException e) {
      throw new RuntimeException(e);
    }
  }
}
