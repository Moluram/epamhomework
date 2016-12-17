package com.moluram.task4;

import java.math.BigDecimal;
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
      BigDecimal a = new BigDecimal(args[0]);
      BigDecimal b = new BigDecimal(args[1]);
      BigDecimal c = new BigDecimal(args[2]);
      for (BigDecimal value : solveEquation(a,b,c)) {
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
  private static ArrayList<BigDecimal> solveEquation(BigDecimal a, BigDecimal b, BigDecimal c) throws
          DoesNotHaveRealRoots{
    BigDecimal D = b.pow(2).subtract(a.multiply(new BigDecimal("4")).multiply(c));
    BigDecimal x1;
    BigDecimal x2;
    if(D.doubleValue() < 0){
      throw  new DoesNotHaveRealRoots();
    } else {
      x1 =  b.negate()
              .add(BigDecimalSqrt.bigSqrt(D))
              .divide(a.multiply(new BigDecimal("2")), 15, BigDecimal.ROUND_HALF_UP);
      x2 = b.negate()
              .subtract(BigDecimalSqrt.bigSqrt(D))
              .divide(a.multiply(new BigDecimal("2")), 15, BigDecimal.ROUND_HALF_UP);
    }
    ArrayList<BigDecimal> list = new ArrayList<>();
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
