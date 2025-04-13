package com.kendao.libgdx.company.dragonbones.core.model;

import com.kendao.libgdx.company.dragonbones.core.core.DisplayType;

/**
 * @private
 */
public class MeshDisplayData extends ImageDisplayData {
  public boolean inheritAnimation;
  public int offset; // IntArray.

  public WeightData weight = null; // Initial value.

  protected void _onClear() {
    super._onClear();

    if (this.weight != null) {
      this.weight.returnToPool();
    }

    this.type = DisplayType.Mesh;
    this.inheritAnimation = false;
    this.offset = 0;
    this.weight = null;
  }
}
