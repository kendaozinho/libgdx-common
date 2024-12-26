package com.kendao.libgdx.listener;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

public class CustomInputListener extends InputListener {
  private final CustomGestureListener directionListener;

  public CustomInputListener(CustomGestureListener directionListener) {
    this.directionListener = directionListener;
  }

  @Override
  public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
    boolean response = super.touchDown(event, x, y, pointer, button);
    this.directionListener.touchDown(x, y);
    return response;
  }

  @Override
  public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
    super.touchUp(event, x, y, pointer, button);
    this.directionListener.touchUp(x, y);
  }

  @Override
  public void touchDragged(InputEvent event, float x, float y, int pointer) {
    super.touchDragged(event, x, y, pointer);
    this.directionListener.touchDragged(x, y);
  }
}
