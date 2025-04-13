package com.kendao.libgdx.company.dragonbones.core.model;

import com.kendao.libgdx.company.dragonbones.core.core.DisplayType;
import com.kendao.libgdx.company.dragonbones.core.util.Array;

/**
 * @private
 */
public class ArmatureDisplayData extends DisplayData {
  public final Array<ActionData> actions = new Array<>();
  public boolean inheritAnimation;
  public ArmatureData armature;

  protected void _onClear() {
    super._onClear();

    for (ActionData action : this.actions) {
      action.returnToPool();
    }

    this.type = DisplayType.Armature;
    this.inheritAnimation = false;
    this.actions.clear();
    this.armature = null;
  }
}
