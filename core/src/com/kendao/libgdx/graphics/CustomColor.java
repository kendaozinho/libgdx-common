package com.kendao.libgdx.graphics;

import com.badlogic.gdx.graphics.Color;

public class CustomColor extends Color {
  public static final Color DEFAULT = new Color(1f, 1f, 1f, 1f);
  public static final Color VISIBLE = new Color(1f, 1f, 1f, 1f);
  public static final Color INVISIBLE = new Color(0f, 0f, 0f, 0f);
  public static final Color ENABLED = new Color(1f, 1f, 1f, 1f);
  public static final Color DISABLED = new Color(0.60f, 0.60f, 0.60f, 0.80f);

  public static Color getColorByHexadecimalCode(String code) {
    if (code == null || code.trim().isEmpty()) {
      return Color.BLACK;
    }

    return new Color(Color.valueOf(code));
  }
}
