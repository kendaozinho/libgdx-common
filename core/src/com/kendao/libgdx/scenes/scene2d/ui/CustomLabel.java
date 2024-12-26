package com.kendao.libgdx.scenes.scene2d.ui;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

public class CustomLabel extends Label {
  public CustomLabel() {
    super("", CustomSkin.getInstance());

    this.setFontSize(Sizes.SMALL);
  }

  public CustomLabel(CharSequence text) {
    super(text, CustomSkin.getInstance());

    this.setFontSize(Sizes.SMALL);
  }

  public CustomLabel(CharSequence text, Color color) {
    super(text, CustomSkin.getInstance());

    if (color != null) {
      super.setColor(color);
    }

    this.setFontSize(Sizes.SMALL);
  }

  public CustomLabel(CharSequence text, Sizes fontSize) {
    super(text, CustomSkin.getInstance());

    this.setFontSize(fontSize);
  }

  public CustomLabel(CharSequence text, Color color, Sizes fontSize) {
    super(text, CustomSkin.getInstance());

    if (color != null) {
      super.setColor(color);
    }

    this.setFontSize(fontSize);
  }

  public void setFontSize(Sizes fontSize) {
    switch (fontSize) {
      case EXTRA_SMALL:
        super.setFontScale(0.70f);
        break;
      case SMALL:
        super.setFontScale(1.00f);
        break;
      case MEDIUM:
        super.setFontScale(1.40f);
        break;
      case LARGE:
        super.setFontScale(2.00f);
        break;
      case EXTRA_LARGE:
        super.setFontScale(2.40f);
        break;
    }
  }

  public void clearText() {
    super.setText("");
  }

  public void hide() {
    super.getColor().a = 0f;
  }

  public void show() {
    super.getColor().a = 1f;
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

  public enum Sizes {
    EXTRA_SMALL, SMALL, MEDIUM, LARGE, EXTRA_LARGE
  }
}
