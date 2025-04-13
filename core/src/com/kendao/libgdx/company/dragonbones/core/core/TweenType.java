package com.kendao.libgdx.company.dragonbones.core.core;

/**
 * @private
 */
public enum TweenType {
  None(0),
  Line(1),
  Curve(2),
  QuadIn(3),
  QuadOut(4),
  QuadInOut(5);

  public static TweenType[] values = values();
  final public int v;

  TweenType(int v) {
    this.v = v;
  }
}
