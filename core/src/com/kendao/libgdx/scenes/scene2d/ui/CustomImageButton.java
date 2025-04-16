package com.kendao.libgdx.scenes.scene2d.ui;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.FileTextureData;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.badlogic.gdx.utils.Align;
import com.kendao.libgdx.assets.CustomAssetManager;
import com.kendao.libgdx.graphics.CustomColor;
import com.kendao.libgdx.storage.CustomPreferences;
import com.kendao.libgdx.util.CustomCoordinatesUtil;
import com.kendao.libgdx.util.CustomStringUtil;
import com.kendao.libgdx.util.dto.CustomPair;

public class CustomImageButton extends ImageButton {
  private int defaultOrigin = Align.center;

  private String imageTexturePath = null;
  private long customX = 0, customY = 0, customZ = 0;
  private boolean enableSound = true;

  public CustomImageButton(Image image, EventListener listener) {
    super(image.getDrawable());
    super.setTransform(true);
    this.setOrigin(Align.center);
    this.addListeners(listener);
  }

  public CustomImageButton(Image image, int x, int y, EventListener listener) {
    super(image.getDrawable());

    super.setPosition(x, y);

    super.setTransform(true);
    this.setOrigin(Align.center);

    this.addListeners(listener);
  }

  public CustomImageButton(Image image, int x, int y, int width, int height, EventListener listener) {
    super(image.getDrawable());

    super.setPosition(x, y);

    if (width > 0 && height > 0) {
      super.setSize(width, height);
    }

    super.setTransform(true);
    this.setOrigin(Align.center);

    this.addListeners(listener);
  }

  public CustomImageButton(Image image, int x, int y, int width, int height, int originAlignment, float amountInDegrees, EventListener listener) {
    super(image.getDrawable());

    super.setPosition(x, y);

    if (width > 0 && height > 0) {
      super.setSize(width, height);
    }

    super.setTransform(true);
    this.setOrigin(originAlignment);
    super.rotateBy(amountInDegrees);

    this.addListeners(listener);
  }

  public CustomImageButton(Texture texture, EventListener listener) {
    super(new Image(texture).getDrawable());
    this.updateImageTexturePath(texture);
    super.setTransform(true);
    this.setOrigin(Align.center);
    this.addListeners(listener);
  }

  public CustomImageButton(Texture texture, int x, int y, EventListener listener) {
    super(new Image(texture).getDrawable());
    this.updateImageTexturePath(texture);

    super.setPosition(x, y);

    super.setTransform(true);
    this.setOrigin(Align.center);

    this.addListeners(listener);
  }

  public CustomImageButton(Texture texture, int x, int y, int width, int height, EventListener listener) {
    super(new Image(texture).getDrawable());
    this.updateImageTexturePath(texture);

    super.setPosition(x, y);

    if (width > 0 && height > 0) {
      super.setSize(width, height);
    }

    super.setTransform(true);
    this.setOrigin(Align.center);

    this.addListeners(listener);
  }

  public CustomImageButton(Texture texture, int x, int y, int width, int height, int originAlignment, float amountInDegrees, EventListener listener) {
    super(new Image(texture).getDrawable());
    this.updateImageTexturePath(texture);

    super.setPosition(x, y);

    if (width > 0 && height > 0) {
      super.setSize(width, height);
    }

    super.setTransform(true);
    this.setOrigin(originAlignment);
    super.rotateBy(amountInDegrees);

    this.addListeners(listener);
  }

  public CustomImageButton(Texture firstTexture, Texture secondTexture, int x, int y, int width, int height, EventListener listener) {
    super(
        new Image(firstTexture).getDrawable(),
        null,
        new Image(secondTexture).getDrawable()
    );

    super.setPosition(x, y);

    if (width > 0 && height > 0) {
      super.setSize(width, height);
    }

    super.setTransform(true);
    this.setOrigin(Align.center);

    this.addListeners(listener);
  }

