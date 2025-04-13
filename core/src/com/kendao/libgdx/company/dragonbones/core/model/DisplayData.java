package com.kendao.libgdx.company.dragonbones.core.model;

import com.kendao.libgdx.company.dragonbones.core.core.BaseObject;
import com.kendao.libgdx.company.dragonbones.core.core.DisplayType;
import com.kendao.libgdx.company.dragonbones.core.geom.Transform;

/**
 * @private
 */
public abstract class DisplayData extends BaseObject {
  public final Transform transform = new Transform();
  public DisplayType type;
  public String name;
  public String path;
  public ArmatureData parent;

  protected void _onClear() {
    this.name = "";
    this.path = "";
    this.transform.identity();
    this.parent = null; //
  }
}

