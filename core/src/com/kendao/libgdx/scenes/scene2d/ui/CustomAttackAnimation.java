package com.kendao.libgdx.scenes.scene2d.ui;

import com.badlogic.gdx.graphics.Texture;

import java.util.HashMap;

public abstract class CustomAttackAnimation extends CustomImage {
  private final HashMap<String, CustomCharacterImage> targets;
  private final float durationInSeconds;

  public CustomAttackAnimation(
      Texture texture, HashMap<String, CustomCharacterImage> targets
  ) {
    super(texture);
    this.targets = targets;
    this.durationInSeconds = 3f;
  }

  public CustomAttackAnimation(
      Texture texture, HashMap<String, CustomCharacterImage> targets, float durationInSeconds
  ) {
    super(texture);
    this.targets = targets;
    this.durationInSeconds = durationInSeconds;
  }

  public CustomAttackAnimation(
      Texture texture, HashMap<String, CustomCharacterImage> targets, float durationInSeconds, CustomAttackEffects effect
  ) {
    super(texture);
    this.targets = targets;
    this.durationInSeconds = durationInSeconds;
    this.setEffect(effect);
  }

  private void setEffect(CustomAttackEffects effect) {
    if (effect != null && effect != CustomAttackEffects.NONE) {
      switch (effect) {
        case FADE:
          super.executeFadeAnimation(true);
          break;
        case PULSE:
          super.executePulseAnimation(true);
          break;
        case ROTATE_RIGHT:
          super.executeRotateRightAnimation(true);
          break;
        case ROTATE_LEFT:
          super.executeRotateLeftAnimation(true);
          break;
        case FLIP_HORIZONTAL:
          super.executeFlipHorizontalAnimation(true);
          break;
        case FLIP_VERTICAL:
          super.executeFlipVerticalAnimation(true);
          break;
      }
    }
  }

  @Override
  public void act(float delta) {
    super.act(delta);

    checkCollision();
  }

  private void checkCollision() {
    float thisX = super.getX();
    float thisY = super.getY();
    float thisWidth = super.getWidth();
    float thisHeight = super.getHeight();

    for (CustomCharacterImage target : this.targets.values()) {
      float targetX = target.getX();
      float targetY = target.getY();
      float targetWidth = target.getWidth();
      float targetHeight = target.getHeight();

      boolean overlaps = thisX < targetX + targetWidth &&
          thisX + thisWidth > targetX &&
          thisY < targetY + targetHeight &&
          thisY + thisHeight > targetY;

      if (overlaps) {
        target.wasAttacked();
      }
    }
  }

  public float getDurationInSeconds() {
    return this.durationInSeconds;
  }

  public abstract void execute();

  public abstract CustomAttackTypes getType();

  public enum CustomAttackTypes {
    TOP_RIGHT_TO_BOTTOM_LEFT,
    TOP_LEFT_TO_BOTTOM_RIGHT,
    BOTTOM_RIGHT_TO_TOP_LEFT,
    BOTTOM_LEFT_TO_TOP_RIGHT,
    UP_TO_DOWN,
    DOWN_TO_UP,
    LEFT_TO_RIGHT,
    RIGHT_TO_LEFT,
    CUSTOM
  }

  public enum CustomAttackEffects {
    NONE, FADE, PULSE, ROTATE_RIGHT, ROTATE_LEFT, FLIP_VERTICAL, FLIP_HORIZONTAL
  }
}
