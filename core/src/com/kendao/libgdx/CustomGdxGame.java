package com.kendao.libgdx;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.kendao.libgdx.assets.CustomAssetManager;
import com.kendao.libgdx.listener.CustomGameListener;
import com.kendao.libgdx.scenes.scene2d.ui.CustomSkin;
import com.kendao.libgdx.screen.base.CustomScreenManager;
import com.kendao.libgdx.screen.splash.CustomSplashScreen;
import com.kendao.libgdx.storage.CustomPreferences;

import java.util.HashMap;

@Deprecated
public class CustomGdxGame extends ApplicationAdapter implements CustomGameListener {
  private HashMap<Class, Object> instances = new HashMap();

  public CustomGdxGame() {
  }

  @Override
  public void create() {
    // Set log level
    Gdx.app.setLogLevel(Application.LOG_DEBUG);

    // Disable hardware back button
    Gdx.input.setCatchKey(Input.Keys.BACK, true);

    // Load asset manager
    this.instances.put(CustomAssetManager.class, new CustomAssetManager());

    // Load default skin
    this.instances.put(CustomSkin.class, new CustomSkin());

    // Load preferences
    this.instances.put(CustomPreferences.class, new CustomPreferences("libgdx-common"));

    // Load screen manager
    this.instances.put(CustomScreenManager.class, new CustomScreenManager());

    // Open the splash screen and load all assets
    CustomScreenManager.getInstance().setScreen(new CustomSplashScreen());
  }

  @Override
  public void render() {
    CustomScreenManager.getInstance().render();
  }

  @Override
  public void resize(int width, int height) {
    CustomScreenManager.getInstance().resize(width, height);
  }

  @Override
  public void pause() {
    CustomScreenManager.getInstance().pause();
  }

  @Override
  public void resume() {
    CustomScreenManager.getInstance().resume();
  }

  @Override
  public void dispose() {
    CustomScreenManager.getInstance().dispose();
  }

  @Override
  public Integer getFullWidth() {
    return 480;
  }

  @Override
  public Integer getFullHeight() {
    return 800;
  }

  @Override
  public <T> T getInstanceOf(Class<T> clazz) {
    Object instance = this.instances.get(clazz);
    return (instance == null ? null : (T) instance);
  }
}
