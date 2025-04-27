package com.kendao.libgdx.scenes.scene2d.animation;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.kendao.libgdx.scenes.scene2d.CustomStage;
import com.kendao.libgdx.scenes.scene2d.ui.CustomImage;

import java.util.List;
import java.util.Map;

public abstract class CustomCharacterImage extends CustomImage {
  private int ticksCooldown = 180;
  private int ticksSinceLastAttack = 0;
  private long hp = 0;
  private long maxHp = 0;
  private Map<String, List<CustomAttackAnimation>> attacks;
  private boolean canTakeDamage = true;

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

    if (!this.canTakeDamage) {
      this.ticksSinceLastAttack++;
      if (this.ticksSinceLastAttack >= this.ticksCooldown) {
        this.ticksSinceLastAttack = 0;
        if (!this.isDeath()) {
          this.canTakeDamage = true;
        }
      }
    }
  }

  public boolean attack(String attackId) {
    if (this.attacks != null && !this.isDeath()) {
      List<CustomAttackAnimation> attacks = this.attacks.get(attackId);
      if (attacks != null) {
        attacks.forEach(CustomAttackAnimation::execute);
        return true;
      }
    }
    return false;
  }

  public void move(Directions direction, long quantity) {
    if (direction == null || this.isDeath()) {
      return;
    }

    float currentX = super.getX();
    float currentY = super.getY();

    float newX = currentX + (direction.getXMultiplier() * quantity);
    float newY = currentY + (direction.getYMultiplier() * quantity);

    super.setPosition(newX, newY);
  }

  public abstract void wasAttacked(CustomCharacterImage attacker, CustomAttackAnimation attack);

  public abstract void wasKilled(CustomCharacterImage attacker, CustomAttackAnimation attack);

  public void addStageActors(CustomStage stage) {
    stage.addActor(this);
    if (this.attacks != null) {
      this.attacks.forEach((id, attacks) -> attacks.forEach(stage::addActor));
    }
  }

  public void setTicksCooldown(int ticksCooldown) {
    this.ticksCooldown = ticksCooldown;
  }

  public boolean getCanTakeDamage() {
    return this.canTakeDamage;
  }

  public void setCanTakeDamage(boolean canTakeDamage) {
    this.canTakeDamage = canTakeDamage;
  }

  public long getHp() {
    return this.hp;
  }

  public void setHp(long hp) {
    this.hp = hp;
  }

  public long getMaxHp() {
    return this.maxHp;
  }

  public void setMaxHp(long maxHp) {
    this.maxHp = maxHp;
  }

  public boolean isDeath() {
    return this.getHp() <= 0 && this.getMaxHp() > 0;
  }

  public Map<String, List<CustomAttackAnimation>> getAttacks() {
    return this.attacks;
  }

  public void setAttacks(Map<String, List<CustomAttackAnimation>> attacks) {
    this.attacks = attacks;
  }
}
