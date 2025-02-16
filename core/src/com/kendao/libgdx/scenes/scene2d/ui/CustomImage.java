package com.kendao.libgdx.scenes.scene2d.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.FileTextureData;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.badlogic.gdx.utils.Align;
import com.kendao.libgdx.graphics.CustomPixmap;
import com.kendao.libgdx.listener.CustomGameListener;
import com.kendao.libgdx.util.CustomCoordinatesUtil;
import com.kendao.libgdx.util.CustomStringUtil;
import com.kendao.libgdx.util.dto.CustomPair;

public class CustomImage extends Image {
  private String texturePath = null;
  private long customX = 0, customY = 0, customZ = 0;

  public CustomImage(Texture texture) {
    super(texture);
    this.updateTexturePath(texture);
    super.setOrigin(Align.center);
  }

  public CustomImage(Texture texture, int x, int y) {
    super(texture);
    this.updateTexturePath(texture);
    super.setPosition(x, y);
    super.setOrigin(Align.center);
  }

  public CustomImage(Texture texture, int x, int y, int width, int height) {
    super(texture);
    this.updateTexturePath(texture);

    super.setPosition(x, y);

    if (width > 0 && height > 0) {
      super.setSize(width, height);
    }

    super.setOrigin(Align.center);
  }

  public CustomImage(Texture texture, int x, int y, int width, int height, int originAlignment, float amountInDegrees) {
    super(texture);
    this.updateTexturePath(texture);

    super.setPosition(x, y);

    if (width > 0 && height > 0) {
      super.setSize(width, height);
    }

    super.setOrigin(originAlignment);
    super.rotateBy(amountInDegrees);
  }

  public CustomImage(TextureRegion textureRegion) {
    super(textureRegion);
    super.setOrigin(Align.center);
  }

  public CustomImage(TextureRegion textureRegion, int x, int y) {
    super(textureRegion);
    super.setPosition(x, y);
    super.setOrigin(Align.center);
  }

  public CustomImage(TextureRegion textureRegion, int x, int y, int width, int height) {
    super(textureRegion);

    super.setPosition(x, y);

    if (width > 0 && height > 0) {
      super.setSize(width, height);
    }

    super.setOrigin(Align.center);
  }

  public CustomImage(TextureRegion textureRegion, int x, int y, int width, int height, int originAlignment, float amountInDegrees) {
    super(textureRegion);

    super.setPosition(x, y);

    if (width > 0 && height > 0) {
      super.setSize(width, height);
    }

    super.setOrigin(originAlignment);
    super.rotateBy(amountInDegrees);
  }

  public CustomImage(Color color) {
    super(new Texture(new CustomPixmap(color, ((CustomGameListener) Gdx.app.getApplicationListener()).getFullWidth(), ((CustomGameListener) Gdx.app.getApplicationListener()).getFullHeight())));
    super.setOrigin(Align.center);
  }

  public CustomImage(Color color, int x, int y) {
    super(new Texture(new CustomPixmap(color, ((CustomGameListener) Gdx.app.getApplicationListener()).getFullWidth(), ((CustomGameListener) Gdx.app.getApplicationListener()).getFullHeight())));
    super.setPosition(x, y);
    super.setOrigin(Align.center);
  }

  public CustomImage(Color color, int x, int y, int width, int height) {
    super(new Texture(new CustomPixmap(color, width, height)));
    super.setPosition(x, y);
    super.setOrigin(Align.center);
  }

  public CustomImage(Color color, int x, int y, int width, int height, int originAlignment, float amountInDegrees) {
    super(new Texture(new CustomPixmap(color, width, height)));
    super.setPosition(x, y);
    super.setOrigin(originAlignment);
    super.rotateBy(amountInDegrees);
  }

  public void updateDrawable(Texture texture) {
    super.setDrawable(
        new SpriteDrawable(
            new Sprite(
                texture
            )
        )
    );
    this.updateTexturePath(texture);
  }

  public void updateDrawable(TextureRegion textureRegion) {
    super.setDrawable(
        new SpriteDrawable(
            new Sprite(
                textureRegion
            )
        )
    );
    this.updateTexturePath(null);
  }

