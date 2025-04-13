package com.kendao.libgdx.company.dragonbones.core.core;

/**
 * @version DragonBones 5.0
 * @language zh_CN
 * 包围盒类型。
 */
public enum BoundingBoxType {
  Rectangle(0),
  Ellipse(1),
  Polygon(2);

  public static BoundingBoxType[] values = values();
  public final int v;

  BoundingBoxType(int v) {
    this.v = v;
  }
}
