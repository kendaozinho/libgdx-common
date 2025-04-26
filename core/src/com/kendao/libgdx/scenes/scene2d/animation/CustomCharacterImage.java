package com.kendao.libgdx.scenes.scene2d.animation;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.kendao.libgdx.scenes.scene2d.ui.CustomImage;

public abstract class CustomCharacterImage extends CustomImage {
  private int ticksCooldown = 250;
  private int ticksSinceLastAttack = 0;
  private boolean canAttack = true;

  public CustomCharacterImage(Texture texture) {
    super(texture);
  }

  public CustomCharacterImage(Texture texture, int x, int y) {
    super(texture, x, y);
  }

  public CustomCharacterImage(Texture texture, int x, int y, int width, int height) {
    super(texture, x, y, width, height);
  }

  public CustomCharacterImage(Texture texture, int x, int y, int width, int height, int ticksCooldown) {
    super(texture, x, y, width, height);
    this.ticksCooldown = ticksCooldown;
  }

  public CustomCharacterImage(Texture texture, int x, int y, int width, int height, int ticksCooldown, int originAlignment, float amountInDegrees) {
    super(texture, x, y, width, height, originAlignment, amountInDegrees);
    this.ticksCooldown = ticksCooldown;
  }

  public CustomCharacterImage(TextureRegion textureRegion) {
    super(textureRegion);
  }

  public CustomCharacterImage(TextureRegion textureRegion, int x, int y) {
    super(textureRegion, x, y);
  }

  public CustomCharacterImage(TextureRegion textureRegion, int x, int y, int width, int height) {
    super(textureRegion, x, y, width, height);
  }

  public CustomCharacterImage(TextureRegion textureRegion, int x, int y, int width, int height, int ticksCooldown) {
    super(textureRegion, x, y, width, height);
    this.ticksCooldown = ticksCooldown;
  }

  public CustomCharacterImage(TextureRegion textureRegion, int x, int y, int width, int height, int ticksCooldown, int originAlignment, float amountInDegrees) {
    super(textureRegion, x, y, width, height, originAlignment, amountInDegrees);
    this.ticksCooldown = ticksCooldown;
  }

  public CustomCharacterImage(Color color) {
    super(color);
  }

  public CustomCharacterImage(Color color, int x, int y) {
    super(color, x, y);
  }

  public CustomCharacterImage(Color color, int x, int y, int width, int height) {
    super(color, x, y, width, height);
  }

  public CustomCharacterImage(Color color, int x, int y, int width, int height, int ticksCooldown) {
    super(color, x, y, width, height);
    this.ticksCooldown = ticksCooldown;
  }

  public CustomCharacterImage(Color color, int x, int y, int width, int height, int ticksCooldown, int originAlignment, float amountInDegrees) {
    super(color, x, y, width, height, originAlignment, amountInDegrees);
    this.ticksCooldown = ticksCooldown;
  }

  @Override
  public void act(float delta) {
    super.act(delta);

    if (!this.canAttack) {
      this.ticksSinceLastAttack++;
      if (this.ticksSinceLastAttack >= this.ticksCooldown) {
        this.ticksSinceLastAttack = 0;
        this.canAttack = true;
      }
    }
  }

  public abstract void wasAttacked(CustomCharacterImage attacker, CustomAttackAnimation attack);

  public boolean getCanAttack() {
    return this.canAttack;
  }
}
