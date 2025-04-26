package com.kendao.libgdx.scenes.scene2d.animation;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.utils.Align;

import java.util.HashMap;

public class CustomAttackFromAttackerToDirectionAnimation extends CustomAttackAnimation {
  private final Directions direction;
  private final float distance;

  public CustomAttackFromAttackerToDirectionAnimation(Texture texture, CustomCharacterImage attacker, HashMap<String, CustomCharacterImage> targets, int width, int height, Directions direction, float distance) {
    super(texture, attacker, targets);
    super.setSize(width, height);
    super.setPosition(-9999, -9999);
    this.direction = direction;
    this.distance = distance;
    super.setRotation(direction.getRotationAngle(), Align.center);
  }

  public CustomAttackFromAttackerToDirectionAnimation(Texture texture, CustomCharacterImage attacker, HashMap<String, CustomCharacterImage> targets, int width, int height, Directions direction, float distance, float durationInSeconds) {
    super(texture, attacker, targets, durationInSeconds);
    super.setSize(width, height);
    super.setPosition(-9999, -9999);
    this.direction = direction;
    this.distance = distance;
    super.setRotation(direction.getRotationAngle(), Align.center);
  }

  public CustomAttackFromAttackerToDirectionAnimation(Texture texture, CustomCharacterImage attacker, HashMap<String, CustomCharacterImage> targets, int width, int height, Directions direction, float distance, float durationInSeconds, int damage) {
    super(texture, attacker, targets, durationInSeconds, damage);
    super.setSize(width, height);
    super.setPosition(-9999, -9999);
    this.direction = direction;
    this.distance = distance;
    super.setRotation(direction.getRotationAngle(), Align.center);
  }

  public CustomAttackFromAttackerToDirectionAnimation(Texture texture, CustomCharacterImage attacker, HashMap<String, CustomCharacterImage> targets, int width, int height, Directions direction, float distance, float durationInSeconds, int damage, CustomAttackEffects effect) {
    super(texture, attacker, targets, durationInSeconds, damage, effect);
    super.setSize(width, height);
    super.setPosition(-9999, -9999);
    this.direction = direction;
    this.distance = distance;
    super.setRotation(direction.getRotationAngle(), Align.center);
  }

  @Override
  public void execute() {
    float originX = super.getAttacker().getX() + (super.getAttacker().getWidth() / 2) - (super.getWidth() / 2);
    float originY = super.getAttacker().getY() + (super.getAttacker().getHeight() / 2) - (super.getHeight() / 2);

    float destinyX = originX + this.direction.getXMultiplier() * this.distance;
    float destinyY = originY + this.direction.getYMultiplier() * this.distance;

    super.getColor().a = 0f; // Começa completamente transparente

    super.addAction(Actions.sequence(
        Actions.run(() -> {
          super.setPosition(originX, originY);
        }),
        Actions.fadeIn(0.2f), // mostrar
        Actions.moveTo(
            destinyX, destinyY, super.getDurationInSeconds(), Interpolation.smooth
        ),
        Actions.fadeOut(0.2f), // esconder
        Actions.run(() -> {
          super.setPosition(-9999, -9999);
        })
    ));
  }

  @Override
  public CustomAttackTypes getType() {
    return CustomAttackTypes.ORIGIN_TO_DIRECTION;
  }
}
