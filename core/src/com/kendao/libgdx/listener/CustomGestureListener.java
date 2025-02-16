package com.kendao.libgdx.listener;

public interface CustomGestureListener {
  void swipeLeft();

  void swipeRight();

  void swipeUp();

  void swipeDown();

  void zoomIn();

  void zoomOut();

  void touchDown(float x, float y);

  void touchUp(float x, float y);

  void touchDragged(float x, float y);
}
