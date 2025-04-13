package com.kendao.libgdx.company.dragonbones.core.animation;

import com.kendao.libgdx.company.dragonbones.core.armature.Bone;

/**
 * @internal
 * @private
 */
public abstract class BoneTimelineState extends TweenTimelineState {
  public Bone bone;
  public BonePose bonePose;

  protected void _onClear() {
    super._onClear();

    this.bone = null; //
    this.bonePose = null; //
  }
}
