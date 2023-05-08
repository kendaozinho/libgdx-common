package com.kendao.libgdx.scenes.scene2d.component;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.Align;
import com.kendao.libgdx.listener.CustomGameListener;
import com.kendao.libgdx.scenes.scene2d.ui.CustomImage;
import com.kendao.libgdx.scenes.scene2d.ui.CustomLabel;
import com.kendao.libgdx.screen.base.CustomScreenManager;

public class CustomLoadingLabel {
  private final CustomImage background;
  private final CustomLabel label;

  public CustomLoadingLabel() {
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
