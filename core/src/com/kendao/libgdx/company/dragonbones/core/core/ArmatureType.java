package com.kendao.libgdx.company.dragonbones.core.core;

/**
 * @private
 */
public enum ArmatureType {
  Armature(0),
  MovieClip(1),
  Stage(2);

  public static ArmatureType[] values = values();
  final public int v;

  ArmatureType(int v) {
    this.v = v;
  }
}
