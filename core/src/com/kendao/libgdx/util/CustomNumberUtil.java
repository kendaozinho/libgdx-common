package com.kendao.libgdx.util;

import java.math.BigDecimal;
import java.util.Random;

public final class CustomNumberUtil {
  private CustomNumberUtil() {
  }

  /***
   * Generate value between min value and max value (int);
   */
  public static Integer getRandomValue(Integer min, Integer max) {
    return min + (int) (new Random().nextDouble() * (max - min));
  }

  /***
   * Generate value between min value and max value (long);
   */
  public static Long getRandomValue(Long min, Long max) {
    return min + (long) (new Random().nextDouble() * (max - min));
  }

  /***
   * Generate value between 0.01D and 100.0D;
   */
  public static BigDecimal getRandomPercentage() {
    return BigDecimal.valueOf(Math.round((0.01D + Math.random() * (100.0D - 0.01D)) * 100.0) / 100.0);
  }
}
