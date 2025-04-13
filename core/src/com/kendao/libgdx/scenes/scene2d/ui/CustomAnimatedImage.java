package com.kendao.libgdx.scenes.scene2d.ui;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Array;

public class CustomAnimatedImage extends CustomImage {
  private final Array<TextureRegion> frames;

  private final int cols;
  private final int rows;
  private final int ticksPerFrame; // how many renders to change the frame

  private int frameCounter = 0;
  private int currentFrame = 0;

  public CustomAnimatedImage(Texture spriteSheet, int cols, int rows, int ticksPerFrame) {
    super(
        TextureRegion.split(
            spriteSheet,
            spriteSheet.getWidth() / cols,
            spriteSheet.getHeight() / rows
        )[0][0],
        0, 0,
        spriteSheet.getWidth() / cols, spriteSheet.getHeight() / rows
    );

    this.cols = cols;
    this.rows = rows;
    this.ticksPerFrame = ticksPerFrame;

    this.frames = this.extractFrames(spriteSheet, cols, rows);
  }

  public CustomAnimatedImage(Texture spriteSheet, int cols, int rows, int x, int y, int width, int height, int ticksPerFrame) {
    super(
        TextureRegion.split(
            spriteSheet,
            spriteSheet.getWidth() / cols,
            spriteSheet.getHeight() / rows
        )[0][0],
        x, y,
        width, height
    );

    this.cols = cols;
    this.rows = rows;
    this.ticksPerFrame = ticksPerFrame;

    this.frames = this.extractFrames(spriteSheet, cols, rows);
  }

  private Array<TextureRegion> extractFrames(Texture spriteSheet, int cols, int rows) {
    TextureRegion[][] split = TextureRegion.split(
        spriteSheet,
        spriteSheet.getWidth() / cols,
        spriteSheet.getHeight() / rows
    );

    Array<TextureRegion> flat = new Array<>(cols * rows);
    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < cols; col++) {
        flat.add(split[row][col]);
      }
    }

    return flat;
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

  public int getCols() {
    return this.cols;
  }

  public int getRows() {
    return this.rows;
  }
}
