package com.moluram.task9;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Moluram on 02.01.2017.
 */
public class Interviewer {
  private final DataBaseOfServers dataBaseOfServers;
  private List<Result> listOfResults = new ArrayList<>();

  public Interviewer(DataBaseOfServers dataBaseOfServers) {
    this.dataBaseOfServers = dataBaseOfServers;
  }

  public void getResultsInHtmlFormFile(String nameOfFileToCreate) {
  }

  public void interviewServers() {
    Random rnd = new Random();
    for (Server server: dataBaseOfServers.getListOfServers()) {
      listOfResults.add(new Result(server, rnd.nextInt()));
    }
  }
}