  public CustomImageButton(Texture firstTexture, Texture secondTexture, int x, int y, int width, int height, int originAlignment, float amountInDegrees, EventListener listener) {
    super(
        new Image(firstTexture).getDrawable(),
        null,
        new Image(secondTexture).getDrawable()
    );

    super.setPosition(x, y);

    if (width > 0 && height > 0) {
      super.setSize(width, height);
    }

    super.setTransform(true);
    this.setOrigin(originAlignment);
    super.rotateBy(amountInDegrees);

    this.addListeners(listener);
  }

  public CustomImageButton(TextureRegion textureRegion, EventListener listener) {
    super(new Image(textureRegion).getDrawable());

    super.setTransform(true);
    this.setOrigin(Align.center);

    this.addListeners(listener);
  }

  public CustomImageButton(TextureRegion textureRegion, int x, int y, EventListener listener) {
    super(new Image(textureRegion).getDrawable());

    super.setPosition(x, y);

    super.setTransform(true);
    this.setOrigin(Align.center);

    this.addListeners(listener);
  }

  public CustomImageButton(TextureRegion textureRegion, int x, int y, int width, int height, EventListener listener) {
    super(new Image(textureRegion).getDrawable());

    super.setPosition(x, y);

    if (width > 0 && height > 0) {
      super.setSize(width, height);
    }

    super.setTransform(true);
    this.setOrigin(Align.center);

    this.addListeners(listener);
  }

  public CustomImageButton(TextureRegion textureRegion, int x, int y, int width, int height, int originAlignment, float amountInDegrees, EventListener listener) {
    super(new Image(textureRegion).getDrawable());

    super.setPosition(x, y);

    if (width > 0 && height > 0) {
      super.setSize(width, height);
    }

    super.setTransform(true);
    this.setOrigin(originAlignment);
    super.rotateBy(amountInDegrees);

    this.addListeners(listener);
  }

  public CustomImageButton(TextureRegion firstTextureRegion, TextureRegion secondTextureRegion, int x, int y, int width, int height, EventListener listener) {
    super(
        new Image(firstTextureRegion).getDrawable(),
        null,
        new Image(secondTextureRegion).getDrawable()
    );

    super.setPosition(x, y);

    if (width > 0 && height > 0) {
      super.setSize(width, height);
    }

    super.setTransform(true);
    this.setOrigin(Align.center);

    this.addListeners(listener);
  }

  public CustomImageButton(TextureRegion firstTextureRegion, TextureRegion secondTextureRegion, int x, int y, int width, int height, int originAlignment, float amountInDegrees, EventListener listener) {
    super(
        new Image(firstTextureRegion).getDrawable(),
        null,
        new Image(secondTextureRegion).getDrawable()
    );

    super.setPosition(x, y);

    if (width > 0 && height > 0) {
      super.setSize(width, height);
    }

    super.setTransform(true);
    this.setOrigin(originAlignment);
    super.rotateBy(amountInDegrees);

    this.addListeners(listener);
  }

