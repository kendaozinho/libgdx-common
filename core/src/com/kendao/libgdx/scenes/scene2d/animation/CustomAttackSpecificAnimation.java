package com.kendao.libgdx.scenes.scene2d.animation;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;

import java.util.HashMap;

public class CustomAttackSpecificAnimation extends CustomAttackAnimation {
  private final int attackOriginX;
  private final int attackOriginY;
  private final int attackDestinyX;
  private final int attackDestinyY;

  public CustomAttackSpecificAnimation(Texture texture, CustomCharacterImage attacker, HashMap<String, CustomCharacterImage> targets, int width, int height, int attackOriginX, int attackOriginY, int attackDestinyX, int attackDestinyY) {
    super(texture, attacker, targets);
    super.setSize(width, height);
    super.setPosition(-9999, -9999);

    this.attackOriginX = attackOriginX;
    this.attackOriginY = attackOriginY;
    this.attackDestinyX = attackDestinyX;
    this.attackDestinyY = attackDestinyY;
  }

  public CustomAttackSpecificAnimation(Texture texture, CustomCharacterImage attacker, HashMap<String, CustomCharacterImage> targets, int width, int height, int attackOriginX, int attackOriginY, int attackDestinyX, int attackDestinyY, float durationInSeconds) {
    super(texture, attacker, targets, durationInSeconds);
    super.setSize(width, height);
    super.setPosition(-9999, -9999);

    this.attackOriginX = attackOriginX;
    this.attackOriginY = attackOriginY;
    this.attackDestinyX = attackDestinyX;
    this.attackDestinyY = attackDestinyY;
  }

  public CustomAttackSpecificAnimation(Texture texture, CustomCharacterImage attacker, HashMap<String, CustomCharacterImage> targets, int width, int height, int attackOriginX, int attackOriginY, int attackDestinyX, int attackDestinyY, float durationInSeconds, int damage) {
    super(texture, attacker, targets, durationInSeconds, damage);
    super.setSize(width, height);
    super.setPosition(-9999, -9999);

    this.attackOriginX = attackOriginX;
    this.attackOriginY = attackOriginY;
    this.attackDestinyX = attackDestinyX;
    this.attackDestinyY = attackDestinyY;
  }

  public CustomAttackSpecificAnimation(Texture texture, CustomCharacterImage attacker, HashMap<String, CustomCharacterImage> targets, int width, int height, int attackOriginX, int attackOriginY, int attackDestinyX, int attackDestinyY, float durationInSeconds, int damage, CustomAttackEffects effect) {
    super(texture, attacker, targets, durationInSeconds, damage, effect);
    super.setSize(width, height);
    super.setPosition(-9999, -9999);

    this.attackOriginX = attackOriginX;
    this.attackOriginY = attackOriginY;
    this.attackDestinyX = attackDestinyX;
    this.attackDestinyY = attackDestinyY;
  }

  @Override
  public void execute() {
    super.getColor().a = 0f; // Começa completamente transparente

    super.addAction(Actions.sequence(
        Actions.run(() -> {
          super.setPosition(this.attackOriginX, this.attackOriginY);
        }),
        Actions.fadeIn(0.2f), // mostrar
        Actions.moveTo(
            this.attackDestinyX, this.attackDestinyY,
            super.getDurationInSeconds(), Interpolation.smooth
        ),
        Actions.fadeOut(0.2f) // esconder
    ));
  }

  @Override
  public CustomAttackTypes getType() {
    return CustomAttackTypes.CUSTOM;
  }

  public int getAttackOriginX() {
    return this.attackOriginX;
  }

  public int getAttackOriginY() {
    return this.attackOriginY;
  }

  public int getAttackDestinyX() {
    return this.attackDestinyX;
  }

  public int getAttackDestinyY() {
    return this.attackDestinyY;
  }
}
