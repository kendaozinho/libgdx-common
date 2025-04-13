package com.kendao.libgdx.company.dragonbones.core.util;

final public class BoolArray extends IntArray {
  @Override
  protected IntArray createInstance() {
    return new BoolArray();
  }

  public boolean getBool(int index) {
    return get(index) != 0;
  }

  public void setBool(int index, boolean value) {
    set(index, value ? 1 : 0);
  }
}
