package com.kendao.libgdx.input;

import com.badlogic.gdx.InputAdapter;
import com.kendao.libgdx.listener.CustomGestureListener;

public class CustomInputAdapter extends InputAdapter {
  private final CustomGestureListener directionListener;

  public CustomInputAdapter(CustomGestureListener directionListener) {
    this.directionListener = directionListener;
  }

  @Override
  public boolean touchDown(int screenX, int screenY, int pointer, int button) {
    boolean response = super.touchDown(screenX, screenY, pointer, button);
    this.directionListener.touchDown(screenX, screenY);
    return response;
  }

  @Override
  public boolean touchUp(int screenX, int screenY, int pointer, int button) {
    boolean response = super.touchUp(screenX, screenY, pointer, button);
    this.directionListener.touchUp(screenX, screenY);
    return response;
  }

  @Override
  public boolean touchDragged(int screenX, int screenY, int pointer) {
    boolean response = super.touchDragged(screenX, screenY, pointer);
    this.directionListener.touchDragged(screenX, screenY);
    return response;
  }
}
