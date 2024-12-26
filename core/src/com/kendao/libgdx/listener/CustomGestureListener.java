package com.kendao.libgdx.listener;

public interface CustomGestureListener {
  void swipeLeft();

  void swipeRight();

  void swipeUp();

  void swipeDown();

  void zoomIn();

  void zoomOut();

  void touchDown(int screenX, int screenY);

  void touchUp(int screenX, int screenY);

  void touchDragged(int screenX, int screenY);
}
