package com.moluram.task7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Moluram on 16.12.2016.
 */
public final class ContainWordFromDictionary {
  private static List<String> dictionary = new LinkedList<>();
  static {
    String inputFile = "dictionary.txt";
    File fileI = new File(inputFile);
    try {
      BufferedReader in = new BufferedReader(new FileReader( fileI.getAbsoluteFile()));
      try {
        String[] words;
        while (in.ready()){
          words = in.readLine().split(" ");
          for (String word: words) {
            dictionary.add(word);
          }
        }
      } finally {
        in.close();
      }
    } catch(IOException e) {
    }
  }
  public static boolean check(String line) {
    String[] words = line.split(" ");
    for (String word: words) {
        if(word.length()!=0 && checkWordInDictionary(word)){
          return true;
        }
    }
    return false;
  }

  private static boolean checkWordInDictionary(String fakeWord){
    for (String word: dictionary) {
      if(fakeWord.equals(word)){
        return true;
      }
    }
    return false;
  }
}
