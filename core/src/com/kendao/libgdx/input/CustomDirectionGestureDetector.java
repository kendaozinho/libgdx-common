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
          directionListener.onRight();
        } else {
          directionListener.onLeft();
        }
      } else {
        if (velocityY > 0) {
          directionListener.onDown();
        } else {
          directionListener.onUp();
        }
      }
      return super.fling(velocityX, velocityY, button);
    }
  }
}
