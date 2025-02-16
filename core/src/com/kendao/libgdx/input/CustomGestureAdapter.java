package com.kendao.libgdx.input;

import com.badlogic.gdx.input.GestureDetector;
import com.kendao.libgdx.listener.CustomGestureListener;

public class CustomGestureAdapter extends GestureDetector.GestureAdapter {
  private final CustomGestureListener directionListener;

  public CustomGestureAdapter(CustomGestureListener directionListener) {
    this.directionListener = directionListener;
  }

  @Override
  public boolean zoom(float initialDistance, float distance) {
    if (distance > initialDistance) {
      this.directionListener.zoomIn();
    } else if (distance < initialDistance) {
      this.directionListener.zoomOut();
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
