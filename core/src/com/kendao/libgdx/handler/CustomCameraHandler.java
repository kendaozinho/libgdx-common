package com.kendao.libgdx.handler;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.kendao.libgdx.screen.base.CustomBaseScreen;

public class CustomCameraHandler {
  private final Vector2 lastTouch;

  public CustomCameraHandler() {
    this.lastTouch = new Vector2();
  }

  public void touchDown() {
    this.lastTouch.set(Gdx.input.getX(), Gdx.input.getY());
  }

  public void touchDragged() {
    final OrthographicCamera camera = ((OrthographicCamera) CustomBaseScreen.getInstance().getMainStage().getCamera());

    float deltaX = Gdx.input.getX() - lastTouch.x;
    float deltaY = Gdx.input.getY() - lastTouch.y;

    camera.position.x -= deltaX * camera.zoom;
    camera.position.y += deltaY * camera.zoom;

    this.lastTouch.set(Gdx.input.getX(), Gdx.input.getY());

    camera.update();
  }
}
