package com.kendao.libgdx.input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.kendao.libgdx.screen.base.CustomBaseScreen;

public class CustomTouchDraggedInputListener extends InputListener {
  private final Vector2 lastTouch;

  public CustomTouchDraggedInputListener() {
    this.lastTouch = new Vector2();
  }

  @Override
  public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
    this.lastTouch.set(Gdx.input.getX(), Gdx.input.getY());
    return true;
  }

  @Override
  public void touchDragged(InputEvent event, float x, float y, int pointer) {
    final OrthographicCamera camera = ((OrthographicCamera) CustomBaseScreen.getInstance().getMainStage().getCamera());

    float deltaX = Gdx.input.getX() - lastTouch.x;
    float deltaY = Gdx.input.getY() - lastTouch.y;

    camera.position.x -= deltaX * camera.zoom;
    camera.position.y += deltaY * camera.zoom;

    this.lastTouch.set(Gdx.input.getX(), Gdx.input.getY());

    camera.update();
  }
}
