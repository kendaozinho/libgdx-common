package com.kendao.libgdx.scenes.scene2d.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.kendao.libgdx.graphics.CustomPixmap;
import com.kendao.libgdx.listener.CustomGameListener;

public class CustomImage extends Image {
  public CustomImage(Texture texture) {
    super(texture);
  }

  public CustomImage(Texture texture, float x, float y) {
    super(texture);
    super.setPosition(x, y);
  }

  public CustomImage(Texture texture, float x, float y, float width, float height) {
    super(texture);

    super.setPosition(x, y);

    if (width > 0 && height > 0) {
      super.setSize(width, height);
    }
  }

  public CustomImage(TextureRegion textureRegion) {
    super(textureRegion);
  }

  public CustomImage(TextureRegion textureRegion, float x, float y) {
    super(textureRegion);
    super.setPosition(x, y);
  }

  public CustomImage(TextureRegion textureRegion, float x, float y, float width, float height) {
    super(textureRegion);

    super.setPosition(x, y);

    if (width > 0 && height > 0) {
      super.setSize(width, height);
    }
  }

  public CustomImage(Color color) {
    super(new Texture(new CustomPixmap(color, ((CustomGameListener) Gdx.app.getApplicationListener()).getFullWidth(), ((CustomGameListener) Gdx.app.getApplicationListener()).getFullHeight())));
  }

  public CustomImage(Color color, float x, float y) {
    super(new Texture(new CustomPixmap(color, ((CustomGameListener) Gdx.app.getApplicationListener()).getFullWidth(), ((CustomGameListener) Gdx.app.getApplicationListener()).getFullHeight())));
    super.setPosition(x, y);
  }

  public CustomImage(Color color, float x, float y, int width, int height) {
    super(new Texture(new CustomPixmap(color, width, height)));
    super.setPosition(x, y);
  }

  public void updateDrawable(Texture texture) {
    super.setDrawable(
        new SpriteDrawable(
            new Sprite(
                texture
            )
        )
    );
  }

  public void updateDrawable(TextureRegion textureRegion) {
    super.setDrawable(
        new SpriteDrawable(
            new Sprite(
                textureRegion
            )
        )
    );
  }

  public void updateDrawable(Image image) {
    super.setDrawable(
        image.getDrawable()
    );
  }

  public void show() {
    super.getColor().a = 1f;
  }

  public void hide() {
    super.getColor().a = 0f;
  }

  public Boolean isShown() {
    return super.getColor().a == 1f;
  }

  public Boolean isHidden() {
    return super.getColor().a == 0f;
  }

  public void setOpacity(float opacity) {
    super.getColor().a = opacity;
  }

  public void addTooltip(String tooltipText) {
    if (tooltipText != null && !tooltipText.trim().isEmpty()) {
      super.addListener(new CustomTooltip(tooltipText));
    }
  }
}
