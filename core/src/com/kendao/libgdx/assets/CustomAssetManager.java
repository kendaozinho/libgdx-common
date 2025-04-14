package com.kendao.libgdx.assets;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Logger;
import com.kendao.libgdx.listener.CustomGameListener;
import com.kendao.libgdx.storage.CustomStorage;
import com.kendao.libgdx.util.CustomGsonUtil;
import com.kendao.libgdx.util.CustomStringUtil;

public class CustomAssetManager extends AssetManager {
  private final Logger logger = new Logger(this.toString(), Application.LOG_DEBUG);

  private String confirmSoundPath = "audio/sound/confirm.mp3";
  private String cancelSoundPath = "audio/sound/cancel.mp3";

  public CustomAssetManager() {
    super();
  }

  public CustomAssetManager(String confirmSoundPath, String cancelSoundPath) {
    super();

    this.confirmSoundPath = confirmSoundPath;
    this.cancelSoundPath = cancelSoundPath;
  }

  public static CustomAssetManager getInstance() {
    return ((CustomGameListener) Gdx.app.getApplicationListener()).getInstanceOf(CustomAssetManager.class);
  }

  public void loadAllAssets() {
    try {
      this.logger.info("Loading assets...");

      this.loadAssetsByPath("");

      this.logger.info("All assets loaded successfully!");
    } catch (Throwable t) {
      this.logger.error("Unable to load all assets!", t);
    } finally {
      super.finishLoading();
    }
  }

  private void loadAssetsByPath(String path) {
    this.logger.info("Loading assets from folder: " + (path.trim().isEmpty() ? "/" : path));

    for (FileHandle fileOrFolder : CustomStorage.loadAssetFolder(path)) {
      boolean isDirectory = fileOrFolder.extension().trim().isEmpty();

      if (isDirectory) {
        this.loadAssetsByPath(path.trim().isEmpty() ? fileOrFolder.name() : (path + "/" + fileOrFolder.name()));
      } else {
        String fileName = (path.trim().isEmpty() ? fileOrFolder.name() : (path + "/" + fileOrFolder.name())); // path + name + extension

        this.logger.info("Loading asset: " + fileName);

        if (fileOrFolder.extension().toLowerCase().equals("mp3")) {
          if (fileName.toLowerCase().contains("/sound")) {
            super.load(fileName, Sound.class);
          } else if (fileName.toLowerCase().contains("/music")) {
            super.load(fileName, Music.class);
          }
        } else if (fileOrFolder.extension().toLowerCase().equals("png") ||
            fileOrFolder.extension().toLowerCase().equals("jpg") ||
            fileOrFolder.extension().toLowerCase().equals("jpeg") ||
            fileOrFolder.extension().toLowerCase().equals("bmp")) {
          super.load(fileName, Texture.class);
        } else if (fileOrFolder.extension().toLowerCase().equals("txt") ||
            fileOrFolder.extension().toLowerCase().equals("json")) {
          super.load(fileName, String.class);
        }
      }
    }
  }

  public boolean exists(String fileName) {
    return super.isLoaded(fileName);
  }

  public Texture getTexture(String fileName) {
    return super.get(fileName, Texture.class);
  }

  public TextureRegion getTextureRegion(String fileName) {
    return new TextureRegion(this.getTexture(fileName));
  }

  public TextureRegion getTextureRegion(String fileName, boolean flipX, boolean flipY) {
    TextureRegion textureRegion = this.getTextureRegion(fileName);
    textureRegion.flip(flipX, flipY);
    return textureRegion;
  }

  public Sound getSound(String fileName) {
    return super.get(fileName, Sound.class);
  }

  public Music getMusic(String fileName) {
    return super.get(fileName, Music.class);
  }

  public String getText(String fileName) {
    return super.get(fileName, String.class);
  }

  public <T> T getJsonAsObject(String fileName, Class<T> clazz) {
    String jsonFile = this.getText(fileName);
    return CustomStringUtil.hasValue(jsonFile) ? CustomGsonUtil.getGson().fromJson(jsonFile, clazz) : null;
  }

  public Sound getConfirmSound() {
    return this.getSound(this.confirmSoundPath);
  }

  public Sound getCancelSound() {
    return this.getSound(this.cancelSoundPath);
  }
}
