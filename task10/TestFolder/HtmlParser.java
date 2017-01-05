package com.moluram.task10.TestFolder;

import java.util.List;

/**
 * Class serve to parse given string in html format
 */
public class HtmlParser {
  private static final String HTML_START_OF_PAGE =
      "<html xmlns=\"http://www.w3.org/1999/xhtml\">\n" +
          "<head>\n" +
          "  <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n" +
          "  <style type=\"text/css\">\n" +
          "   .layout {\n" +
          "    width: 100%;\n" +
          "   }\n" +
          "   TD {\n" +
          "    vertical-align: top;\n" +
          "       text-align: center;\n" +
          "       font: bold 16px arial,sans-serif;\n" +
          "    height: 34px;\n" +
          "    border-top: 2px solid rgb(255, 255, 255);\n" +
          "    border-left: 2px solid rgb(255, 255, 255);\n" +
          "    border-right: 2px solid rgb(255, 255, 255);" +
          "    padding: 5px;width: 626px;" +
          "   }\n" +
          "   TD.topcol {\n" +
          "    width: 200px;\n" +
          "    background-color: rgb(153, 153, 153);\n" +
          "   }\n" +
          "   TD.colRed {\n" +
          "    width: 200px;\n" +
          "    background-color: rgb(255, 0, 0);\n" +
          "   }\n" +
          "   TD.col {\n" +
          "    width: 200px;\n" +
          "    background-color: rgb(239, 239, 239);\n" +
          "   }\n" +
          "  </style>\n" +
          " </head>" +
          " <body>\n" +
          "  <table width=\"50%\" cellspacing=\"0\" cellpadding=\"5\">\n";

  private static final String HTML_LINE_START = "<tr>\n";

  private static final String HTML_COL_START = "<td class=\"col\">\n";

  private static final String HTML_COL_END = "</td>\n";

  private static final String HTML_LINE_END = "</tr>\n";

  private static final String HTML_TOP_LINE = "<tr>\n" +
      "    <td class=\"topcol\">Name</td>\n" +
      "    <td class=\"topcol\">Type</td>\n" +
      "    <td class=\"topcol\">Date of creation</td>\n" +
      "    <td class=\"topcol\">Size, Kb</td>\n" +
      "   </tr>\n" ;

  private static final String HTML_END_OF_PAGE = "</table>\n" +
      " </body>\n" +
      "</html>\n";

  private static final String HTML_COL_RED_START = "<td class=\"colRed\">\n";

  /**
   * Parsing given results in table html format
   * @param listOfResults - results to parse
   * @return - return Html page in String
   */
  public String getResultsInHtmlTableForm(List<Result> listOfResults) {
    String resultOfParse = HTML_START_OF_PAGE + HTML_TOP_LINE;
    for (Result result: listOfResults) {
      resultOfParse += createLine(HTML_COL_START , result.getName(), result.getType(), result.getDateOfCreation(),
            result.getSizeInKb().toString(), HTML_COL_END);
    }
    return resultOfParse + HTML_END_OF_PAGE;
  }

  /**
   * Create a line with 2 columns with given Strings
   * @param start - html start of the line
   * @param textFirstColumn - text in first column
   * @param textSecondColumn - text in second column
   * @param textThirdColumn - text in third column
   * @param textFourthColumn - text in fourth column
   * @param end - html end of the line
   * @return - line for html table
   */
  private String createLine (String start, String textFirstColumn, String textSecondColumn,
                             String textThirdColumn, String textFourthColumn, String end) {
    return HTML_LINE_START +
        start +
        textFirstColumn +
        end +
        start +
        textSecondColumn +
        end +
        start +
        textThirdColumn +
        end +
        start +
        textFourthColumn +
        end +
        HTML_LINE_END;
  }
}
