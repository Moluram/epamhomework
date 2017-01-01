package com.moluram.task8;

import java.util.ArrayList;
import java.util.List;

/**
 * Class serve for emulating work of the database
 */
public class DataBaseOfProducts {
  /**
   * Contain all existing products
   */
  private List<Product> listOfProducts = new ArrayList<>();

  /**
   * Adds product to the database
   * @param product - adding product
   */
  public void addProduct(Product product){
      listOfProducts.add(product);
  }

  /**
   * Returns list of all existing products
   * @return - list of products
   */
  public List<Product> getListOfProducts() {
    return listOfProducts;
  }
}
