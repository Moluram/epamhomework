package com.moluram.task4;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;

/**
 * Class serve for calculation square root from BigDecimal number
 * @author Moluram
 * @version 1.0
 */
class BigDecimalSqrt extends BigDecimal {
  private static final BigDecimal SQRT_DIG = new BigDecimal(150);
  private static final BigDecimal SQRT_PRE = new BigDecimal(10).pow(SQRT_DIG.intValue());

  /**
   * Create new BigDecimalSqrt from existing BigDecimal
   * @param value - value to copy
   */
  public BigDecimalSqrt(BigDecimal value) {
    super(value.toString());
  }

  /**
   * Uses Newton Raphson to compute the square root of a BigDecimal.
   * @author Luciano Culacciatti
   * @url http://www.codeproject.com/Tips/257031/Implementing-SqrtRoot-in-BigDecimal
   */
  public BigDecimal sqrtValue() {
    return sqrtNewtonRaphson(this ,new BigDecimal(1),new BigDecimal(1).divide(SQRT_PRE));
  }

  /**
   * Private utility method used to compute the square root of a BigDecimal.
   * @param c - value for evolution
   * @author Luciano Culacciatti
   * @url http://www.codeproject.com/Tips/257031/Implementing-SqrtRoot-in-BigDecimal
   */
  private static BigDecimal sqrtNewtonRaphson  (BigDecimal c, BigDecimal xn, BigDecimal precision) {
    BigDecimal fx = xn.pow(2).add(c.negate());
    BigDecimal fpx = xn.multiply(new BigDecimal(2));
    BigDecimal xn1 = fx.divide(fpx, 2 * SQRT_DIG.intValue(), BigDecimal.ROUND_HALF_DOWN);
    xn1 = xn.add(xn1.negate());
    BigDecimal currentSquare = xn1.pow(2);
    BigDecimal currentPrecision = currentSquare.subtract(c);
    currentPrecision = currentPrecision.abs();
    if (currentPrecision.compareTo(precision) <= -1) {
      return xn1;
    }
    return sqrtNewtonRaphson(c, xn1, precision);
  }

  /**
   * Constructors from super
   */
  public BigDecimalSqrt(char[] in, int offset, int len) {
    super(in, offset, len);
  }

  public BigDecimalSqrt(char[] in, int offset, int len, MathContext mc) {
    super(in, offset, len, mc);
  }

  public BigDecimalSqrt(char[] in) {
    super(in);
  }

  public BigDecimalSqrt(char[] in, MathContext mc) {
    super(in, mc);
  }

  public BigDecimalSqrt(String val) {
    super(val);
  }

  public BigDecimalSqrt(String val, MathContext mc) {
    super(val, mc);
  }

  public BigDecimalSqrt(double val) {
    super(val);
  }

  public BigDecimalSqrt(double val, MathContext mc) {
    super(val, mc);
  }

  public BigDecimalSqrt(BigInteger val) {
    super(val);
  }

  public BigDecimalSqrt(BigInteger val, MathContext mc) {
    super(val, mc);
  }

  public BigDecimalSqrt(BigInteger unscaledVal, int scale) {
    super(unscaledVal, scale);
  }

  public BigDecimalSqrt(BigInteger unscaledVal, int scale, MathContext mc) {
    super(unscaledVal, scale, mc);
  }

  public BigDecimalSqrt(int val) {
    super(val);
  }

  public BigDecimalSqrt(int val, MathContext mc) {
    super(val, mc);
  }

  public BigDecimalSqrt(long val) {
    super(val);
  }

  public BigDecimalSqrt(long val, MathContext mc) {
    super(val, mc);
  }

}
