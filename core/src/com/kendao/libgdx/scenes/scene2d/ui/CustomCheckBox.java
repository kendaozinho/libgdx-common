package com.kendao.libgdx.scenes.scene2d.ui;

import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;

public class CustomCheckBox extends CheckBox {
  public CustomCheckBox(String text, boolean checked) {
    super(text, CustomSkin.getInstance());

    super.setChecked(checked);
    super.getCells().get(0).size(25, 25);
  }
}
