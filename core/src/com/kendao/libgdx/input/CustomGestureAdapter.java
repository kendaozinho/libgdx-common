package com.kendao.libgdx.input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Vector2;
import com.kendao.libgdx.listener.CustomGestureListener;
import com.kendao.libgdx.screen.base.CustomBaseScreen;

public class CustomGestureAdapter extends GestureDetector.GestureAdapter {
  private final CustomGestureListener directionListener;
  private final Vector2 lastTouch;
  private final Boolean updateCamera;
  private float initialZoom;

  public CustomGestureAdapter(CustomGestureListener directionListener, Boolean updateCamera) {
    this.directionListener = directionListener;
    this.initialZoom = 0f;
    this.lastTouch = new Vector2();
    this.updateCamera = updateCamera;
  }

  @Override
  public boolean touchDown(float x, float y, int pointer, int button) {
    this.initialZoom = ((OrthographicCamera) CustomBaseScreen.getInstance().getMainStage().getCamera()).zoom;
    this.lastTouch.set(Gdx.input.getX(), Gdx.input.getY());
    return super.touchDown(x, y, pointer, button);
  }

  @Override
  public boolean zoom(float initialDistance, float distance) {
    if (CustomBaseScreen.getInstance().getMainStage().getEnableCameraFeatures()) {
      float ratio = initialDistance / distance;
      ((OrthographicCamera) CustomBaseScreen.getInstance().getMainStage().getCamera()).zoom =
          Math.max(CustomBaseScreen.getInstance().getMainStage().getMinZoomValue(), Math.min(this.initialZoom * ratio, CustomBaseScreen.getInstance().getMainStage().getMaxZoomValue()));
    }

    if (distance > initialDistance) {
      this.directionListener.pinchIn();
    } else if (distance < initialDistance) {
      this.directionListener.pinchOut();
    }

    return super.zoom(initialDistance, distance);
  }

  @Override
  public boolean fling(float velocityX, float velocityY, int button) {
    if (Math.abs(velocityX) > Math.abs(velocityY)) {
      if (velocityX > 0) {
        this.directionListener.swipeRight();
      } else {
        this.directionListener.swipeLeft();
      }
    } else {
      if (velocityY > 0) {
        this.directionListener.swipeDown();
      } else {
        this.directionListener.swipeUp();
      }
    }
    return super.fling(velocityX, velocityY, button);
  }

  @Override
  public boolean pan(float x, float y, float deltaX, float deltaY) {
    if (this.updateCamera) {
      final OrthographicCamera camera = ((OrthographicCamera) CustomBaseScreen.getInstance().getMainStage().getCamera());

      float deltaX2 = Gdx.input.getX() - lastTouch.x;
      float deltaY2 = Gdx.input.getY() - lastTouch.y;

      camera.position.x -= deltaX2 * camera.zoom;
      camera.position.y += deltaY2 * camera.zoom;

      this.lastTouch.set(Gdx.input.getX(), Gdx.input.getY());

      camera.update();
    }

    this.directionListener.onDrag(x, y, deltaX, deltaY);
    return super.pan(x, y, deltaX, deltaY);
  }
}
