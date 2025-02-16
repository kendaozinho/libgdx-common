package com.kendao.libgdx.scenes.scene2d.ui;

import com.badlogic.gdx.scenes.scene2d.ui.TextTooltip;

public class CustomTooltip extends TextTooltip {
  public CustomTooltip(String text) {
    super(text, CustomSkin.getInstance());
    super.setInstant(true);
  }

  public void setText(String text) {
    super.getContainer().getActor().setText(text);
  }
}
