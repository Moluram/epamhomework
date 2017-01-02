package com.moluram.task8;

import java.math.BigDecimal;

/**
 * Class represent a product for application
 */
public class Product {
  private String type;
  private String name;
  private BigDecimal amount;
  private BigDecimal costPerUnit;

  /**
   * Minimal constructor for class Product. Accepts all needed parameters for the Product object
   * @param type - type of the product
   * @param name - name of the product
   * @param amount - amount of the products
   * @param costPerUnit - cost per unit for product
   */
  public Product(String type, String name, BigDecimal amount, BigDecimal costPerUnit) {
    this.type = type;
    this.name = name;
    this.amount = amount;
    this.costPerUnit = costPerUnit;
  }

  /**
   * Getters and setters
   */
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  public BigDecimal getCostPerUnit() {
    return costPerUnit;
  }

  public void setCostPerUnit(BigDecimal costPerUnit) {
    this.costPerUnit = costPerUnit;
  }
}
