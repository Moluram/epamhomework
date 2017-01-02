package com.moluram.task9;

/**
 * Class represents an objects of results
 */
public class Result {
  /**
   * Test server
   */
  private final Server server;

  /**
   * Result of test
   */
  private final int response;

  /**
   * Return ip address of the server
   * @return - String - address
   */
  public String getServerAddress() {
    return server.getFullAddress();
  }

  /**
   * Return result of test
   * @return - int - response
   */
  public int getResponse() {
    return response;
  }

  /**
   * Constructor for a result
   * @param server - Test server
   * @param response - Result of test
   */
  public Result (Server server, int response) {
    this.server = server;
    this.response = response;
  }
}
