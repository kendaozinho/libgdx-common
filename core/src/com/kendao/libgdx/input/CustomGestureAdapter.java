package com.kendao.libgdx.input;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.input.GestureDetector;
import com.kendao.libgdx.listener.CustomGestureListener;
import com.kendao.libgdx.screen.base.CustomBaseScreen;

public class CustomGestureAdapter extends GestureDetector.GestureAdapter {
  private final CustomGestureListener directionListener;
  private float initialZoom;

  public CustomGestureAdapter(CustomGestureListener directionListener) {
    this.directionListener = directionListener;
    this.initialZoom = 0f;
  }

  @Override
  public boolean touchDown(float x, float y, int pointer, int button) {
    this.initialZoom = ((OrthographicCamera) CustomBaseScreen.getInstance().getMainStage().getCamera()).zoom;
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
}
