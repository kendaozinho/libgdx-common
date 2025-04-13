package com.kendao.libgdx.company.dragonbones.core.core;

/**
 * @private
 */
public enum DisplayType {
  Image(0),
  Armature(1),
  Mesh(2),
  BoundingBox(3);

  public static DisplayType[] values = values();
  final public int v;

  DisplayType(int v) {
    this.v = v;
  }
}
