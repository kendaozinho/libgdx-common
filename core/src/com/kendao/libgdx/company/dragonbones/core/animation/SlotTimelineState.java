package com.kendao.libgdx.company.dragonbones.core.animation;

import com.kendao.libgdx.company.dragonbones.core.armature.Slot;

/**
 * @internal
 * @private
 */
public abstract class SlotTimelineState extends TweenTimelineState {
  public Slot slot;

  protected void _onClear() {
    super._onClear();

    this.slot = null; //
  }
}
