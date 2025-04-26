package com.kendao.libgdx.scenes.scene2d.animation;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;

import java.util.HashMap;

public class CustomAttackFromAttackerToTargetAnimation extends CustomAttackAnimation {
  public CustomAttackFromAttackerToTargetAnimation(Texture texture, CustomCharacterImage attacker, HashMap<String, CustomCharacterImage> targets, int width, int height) {
    super(texture, attacker, targets);
    super.setSize(width, height);
    super.setPosition(-9999, -9999);
  }

  public CustomAttackFromAttackerToTargetAnimation(Texture texture, CustomCharacterImage attacker, HashMap<String, CustomCharacterImage> targets, int width, int height, float durationInSeconds) {
    super(texture, attacker, targets, durationInSeconds);
    super.setSize(width, height);
    super.setPosition(-9999, -9999);
  }

  public CustomAttackFromAttackerToTargetAnimation(Texture texture, CustomCharacterImage attacker, HashMap<String, CustomCharacterImage> targets, int width, int height, float durationInSeconds, int damage) {
    super(texture, attacker, targets, durationInSeconds, damage);
    super.setSize(width, height);
    super.setPosition(-9999, -9999);
  }

  public CustomAttackFromAttackerToTargetAnimation(Texture texture, CustomCharacterImage attacker, HashMap<String, CustomCharacterImage> targets, int width, int height, float durationInSeconds, int damage, CustomAttackEffects effect) {
    super(texture, attacker, targets, durationInSeconds, damage, effect);
    super.setSize(width, height);
    super.setPosition(-9999, -9999);
  }

  @Override
  public void execute() {
    super.getColor().a = 0f; // Começa completamente transparente

    CustomCharacterImage firstTarget = (super.getTargets() == null || super.getTargets().isEmpty()) ? null : super.getTargets().values().iterator().next();

    float targetX = (firstTarget == null) ? 0 : firstTarget.getX() + (firstTarget.getWidth() / 2) - (super.getWidth() / 2);
    float targetY = (firstTarget == null) ? 0 : firstTarget.getY() + (firstTarget.getHeight() / 2) - (super.getHeight() / 2);

    super.addAction(Actions.sequence(
        Actions.run(() -> {
          super.setPosition(
              super.getAttacker().getX() + (super.getAttacker().getWidth() / 2) - (super.getWidth() / 2),
              super.getAttacker().getY() + (super.getAttacker().getHeight() / 2) - (super.getHeight() / 2)
          );
        }),
        Actions.fadeIn(0.2f), // mostrar
        Actions.moveTo(
            targetX, targetY,
            super.getDurationInSeconds(), Interpolation.smooth
        ),
        Actions.fadeOut(0.2f), // esconder
        Actions.run(() -> {
          super.setPosition(-9999, -9999);
        })
    ));
  }

  @Override
  public CustomAttackTypes getType() {
    return CustomAttackTypes.ORIGIN_TO_DESTINY;
  }
}
