package com.kendao.libgdx.scenes.scene2d.ui;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import java.util.List;

public class CustomRadioButton extends CustomTable {
  public CustomRadioButton(List<CustomCheckBox> checkBoxes) {
    if (checkBoxes.stream().filter(Button::isChecked).count() != 1) {
      for (int i = 0; i < checkBoxes.size(); i++) {
        checkBoxes.get(i).setChecked(i == 0);
      }
    }

    checkBoxes.forEach(cb -> cb.addListener(new ChangeListener() {
      @Override
      public void changed(ChangeEvent event, Actor actor) {
        if (cb.isChecked()) {
          checkBoxes.stream().filter(cbx -> !cbx.equals(cb)).forEach(cbx -> cbx.setChecked(false));
        }
      }
    }));

    for (int i = 0; i < checkBoxes.size(); i++) {
      super.addRow(checkBoxes.get(i));
    }
  }
}
