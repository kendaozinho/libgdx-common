package com.kendao.libgdx.scenes.scene2d.ui;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

public class CustomTable extends Table {
  private final int padding = 5;

  public CustomTable() {
    super();
  }

  public CustomTable(boolean debug) {
    super();

    if (debug) {
      super.debug();
    }
  }

  public void addRow() {
    this.addRow(new CustomLabel());
  }

  public void addRow(Actor actor) {
    super.add(actor).center().pad(this.padding).fill().colspan(2);

    super.row();
  }

  public void addRow(Actor actor, int width, int height) {
    super.add(actor).center().pad(this.padding).width(width).height(height).colspan(2);

    super.row();
  }

  public void addRow(Actor firstActor, Actor secondActor) {
    if (firstActor instanceof CustomLabel && secondActor instanceof CustomLabel) {
      super.add(firstActor).center().pad(this.padding).fill();
      super.add(secondActor).center().pad(this.padding).fill();
    } else {
      super.add(firstActor).right().pad(this.padding).fill();
      super.add(secondActor).left().pad(this.padding).fill();
    }

    super.row();
  }

  public void addRow(Actor firstActor, Actor secondActor, int width, int height) {
    if (firstActor instanceof CustomLabel && secondActor instanceof CustomLabel) {
      super.add(firstActor).center().pad(this.padding).width(width).height(height);
      super.add(secondActor).center().pad(this.padding).width(width).height(height);
    } else {
      super.add(firstActor).right().pad(this.padding).width(width).height(height);
      super.add(secondActor).left().pad(this.padding).width(width).height(height);
    }

    super.row();
  }

  public void addRow(int width, int height, Actor... actors) {
    for (Actor actor : actors) {
      super.add(actor).center().pad(this.padding).width(width).height(height);
    }

    super.row();
  }
}
