package com.kendao.libgdx.company.dragonbones.core.util;

public class StringUtil {
  static public String fromCharCode(int cc) {
    return new String(new int[]{cc}, 0, 1);
  }

  static public String fromCodePoint(int cp) {
    return new String(new int[]{cp}, 0, 1);
  }
}
