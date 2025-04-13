package com.kendao.libgdx.company.dragonbones.core.model;

import com.kendao.libgdx.company.dragonbones.core.core.ActionType;
import com.kendao.libgdx.company.dragonbones.core.core.BaseObject;

/**
 * @private
 */
public class ActionData extends BaseObject {
  public ActionType type;
  public String name; // Frame event name | Sound event name | Animation name
  public
  BoneData bone;
  public
  SlotData slot;
  public
  UserData data = null; //

  protected void _onClear() {
    if (this.data != null) {
      this.data.returnToPool();
    }

    this.type = ActionType.Play;
    this.name = "";
    this.bone = null;
    this.slot = null;
    this.data = null;
  }
}
