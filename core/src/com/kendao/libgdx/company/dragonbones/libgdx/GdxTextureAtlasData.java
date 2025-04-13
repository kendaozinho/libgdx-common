package com.kendao.libgdx.company.dragonbones.libgdx;

import com.kendao.libgdx.company.dragonbones.core.core.BaseObject;
import com.kendao.libgdx.company.dragonbones.core.factory.BaseFactory;
import com.kendao.libgdx.company.dragonbones.core.model.TextureAtlasData;
import com.kendao.libgdx.company.dragonbones.core.model.TextureData;
import com.kendao.libgdx.company.dragonbones.core.util.Console;
import com.kendao.libgdx.company.dragonbones.libgdx.compat.EgretBitmapData;
import com.kendao.libgdx.company.dragonbones.libgdx.compat.EgretTexture;

/**
 * Egret 贴图集数据。
 *
 * @version DragonBones 3.0
 * @language zh_CN
 */
public class GdxTextureAtlasData extends TextureAtlasData {
  private EgretTexture _renderTexture = null; // Initial value.

  /**
   * @private
   */
  protected void _onClear() {
    super._onClear();

    if (this._renderTexture != null) {
      //this.texture.dispose();
    }

    this._renderTexture = null;
  }

  /**
   * @private
   */
  public TextureData createTexture() {
    return BaseObject.borrowObject(GdxTextureData.class);
  }

  /**
   * Egret 贴图。
   *
   * @version DragonBones 3.0
   * @language zh_CN
   */

  public EgretTexture getRenderTexture() {
    return this._renderTexture;
  }

  public void setRenderTexture(EgretTexture value) {
    if (this._renderTexture == value) {
      return;
    }

    this._renderTexture = value;

    if (this._renderTexture != null) {
      EgretBitmapData bitmapData = this._renderTexture.getBitmapData();
      int textureAtlasWidth = this.width > 0.0 ? this.width : bitmapData.getWidth();
      int textureAtlasHeight = this.height > 0.0 ? this.height : bitmapData.getHeight();

      for (String k : this.textures.keySet()) {
        GdxTextureData textureData = (GdxTextureData) this.textures.get(k);
        float subTextureWidth = Math.min(textureData.region.width, textureAtlasWidth - textureData.region.x); // TODO need remove
        float subTextureHeight = Math.min(textureData.region.height, textureAtlasHeight - textureData.region.y); // TODO need remove

        if (textureData.renderTexture == null) {
          textureData.renderTexture = new EgretTexture();
          if (textureData.rotated) {
            textureData.renderTexture.$initData(
                textureData.region.x, textureData.region.y,
                subTextureHeight, subTextureWidth,
                0, 0,
                subTextureHeight, subTextureWidth,
                textureAtlasWidth, textureAtlasHeight
            );
          } else {
            textureData.renderTexture.$initData(
                textureData.region.x, textureData.region.y,
                subTextureWidth, subTextureHeight,
                0, 0,
                subTextureWidth, subTextureHeight,
                textureAtlasWidth, textureAtlasHeight
            );
          }
        }

        textureData.renderTexture._bitmapData = bitmapData;
      }
    } else {
      for (String k : this.textures.keySet()) {
        GdxTextureData textureData = (GdxTextureData) this.textures.get(k);
        textureData.renderTexture = null;
      }
    }
  }

  /**
   * @see BaseFactory#removeTextureAtlasData(String, boolean)
   * @deprecated 已废弃，请参考 @see
   */
  public void dispose() {
    Console.warn("已废弃，请参考 @see");
    this.returnToPool();
  }

  /**
   * @see BaseFactory#removeTextureAtlasData(String, boolean)
   * @deprecated 已废弃，请参考 @see
   */
  public EgretTexture getTexture() {
    return this.getRenderTexture();
  }
}
