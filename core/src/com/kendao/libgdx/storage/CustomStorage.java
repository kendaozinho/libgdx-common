package com.kendao.libgdx.storage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

import java.nio.file.Files;
import java.nio.file.Paths;

public final class CustomStorage {
  private CustomStorage() {
  }

  public static FileHandle loadAssetFile(String path) {
    return Gdx.files.internal(CustomStorage.getResourcePath(path));
  }

  public static FileHandle[] loadAssetFolder(String path) {
    return Gdx.files.internal(CustomStorage.getResourcePath(path)).list();
  }

  private static String getResourcePath(String name) {
    // for eclipse
    if (Files.isDirectory(Paths.get("assets/"))) {
      return ("assets/" + name);
    }

    // for IntelliJ
    if (Files.isDirectory(Paths.get("android/assets/"))) {
      return ("android/assets/" + name);
    }
    if (Files.isDirectory(Paths.get("desktop/assets/"))) {
      return ("desktop/assets/" + name);
    }
    if (Files.isDirectory(Paths.get("core/assets/"))) {
      return ("core/assets/" + name);
    }

    return name;
  }
}