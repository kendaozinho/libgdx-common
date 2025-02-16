package com.kendao.libgdx.util;

import com.badlogic.gdx.Gdx;

public final class CustomRunnableUtil {
  private CustomRunnableUtil() {
  }

  public static void executeAfterRender(Runnable runnable) {
    Gdx.app.postRunnable(runnable);
  }

  public static void startThread(Runnable runnable) {
    new Thread(runnable).start();
  }
}
