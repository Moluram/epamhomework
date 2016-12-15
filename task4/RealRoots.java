package com.moluram.task4;

import java.util.ArrayList;

/**
 * Class serve for calculating roots from equation
 * @author Moluram
 * @version 1.0
 */
public class RealRoots {
   /**
   * Takes 3 parameters from command line and calls for roots of the equation
   * @param args - attributes from command line
   */
  public static void main(String[] args) {
    try {
      int a = Integer.parseInt(args[0]);
      int b = Integer.parseInt(args[1]);
      int c = Integer.parseInt(args[2]);
      for (Double value : solveEquation(a,b,c)) {
        print(value.toString());
      }
    }catch (ArrayIndexOutOfBoundsException e){
      print("*.class <a> <b> <c>");
    }catch (NumberFormatException e){
      print("The number must consist only of digits");
    }catch (DoesNotHaveRealRoots e){
      print("Equation doesn't have real roots");
    }
  }

  /**
   * Gets real roots from the equation :
   * a*x^2 + b*x + c = 0
   * @param a - attribute for equation
   * @param b - attribute for equation
   * @param c - attribute for equation
   * @return array of roots
   * @throws DoesNotHaveRealRoots
   */
  private static ArrayList<Double> solveEquation(int a, int b, int c) throws DoesNotHaveRealRoots{
    double D = b*b - 4 * a * c;
    double x1;
    double x2;
    if(D < 0){
      throw  new DoesNotHaveRealRoots();
    } else {
      x1 = ((-1 * b) + Math.sqrt(D)) / (2 * a);
      x2 = ((-1 * b) - Math.sqrt(D)) / (2 * a);
    }
    ArrayList<Double> list = new ArrayList<Double>();
    list.add(x1);
    list.add(x2);
    return list;
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
