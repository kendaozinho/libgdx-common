package com.kendao.libgdx.scenes.scene2d.animation;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.kendao.libgdx.dragonbones.dto.DragonBonesTextureDto;

import java.util.*;

public abstract class CustomCharacterAnimatedImage extends CustomCharacterImage {
  private final List<String> animationOptions;
  private final Map<String, List<TextureRegion>> animationFrames;
  private final int ticksPerFrame; // how many renders to change the frame

  private String currentAnimation;
  private String lastAnimation;
  private int frameCounter = 0;
  private int currentFrame = 0;

  private boolean waitToSwitch = true;

  public CustomCharacterAnimatedImage(Texture spriteSheet, int cols, int rows, int ticksPerFrame) {
    super(
        TextureRegion.split(
            spriteSheet,
            spriteSheet.getWidth() / cols,
            spriteSheet.getHeight() / rows
        )[0][0],
        0, 0,
        spriteSheet.getWidth() / cols, spriteSheet.getHeight() / rows
    );

    this.ticksPerFrame = ticksPerFrame;

    this.animationOptions = Collections.singletonList("default");
    this.currentAnimation = this.animationOptions.get(0);
    this.lastAnimation = this.currentAnimation;
    this.animationFrames = this.extractFrames(spriteSheet, cols, rows, (cols * rows));
  }

  public CustomCharacterAnimatedImage(Texture spriteSheet, int cols, int rows, int frameQuantity, int ticksPerFrame) {
    super(
        TextureRegion.split(
            spriteSheet,
            spriteSheet.getWidth() / cols,
            spriteSheet.getHeight() / rows
        )[0][0],
        0, 0,
        spriteSheet.getWidth() / cols, spriteSheet.getHeight() / rows
    );

    this.ticksPerFrame = ticksPerFrame;

    this.animationOptions = Collections.singletonList("default");
    this.currentAnimation = this.animationOptions.get(0);
    this.lastAnimation = this.currentAnimation;
    this.animationFrames = this.extractFrames(spriteSheet, cols, rows, frameQuantity);
  }

  public CustomCharacterAnimatedImage(Texture spriteSheet, int cols, int rows, int x, int y, int width, int height, int frameQuantity, int ticksPerFrame) {
    super(
        TextureRegion.split(
            spriteSheet,
            spriteSheet.getWidth() / cols,
            spriteSheet.getHeight() / rows
        )[0][0],
        x, y,
        width, height
    );

    this.ticksPerFrame = ticksPerFrame;

    this.animationOptions = Collections.singletonList("default");
    this.currentAnimation = this.animationOptions.get(0);
    this.lastAnimation = this.currentAnimation;
    this.animationFrames = this.extractFrames(spriteSheet, cols, rows, frameQuantity);
  }

  public CustomCharacterAnimatedImage(Texture spriteSheet, int cols, int rows, int x, int y, int width, int height, int frameQuantity, int ticksPerFrame, int ticksCooldown) {
    super(
        TextureRegion.split(
            spriteSheet,
            spriteSheet.getWidth() / cols,
            spriteSheet.getHeight() / rows
        )[0][0],
        x, y,
        width, height,
        ticksCooldown
    );

    this.ticksPerFrame = ticksPerFrame;

    this.animationOptions = Collections.singletonList("default");
    this.currentAnimation = this.animationOptions.get(0);
    this.lastAnimation = this.currentAnimation;
    this.animationFrames = this.extractFrames(spriteSheet, cols, rows, frameQuantity);
  }

  public CustomCharacterAnimatedImage(Texture spriteSheet, DragonBonesTextureDto textureDto, int ticksPerFrame) {
    super(
        TextureRegion.split(
            spriteSheet,
            textureDto.getSubTexture().isEmpty() ? spriteSheet.getWidth() : (spriteSheet.getWidth() / textureDto.getSubTexture().get(0).getWidth()),
            textureDto.getSubTexture().isEmpty() ? spriteSheet.getHeight() : (spriteSheet.getHeight() / textureDto.getSubTexture().get(0).getHeight())
        )[0][0],
        0, 0,
        textureDto.getSubTexture().isEmpty() ? spriteSheet.getWidth() : textureDto.getSubTexture().get(0).getWidth(),
        textureDto.getSubTexture().isEmpty() ? spriteSheet.getHeight() : textureDto.getSubTexture().get(0).getHeight()
    );

    this.ticksPerFrame = ticksPerFrame;

    this.animationOptions = textureDto.getAnimationTypes();
    this.currentAnimation = this.getDefaultAnimation(this.animationOptions);
    this.lastAnimation = this.currentAnimation;
    this.animationFrames = textureDto.getTextureRegionsByAnimationType(spriteSheet);
  }

  public CustomCharacterAnimatedImage(Texture spriteSheet, DragonBonesTextureDto textureDto, int x, int y, int width, int height, int ticksPerFrame) {
    super(
        TextureRegion.split(
            spriteSheet,
            textureDto.getSubTexture().isEmpty() ? spriteSheet.getWidth() : (spriteSheet.getWidth() / textureDto.getSubTexture().get(0).getWidth()),
            textureDto.getSubTexture().isEmpty() ? spriteSheet.getHeight() : (spriteSheet.getHeight() / textureDto.getSubTexture().get(0).getHeight())
        )[0][0],
        x, y,
        width, height
    );

    this.ticksPerFrame = ticksPerFrame;

    this.animationOptions = textureDto.getAnimationTypes();
    this.currentAnimation = this.getDefaultAnimation(this.animationOptions);
    this.lastAnimation = this.currentAnimation;
    this.animationFrames = textureDto.getTextureRegionsByAnimationType(spriteSheet);
  }

