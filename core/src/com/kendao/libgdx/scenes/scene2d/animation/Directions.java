package com.kendao.libgdx.scenes.scene2d.animation;

public enum Directions {
  N(0f),
  NNE(22.5f),
  NE(45f),
  ENE(67.5f),
  E(90f),
  ESE(112.5f),
  SE(135f),
  SSE(157.5f),
  S(180f),
  SSW(202.5f),
  SW(225f),
  WSW(247.5f),
  W(270f),
  WNW(292.5f),
  NW(315f),
  NNW(337.5f);

  private final float rotationAngle;

  Directions(float rotationAngle) {
    this.rotationAngle = rotationAngle;
  }

  public float getRotationAngle() {
    return this.rotationAngle;
  }
}
