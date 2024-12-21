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
    this.addRow(actor, Alignments.CENTER);
  }

  public void addRow(Actor actor, Alignments alignment) {
    switch (alignment) {
      case LEFT:
        super.add(actor).left().pad(this.padding).fill().colspan(2);
        break;
      case RIGHT:
        super.add(actor).right().pad(this.padding).fill().colspan(2);
        break;
      default:
        super.add(actor).center().pad(this.padding).fill().colspan(2);
        break;
    }

    super.row();
  }

  public void addRow(Actor actor, int width, int height) {
    this.addRow(actor, width, height, Alignments.CENTER);
  }

  public void addRow(Actor actor, int width, int height, Alignments alignment) {
    switch (alignment) {
      case LEFT:
        super.add(actor).left().pad(this.padding).width(width).height(height).colspan(2);
        break;
      case RIGHT:
        super.add(actor).right().pad(this.padding).width(width).height(height).colspan(2);
        break;
      default:
        super.add(actor).center().pad(this.padding).width(width).height(height).colspan(2);
        break;
    }

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

  public void addRow(Actor... actors) {
    this.addRow(Alignments.CENTER, actors);
  }

  public void addRow(Alignments alignment, Actor... actors) {
    for (Actor actor : actors) {
      switch (alignment) {
        case LEFT:
          super.add(actor).left().pad(this.padding).fill();
          break;
        case RIGHT:
          super.add(actor).right().pad(this.padding).fill();
          break;
        default:
          super.add(actor).center().pad(this.padding).fill();
          break;
      }
    }

    super.row();
  }

  public void addRow(int width, int height, Actor... actors) {
    this.addRow(width, height, Alignments.CENTER, actors);
  }

  public void addRow(int width, int height, Alignments alignment, Actor... actors) {
    for (Actor actor : actors) {
      switch (alignment) {
        case LEFT:
          super.add(actor).left().pad(this.padding).width(width).height(height);
          break;
        case RIGHT:
          super.add(actor).right().pad(this.padding).width(width).height(height);
          break;
        default:
          super.add(actor).center().pad(this.padding).width(width).height(height);
          break;
      }
    }

    super.row();
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

  public enum Alignments {LEFT, CENTER, RIGHT}
}
