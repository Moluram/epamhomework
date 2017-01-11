package com.moluram.task11;

import com.moluram.task11.TestTransport.HtmlParser;
import com.moluram.task11.TestTransport.Printer;
import com.moluram.task11.TestTransport.Route;
import com.moluram.task11.TestTransport.TransportTest;
import com.moluram.task11.Transports.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Moluram on 05.01.2017.
 */
public class Main {
  private static final Long AUTOMOBILE_NUMBER_OF_SEATS = 4L;
  private static final Long AUTOMOBILE_CONSUMPTION = 15L;
  private static final Long AUTOMOBILE_VELOCITY = 100L;

  private static final Long BIKE_VELOCITY = 30L;
  private static final Long BIKE_CONSUMPTION = 5L;

  private static final Long BUS_NUMBER_OF_SEATS = 100L;
  private static final Long BUS_CONSUMPTION = 20L;
  private static final Long BUS_VELOCITY = 40L;

  private static final Long PEDESTRIAN_CONSUMPTION = 2L;
  private static final Long PEDESTRIAN_VELOCITY = 5L;

  private static final String NAME_OF_DICTIONARY_FILE = "checkpoints.txt";
  private static final String NAME_OF_FILE_WHERE_TO_PRINT = "result.html";

  public static void main(String[] args) {
    Route routeForTest = new Route(NAME_OF_DICTIONARY_FILE);
    TransportTest transportTest = new TransportTest(routeForTest);
    transportTest.startTestOnTransports(getListOfTestingTransports());
    HtmlParser htmlParser = new HtmlParser();
    Printer printer = new Printer();
    printer.printInFile(htmlParser.getResultsInHtmlTableForm(transportTest.getResults()), NAME_OF_FILE_WHERE_TO_PRINT);
  }

  private static List<Transport> getListOfTestingTransports() {
    List<Transport> list = new ArrayList<>();
    list.add(new Automobile(AUTOMOBILE_VELOCITY, AUTOMOBILE_CONSUMPTION, AUTOMOBILE_NUMBER_OF_SEATS));
    list.add(new Bike(BIKE_VELOCITY, BIKE_CONSUMPTION));
    list.add(new Bus(BUS_VELOCITY, BUS_CONSUMPTION, BUS_NUMBER_OF_SEATS));
    list.add(new Pedestrian(PEDESTRIAN_VELOCITY, PEDESTRIAN_CONSUMPTION));
    return list;
  }
}
