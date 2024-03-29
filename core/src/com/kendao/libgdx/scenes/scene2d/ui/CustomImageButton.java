package com.kendao.libgdx.scenes.scene2d.ui;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.kendao.libgdx.assets.CustomAssetManager;
import com.kendao.libgdx.graphics.CustomColor;
import com.kendao.libgdx.storage.CustomPreferences;
import com.kendao.libgdx.util.CustomCoordinatesUtil;
import com.kendao.libgdx.util.CustomStringUtil;
import com.kendao.libgdx.util.dto.CustomPair;

public class CustomImageButton extends ImageButton {
  private long customX = 0, customY = 0, customZ = 0;
  private boolean enableSound = true;

  public CustomImageButton(Image image, EventListener listener) {
    super(image.getDrawable());
    this.addListeners(listener);
  }

  public CustomImageButton(Image image, int x, int y, EventListener listener) {
    super(image.getDrawable());

    super.setPosition(x, y);

    this.addListeners(listener);
  }

  public CustomImageButton(Image image, int x, int y, float width, float height, EventListener listener) {
    super(image.getDrawable());

    super.setPosition(x, y);

    if (width > 0 && height > 0) {
      super.setSize(width, height);
    }

    this.addListeners(listener);
  }

  public CustomImageButton(Texture texture, EventListener listener) {
    super(new Image(texture).getDrawable());
    this.addListeners(listener);
  }

  public CustomImageButton(Texture texture, int x, int y, EventListener listener) {
    super(new Image(texture).getDrawable());

    super.setPosition(x, y);
    this.addListeners(listener);
  }

  public CustomImageButton(Texture texture, int x, int y, float width, float height, EventListener listener) {
    super(new Image(texture).getDrawable());

    super.setPosition(x, y);

    if (width > 0 && height > 0) {
      super.setSize(width, height);
    }

    this.addListeners(listener);
  }

  public CustomImageButton(Texture firstTexture, Texture secondTexture, int x, int y, float width, float height, EventListener listener) {
    super(
        new Image(firstTexture).getDrawable(),
        null,
        new Image(secondTexture).getDrawable()
    );

    super.setPosition(x, y);

    if (width > 0 && height > 0) {
      super.setSize(width, height);
    }

    this.addListeners(listener);
  }

  public CustomImageButton(TextureRegion textureRegion, EventListener listener) {
    super(new Image(textureRegion).getDrawable());
    this.addListeners(listener);
  }

  public CustomImageButton(TextureRegion textureRegion, int x, int y, EventListener listener) {
    super(new Image(textureRegion).getDrawable());

    super.setPosition(x, y);

    this.addListeners(listener);
  }

  public CustomImageButton(TextureRegion textureRegion, int x, int y, float width, float height, EventListener listener) {
    super(new Image(textureRegion).getDrawable());

    super.setPosition(x, y);

    if (width > 0 && height > 0) {
      super.setSize(width, height);
    }

    this.addListeners(listener);
  }

  public CustomImageButton(TextureRegion firstTextureRegion, TextureRegion secondTextureRegion, int x, int y, float width, float height, EventListener listener) {
    super(
        new Image(firstTextureRegion).getDrawable(),
        null,
        new Image(secondTextureRegion).getDrawable()
    );

    super.setPosition(x, y);

    if (width > 0 && height > 0) {
      super.setSize(width, height);
    }

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
        super.getX(), super.getY(), (long) super.getWidth(), (long) super.getHeight()
    );
  }

  public void updateCustomImagePositionBySize() {
    CustomPair<Long, Long> position = this.getCustomImagePositionBySize();
    this.setCustomPosition(position.getFirstValue(), position.getSecondValue());
  }
}
