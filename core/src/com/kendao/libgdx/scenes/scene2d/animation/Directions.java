package com.kendao.libgdx.scenes.scene2d.animation;

public enum Directions {
  N(0f, 0f, 1f),
  NNE(337.5f, 0.3827f, 0.9239f),
  NE(315f, 0.7071f, 0.7071f),
  ENE(292.5f, 0.9239f, 0.3827f),
  E(270f, 1f, 0f),
  ESE(247.5f, 0.9239f, -0.3827f),
  SE(225f, 0.7071f, -0.7071f),
  SSE(202.5f, 0.3827f, -0.9239f),
  S(180f, 0f, -1f),
  SSW(157.5f, -0.3827f, -0.9239f),
  SW(135f, -0.7071f, -0.7071f),
  WSW(112.5f, -0.9239f, -0.3827f),
  W(90f, -1f, 0f),
  WNW(67.5f, -0.9239f, 0.3827f),
  NW(45f, -0.7071f, 0.7071f),
  NNW(22.5f, -0.3827f, 0.9239f);

  private final float rotationAngle;
  private final float xMultiplier;
  private final float yMultiplier;

  Directions(float rotationAngle, float xMultiplier, float yMultiplier) {
    this.rotationAngle = rotationAngle;
    this.xMultiplier = xMultiplier;
    this.yMultiplier = yMultiplier;
  }

  public float getRotationAngle() {
    return this.rotationAngle;
  }

  public float getXMultiplier() {
    return this.xMultiplier;
  }

  public float getYMultiplier() {
    return this.yMultiplier;
  }
}
