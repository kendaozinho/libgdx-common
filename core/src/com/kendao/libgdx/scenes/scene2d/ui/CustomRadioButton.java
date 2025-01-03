package com.kendao.libgdx.scenes.scene2d.ui;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

import java.util.List;

public class CustomRadioButton extends CustomTable {
  private final List<CustomCheckBox> checkBoxes;

  public CustomRadioButton(List<CustomCheckBox> checkBoxes) {
    this.checkBoxes = this.getFormattedCheckBoxes(checkBoxes, 1);
  }

  public CustomRadioButton(List<CustomCheckBox> checkBoxes, int numberOfColumns) {
    this.checkBoxes = this.getFormattedCheckBoxes(checkBoxes, numberOfColumns);
  }

  public CustomRadioButton(List<CustomCheckBox> checkBoxes, int numberOfColumns, int x, int y) {
    this.checkBoxes = this.getFormattedCheckBoxes(checkBoxes, numberOfColumns);
    super.setPosition(x, y);
  }

  public CustomRadioButton(List<CustomCheckBox> checkBoxes, int numberOfColumns, int x, int y, int width, int height) {
    this.checkBoxes = this.getFormattedCheckBoxes(checkBoxes, numberOfColumns);
    super.setPosition(x, y);
    super.setSize(width, height);
  }

  private List<CustomCheckBox> getFormattedCheckBoxes(List<CustomCheckBox> checkBoxes, int numberOfColumns) {
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

    for (int i = 0; i < checkBoxes.size(); i += numberOfColumns) {
      List<CustomCheckBox> row = checkBoxes.subList(i, Math.min(i + numberOfColumns, checkBoxes.size()));
      super.addRow(row.toArray(new CustomCheckBox[0]));
    }

    return checkBoxes;
  }

  public List<CustomCheckBox> getCheckBoxes() {
    return this.checkBoxes;
  }

  public CustomCheckBox getCheckedBox() {
    return this.checkBoxes.stream().filter(Button::isChecked).findFirst().orElse(null);
  }
}
