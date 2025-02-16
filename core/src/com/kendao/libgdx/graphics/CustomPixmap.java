package com.kendao.libgdx.graphics;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;

public class CustomPixmap extends Pixmap {
  public CustomPixmap(Color color, int width, int height) {
    super(width, height, Pixmap.Format.RGB888);
    super.setColor(color);
    super.fill();
  }

  public CustomPixmap(FileHandle file) {
    super(file);
  }

  public boolean isTransparentPixel(Integer x, Integer y, Boolean reverseY) {
    if (reverseY) {
      y = super.getHeight() - y;
    }

    return ((super.getPixel(x, y) & 0x000000ff) == 0);
  }
}
