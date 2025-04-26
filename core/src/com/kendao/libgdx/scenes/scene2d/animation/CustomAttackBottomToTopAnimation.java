package com.kendao.libgdx.scenes.scene2d.animation;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.utils.Align;
import com.kendao.libgdx.listener.CustomGameListener;

import java.util.HashMap;

public class CustomAttackBottomToTopAnimation extends CustomAttackAnimation {
  public CustomAttackBottomToTopAnimation(Texture texture, CustomCharacterImage attacker, HashMap<String, CustomCharacterImage> targets, int width, int height, int x) {
    super(texture, attacker, targets);
    super.setSize(width, height);
    super.setPosition(x, -9999);
    super.setRotation(Directions.N.getRotationAngle(), Align.center);
  }

  public CustomAttackBottomToTopAnimation(Texture texture, CustomCharacterImage attacker, HashMap<String, CustomCharacterImage> targets, int width, int height, int x, float durationInSeconds) {
    super(texture, attacker, targets, durationInSeconds);
    super.setSize(width, height);
    super.setPosition(x, -9999);
    super.setRotation(Directions.N.getRotationAngle(), Align.center);
  }

  public CustomAttackBottomToTopAnimation(Texture texture, CustomCharacterImage attacker, HashMap<String, CustomCharacterImage> targets, int width, int height, int x, float durationInSeconds, int damage) {
    super(texture, attacker, targets, durationInSeconds, damage);
    super.setSize(width, height);
    super.setPosition(x, -9999);
    super.setRotation(Directions.N.getRotationAngle(), Align.center);
  }

  public CustomAttackBottomToTopAnimation(Texture texture, CustomCharacterImage attacker, HashMap<String, CustomCharacterImage> targets, int width, int height, int x, float durationInSeconds, int damage, CustomAttackEffects effect) {
    super(texture, attacker, targets, durationInSeconds, damage, effect);
    super.setSize(width, height);
    super.setPosition(x, -9999);
    super.setRotation(Directions.N.getRotationAngle(), Align.center);
  }

  @Override
  public void execute() {
    super.setPosition(super.getX(), -super.getHeight());
    super.addAction(
        Actions.moveTo(
            super.getX(), ((CustomGameListener) Gdx.app.getApplicationListener()).getFullHeight(),
            super.getDurationInSeconds(), Interpolation.smooth
        )
    );
  }

  @Override
  public CustomAttackTypes getType() {
    return CustomAttackTypes.BOTTOM_TO_TOP;
  }
}
