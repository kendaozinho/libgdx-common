package com.kendao.libgdx.company.dragonbones.libgdx;

import com.kendao.libgdx.company.dragonbones.core.model.TextureData;
import com.kendao.libgdx.company.dragonbones.libgdx.compat.EgretTexture;

/**
 * @private
 */
public class GdxTextureData extends TextureData {
  public EgretTexture renderTexture = null; // Initial value.

  protected void _onClear() {
    super._onClear();

    if (this.renderTexture != null) {
      //this.texture.dispose();
    }

    this.renderTexture = null;
  }
}
