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
    float originX = super.getAttacker().getX() + (super.getAttacker().getWidth() / 2);
    float originY = super.getAttacker().getY() + (super.getAttacker().getHeight() / 2);

    float destinyX = originX;
    float destinyY = originY;

    // Calcula o fator de diagonal (1/sqrt(2) ≈ 0.7071) para manter a mesma distância total
    float diagonalFactor = (float) (this.distance * Math.sqrt(2) / 2);
    float halfDiagonalFactor = (float) (this.distance * Math.sqrt(0.5 - Math.sqrt(2) / 4)); // Fator para direções intermediárias

    switch (this.direction) {
      case N:
        destinyY += this.distance;
        break;
      case NNE:
        destinyX += halfDiagonalFactor;
        destinyY += halfDiagonalFactor;
        break;
      case NE:
        destinyX += diagonalFactor;
        destinyY += diagonalFactor;
        break;
      case ENE:
        destinyX += halfDiagonalFactor;
        destinyY += halfDiagonalFactor;
        break;
      case E:
        destinyX += this.distance;
        break;
      case ESE:
        destinyX += halfDiagonalFactor;
        destinyY -= halfDiagonalFactor;
        break;
      case SE:
        destinyX += diagonalFactor;
        destinyY -= diagonalFactor;
        break;
      case SSE:
        destinyX += halfDiagonalFactor;
        destinyY -= halfDiagonalFactor;
        break;
      case S:
        destinyY -= this.distance;
        break;
      case SSW:
        destinyX -= halfDiagonalFactor;
        destinyY -= halfDiagonalFactor;
        break;
      case SW:
        destinyX -= diagonalFactor;
        destinyY -= diagonalFactor;
        break;
      case WSW:
        destinyX -= halfDiagonalFactor;
        destinyY -= halfDiagonalFactor;
        break;
      case W:
        destinyX -= this.distance;
        break;
      case WNW:
        destinyX -= halfDiagonalFactor;
        destinyY += halfDiagonalFactor;
        break;
      case NW:
        destinyX -= diagonalFactor;
        destinyY += diagonalFactor;
        break;
      case NNW:
        destinyX -= halfDiagonalFactor;
        destinyY += halfDiagonalFactor;
        break;
    }

    super.getColor().a = 0f; // Começa completamente transparente

    super.addAction(Actions.sequence(
        Actions.run(() -> {
          super.setPosition(
              super.getAttacker().getX() + (super.getAttacker().getWidth() / 2),
              super.getAttacker().getY() + (super.getAttacker().getHeight() / 2)
          );
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
