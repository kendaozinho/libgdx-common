package com.kendao.libgdx.scenes.scene2d.animation;

public enum Directions {
  N(0f),
  S(180f),
  E(270f),
  W(90f),
  NE(315f),
  NW(45f),
  SE(225f),
  SW(135f);

  private final float rotationAngle;

  Directions(float rotationAngle) {
    this.rotationAngle = rotationAngle;
  }

  public float getRotationAngle() {
    return this.rotationAngle;
  }
}
