package com.kendao.libgdx.scenes.scene2d.animation;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.utils.Align;
import com.kendao.libgdx.listener.CustomGameListener;

import java.util.HashMap;

public class CustomAttackBottomRightToTopLeftAnimation extends CustomAttackAnimation {
  public CustomAttackBottomRightToTopLeftAnimation(Texture texture, CustomCharacterImage attacker, HashMap<String, CustomCharacterImage> targets, int width, int height) {
    super(texture, attacker, targets);
    super.setSize(width, height);
    super.setPosition(-9999, -9999);
    super.setRotation(Directions.NW.getRotationAngle(), Align.center);
  }

  public CustomAttackBottomRightToTopLeftAnimation(Texture texture, CustomCharacterImage attacker, HashMap<String, CustomCharacterImage> targets, int width, int height, float durationInSeconds) {
    super(texture, attacker, targets, durationInSeconds);
    super.setSize(width, height);
    super.setPosition(-9999, -9999);
    super.setRotation(Directions.NW.getRotationAngle(), Align.center);
  }

  public CustomAttackBottomRightToTopLeftAnimation(Texture texture, CustomCharacterImage attacker, HashMap<String, CustomCharacterImage> targets, int width, int height, float durationInSeconds, int damage) {
    super(texture, attacker, targets, durationInSeconds, damage);
    super.setSize(width, height);
    super.setPosition(-9999, -9999);
    super.setRotation(Directions.NW.getRotationAngle(), Align.center);
  }

  public CustomAttackBottomRightToTopLeftAnimation(Texture texture, CustomCharacterImage attacker, HashMap<String, CustomCharacterImage> targets, int width, int height, float durationInSeconds, int damage, CustomAttackEffects effect) {
    super(texture, attacker, targets, durationInSeconds, damage, effect);
    super.setSize(width, height);
    super.setPosition(-9999, -9999);
    super.setRotation(Directions.NW.getRotationAngle(), Align.center);
  }

  @Override
  public void execute() {
    super.setPosition(
        ((CustomGameListener) Gdx.app.getApplicationListener()).getFullWidth() + super.getWidth(),
        -(super.getHeight() / 2)
    );
    super.addAction(
        Actions.moveTo(-super.getWidth(), ((CustomGameListener) Gdx.app.getApplicationListener()).getFullHeight() + (super.getHeight() / 2), super.getDurationInSeconds(), Interpolation.smooth)
    );
  }

  @Override
  public CustomAttackTypes getType() {
    return CustomAttackTypes.BOTTOM_RIGHT_TO_TOP_LEFT;
  }
}
