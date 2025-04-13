package com.kendao.libgdx.company.dragonbones.core.model;

import com.kendao.libgdx.company.dragonbones.core.core.DisplayType;
import com.kendao.libgdx.company.dragonbones.core.geom.Point;

/**
 * @private
 */
public class ImageDisplayData extends DisplayData {
  public final Point pivot = new Point();

  public TextureData texture;

  protected void _onClear() {
    super._onClear();

    this.type = DisplayType.Image;
    this.pivot.clear();
    this.texture = null;
  }
}
