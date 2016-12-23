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
   * Scale of the quotient to be returned after dividing.
   */
  private static final int SCALE = 150;

  /**
   * Used for calculating D:
   *           ' - our number
   * D = B^2 - 4 * a * c;
   */
  private static String PARAM_FOR_CALCULATING_D = "4";

  /**
   * Used for calculating roots:
   *                            ' - our number
   * x = (-b -+ D^(1/2)) / (a * 2)
   */
  private static String PARAM_FOR_CALCULATING_X = "2";

  /**
   * Takes 3 parameters as arguments from command line and calls for roots of the equation
   * @param args - arguments from command line
   */
  public static void main(String[] args) {
    try {
      BigDecimal a = new BigDecimal(args[0]);
      BigDecimal b = new BigDecimal(args[1]);
      BigDecimal c = new BigDecimal(args[2]);
      int counter = 1;
      RealRoots realRoots = new RealRoots();
      for (BigDecimal value : realRoots.solveEquation(a, b, c)) {
        System.out.println("x" + counter++ + " : " + value.toString());
      }
    } catch (DoesNotHaveRealRoots e) {
      System.out.println("Equation doesn't have real roots");
    } catch (ArrayIndexOutOfBoundsException e) {
      System.out.println("You must enter 3 parameters of the equation as arguments of the command line");
    } catch (NumberFormatException e) {
      System.out.println("The number must consist only of digits");
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
  private ArrayList<BigDecimal> solveEquation(BigDecimal a, BigDecimal b, BigDecimal c)
          throws DoesNotHaveRealRoots {
    BigDecimalSqrt D = new BigDecimalSqrt(
            b.pow(2).subtract(a.multiply(new BigDecimal(PARAM_FOR_CALCULATING_D)).multiply(c)));
    BigDecimal x1;
    BigDecimal x2;
    if (D.doubleValue() < 0) {
      throw  new DoesNotHaveRealRoots();
    }
    x1 =  b.negate()
            .add(D.sqrtValue())
            .divide(a.multiply(new BigDecimal(PARAM_FOR_CALCULATING_X)),
                                SCALE, BigDecimal.ROUND_HALF_UP);
    x2 = b.negate()
            .subtract(D.sqrtValue())
            .divide(a.multiply(new BigDecimal(PARAM_FOR_CALCULATING_X)),
                                SCALE, BigDecimal.ROUND_HALF_UP);
    ArrayList<BigDecimal> list = new ArrayList<>();
    list.add(x1);
    list.add(x2);
    return list;
  }

  /**
   * Throws when equation doesn't have real roots
   */
  private static class DoesNotHaveRealRoots extends Exception {}
}
