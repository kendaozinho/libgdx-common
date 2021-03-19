package com.kendao.libgdx.scenes.scene2d.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.kendao.libgdx.listener.CustomGameListener;

public class CustomSkin extends Skin {
  public CustomSkin() {
    super(Gdx.files.internal("ui/default-skin.json"),
        new TextureAtlas(Gdx.files.internal("ui/default-skin.atlas")));
  }

  public static CustomSkin getInstance() {
    return ((CustomGameListener) Gdx.app.getApplicationListener()).getInstanceOf(CustomSkin.class);
  }
}
