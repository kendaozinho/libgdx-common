package com.kendao.libgdx.scenes.scene2d;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.kendao.libgdx.listener.CustomGameListener;

public class CustomStage extends Stage {
  private final Boolean isScrollable;

  public CustomStage(Boolean isScrollable) {
    super(new StretchViewport(
        ((CustomGameListener) Gdx.app.getApplicationListener()).getFullWidth(),
        ((CustomGameListener) Gdx.app.getApplicationListener()).getFullHeight()
    ));
    this.isScrollable = isScrollable;
  }

  public void addCamera() {
    super.getViewport().setCamera(new OrthographicCamera(
        ((CustomGameListener) Gdx.app.getApplicationListener()).getFullWidth(),
        ((CustomGameListener) Gdx.app.getApplicationListener()).getFullHeight()
    ));
  }

  public void updateCameraPosition(float x, float y, float z) {
    if (super.getViewport().getCamera() != null) {
      super.getViewport().getCamera().position.set(x, y, z);
      super.getViewport().getCamera().update();
    }
  }

  public void removeActors() {
    Array<Actor> actors = super.getActors();
    for (int i = (actors.size - 1); i >= 0; i--) {
      actors.get(i).remove();
    }
  }

  @Override
  public boolean scrolled(float amountX, float amountY) {
    boolean response = super.scrolled(amountX, amountY);

    if (this.isScrollable && super.getViewport().getCamera() != null) {
      if (amountX == -1 || amountY == -1) { // + zoom
        if (((OrthographicCamera) super.getViewport().getCamera()).zoom > 0.5f /* 1.0f is default */) {
          ((OrthographicCamera) super.getViewport().getCamera()).zoom -= 0.25;
        }
      } else if (amountX == 1 || amountY == 1) { // - zoom
        if (((OrthographicCamera) super.getViewport().getCamera()).zoom < 2.5f) {
          ((OrthographicCamera) super.getViewport().getCamera()).zoom += 0.25;
        }
      }
    }

    return response;
  }
}