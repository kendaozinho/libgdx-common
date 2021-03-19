package com.kendao.libgdx.scenes.scene2d.ui;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

public class CustomTable extends Table {
  private final int padding = 5;

  public CustomTable() {
    super();
  }

  public void addRow() {
    this.addRow(new CustomLabel());
  }

  public void addRow(Actor actor) {
    super.add(actor).center().pad(this.padding).fill().colspan(2);

    super.row();
  }

  public void addRow(Actor firstActor, Actor secondActor) {
    if (firstActor instanceof CustomLabel && secondActor instanceof CustomLabel) {
      super.add(firstActor).center().pad(this.padding);
      super.add(secondActor).center().pad(this.padding);
    } else {
      super.add(firstActor).right().pad(this.padding);
      super.add(secondActor).left().pad(this.padding);
    }

    super.row();
  }

  public void addRow(int actorWidth, int actorHeight, Actor... actors) {
    for (Actor actor : actors) {
      super.add(actor).center().pad(this.padding).width(actorWidth).height(actorHeight);
    }

    super.row();
  }
}
