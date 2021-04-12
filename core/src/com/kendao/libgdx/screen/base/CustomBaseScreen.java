package com.kendao.libgdx.screen.base;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.kendao.libgdx.scenes.scene2d.CustomStage;

public abstract class CustomBaseScreen {
  private CustomStage hudStage;
  private CustomStage landscapeStage;
  private CustomStage mainStage;
  private CustomStage backgroundStage;

  protected CustomBaseScreen() {
    this.hudStage = new CustomStage(false);
    this.landscapeStage = new CustomStage(false);
    this.mainStage = new CustomStage(true);
    this.backgroundStage = new CustomStage(false);

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

  public CustomStage getHudStage() {
    return this.hudStage;
  }

  public CustomStage getMainStage() {
    return this.mainStage;
  }

  public CustomStage getBackgroundStage() {
    return this.backgroundStage;
  }

  public CustomStage getLandscapeStage() {
    return this.landscapeStage;
  }
}
