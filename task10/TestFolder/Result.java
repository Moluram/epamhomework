package com.moluram.task10.TestFolder;

/**
 * Class represent an object of result of test
 */
class Result {
  private static final Long NUMBER_OF_BYTES_IN_KB = 1024L;
  private final String name;
  private final String type;
  private final String dateOfCreation;
  private final Long size;

  /**
   * Creates a final object of Result
   * @param name - name of the file/folder
   * @param type - type of the file
   * @param dateOfCreation - file date of creation
   * @param size - size of the file
   */
  Result(String name, String type, String dateOfCreation, Long size) {
    this.name = name;
    this.type = type;
    this.dateOfCreation = dateOfCreation;
    this.size = size;
  }

  /**
   * Returns size in Kb
   * @return - Long
   */
  Long getSizeInKb() {
    return size / NUMBER_OF_BYTES_IN_KB;
  }

  String getName() {
    return name;
  }

  String getType() {
    return type;
  }

  String getDateOfCreation() {
    return dateOfCreation;
  }
}
