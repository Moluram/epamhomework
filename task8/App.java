package com.moluram.task8;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Class representing layer between database and UI
 */
public class App {
  private static final String DEFAULT_VALUE_FOR_BIG_DECIMAL = "0";
  private static final String SUCCESS_MESSAGE = "Success";
  private static final String UNSUCCESS_MESSAGE = "Unsuccess. Number format exception";

  /**
   * Represent database
   */
  private final DataBaseOfProducts dataBase = new DataBaseOfProducts();

  /**
   * Function which adds a new product to the database
   * @param type - type of the product
   * @param name - name of the product
   * @param amount - amount of the products
   * @param costPerUnit - cost per unit for product
   */
  public String addProduct(String type, String name, String amount, String costPerUnit) {
    try {
      dataBase.addProduct(new Product(type, name, new BigDecimal(amount), new BigDecimal(costPerUnit)));
      return SUCCESS_MESSAGE;
    } catch (NumberFormatException e) {
      return UNSUCCESS_MESSAGE;
    }
  }

  /**
   * Returns amount of the types in database
   * @return - amount of types
   */
  public int getAmountOfTypes() {
    List<String> listOfTypes = new LinkedList<>();
    List<Product> productList = dataBase.getListOfProducts();
    productList.stream().filter(product -> !listOfTypes.contains(product.getType()))
        .forEach(product -> {
          listOfTypes.add(product.getType());
        });
    return listOfTypes.size();
  }

  /**
   * Returns amount of the products of all the types
   * @return - amount of the products
   */
  public BigDecimal getAmountOfProducts() {
    BigDecimal amount = new BigDecimal(DEFAULT_VALUE_FOR_BIG_DECIMAL);
    for (Product product: dataBase.getListOfProducts()) {
      amount = amount.add(product.getAmount());
    }
    return amount;
  }

  /**
   * Returns average price of the all products in the database
   * @return - average price
   */
  public BigDecimal getAveragePriceOfProducts() {
    BigDecimal averageValue = new BigDecimal(DEFAULT_VALUE_FOR_BIG_DECIMAL);
    BigDecimal counter = new BigDecimal(DEFAULT_VALUE_FOR_BIG_DECIMAL);
    for (Product product : dataBase.getListOfProducts()) {
      averageValue = averageValue.add(product.getCostPerUnit().multiply(product.getAmount()));
      counter = counter.add(product.getAmount());
    }
    return averageValue.divide(counter, 150, BigDecimal.ROUND_HALF_UP);
  }

  /**
   * Returns average price of the products particular type in the database
   * @param type - selected type
   * @return - average price
   */
  public BigDecimal getAveragePriceOfType(String type) {
    BigDecimal averageValue = new BigDecimal(DEFAULT_VALUE_FOR_BIG_DECIMAL);
    BigDecimal counter = new BigDecimal(DEFAULT_VALUE_FOR_BIG_DECIMAL);
    for (Product product : dataBase.getListOfProducts()) {
      if (product.getType().equals(type)){
        averageValue = averageValue.add(product.getCostPerUnit());
        counter = counter.add(product.getAmount());
      }
    }
    return averageValue.divide(counter, 150, BigDecimal.ROUND_HALF_UP);
  }
}
