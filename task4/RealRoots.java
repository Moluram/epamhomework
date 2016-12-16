package com.moluram.task4;

import java.util.ArrayList;

/**
 * Class serve for calculating roots from equation
 * @author Moluram
 * @version 1.0
 */
public class RealRoots {
   /**
   * Takes 3 parameters as arguments from command line and calls for roots of the equation
   * @param args - arguments from command line
   */
  public static void main(String[] args) {
    try {
      double a = parseDoubleWithDefault(args[0], 0);
      double b = parseDoubleWithDefault(args[1], 0);
      double c = parseDoubleWithDefault(args[2], 0);
      for (Double value : solveEquation(a,b,c)) {
        print(value.toString());
      }
    } catch (ArrayIndexOutOfBoundsException e){
      print("You must enter 3 parameters of the equation as arguments of the command line");
    } catch (NumberFormatException e){
      print("The number must consist only of digits");
    } catch (DoesNotHaveRealRoots e){
      print("Equation doesn't have real roots");
    }
  }

  /**
   * Gets real roots from the equation :
   * a*x^2 + b*x + c = 0
   * Returns array of roots
   * @param a - parameter for equation
   * @param b - parameter for equation
   * @param c - parameter for equation
   * @return ArrayList
   * @throws DoesNotHaveRealRoots if equation does not have real roots
   */
  private static ArrayList<Double> solveEquation(double a, double b, double c) throws
          DoesNotHaveRealRoots{
    double D = b*b - 4 * a * c;
    double x1;
    double x2;
    if(D < 0){
      throw  new DoesNotHaveRealRoots();
    } else {
      x1 = ((-1 * b) + Math.sqrt(D)) / (2 * a);
      x2 = ((-1 * b) - Math.sqrt(D)) / (2 * a);
    }
    ArrayList<Double> list = new ArrayList<>();
    list.add(x1);
    list.add(x2);
    return list;
  }

  /**
   * Return Double equivalent of the given line.
   * @param value - number in string form
   * @param def - default value comes into if exception will be thrown
   * @return Double
   */
  private static Double parseDoubleWithDefault(String value, double def) {
    try {
      return Double.parseDouble(value);
    } catch (NumberFormatException e) {
      return def;
    }
  }

  /**
   * Prints to the console value
   * @param value - printed value
   */
  private static void print(String value){
    System.out.println(value);
  }

  /**
   * Throws when equation doesn't have real roots
   */
  private static class DoesNotHaveRealRoots extends Exception{}
}
