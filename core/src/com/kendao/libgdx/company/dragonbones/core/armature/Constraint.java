package com.kendao.libgdx.company.dragonbones.core.armature;

import com.kendao.libgdx.company.dragonbones.core.core.BaseObject;
import com.kendao.libgdx.company.dragonbones.core.geom.Matrix;
import com.kendao.libgdx.company.dragonbones.core.geom.Point;
import com.kendao.libgdx.company.dragonbones.core.geom.Transform;

/**
 * @private
 * @internal
 */
public abstract class Constraint extends BaseObject {
  protected static final Matrix _helpMatrix = new Matrix();
  protected static final Transform _helpTransform = new Transform();
  protected static final Point _helpPoint = new Point();

  public Bone target;
  public Bone bone;

  public Bone root;

  protected void _onClear() {
    this.target = null; //
    this.bone = null; //
    this.root = null; //
  }

  public abstract void update();
}
