package com.kendao.libgdx.scenes.scene2d.ui;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.kendao.libgdx.assets.CustomAssetManager;
import com.kendao.libgdx.storage.CustomPreferences;
import com.kendao.libgdx.util.CustomStringUtil;

public class CustomTextButton extends TextButton {
  private final Color defaultColor = Color.ROYAL;
  private boolean enableSound = true;

  public CustomTextButton(String text, EventListener listener) {
    super(text, CustomSkin.getInstance());
    super.setColor(this.defaultColor);
    super.setTransform(true);
    super.setOrigin(Align.center);
    this.addListeners(listener);
  }

  public CustomTextButton(String text, int x, int y, EventListener listener) {
    super(text, CustomSkin.getInstance());
    super.setPosition(x, y);
    super.setColor(this.defaultColor);
    super.setTransform(true);
    super.setOrigin(Align.center);
    this.addListeners(listener);
  }

  public CustomTextButton(String text, int x, int y, int width, int height, EventListener listener) {
    super(text, CustomSkin.getInstance());
    super.setPosition(x, y);
    super.setSize(width, height);
    super.setColor(this.defaultColor);
    super.setTransform(true);
    super.setOrigin(Align.center);
    this.addListeners(listener);
  }

  public CustomTextButton(String text, int x, int y, int width, int height, Color color, EventListener listener) {
    super(text, CustomSkin.getInstance());
    super.setPosition(x, y);
    super.setSize(width, height);
    super.setColor(color);
    super.setTransform(true);
    super.setOrigin(Align.center);
    this.addListeners(listener);
  }

  public CustomTextButton(String text, int x, int y, int width, int height, Color color, int originAlignment, float amountInDegrees, EventListener listener) {
    super(text, CustomSkin.getInstance());
    super.setPosition(x, y);
    super.setSize(width, height);
    super.setColor(color);
    super.setTransform(true);
    super.setOrigin(originAlignment);
    super.rotateBy(amountInDegrees);
    this.addListeners(listener);
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
