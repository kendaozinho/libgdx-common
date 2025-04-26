package com.kendao.libgdx.util;

import java.math.BigDecimal;
import java.util.concurrent.ThreadLocalRandom;

public final class CustomNumberUtil {
  private CustomNumberUtil() {
  }

  /***
   * Generate random Integer between min and max (inclusive)
   */
  public static Integer getRandomValue(Integer min, Integer max) {
    if (min > max) {
      throw new IllegalArgumentException("Max must be greater than or equal to min");
    }
    return ThreadLocalRandom.current().nextInt(min, max + 1);
  }

  /***
   * Generate random Long between min and max (inclusive)
   */
  public static Long getRandomValue(Long min, Long max) {
    if (min > max) {
      throw new IllegalArgumentException("Max must be greater than or equal to min");
    }
    return ThreadLocalRandom.current().nextLong(min, max + 1);
  }

  /***
   * Generate random BigDecimal between 0.01 and 100.00 (inclusive)
   */
  public static BigDecimal getRandomPercentage() {
    double value = 0.01D + (100.00D - 0.01D) * ThreadLocalRandom.current().nextDouble();
    return BigDecimal.valueOf(Math.round(value * 100.0) / 100.0);
  }
}
