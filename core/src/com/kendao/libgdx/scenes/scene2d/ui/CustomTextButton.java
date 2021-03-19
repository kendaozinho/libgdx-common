package com.kendao.libgdx.scenes.scene2d.ui;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.kendao.libgdx.assets.CustomAssetManager;
import com.kendao.libgdx.storage.CustomPreferences;

public class CustomTextButton extends TextButton {
  private final Color defaultColor = Color.ROYAL;

  public CustomTextButton(String text, EventListener listener) {
    super(text, CustomSkin.getInstance());
    super.setColor(this.defaultColor);
    this.addListeners(listener, true);
  }

  public CustomTextButton(String text, int x, int y, EventListener listener) {
    super(text, CustomSkin.getInstance());
    super.setPosition(x, y);
    super.setColor(this.defaultColor);
    this.addListeners(listener, true);
  }

  public CustomTextButton(String text, int x, int y, float width, float height, EventListener listener) {
    super(text, CustomSkin.getInstance());
    super.setPosition(x, y);
    super.setSize(width, height);
    super.setColor(this.defaultColor);
    this.addListeners(listener, true);
  }

  public CustomTextButton(String text, int x, int y, float width, float height, Color color, EventListener listener) {
    super(text, CustomSkin.getInstance());
    super.setPosition(x, y);
    super.setSize(width, height);
    super.setColor(color);
    this.addListeners(listener, true);
  }

  public CustomTextButton(String text, int x, int y, float width, float height, Color color, Boolean enableSound, EventListener listener) {
    super(text, CustomSkin.getInstance());
    super.setPosition(x, y);
    super.setSize(width, height);
    super.setColor(color);
    this.addListeners(listener, enableSound);
  }

  @Override
  public void setDisabled(boolean isDisabled) {
    super.setDisabled(isDisabled);
    super.setTouchable(isDisabled ? Touchable.disabled : Touchable.enabled);
  }

  @Override
  public void setTouchable(Touchable touchable) {
    super.setTouchable(touchable);
    if (touchable.equals(Touchable.enabled) || touchable.equals(Touchable.disabled)) {
      super.setDisabled(touchable.equals(Touchable.disabled));
    }
  }

  @Override
  public String getText() {
    return super.getText().toString();
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
          // setColor(CustomColor.DISABLED);

          if (enableSound && CustomPreferences.getInstance().isAudioEnabled()) {
            CustomAssetManager.getInstance().getConfirmSound().play();
          }
        }

        return true;
      }

      @Override
      public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
        if (!isDisabled()) {
          // setColor(CustomColor.ENABLED);
        }
      }
    });

    if (newListener != null) {
      super.addListener(newListener);
    }
  }

  public void addTooltip(String tooltipText) {
    if (tooltipText != null && !tooltipText.trim().isEmpty()) {
      super.addListener(new CustomTooltip(tooltipText));
    }
  }
}
