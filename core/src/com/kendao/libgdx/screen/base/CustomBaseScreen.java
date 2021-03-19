package com.kendao.libgdx.screen.base;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.kendao.libgdx.listener.CustomGameListener;

public abstract class CustomBaseScreen {
  private Stage hudStage;
  private Stage landscapeStage;
  private Stage mainStage;
  private Stage backgroundStage;

  protected CustomBaseScreen() {
    this.hudStage = new Stage(new StretchViewport(((CustomGameListener) Gdx.app.getApplicationListener()).getFullWidth(), ((CustomGameListener) Gdx.app.getApplicationListener()).getFullHeight()));
    this.landscapeStage = new Stage(new StretchViewport(((CustomGameListener) Gdx.app.getApplicationListener()).getFullWidth(), ((CustomGameListener) Gdx.app.getApplicationListener()).getFullHeight()));
    this.mainStage = new Stage(new StretchViewport(((CustomGameListener) Gdx.app.getApplicationListener()).getFullWidth(), ((CustomGameListener) Gdx.app.getApplicationListener()).getFullHeight()));
    this.backgroundStage = new Stage(new StretchViewport(((CustomGameListener) Gdx.app.getApplicationListener()).getFullWidth(), ((CustomGameListener) Gdx.app.getApplicationListener()).getFullHeight()));

    InputMultiplexer multiplexer = new InputMultiplexer();

    multiplexer.addProcessor(this.hudStage);
    multiplexer.addProcessor(this.landscapeStage);
    multiplexer.addProcessor(this.mainStage);
    multiplexer.addProcessor(this.backgroundStage);

    Gdx.input.setInputProcessor(multiplexer);
  }

  protected abstract void load();

  protected abstract void handleInput();

  protected abstract void update();

  protected abstract void render();

  protected abstract void pause();

  protected abstract void resume();

  protected abstract void dispose();

  public void removeActorsFromMainStage() {
    if (this.mainStage != null) {
      Array<Actor> actors = this.mainStage.getActors();
      for (int i = (actors.size - 1); i >= 0; i--) {
        actors.get(i).remove();
      }
    }
  }

  public void removeActorsFromHudStage() {
    if (this.hudStage != null) {
      Array<Actor> actors = this.hudStage.getActors();
      for (int i = (actors.size - 1); i >= 0; i--) {
        actors.get(i).remove();
      }
    }
  }

  public void removeActorsFromBackgroundStage() {
    if (this.backgroundStage != null) {
      Array<Actor> actors = this.backgroundStage.getActors();
      for (int i = (actors.size - 1); i >= 0; i--) {
        actors.get(i).remove();
      }
    }
  }

  public void removeActorsFromLandscapeStage() {
    if (this.landscapeStage != null) {
      Array<Actor> actors = this.landscapeStage.getActors();
      for (int i = (actors.size - 1); i >= 0; i--) {
        actors.get(i).remove();
      }
    }
  }

  public Stage getHudStage() {
    return this.hudStage;
  }

  public Stage getMainStage() {
    return this.mainStage;
  }

  public Stage getBackgroundStage() {
    return this.backgroundStage;
  }

  public Stage getLandscapeStage() {
    return this.landscapeStage;
  }
}
