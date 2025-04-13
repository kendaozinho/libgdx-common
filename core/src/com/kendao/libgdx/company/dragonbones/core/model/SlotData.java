package com.kendao.libgdx.company.dragonbones.core.model;

import com.kendao.libgdx.company.dragonbones.core.armature.Slot;
import com.kendao.libgdx.company.dragonbones.core.core.BaseObject;
import com.kendao.libgdx.company.dragonbones.core.core.BlendMode;
import com.kendao.libgdx.company.dragonbones.core.geom.ColorTransform;

/**
 * 插槽数据。
 *
 * @version DragonBones 3.0
 * @language zh_CN
 * @see Slot
 */
public class SlotData extends BaseObject {
  /**
   * @private
   */
  public static final ColorTransform DEFAULT_COLOR = new ColorTransform();
  /**
   * @private
   */
  public BlendMode blendMode;
  /**
   * @private
   */
  public int displayIndex;
  /**
   * @private
   */
  public float zOrder;
  /**
   * 数据名称。
   *
   * @version DragonBones 3.0
   * @language zh_CN
   */
  public String name;
  /**
   * @private
   */

  public ColorTransform color = null; // Initial value.
  /**
   * @private
   */

  public UserData userData = null; // Initial value.
  /**
   * 所属的父骨骼数据。
   *
   * @version DragonBones 3.0
   * @language zh_CN
   * @see BoneData
   */
  public BoneData parent;

  /**
   * @private
   */
  public static ColorTransform createColor() {
    return new ColorTransform();
  }

  /**
   * @private
   */
  protected void _onClear() {
    if (this.userData != null) {
      this.userData.returnToPool();
    }

    this.blendMode = BlendMode.Normal;
    this.displayIndex = 0;
    this.zOrder = 0;
    this.name = "";
    this.color = null; //
    this.userData = null;
    this.parent = null; //
  }
}
