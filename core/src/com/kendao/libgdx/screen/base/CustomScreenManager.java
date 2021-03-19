package com.kendao.libgdx.screen.base;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.ScreenUtils;
import com.kendao.libgdx.assets.CustomAssetManager;
import com.kendao.libgdx.listener.CustomGameListener;

public class CustomScreenManager {
  private Float currentDeltaTime = 0f;
  private Float maximumDeltaTime = 0.05f;
  private CustomBaseScreen screen;

  public CustomScreenManager() {
  }

  public static CustomScreenManager getInstance() {
    return ((CustomGameListener) Gdx.app.getApplicationListener()).getInstanceOf(CustomScreenManager.class);
  }

  public void render() {
    ScreenUtils.clear(0, 0, 0, 0);

    this.handleInput();

    float deltaTime = Gdx.graphics.getDeltaTime();
    this.update(deltaTime);
    this.render(deltaTime);
  }

  private void handleInput() {
    if (this.screen != null) {
      this.screen.handleInput();
    }
  }

  private void update(float deltaTime) {
    if (this.screen != null) {
      this.currentDeltaTime += deltaTime;
      if (this.currentDeltaTime < this.maximumDeltaTime) {
        return;
      } else {
        this.currentDeltaTime = 0f;
      }

      this.screen.update();
    }
  }

  private void render(float deltaTime) {
    if (this.screen != null) {
      this.screen.render();

      if (CustomAssetManager.getInstance() != null) {
        CustomAssetManager.getInstance().update();
      }

      if (this.screen.getBackgroundStage() != null) {
        this.screen.getBackgroundStage().getBatch().begin();
        // this.screen.getBackgroundStage().getBatch().draw("?");
        this.screen.getBackgroundStage().getBatch().end();

        this.screen.getBackgroundStage().act(deltaTime);
        this.screen.getBackgroundStage().draw();
      }

      if (this.screen.getMainStage() != null) {
        this.screen.getMainStage().getBatch().begin();
        // this.screen.getMainStage().getBatch().draw("?");
        this.screen.getMainStage().getBatch().end();

        this.screen.getMainStage().act(deltaTime);
        this.screen.getMainStage().draw();
      }

      if (this.screen.getLandscapeStage() != null) {
        this.screen.getLandscapeStage().getBatch().begin();
        // this.screen.getLandscapeStage().getBatch().draw("?");
        this.screen.getLandscapeStage().getBatch().end();

        this.screen.getLandscapeStage().act(deltaTime);
        this.screen.getLandscapeStage().draw();
      }

      if (this.screen.getHudStage() != null) {
        this.screen.getHudStage().getBatch().begin();
        // this.screen.getHudStage().getBatch().draw("?");
        this.screen.getHudStage().getBatch().end();

        this.screen.getHudStage().act(deltaTime);
        this.screen.getHudStage().draw();
      }
    }
  }

  public void resize(int width, int height) {
    if (this.screen != null) {
      if (this.screen.getBackgroundStage() != null) {
        this.screen.getBackgroundStage().getViewport().setScreenSize(width, height);
      }

      if (this.screen.getMainStage() != null) {
        this.screen.getMainStage().getViewport().setScreenSize(width, height);
      }

      if (this.screen.getLandscapeStage() != null) {
        this.screen.getLandscapeStage().getViewport().setScreenSize(width, height);
      }

      if (this.screen.getHudStage() != null) {
        this.screen.getHudStage().getViewport().setScreenSize(width, height);
      }
    }
  }

  public void pause() {
    if (this.screen != null) {
      this.screen.pause();
    }
  }

  public void resume() {
    if (this.screen != null) {
      this.screen.resume();
    }
  }

  public void dispose() {
    if (this.screen != null) {
      this.screen.dispose();

      // Remove actors and dispose background stage
      if (this.screen.getBackgroundStage() != null) {
        this.screen.removeActorsFromBackgroundStage();
        this.screen.getBackgroundStage().dispose();
      }

      // Remove actors and dispose main stage
      if (this.screen.getMainStage() != null) {
        this.screen.removeActorsFromMainStage();
        this.screen.getMainStage().dispose();
      }

      // Remove actors and dispose landscape stage
      if (this.screen.getLandscapeStage() != null) {
        this.screen.removeActorsFromLandscapeStage();
        this.screen.getLandscapeStage().dispose();
      }

      // Remove actors and dispose hud stage
      if (this.screen.getHudStage() != null) {
        this.screen.removeActorsFromHudStage();
        this.screen.getHudStage().dispose();
      }
    }
  }

  public Float getCurrentDeltaTime() {
    return this.currentDeltaTime;
  }

  public Float getMaximumDeltaTime() {
    return this.maximumDeltaTime;
  }

  // returns the current screen
  public CustomBaseScreen getScreen() {
    return this.screen;
  }

  public void setScreen(CustomBaseScreen screen) {
    this.dispose();

    this.screen = screen;
    if (this.screen != null) {
      this.screen.load();
    }
  }
}