  public CustomCharacterAnimatedImage(Texture spriteSheet, DragonBonesTextureDto textureDto, int x, int y, int width, int height, int ticksPerFrame, int ticksCooldown) {
    super(
        TextureRegion.split(
            spriteSheet,
            textureDto.getSubTexture().isEmpty() ? spriteSheet.getWidth() : (spriteSheet.getWidth() / textureDto.getSubTexture().get(0).getWidth()),
            textureDto.getSubTexture().isEmpty() ? spriteSheet.getHeight() : (spriteSheet.getHeight() / textureDto.getSubTexture().get(0).getHeight())
        )[0][0],
        x, y,
        width, height,
        ticksCooldown
    );

    this.ticksPerFrame = ticksPerFrame;

    this.animationOptions = textureDto.getAnimationTypes();
    this.currentAnimation = this.getDefaultAnimation(this.animationOptions);
    this.lastAnimation = this.currentAnimation;
    this.animationFrames = textureDto.getTextureRegionsByAnimationType(spriteSheet);
  }

  private String getDefaultAnimation(List<String> animationOptions) {
    return (animationOptions == null || animationOptions.isEmpty())
        ? null
        : animationOptions.stream()
        .filter(a -> {
          String lower = a.toLowerCase();
          return lower.equals("default") || lower.equals("idle") || lower.equals("normal");
        })
        .findFirst()
        .orElse(animationOptions.get(0));
  }

  private Map<String, List<TextureRegion>> extractFrames(Texture spriteSheet, int cols, int rows, int frameQuantity) {
    TextureRegion[][] dividedTextureRegions = TextureRegion.split(
        spriteSheet,
        spriteSheet.getWidth() / cols,
        spriteSheet.getHeight() / rows
    );

    ArrayList<TextureRegion> textureRegions = new ArrayList<>(frameQuantity);
    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < cols; col++) {
        textureRegions.add(dividedTextureRegions[row][col]);

        if (textureRegions.size() >= frameQuantity) {
          break;
        }
      }

      if (textureRegions.size() >= frameQuantity) {
        break;
      }
    }

    Map<String, List<TextureRegion>> response = new HashMap<>();
    response.put("default", textureRegions);
    return response;
  }

  @Override
  public boolean attack(String attackId) {
    boolean attacked = super.attack(attackId);

    if (attacked) {
      this.setAttackAnimation();
    }

    return attacked;
  }

  private void setAttackAnimation() {
    for (String animation : this.animationOptions) {
      if (animation.equalsIgnoreCase("attack") || animation.equalsIgnoreCase("atk")) {
        this.setCurrentAnimation(animation);
        break;
      }
    }
  }

  private void setIdleAnimation() {
    for (String animation : this.animationOptions) {
      if (
          animation.equalsIgnoreCase("default") || animation.equalsIgnoreCase("idle") || animation.equalsIgnoreCase("normal")
      ) {
        this.setCurrentAnimation(animation);
        break;
      }
    }
  }

  private void setDeathAnimation() {
    for (String animation : this.animationOptions) {
      if (
          animation.equalsIgnoreCase("death")
      ) {
        this.setCurrentAnimation(animation);
        break;
      }
    }
  }

  @Override
  public void act(float delta) {
    super.act(delta);

    if (this.currentAnimation == null || !this.animationFrames.containsKey(this.currentAnimation)) {
      return;
    }

    // Decide qual animação usar: se for pra esperar, continua usando a última até terminar
    String animationToUse = this.waitToSwitch && !this.currentAnimation.equals(this.lastAnimation)
        ? this.lastAnimation
        : this.currentAnimation;

    List<TextureRegion> frames = this.animationFrames.get(animationToUse);

    this.frameCounter++;

    if (this.frameCounter >= this.ticksPerFrame) {
      this.frameCounter = 0;
      boolean animationFinished = false;

      this.currentFrame++;

      if (this.currentFrame >= frames.size()) {
        this.currentFrame = 0;
        animationFinished = true;

        // Se terminou a animação, verifica se precisa trocar
        if (this.waitToSwitch && !this.currentAnimation.equals(this.lastAnimation)) {
          this.lastAnimation = this.currentAnimation;
        }
      }

      // Atualiza o frame
      super.setDrawable(new TextureRegionDrawable(frames.get(this.currentFrame)));

      if (animationFinished) {
        if (super.isDeath()) {
          this.setDeathAnimation();
        } else if (animationToUse.equalsIgnoreCase("attack") || animationToUse.equalsIgnoreCase("atk")) {
          this.setIdleAnimation();
        }
      }
    }
  }

  public List<String> getAnimationOptions() {
    return this.animationOptions;
  }

  public String getCurrentAnimation() {
    return this.currentAnimation;
  }

  public void setCurrentAnimation(String currentAnimation) {
    if (this.animationOptions.contains(currentAnimation)) {
      this.currentAnimation = currentAnimation;
    } else {
      System.err.println(
          "Unable to load animation " + currentAnimation + ". Options: " + String.join(",", this.animationOptions)
      );
    }
  }

//  public Map<String, List<TextureRegion>> getAnimationFrames() {
//    return this.animationFrames;
//  }

  public int getTicksPerFrame() {
    return this.ticksPerFrame;
  }

  public boolean getWaitToSwitch() {
    return this.waitToSwitch;
  }

  public void setWaitToSwitch(boolean waitToSwitch) {
    this.waitToSwitch = waitToSwitch;
  }

}
