package com.kendao.libgdx.scenes.scene2d.ui;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;

public class CustomScrollPane extends ScrollPane {
  public CustomScrollPane(Actor actor, int x, int y, int width, int height) {
    super(actor, CustomSkin.getInstance());

    super.setPosition(x, y);
    super.setSize(width, height);

    super.setFadeScrollBars(Gdx.app.getType() != Application.ApplicationType.Desktop);
    super.setFlickScroll(true);
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
}