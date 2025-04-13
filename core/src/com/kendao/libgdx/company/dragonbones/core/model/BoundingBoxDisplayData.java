package com.kendao.libgdx.company.dragonbones.core.model;

import com.kendao.libgdx.company.dragonbones.core.core.DisplayType;

/**
 * @private
 */
public class BoundingBoxDisplayData extends DisplayData {

  public BoundingBoxData boundingBox = null; // Initial value.

  protected void _onClear() {
    super._onClear();

    if (this.boundingBox != null) {
      this.boundingBox.returnToPool();
    }

    this.type = DisplayType.BoundingBox;
    this.boundingBox = null;
  }
}
