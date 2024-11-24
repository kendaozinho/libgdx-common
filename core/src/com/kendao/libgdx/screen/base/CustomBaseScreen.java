package com.kendao.libgdx.screen.base;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.kendao.libgdx.input.CustomDirectionGestureDetector;
import com.kendao.libgdx.listener.CustomDirectionListener;
import com.kendao.libgdx.scenes.scene2d.CustomStage;

public abstract class CustomBaseScreen implements CustomDirectionListener {
  private CustomStage hudStage;
  private CustomStage landscapeStage;
  private CustomStage mainStage;
  private CustomStage backgroundStage;
  private Boolean processing;

  protected CustomBaseScreen() {
    this.hudStage = new CustomStage(false);
    this.landscapeStage = new CustomStage(false);
    this.mainStage = new CustomStage(false);
    this.backgroundStage = new CustomStage(false);
    this.processing = false;

    this.setInputMultiplexerProcessor();
  }

  protected CustomBaseScreen(Boolean isMainStageScrollable) {
    this.hudStage = new CustomStage(false);
    this.landscapeStage = new CustomStage(false);
    this.mainStage = new CustomStage(isMainStageScrollable);
    this.backgroundStage = new CustomStage(false);
    this.processing = false;

    this.setInputMultiplexerProcessor();
  }

  public static CustomBaseScreen getInstance() {
    return CustomScreenManager.getInstance().getScreen();
  }

  public static <T> T getInstanceAs(Class<T> clazz) {
    return (T) CustomBaseScreen.getInstance();
  }

  private void setInputMultiplexerProcessor() {
    InputMultiplexer multiplexer = new InputMultiplexer();

    multiplexer.addProcessor(this.hudStage);
    multiplexer.addProcessor(this.landscapeStage);
    multiplexer.addProcessor(this.mainStage);
    multiplexer.addProcessor(this.backgroundStage);
    multiplexer.addProcessor(new CustomDirectionGestureDetector(this));

    Gdx.input.setInputProcessor(multiplexer);
  }

  protected abstract void load();

  protected abstract void handleInput();

  protected abstract void update(float deltaTime);

  protected abstract void render();

  protected abstract void pause();

  protected abstract void resume();

  protected abstract void dispose();

  public void removeActorsFromAllStages() {
    this.getBackgroundStage().clear();
    this.getMainStage().clear();
    this.getLandscapeStage().clear();
    this.getHudStage().clear();
  }

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

  public Boolean isProcessing() {
    return this.processing;
  }

  public void setProcessing(Boolean processing) {
    this.processing = processing;
  }
}
