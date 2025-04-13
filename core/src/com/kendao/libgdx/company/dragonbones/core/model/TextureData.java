package com.kendao.libgdx.company.dragonbones.core.model;

import com.kendao.libgdx.company.dragonbones.core.core.BaseObject;
import com.kendao.libgdx.company.dragonbones.core.geom.Rectangle;

/**
 * @private
 */
public abstract class TextureData extends BaseObject {
  public final Rectangle region = new Rectangle();
  public boolean rotated;
  public String name;
  public TextureAtlasData parent;
  public Rectangle frame = null; // Initial value.

  public static Rectangle createRectangle() {
    return new Rectangle();
  }

  protected void _onClear() {
    this.rotated = false;
    this.name = "";
    this.region.clear();
    this.parent = null; //
    this.frame = null;
  }

  public void copyFrom(TextureData value) {
    this.rotated = value.rotated;
    this.name = value.name;
    this.region.copyFrom(value.region);
    this.parent = value.parent;

    if (this.frame == null && value.frame != null) {
      this.frame = TextureData.createRectangle();
    } else if (this.frame != null && value.frame == null) {
      this.frame = null;
    }

    if (this.frame != null && value.frame != null) {
      this.frame.copyFrom(value.frame);
    }
  }
}
