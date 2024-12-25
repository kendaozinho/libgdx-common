package com.kendao.libgdx.screen.base;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.kendao.libgdx.input.CustomGestureDetector;
import com.kendao.libgdx.listener.CustomGestureListener;
import com.kendao.libgdx.scenes.scene2d.CustomStage;

public abstract class CustomBaseScreen implements CustomGestureListener {
  private CustomStage hudStage;
  private CustomStage landscapeStage;
  private CustomStage mainStage;
  private CustomStage backgroundStage;
  private Boolean processing;

  protected CustomBaseScreen() {
    this.hudStage = new CustomStage(false, null, null);
    this.landscapeStage = new CustomStage(false, null, null);
    this.mainStage = new CustomStage(false, 0.50f, 2.50f);
    this.backgroundStage = new CustomStage(false, null, null);
    this.processing = false;

    this.setInputMultiplexerProcessor(false);
  }

  protected CustomBaseScreen(Boolean mainStageEnableCameraFeatures, Float mainStageMinZoomValue, Float mainStageMaxZoomValue) {
    this.hudStage = new CustomStage(false, null, null);
    this.landscapeStage = new CustomStage(false, null, null);
    this.mainStage = new CustomStage(mainStageEnableCameraFeatures, mainStageMinZoomValue, mainStageMaxZoomValue);
    this.backgroundStage = new CustomStage(false, null, null);
    this.processing = false;

    this.setInputMultiplexerProcessor(mainStageEnableCameraFeatures);
  }

  public static CustomBaseScreen getInstance() {
    return CustomScreenManager.getInstance().getScreen();
  }

  public static <T> T getInstanceAs(Class<T> clazz) {
    return (T) CustomBaseScreen.getInstance();
  }

  private void setInputMultiplexerProcessor(Boolean mainStageEnableCameraFeatures) {
    InputMultiplexer multiplexer = new InputMultiplexer();

    multiplexer.addProcessor(this.hudStage);
    multiplexer.addProcessor(this.landscapeStage);
    multiplexer.addProcessor(this.mainStage);
    multiplexer.addProcessor(this.backgroundStage);
    multiplexer.addProcessor(new CustomGestureDetector(this, mainStageEnableCameraFeatures));

    Gdx.input.setInputProcessor(multiplexer);
  }

  protected abstract void load();

  protected abstract void handleInput();

  protected abstract void update(float deltaTime);

  protected abstract void render();

  protected abstract void pause();

  protected abstract void resume();

  protected abstract void dispose();

  public void clearAllStages() {
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

  public synchronized Boolean getOrSetProcessingSafely(Boolean processing) {
    if (processing != null) {
      this.processing = processing;
    }
    return this.processing;
  }
}
