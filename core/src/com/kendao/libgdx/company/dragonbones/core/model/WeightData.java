package com.kendao.libgdx.company.dragonbones.core.model;

import com.kendao.libgdx.company.dragonbones.core.core.BaseObject;
import com.kendao.libgdx.company.dragonbones.core.util.Array;

/**
 * @private
 */
public class WeightData extends BaseObject {
  public final Array<BoneData> bones = new Array<>();
  public int count;
  public int offset; // IntArray.

  protected void _onClear() {
    this.count = 0;
    this.offset = 0;
    this.bones.clear();
  }
}