  private void addListeners(EventListener newListener) {
    super.addListener(new ClickListener() {
      @Override
      public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor) {
        if (!isDisabled()) {
          getColor().a = 0.8f;
        }
      }

      @Override
      public void exit(InputEvent event, float x, float y, int pointer, Actor toActor) {
        if (!isDisabled()) {
          getColor().a = 1f;
        }
      }

      @Override
      public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
        if (!isDisabled()) {
          setColor(CustomColor.DISABLED);

          if (enableSound && CustomPreferences.getInstance().isAudioEnabled()) {
            CustomAssetManager.getInstance().getConfirmSound().play();
          }
        }

        return true;
      }

      @Override
      public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
        if (!isDisabled()) {
          setColor(CustomColor.ENABLED);
        }
      }
    });

    if (newListener != null) {
      super.addListener(newListener);
    }
  }

  @Override
  public void setDisabled(boolean isDisabled) {
    super.setColor(isDisabled ? CustomColor.DISABLED : CustomColor.ENABLED);
    super.setDisabled(isDisabled);
  }

  public void addTooltip(String tooltipText) {
    if (CustomStringUtil.hasValue(tooltipText)) {
      super.addListener(new CustomTooltip(tooltipText));
    }
  }

  public void setEnableSound(boolean enableSound) {
    this.enableSound = enableSound;
  }

  public void setRotation(float amountInDegrees, int align) {
    this.setOrigin(align);
    super.setRotation(amountInDegrees);
  }

  public void rotateBy(float amountInDegrees, int align) {
    this.setOrigin(align);
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

  public void updateImageDrawable(Texture texture) {
    super.getStyle().imageUp = new SpriteDrawable(
        new Sprite(texture)
    );
    this.updateImageTexturePath(texture);
  }

  public void updateImageDrawable(Texture firstTexture, Texture secondTexture) {
    super.getStyle().imageUp = new SpriteDrawable(
        new Sprite(firstTexture)
    );
    super.getStyle().imageChecked = new SpriteDrawable(
        new Sprite(secondTexture)
    );
    this.updateImageTexturePath(firstTexture);
  }

  public void updateImageDrawable(TextureRegion textureRegion) {
    super.getStyle().imageUp = new SpriteDrawable(
        new Sprite(textureRegion)
    );
    this.updateImageTexturePath(null);
  }

  public void updateImageDrawable(TextureRegion firstTextureRegion, TextureRegion secondTextureRegion) {
    super.getStyle().imageUp = new SpriteDrawable(
        new Sprite(firstTextureRegion)
    );
    super.getStyle().imageChecked = new SpriteDrawable(
        new Sprite(secondTextureRegion)
    );
    this.updateImageTexturePath(null);
  }

  public void updateImageDrawable(Image image) {
    super.getStyle().imageUp = image.getDrawable();
    this.updateImageTexturePath(null);
  }

  public void updateImageDrawable(Image firstImage, Image secondImage) {
    super.getStyle().imageUp = firstImage.getDrawable();
    super.getStyle().imageChecked = secondImage.getDrawable();
    this.updateImageTexturePath(null);
  }

  private void updateImageTexturePath(Texture texture) {
    if (texture != null && texture.getTextureData() instanceof FileTextureData) {
      this.imageTexturePath = ((FileTextureData) texture.getTextureData()).getFileHandle().path();
    } else {
      this.imageTexturePath = null;
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

  public void executeRotateRightAnimation(boolean forever) {
    Action rotateAction = Actions.rotateBy(360f, 2f); // horário
    if (forever) {
      super.addAction(Actions.forever(rotateAction));
    } else {
      super.addAction(rotateAction);
    }
  }

  public void executeRotateLeftAnimation(boolean forever) {
    Action rotateAction = Actions.rotateBy(-360f, 2f); // anti-horário
    if (forever) {
      super.addAction(Actions.forever(rotateAction));
    } else {
      super.addAction(rotateAction);
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

  public void executeFlipHorizontalAnimation(boolean forever) {
    Action flipAction = Actions.sequence(
        Actions.run(() -> setScaleX(-1f)),
        Actions.delay(0.25f),
        Actions.run(() -> setScaleX(1f)),
        Actions.delay(0.25f)
    );

    if (forever) {
      super.addAction(Actions.forever(flipAction));
    } else {
      super.addAction(flipAction);
    }
  }

  public void executeFlipVerticalAnimation(boolean forever) {
    Action flipAction = Actions.sequence(
        Actions.run(() -> setScaleY(-1f)),
        Actions.delay(0.25f),
        Actions.run(() -> setScaleY(1f)),
        Actions.delay(0.25f)
    );

    if (forever) {
      super.addAction(Actions.forever(flipAction));
    } else {
      super.addAction(flipAction);
    }
  }

  public String getImageTexturePath() {
    return this.imageTexturePath;
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

  @Override
  public void setOrigin(int alignment) {
    super.setOrigin(alignment);
    this.defaultOrigin = alignment;
  }

  @Override
  public void setSize(float width, float height) {
    super.setSize(width, height);
    super.setOrigin(this.defaultOrigin);
  }

  @Override
  public void setWidth(float width) {
    super.setWidth(width);
    super.setOrigin(this.defaultOrigin);
  }

  @Override
  public void setHeight(float height) {
    super.setHeight(height);
    super.setOrigin(this.defaultOrigin);
  }
}
