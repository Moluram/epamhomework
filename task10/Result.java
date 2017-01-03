package com.moluram.task10;

/**
 * Created by Moluram on 03.01.2017.
 */
public class Result {
  private static final Long NUMBER_OF_BYTES_IN_KB = 1024L;
  private final String name;
  private final String type;
  private final String dateOfCreation;
  private final Long size;

  public Result(String name, String type, String dateOfCreation, Long size) {
    this.name = name;
    this.type = type;
    this.dateOfCreation = dateOfCreation;
    this.size = size;
  }

  public String getName() {
    return name;
  }

  public String getType() {
    return type;
  }

  public String getDateOfCreation() {
    return dateOfCreation;
  }

  public Long getSizeInKb() {
    return size / NUMBER_OF_BYTES_IN_KB;
  }
}
