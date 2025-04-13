package com.kendao.libgdx.company.dragonbones.core.model;

import com.kendao.libgdx.company.dragonbones.core.core.BaseObject;

/**
 * @private
 */
public abstract class ConstraintData extends BaseObject {
  public float order;
  public BoneData target;
  public BoneData bone;

  public BoneData root;

  protected void _onClear() {
    this.order = 0;
    this.target = null; //
    this.bone = null; //
    this.root = null;
  }
}
