package com.kendao.libgdx.company.dragonbones.core.util;

public class ShortArray extends IntArray {
  public ShortArray(boolean none) {
    super(none);
  }

  public ShortArray() {
  }

  public ShortArray(int length) {
    super(length);
  }

  public ShortArray(int[] data) {
    super(data);
  }

  public ShortArray(int[] data, int length) {
    super(data, length);
  }

  @Override
  protected IntArray createInstance() {
    return new ShortArray();
  }
}
