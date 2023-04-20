package com.kendao.libgdx.input;

import com.badlogic.gdx.input.GestureDetector;
import com.kendao.libgdx.listener.CustomDirectionListener;

public class CustomDirectionGestureDetector extends GestureDetector {
  public CustomDirectionGestureDetector(CustomDirectionListener directionListener) {
    super(new DirectionGestureListener(directionListener));
  }

  private static class DirectionGestureListener extends GestureAdapter {
    CustomDirectionListener directionListener;

    public DirectionGestureListener(CustomDirectionListener directionListener) {
      this.directionListener = directionListener;
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
}
