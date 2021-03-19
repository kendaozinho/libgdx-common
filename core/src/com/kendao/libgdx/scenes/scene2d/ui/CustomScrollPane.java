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
}