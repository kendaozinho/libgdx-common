package com.kendao.libgdx.scenes.scene2d.ui;

import com.badlogic.gdx.graphics.Color;
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

  public enum Sizes {
    EXTRA_SMALL, SMALL, MEDIUM, LARGE, EXTRA_LARGE
  }
}
