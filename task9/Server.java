package com.moluram.task9;

import java.math.BigInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class represents an objects of servers
 */
public class Server {
  private static final String REGEX_VALUE_FOR_TESTING_LINE = "[^0-9&&[^.]]";
  private static final String REGEX_VALUE_FOR_SPLITTING_LINE = "\\.";
  private static final int NUMBER_OF_WORDS_IN_IP_ADDRESS = 4;
  private static final int BIG_INTEGER_COMPARE_VALUE_FOR_LESS = -1;
  private static final String MAX_VALUE_FOR_PART_OF_IPV4_ADDRESS = "256";
  private static final BigInteger BIG_INTEGER_VALUE_FOR_COMPARE = new BigInteger(MAX_VALUE_FOR_PART_OF_IPV4_ADDRESS);

  /**
   * Ip address of the server
   */
  private final String address;

  /**
   * Constructor create new Server object with receiving address.
   * Tests receiving addresses and throws an exception if address incorrect
   * @param address - address of the server
   * @throws WrongInputException - throws when address is incorrect
   */
  public Server (String address) throws WrongInputException {
    if (isAddressCorrect(address)) {
      this.address = address;
    } else {
      throw new WrongInputException();
    }
  }

  /**
   * Test IPv4 addresses for correctness
   * @param address - address for check
   * @return - boolean - answer whether the address is correct
   */
  private boolean isAddressCorrect(String address) {
    Pattern p = Pattern.compile(REGEX_VALUE_FOR_TESTING_LINE);
    Matcher m = p.matcher(address);
    if (!m.find()) {
      String[] addressParts = address.split(REGEX_VALUE_FOR_SPLITTING_LINE);
      if (addressParts.length == NUMBER_OF_WORDS_IN_IP_ADDRESS) {
        for (String addressPart: addressParts) {
          if (new BigInteger(addressPart)
              .compareTo(BIG_INTEGER_VALUE_FOR_COMPARE) != BIG_INTEGER_COMPARE_VALUE_FOR_LESS) {
            return false;
          }
        }
        return true;
      }
    }
    return false;
  }

  /**
   * Returns IPv4 Address
   * @return - String - address
   */
  public String getFullAddress () {
    return address;
  }

  /**
   * Throws whether the IPv4 address is incorrect
   */
  public class WrongInputException extends Exception {}
}
