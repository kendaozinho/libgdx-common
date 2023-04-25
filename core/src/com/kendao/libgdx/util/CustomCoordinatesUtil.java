package com.kendao.libgdx.util;

import com.kendao.libgdx.util.dto.CustomPair;

public final class CustomCoordinatesUtil {
  private CustomCoordinatesUtil() {
  }

  public static CustomPair<Long, Long> getCustomPositionByBlockSize(float x, float y, long blockWidth, long blockHeight) {
    return new CustomPair<>((long) (x / blockWidth), (long) (y / blockHeight));
  }
}
