package com.kendao.libgdx.scenes.scene2d;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.kendao.libgdx.listener.CustomGameListener;
import com.kendao.libgdx.listener.CustomGestureListener;

public class CustomStage extends Stage {
  private final CustomGestureListener directionListener;

  public CustomStage(CustomGestureListener directionListener) {
    super(new StretchViewport(
        ((CustomGameListener) Gdx.app.getApplicationListener()).getFullWidth(),
        ((CustomGameListener) Gdx.app.getApplicationListener()).getFullHeight(),
        new OrthographicCamera(
            ((CustomGameListener) Gdx.app.getApplicationListener()).getFullWidth(),
            ((CustomGameListener) Gdx.app.getApplicationListener()).getFullHeight()
        )
    ));
    this.directionListener = directionListener;
  }

  @Override
  public boolean scrolled(float amountX, float amountY) {
    if (amountX == -1 || amountY == -1) {
      this.directionListener.zoomIn();
    } else if (amountX == 1 || amountY == 1) {
      this.directionListener.zoomOut();
    }
    return super.scrolled(amountX, amountY);
  }

  public void updateCameraPosition(float x, float y, float z) {
    super.getViewport().getCamera().position.set(x, y, z);
    super.getViewport().getCamera().update();
  }

  public void zoomIn(float minZoomValue, float quantity) {
    if (((OrthographicCamera) super.getViewport().getCamera()).zoom > minZoomValue /* 1.0f is default */) {
      ((OrthographicCamera) super.getViewport().getCamera()).zoom -= quantity;
    }
  }

  public void zoomOut(float maxZoomValue, float quantity) {
    if (((OrthographicCamera) super.getViewport().getCamera()).zoom < maxZoomValue /* 1.0f is default */) {
      ((OrthographicCamera) super.getViewport().getCamera()).zoom += quantity;
    }
  }

  public Actor getActorById(String id) {
    for (Actor actor : super.getActors()) {
      if (id != null && actor.getName() != null && id.equals(actor.getName())) {
        return actor;
      }
    }
    return null;
  }

  public Vector2 fromScreenToStageCoordinates(int screenX, int screenY) {
    return super.getViewport().unproject(new Vector2(screenX, screenY));
  }
}
