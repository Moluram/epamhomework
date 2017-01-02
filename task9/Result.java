package com.moluram.task9;

/**
 * Created by Moluram on 02.01.2017.
 */
public class Result {
  private final Server server;
  private final int response;

  public Server getServerAddress() {
    return server;
  }

  public int getResponse() {
    return response;
  }

  public Result (Server server, int response) {
    this.server = server;
    this.response = response;

  }
}
