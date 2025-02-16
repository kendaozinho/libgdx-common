package com.kendao.libgdx.input;

import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.math.Vector2;
import com.kendao.libgdx.listener.CustomGestureListener;
import com.kendao.libgdx.screen.base.CustomScreenManager;

public class CustomInputAdapter extends InputAdapter {
  private final CustomGestureListener directionListener;

  public CustomInputAdapter(CustomGestureListener directionListener) {
    this.directionListener = directionListener;
  }

  @Override
  public boolean touchDown(int screenX, int screenY, int pointer, int button) {
    boolean response = super.touchDown(screenX, screenY, pointer, button);

    Vector2 mainStageCoordinates =
        CustomScreenManager.getInstance().getScreen().getMainStage().fromScreenToStageCoordinates(screenX, screenY);

    this.directionListener.touchDown(mainStageCoordinates.x, mainStageCoordinates.y);

    return response;
  }

  @Override
  public boolean touchUp(int screenX, int screenY, int pointer, int button) {
    boolean response = super.touchUp(screenX, screenY, pointer, button);

    Vector2 mainStageCoordinates =
        CustomScreenManager.getInstance().getScreen().getMainStage().fromScreenToStageCoordinates(screenX, screenY);

    this.directionListener.touchUp(mainStageCoordinates.x, mainStageCoordinates.y);

    return response;
  }

  @Override
  public boolean touchDragged(int screenX, int screenY, int pointer) {
    boolean response = super.touchDragged(screenX, screenY, pointer);

    Vector2 mainStageCoordinates =
        CustomScreenManager.getInstance().getScreen().getMainStage().fromScreenToStageCoordinates(screenX, screenY);

    this.directionListener.touchDragged(mainStageCoordinates.x, mainStageCoordinates.y);

    return response;
  }
}
