package com.kendao.libgdx;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

@Deprecated
public class DesktopLauncher {
  public static void main(String[] arg) {
    LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
    config.title = "libgdx-common";
    config.width = 480;
    config.height = 800;
    new LwjglApplication(new CustomGdxGame(), config);
  }
}
