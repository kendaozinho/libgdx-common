package com.kendao.libgdx.scenes.scene2d.ui;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

import java.util.List;

public class CustomRadioButton extends CustomTable {
  private final List<CustomCheckBox> checkBoxes;

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
          checkBoxes.stream().filter(cb2 -> !cb2.equals(cb)).forEach(cb2 -> cb2.setChecked(false));
        }

        if (checkBoxes.stream().noneMatch(Button::isChecked)) {
          cb.setChecked(true);
        }
      }
    }));

    if (checkBoxes.size() == 2) {
      super.addRow(checkBoxes.get(0), checkBoxes.get(1));
    } else {
      checkBoxes.forEach(super::addRow);
    }

    this.checkBoxes = checkBoxes;
  }

  public List<CustomCheckBox> getCheckBoxes() {
    return this.checkBoxes;
  }

  public CustomCheckBox getCheckedBox() {
    return this.checkBoxes.stream().filter(Button::isChecked).findFirst().orElse(null);
  }
}
