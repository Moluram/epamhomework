package com.moluram.task4;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * Class serve for calculation square root from BigDecimal number
 * @author Moluram
 * @version 1.0
 */
class BigDecimalSqrt extends BigDecimal {
  /**
   * Specifies the accuracy of calculations.
   */
  private static final BigDecimal SQRT_DIG = new BigDecimal(150);
  private static final BigDecimal SQRT_PRECISION = new BigDecimal(10).pow(SQRT_DIG.intValue());

  private static int BIG_DECIMAL_COMPARE_VALUE_FOR_LESS = -1;
  private static BigDecimal BIG_DECIMAL_FOR_DIVISION = new BigDecimal("2");

  public BigDecimalSqrt(BigDecimal decimal) {
    super(decimal.byteValue());
  }

  /**
   * Uses Newton Raphson to compute the square root of a BigDecimal.
   */
  public BigDecimal sqrtValue() {
    return sqrtNewtonRaphson(this, new BigDecimal(1).divide(SQRT_PRECISION));
  }

  /**
   * Private utility method used to compute the square root of a BigDecimal.
   * @param n - value for evolution
   * @param precision - the accuracy of calculations
   * @author Moluram
   */
  private BigDecimal sqrtNewtonRaphson  (BigDecimal n, BigDecimal precision) {
    BigDecimal x = new BigDecimal("1");
    BigDecimal xn = x.add(n.divide(x , SQRT_DIG.intValue(), BigDecimal.ROUND_HALF_UP))
            .divide(BIG_DECIMAL_FOR_DIVISION , SQRT_DIG.intValue(), BigDecimal.ROUND_HALF_UP);
    while(x.add(xn.negate()).abs().compareTo(precision) != BIG_DECIMAL_COMPARE_VALUE_FOR_LESS) {
      x = xn;
      xn = x.add(n.divide(x, SQRT_DIG.intValue(), BigDecimal.ROUND_HALF_UP))
              .divide(BIG_DECIMAL_FOR_DIVISION, SQRT_DIG.intValue(), BigDecimal.ROUND_HALF_UP);
    }
    return x;
  }
}
