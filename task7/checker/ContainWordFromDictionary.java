package com.moluram.task7.checker;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Class serves for determine is sent line contain word from dictionary
 * @author Moluram
 * @version 1.0
 */
class ContainWordFromDictionary implements Checker{
  /**
   * Contain all dictionary words
   */
  private List<String> dictionary = new LinkedList<>();

  /**
   * Initializes dictionary list from file
   */
  ContainWordFromDictionary() {
    String inputFile = "src/com/moluram/task7/dictionary.txt";
    File fileI = new File(inputFile);
    try {
      try (BufferedReader in = new BufferedReader(new FileReader(fileI.getAbsoluteFile()))) {
        String[] words;
        while (in.ready()) {
          words = in.readLine().split(" ");
          Collections.addAll(dictionary, words);
        }
      }
    } catch(IOException e) {
      System.out.println("Dictionary file didn't found");
    }
  }

  public boolean check(String line) {
    String[] words = line.split(" ");
    for (String word: words) {
        if (word.length() != 0 && checkWordInDictionary(word)) {
          return true;
        }
    }
    return false;
  }

  private boolean checkWordInDictionary(String fakeWord) {
    for (String word: dictionary) {
      if (fakeWord.equals(word)) {
        return true;
      }
    }
    return false;
  }
}
