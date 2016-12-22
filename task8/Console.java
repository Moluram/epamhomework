package com.moluram.task8;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Moluram on 22.12.2016.
 */
public class Console {
  private List<Product> listOfProducts = new ArrayList<>();

  void start() {
    String[] line = {""};
    while (!line[0].equals("exit")) {
      switch (line[0]) {
        case "add":
          listOfProducts.add(new Product(line[1], line[2], line[3], line[4]));
          break;

        case "count":
          switch (line[1]) {
            case "types":
              printCountOfTypes();
              break;

            case "all":
              printCountOfAllProducts();
              break;
          }
          break;

        case "average":
          if (line[1].equals("price")) {
            if(line.length>=3){
              printAveragePriceOfType(line[3]);
            }else {
              printAveragePriceOfProducts();
            }
          }
          break;

        default:
          line = new Scanner(System.in).nextLine().split(" ");
      }
    }
  }

  private void printCountOfTypes() {
    List<String> listOfTypes = new LinkedList<>();
    listOfProducts.stream().filter(product -> !listOfTypes.contains(product.getType()))
            .forEach(product -> {
      listOfTypes.add(product.getType());
    });
    System.out.println("Count of types: " + listOfTypes.size());
  }

  private void printCountOfAllProducts() {
    System.out.println("Count of all products: " + listOfProducts.size());
  }

  private void printAveragePriceOfType(String type) {
    BigDecimal averageValue = new BigDecimal("0");
    int counter = 0;
    for (Product product : listOfProducts) {
      if (product.getType().equals(type)){
        averageValue = averageValue.add(new BigDecimal(product.getCostPerUnit()));
        counter++;
      }
    }
    System.out.println(
            averageValue.divide(new BigDecimal(counter), 150, BigDecimal.ROUND_HALF_UP));
  }

  private void printAveragePriceOfProducts() {
    BigDecimal averageValue = new BigDecimal("0");
    int counter = 0;
    for (Product product : listOfProducts) {
      averageValue = averageValue.add(new BigDecimal(product.getCostPerUnit()));
      counter++;
    }
    System.out.println(
            averageValue.divide(new BigDecimal(counter), 150, BigDecimal.ROUND_HALF_UP));
  }
}
