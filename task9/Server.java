package com.moluram.task9;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Moluram on 02.01.2017.
 */
public class Server {
  private String address;
  private BigInteger compareValue = new BigInteger("256");

  public Server (String address) throws WrongInputException {
    if (isAddressCorrect(address)) {
      this.address = address;
    } else {
      throw new WrongInputException();
    }
  }

  private boolean isAddressCorrect(String address) {
    String pattern = "[^0-9&&[^.]]";
    Pattern p = Pattern.compile(pattern);
    Matcher m = p.matcher(address);
    if (!m.find()) {
      String[] addressParts = address.split(".");
      if (addressParts.length == 4) {
        for (String addressPart: addressParts) {
          if (new BigInteger(addressPart).compareTo(compareValue) != -1) {
            return false;
          }
        }
        return true;
      }
    }
    return false;
  }

  public String getFullAddress () {
    return address;
  }

  public class WrongInputException extends Exception {}
}
