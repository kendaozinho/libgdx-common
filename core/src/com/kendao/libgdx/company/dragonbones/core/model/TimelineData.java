package com.kendao.libgdx.company.dragonbones.core.model;

import com.kendao.libgdx.company.dragonbones.core.core.BaseObject;
import com.kendao.libgdx.company.dragonbones.core.core.TimelineType;

/**
 * @private
 */
public class TimelineData extends BaseObject {
  public TimelineType type;
  public int offset; // TimelineArray.
  public int frameIndicesOffset; // FrameIndices.

  protected void _onClear() {
    this.type = TimelineType.BoneAll;
    this.offset = 0;
    this.frameIndicesOffset = -1;
  }
}
