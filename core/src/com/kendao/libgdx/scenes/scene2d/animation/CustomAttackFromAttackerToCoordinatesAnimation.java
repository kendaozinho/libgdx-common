package com.kendao.libgdx.scenes.scene2d.animation;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;

import java.util.HashMap;

public class CustomAttackFromAttackerToCoordinatesAnimation extends CustomAttackAnimation {
  private final int attackDestinyX;
  private final int attackDestinyY;

  public CustomAttackFromAttackerToCoordinatesAnimation(Texture texture, CustomCharacterImage attacker, HashMap<String, CustomCharacterImage> targets, int width, int height, int attackDestinyX, int attackDestinyY) {
    super(texture, attacker, targets);
    super.setSize(width, height);
    super.setDefaultPosition();
    this.attackDestinyX = attackDestinyX;
    this.attackDestinyY = attackDestinyY;
  }

  public CustomAttackFromAttackerToCoordinatesAnimation(Texture texture, CustomCharacterImage attacker, HashMap<String, CustomCharacterImage> targets, int width, int height, int attackDestinyX, int attackDestinyY, float durationInSeconds) {
    super(texture, attacker, targets, durationInSeconds);
    super.setSize(width, height);
    super.setDefaultPosition();
    this.attackDestinyX = attackDestinyX;
    this.attackDestinyY = attackDestinyY;
  }

  public CustomAttackFromAttackerToCoordinatesAnimation(Texture texture, CustomCharacterImage attacker, HashMap<String, CustomCharacterImage> targets, int width, int height, int attackDestinyX, int attackDestinyY, float durationInSeconds, int damage) {
    super(texture, attacker, targets, durationInSeconds, damage);
    super.setSize(width, height);
    super.setDefaultPosition();
    this.attackDestinyX = attackDestinyX;
    this.attackDestinyY = attackDestinyY;
  }

  public CustomAttackFromAttackerToCoordinatesAnimation(Texture texture, CustomCharacterImage attacker, HashMap<String, CustomCharacterImage> targets, int width, int height, int attackDestinyX, int attackDestinyY, float durationInSeconds, int damage, CustomAttackEffects effect) {
    super(texture, attacker, targets, durationInSeconds, damage, effect);
    super.setSize(width, height);
    super.setDefaultPosition();
    this.attackDestinyX = attackDestinyX;
    this.attackDestinyY = attackDestinyY;
  }

  @Override
  public void execute() {
    if (super.getAttacker().isDeath()) {
      return;
    }

    super.getColor().a = 0f; // Começa completamente transparente

    super.addAction(Actions.sequence(
        Actions.run(() -> {
          super.setPosition(
              super.getAttacker().getX() + (super.getAttacker().getWidth() / 2) - (super.getWidth() / 2),
              super.getAttacker().getY() + (super.getAttacker().getHeight() / 2) - (super.getHeight() / 2)
          );
        }),
        Actions.fadeIn(0.2f), // mostrar
        Actions.moveTo(
            this.attackDestinyX, this.attackDestinyY,
            super.getDurationInSeconds(), Interpolation.smooth
        ),
        Actions.fadeOut(0.2f), // esconder
        Actions.run(() -> {
          super.setDefaultPosition();
        })
    ));
  }

  @Override
  public CustomAttackTypes getType() {
    return CustomAttackTypes.ORIGIN_TO_COORDINATES;
  }

  public int getAttackDestinyX() {
    return this.attackDestinyX;
  }

  public int getAttackDestinyY() {
    return this.attackDestinyY;
  }
}
