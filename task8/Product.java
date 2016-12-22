package com.moluram.task8;

import java.math.BigInteger;

/**
 * Created by Moluram on 22.12.2016.
 */
public class Product {
  private String type;
  private String name;
  private BigInteger amount;
  private BigInteger costPerUnit;

  public Product(String type, String name, String amount, String costPerUnit) {
    this.type = type;
    this.name = name;
    this.amount = new BigInteger(amount);
    this.costPerUnit = new BigInteger(costPerUnit);
  }

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

  public BigInteger getAmount() {
    return amount;
  }

  public void setAmount(BigInteger amount) {
    this.amount = amount;
  }

  public BigInteger getCostPerUnit() {
    return costPerUnit;
  }

  public void setCostPerUnit(BigInteger costPerUnit) {
    this.costPerUnit = costPerUnit;
  }
}
