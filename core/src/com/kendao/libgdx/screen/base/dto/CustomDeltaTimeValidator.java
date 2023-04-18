package com.kendao.libgdx.screen.base.dto;

public class CustomDeltaTimeValidator {
  private float currentDeltaTime;
  private final float maximumDeltaTime;

  public CustomDeltaTimeValidator(float maximumDeltaTime) {
    this.currentDeltaTime = 0f;
    this.maximumDeltaTime = maximumDeltaTime;
  }

  public boolean validateDeltaTime(float deltaTime) {
    this.currentDeltaTime += deltaTime;
    if (this.currentDeltaTime < this.maximumDeltaTime) {
      return false;
    } else {
      this.currentDeltaTime = 0f;
      return true;
    }
  }
}
