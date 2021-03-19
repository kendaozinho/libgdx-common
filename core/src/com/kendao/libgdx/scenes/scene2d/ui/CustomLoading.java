package com.kendao.libgdx.scenes.scene2d.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.Align;
import com.kendao.libgdx.listener.CustomGameListener;
import com.kendao.libgdx.screen.base.CustomScreenManager;

public class CustomLoading {
  private CustomImage background;
  private CustomLabel label;

  public CustomLoading() {
    this.background = new CustomImage(Color.BLACK) {{
      super.setOpacity(0.80f);
    }};

    this.label = new CustomLabel("LOADING...", Color.WHITE, CustomLabel.Sizes.LARGE) {
      {
        super.setPosition(
            (((CustomGameListener) Gdx.app.getApplicationListener()).getFullWidth() / 2) - (super.getWidth() / 2),
            (((CustomGameListener) Gdx.app.getApplicationListener()).getFullHeight() / 2) - (super.getHeight() / 2)
        );
        super.setAlignment(Align.center);
      }
    };
  }

  public void show() {
    CustomScreenManager.getInstance().getScreen().getHudStage().addActor(this.background);
    CustomScreenManager.getInstance().getScreen().getHudStage().addActor(this.label);
  }

  public void hide() {
    this.label.remove();
    this.background.remove();
  }
}
