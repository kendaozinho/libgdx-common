package com.kendao.libgdx.scenes.scene2d;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.kendao.libgdx.listener.CustomGameListener;

public class CustomStage extends Stage {
  private final Boolean isScrollable;

  public CustomStage(Boolean isScrollable) {
    super(new StretchViewport(
        ((CustomGameListener) Gdx.app.getApplicationListener()).getFullWidth(),
        ((CustomGameListener) Gdx.app.getApplicationListener()).getFullHeight(),
        new OrthographicCamera(
            ((CustomGameListener) Gdx.app.getApplicationListener()).getFullWidth(),
            ((CustomGameListener) Gdx.app.getApplicationListener()).getFullHeight()
        )
    ));
    this.isScrollable = isScrollable;
  }

  public void updateCameraPosition(float x, float y, float z) {
    super.getViewport().getCamera().position.set(x, y, z);
    super.getViewport().getCamera().update();
  }

  @Override
  public boolean scrolled(float amountX, float amountY) {
    boolean response = super.scrolled(amountX, amountY);

    if (this.isScrollable) {
      if (amountX == -1 || amountY == -1) {
        this.zoomIn(0.25f, 0.50f);
      } else if (amountX == 1 || amountY == 1) {
        this.zoomOut(0.25f, 2.50f);
      }
    }

    return response;
  }

  public void zoomIn(float quantity, float minValue) {
    if (((OrthographicCamera) super.getViewport().getCamera()).zoom > minValue /* 1.0f is default */) {
      ((OrthographicCamera) super.getViewport().getCamera()).zoom -= quantity;
    }
  }

  public void zoomOut(float quantity, float maxValue) {
    if (((OrthographicCamera) super.getViewport().getCamera()).zoom < maxValue /* 1.0f is default */) {
      ((OrthographicCamera) super.getViewport().getCamera()).zoom += quantity;
    }
  }
}
