package com.kendao.libgdx.scenes.scene2d.ui;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class CustomCharacterImage extends CustomImage {
  public CustomCharacterImage(Texture texture) {
    super(texture);
  }

  public CustomCharacterImage(Texture texture, int x, int y) {
    super(texture, x, y);
  }

  public CustomCharacterImage(Texture texture, int x, int y, int width, int height) {
    super(texture, x, y, width, height);
  }

  public CustomCharacterImage(Texture texture, int x, int y, int width, int height, int originAlignment, float amountInDegrees) {
    super(texture, x, y, width, height, originAlignment, amountInDegrees);
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

  public CustomCharacterImage(TextureRegion textureRegion, int x, int y, int width, int height, int originAlignment, float amountInDegrees) {
    super(textureRegion, x, y, width, height, originAlignment, amountInDegrees);
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

  public CustomCharacterImage(Color color, int x, int y, int width, int height, int originAlignment, float amountInDegrees) {
    super(color, x, y, width, height, originAlignment, amountInDegrees);
  }

  public void wasAttacked() {
    // do nothing by default, override this method!
  }
}
