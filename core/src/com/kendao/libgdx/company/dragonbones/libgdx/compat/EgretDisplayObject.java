package com.kendao.libgdx.company.dragonbones.libgdx.compat;

import com.kendao.libgdx.company.dragonbones.core.core.BlendMode;
import com.kendao.libgdx.company.dragonbones.core.geom.Matrix;
import com.kendao.libgdx.company.dragonbones.core.util.Array;

public class EgretDisplayObject extends EgretEventDispatcher {
  public String name;
  public double x;
  public double y;
  public Array<EgretFilter> filters = new Array<>();
  public BlendMode blendMode;
  public boolean visible;
  private EgretDisplayObjectContainer _parent;

  public void $setMatrix(Matrix globalTransformMatrix, boolean b) {
    throw new RuntimeException("Not implemented");
  }

  public Matrix getMatrix() {
    throw new RuntimeException("Not implemented");
  }

  public void $setAnchorOffsetX(float pivotX) {
    throw new RuntimeException("Not implemented");
  }

  public void $setAnchorOffsetY(float pivotY) {
    throw new RuntimeException("Not implemented");
  }

  public void $updateVertices() {
    throw new RuntimeException("Not implemented");
  }

  public EgretDisplayObjectContainer getParent() {
    return _parent;
  }

  public void $setAlpha(double v) {
    throw new RuntimeException("Not implemented");
  }
}
