package com.kendao.libgdx.scenes.scene2d.ui;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Array;
import com.kendao.libgdx.dragonbones.dto.DragonBonesTextureDto;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CustomAnimatedImage extends CustomImage {
  private final Array<TextureRegion> frames;

  private final int ticksPerFrame; // how many renders to change the frame

  private int frameCounter = 0;
  private int currentFrame = 0;

  public CustomAnimatedImage(Texture spriteSheet, int cols, int rows, int frameQuantity, int ticksPerFrame) {
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

    this.frames = this.extractFrames(spriteSheet, cols, rows, frameQuantity);
  }

  public CustomAnimatedImage(Texture spriteSheet, int cols, int rows, int x, int y, int width, int height, int frameQuantity, int ticksPerFrame) {
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

    this.frames = this.extractFrames(spriteSheet, cols, rows, frameQuantity);
  }


  public CustomAnimatedImage(Texture spriteSheet, DragonBonesTextureDto textureDto, int ticksPerFrame) {
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

    this.frames = this.extractFrames(spriteSheet, textureDto);
  }

  public CustomAnimatedImage(Texture spriteSheet, DragonBonesTextureDto textureDto, int x, int y, int width, int height, int ticksPerFrame) {
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

    this.frames = this.extractFrames(spriteSheet, textureDto);
  }

  private Array<TextureRegion> extractFrames(Texture spriteSheet, int cols, int rows, int frameQuantity) {
    TextureRegion[][] dividedTextureRegions = TextureRegion.split(
        spriteSheet,
        spriteSheet.getWidth() / cols,
        spriteSheet.getHeight() / rows
    );

    Array<TextureRegion> textureRegions = new Array<>(frameQuantity);
    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < cols; col++) {
        textureRegions.add(dividedTextureRegions[row][col]);

        if (textureRegions.size >= frameQuantity) {
          break;
        }
      }

      if (textureRegions.size >= frameQuantity) {
        break;
      }
    }

    return textureRegions;
  }

  private Array<TextureRegion> extractFrames(Texture spriteSheet, DragonBonesTextureDto textureDto) {
    Array<TextureRegion> textureRegions = new Array<>();

    List<DragonBonesTextureDto.SubTexture> sortedSubTextures = new ArrayList<>(textureDto.getSubTexture());

    sortedSubTextures.sort(Comparator.comparing(DragonBonesTextureDto.SubTexture::getName));

    for (DragonBonesTextureDto.SubTexture sub : sortedSubTextures) {
      TextureRegion region = new TextureRegion(
          spriteSheet,
          sub.getX(),
          sub.getY(),
          sub.getWidth(),
          sub.getHeight()
      );
      textureRegions.add(region);
    }

    return textureRegions;
  }

  @Override
  public void act(float delta) {
    super.act(delta);

    this.frameCounter++;
    if (this.frameCounter >= this.ticksPerFrame) {
      this.frameCounter = 0;
      this.currentFrame = (this.currentFrame + 1) % this.frames.size;
      super.setDrawable(new TextureRegionDrawable(this.frames.get(this.currentFrame)));
    }
  }
}