  public void updateDrawable(Image image) {
    super.setDrawable(
        image.getDrawable()
    );
    this.updateTexturePath(null);
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
    if (CustomStringUtil.hasValue(tooltipText)) {
      super.addListener(new CustomTooltip(tooltipText));
    }
  }

  public void setRotation(float amountInDegrees, int align) {
    super.setOrigin(align);
    super.setRotation(amountInDegrees);
  }

  public void rotateBy(float amountInDegrees, int align) {
    super.setOrigin(align);
    super.rotateBy(amountInDegrees);
  }

  public long getCustomX() {
    return this.customX;
  }

  public void setCustomX(long customX) {
    this.customX = customX;
  }

  public long getCustomY() {
    return this.customY;
  }

  public void setCustomY(long customY) {
    this.customY = customY;
  }

  public long getCustomZ() {
    return this.customZ;
  }

  public void setCustomZ(long customZ) {
    this.customZ = customZ;
  }

  public void setCustomPosition(long customX, long customY) {
    this.customX = customX;
    this.customY = customY;
  }

  public void setCustomPosition(long customX, long customY, long customZ) {
    this.customX = customX;
    this.customY = customY;
    this.customZ = customZ;
  }

  public CustomPair<Long, Long> getCustomImagePositionBySize() {
    return CustomCoordinatesUtil.getCustomPositionByBlockSize(
        (int) super.getX(), (int) super.getY(), (int) super.getWidth(), (int) super.getHeight()
    );
  }

  public void updateCustomImagePositionBySize() {
    CustomPair<Long, Long> position = this.getCustomImagePositionBySize();
    this.setCustomPosition(position.getFirstValue(), position.getSecondValue());
  }

  private void updateTexturePath(Texture texture) {
    if (texture != null && texture.getTextureData() instanceof FileTextureData) {
      this.texturePath = ((FileTextureData) texture.getTextureData()).getFileHandle().path();
    } else {
      this.texturePath = null;
    }
  }

  public void executePulseAnimation(boolean forever) {
    if (forever) {
      super.addAction(Actions.forever(
          Actions.sequence(
              Actions.scaleTo(1.1f, 1.1f, 0.5f),
              Actions.scaleTo(1.0f, 1.0f, 0.5f)
          )
      ));
    } else {
      super.addAction(
          Actions.sequence(
              Actions.scaleTo(1.1f, 1.1f, 0.5f),
              Actions.scaleTo(1.0f, 1.0f, 0.5f)
          )
      );
    }
  }

  public void executeRotationAnimation(boolean forever) {
    if (forever) {
      super.addAction(Actions.forever(
          Actions.rotateBy(360, 2)
      ));
    } else {
      super.addAction(
          Actions.rotateBy(360, 2)
      );
    }
  }

  public void executeFadeAnimation(boolean forever) {
    if (forever) {
      super.addAction(Actions.forever(
          Actions.sequence(
              Actions.alpha(0.25f, 0.25f),
              Actions.alpha(1f, 0.25f),
              Actions.delay(0.5f)
          )
      ));
    } else {
      super.addAction(
          Actions.sequence(
              Actions.alpha(0.25f, 0.25f),
              Actions.alpha(1f, 0.25f)
          )
      );
    }
  }

  public void executeBounceAnimation(boolean forever) {
    if (forever) {
      super.addAction(Actions.forever(
          Actions.sequence(
              Actions.moveBy(0, 20, 0.3f),
              Actions.moveBy(0, -20, 0.3f, Interpolation.bounce),
              Actions.delay(0.5f)
          )
      ));
    } else {
      super.addAction(
          Actions.sequence(
              Actions.moveBy(0, 20, 0.3f),
              Actions.moveBy(0, -20, 0.3f, Interpolation.bounce)
          )
      );
    }
  }

  public String getTexturePath() {
    return this.texturePath;
  }

  public String getId() {
    return super.getName();
  }

  public void setId(String id) {
    super.setName(id);
  }

  /**
   * @deprecated Use {@link #getId()} method
   */
  @Deprecated
  @Override
  public String getName() {
    return this.getId();
  }

  /**
   * @deprecated Use {@link #setId(String name)} method
   */
  @Deprecated
  @Override
  public void setName(String name) {
    this.setId(name);
  }
}
