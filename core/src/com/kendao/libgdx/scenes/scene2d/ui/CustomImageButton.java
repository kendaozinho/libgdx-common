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

public class CustomImageButton extends ImageButton {
  public CustomImageButton(Image image, EventListener listener) {
    super(image.getDrawable());
    this.addListeners(listener, true);
  }

  public CustomImageButton(Image image, int x, int y, EventListener listener) {
    super(image.getDrawable());

    super.setPosition(x, y);

    this.addListeners(listener, true);
  }

  public CustomImageButton(Image image, int x, int y, float width, float height, EventListener listener) {
    super(image.getDrawable());

    super.setPosition(x, y);

    if (width > 0 && height > 0) {
      super.setSize(width, height);
    }

    this.addListeners(listener, true);
  }

  public CustomImageButton(Texture texture, EventListener listener) {
    super(new Image(texture).getDrawable());
    this.addListeners(listener, true);
  }

  public CustomImageButton(Texture texture, int x, int y, EventListener listener) {
    super(new Image(texture).getDrawable());

    super.setPosition(x, y);
    this.addListeners(listener, true);
  }

  public CustomImageButton(Texture texture, int x, int y, float width, float height, EventListener listener) {
    super(new Image(texture).getDrawable());

    super.setPosition(x, y);

    if (width > 0 && height > 0) {
      super.setSize(width, height);
    }

    this.addListeners(listener, true);
  }

  public CustomImageButton(Texture texture, int x, int y, float width, float height, boolean enableSound, EventListener listener) {
    super(new Image(texture).getDrawable());

    super.setPosition(x, y);

    if (width > 0 && height > 0) {
      super.setSize(width, height);
    }

    this.addListeners(listener, enableSound);
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

    this.addListeners(listener, true);
  }

  public CustomImageButton(Texture firstTexture, Texture secondTexture, int x, int y, float width, float height, boolean enableSound, EventListener listener) {
    super(
        new Image(firstTexture).getDrawable(),
        null,
        new Image(secondTexture).getDrawable()
    );

    super.setPosition(x, y);

    if (width > 0 && height > 0) {
      super.setSize(width, height);
    }

    this.addListeners(listener, enableSound);
  }

  public CustomImageButton(TextureRegion textureRegion, EventListener listener) {
    super(new Image(textureRegion).getDrawable());
    this.addListeners(listener, true);
  }

  public CustomImageButton(TextureRegion textureRegion, int x, int y, EventListener listener) {
    super(new Image(textureRegion).getDrawable());

    super.setPosition(x, y);

    this.addListeners(listener, true);
  }

  public CustomImageButton(TextureRegion textureRegion, int x, int y, float width, float height, EventListener listener) {
    super(new Image(textureRegion).getDrawable());

    super.setPosition(x, y);

    if (width > 0 && height > 0) {
      super.setSize(width, height);
    }

    this.addListeners(listener, true);
  }

  public CustomImageButton(TextureRegion textureRegion, int x, int y, float width, float height, boolean enableSound, EventListener listener) {
    super(new Image(textureRegion).getDrawable());

    super.setPosition(x, y);

    if (width > 0 && height > 0) {
      super.setSize(width, height);
    }

    this.addListeners(listener, enableSound);
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

    this.addListeners(listener, true);
  }

  public CustomImageButton(TextureRegion firstTextureRegion, TextureRegion secondTextureRegion, int x, int y, float width, float height, boolean enableSound, EventListener listener) {
    super(
        new Image(firstTextureRegion).getDrawable(),
        null,
        new Image(secondTextureRegion).getDrawable()
    );

    super.setPosition(x, y);

    if (width > 0 && height > 0) {
      super.setSize(width, height);
    }

    this.addListeners(listener, enableSound);
  }

  private void addListeners(EventListener newListener, final Boolean enableSound) {
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
    if (tooltipText != null && !tooltipText.trim().isEmpty()) {
      super.addListener(new CustomTooltip(tooltipText));
    }
  }
}
