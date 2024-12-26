package com.kendao.libgdx.screen.base;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.kendao.libgdx.input.CustomGestureDetector;
import com.kendao.libgdx.input.CustomInputAdapter;
import com.kendao.libgdx.listener.CustomGestureListener;
import com.kendao.libgdx.scenes.scene2d.CustomStage;

public abstract class CustomBaseScreen implements CustomGestureListener {
  private final CustomStage hudStage;
  private final CustomStage landscapeStage;
  private final CustomStage mainStage;
  private final CustomStage backgroundStage;
  private Boolean processing;

  protected CustomBaseScreen() {
    this.hudStage = new CustomStage(this);
    this.landscapeStage = new CustomStage(this);
    this.mainStage = new CustomStage(this);
    this.backgroundStage = new CustomStage(this);
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
    multiplexer.addProcessor(new CustomGestureDetector(this));
    multiplexer.addProcessor(new CustomInputAdapter(this));

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
