package com.kendao.libgdx.scenes.scene2d.animation;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.utils.Align;
import com.kendao.libgdx.listener.CustomGameListener;

import java.util.HashMap;

public class CustomAttackBottomLeftToTopRightAnimation extends CustomAttackAnimation {
  public CustomAttackBottomLeftToTopRightAnimation(Texture texture, CustomCharacterImage attacker, HashMap<String, CustomCharacterImage> targets, int width, int height) {
    super(texture, attacker, targets);
    super.setSize(width, height);
    super.setDefaultPosition();
    super.setRotation(Directions.NE.getRotationAngle(), Align.center);
  }

  public CustomAttackBottomLeftToTopRightAnimation(Texture texture, CustomCharacterImage attacker, HashMap<String, CustomCharacterImage> targets, int width, int height, float durationInSeconds) {
    super(texture, attacker, targets, durationInSeconds);
    super.setSize(width, height);
    super.setDefaultPosition();
    super.setRotation(Directions.NE.getRotationAngle(), Align.center);
  }

  public CustomAttackBottomLeftToTopRightAnimation(Texture texture, CustomCharacterImage attacker, HashMap<String, CustomCharacterImage> targets, int width, int height, float durationInSeconds, int damage) {
    super(texture, attacker, targets, durationInSeconds, damage);
    super.setSize(width, height);
    super.setDefaultPosition();
    super.setRotation(Directions.NE.getRotationAngle(), Align.center);
  }

  public CustomAttackBottomLeftToTopRightAnimation(Texture texture, CustomCharacterImage attacker, HashMap<String, CustomCharacterImage> targets, int width, int height, float durationInSeconds, int damage, CustomAttackEffects effect) {
    super(texture, attacker, targets, durationInSeconds, damage, effect);
    super.setSize(width, height);
    super.setDefaultPosition();
    super.setRotation(Directions.NE.getRotationAngle(), Align.center);
  }

  @Override
  public void execute() {
    super.setPosition(
        -super.getWidth(),
        -super.getHeight()
    );
    super.addAction(
        Actions.moveTo(
            ((CustomGameListener) Gdx.app.getApplicationListener()).getFullWidth(),
            ((CustomGameListener) Gdx.app.getApplicationListener()).getFullHeight(),
            super.getDurationInSeconds(),
            Interpolation.smooth
        )
    );
  }

  @Override
  public CustomAttackTypes getType() {
    return CustomAttackTypes.BOTTOM_LEFT_TO_TOP_RIGHT;
  }
}
