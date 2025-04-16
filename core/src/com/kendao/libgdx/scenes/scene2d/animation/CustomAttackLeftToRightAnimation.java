package com.kendao.libgdx.scenes.scene2d.animation;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.kendao.libgdx.listener.CustomGameListener;

import java.util.HashMap;

public class CustomAttackLeftToRightAnimation extends CustomAttackAnimation {
  public CustomAttackLeftToRightAnimation(Texture texture, CustomCharacterImage attacker, HashMap<String, CustomCharacterImage> targets, int width, int height, int y) {
    super(texture, attacker, targets);
    super.setSize(width, height);
    super.setPosition(-9999, y);
  }

  public CustomAttackLeftToRightAnimation(Texture texture, CustomCharacterImage attacker, HashMap<String, CustomCharacterImage> targets, int width, int height, int y, float durationInSeconds) {
    super(texture, attacker, targets, durationInSeconds);
    super.setSize(width, height);
    super.setPosition(-9999, y);
  }

  public CustomAttackLeftToRightAnimation(Texture texture, CustomCharacterImage attacker, HashMap<String, CustomCharacterImage> targets, int width, int height, int y, float durationInSeconds, int damage) {
    super(texture, attacker, targets, durationInSeconds, damage);
    super.setSize(width, height);
    super.setPosition(-9999, y);
  }

  public CustomAttackLeftToRightAnimation(Texture texture, CustomCharacterImage attacker, HashMap<String, CustomCharacterImage> targets, int width, int height, int y, float durationInSeconds, int damage, CustomAttackEffects effect) {
    super(texture, attacker, targets, durationInSeconds, damage, effect);
    super.setSize(width, height);
    super.setPosition(-9999, y);
  }

  @Override
  public void execute() {
    super.setPosition(-super.getWidth(), super.getY());
    super.addAction(
        Actions.moveTo(
            ((CustomGameListener) Gdx.app.getApplicationListener()).getFullWidth(),
            super.getY(), super.getDurationInSeconds(), Interpolation.smooth
        )
    );
  }

  @Override
  public CustomAttackTypes getType() {
    return CustomAttackTypes.LEFT_TO_RIGHT;
  }
}
