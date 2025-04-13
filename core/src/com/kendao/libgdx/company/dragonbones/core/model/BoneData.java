package com.kendao.libgdx.company.dragonbones.core.model;

import com.kendao.libgdx.company.dragonbones.core.core.BaseObject;
import com.kendao.libgdx.company.dragonbones.core.geom.Transform;
import com.kendao.libgdx.company.dragonbones.core.util.Array;

/**
 * 骨骼数据。
 *
 * @version DragonBones 3.0
 * @language zh_CN
 */
public class BoneData extends BaseObject {
  /**
   * @private
   */
  public final Transform transform = new Transform();
  /**
   * @private
   */
  public final Array<ConstraintData> constraints = new Array<>();
  /**
   * @private
   */
  public boolean inheritTranslation;
  /**
   * @private
   */
  public boolean inheritRotation;
  /**
   * @private
   */
  public boolean inheritScale;
  /**
   * @private
   */
  public boolean inheritReflection;
  /**
   * @private
   */
  public float length;
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

  public UserData userData = null; // Initial value.
  /**
   * 所属的父骨骼数据。
   *
   * @version DragonBones 3.0
   * @language zh_CN
   */

  public BoneData parent;

  /**
   * @private
   */
  protected void _onClear() {
    for (ConstraintData constraint : this.constraints) {
      constraint.returnToPool();
    }

    if (this.userData != null) {
      this.userData.returnToPool();
    }

    this.inheritTranslation = false;
    this.inheritRotation = false;
    this.inheritScale = false;
    this.inheritReflection = false;
    this.length = 0f;
    this.name = "";
    this.transform.identity();
    this.constraints.clear();
    this.userData = null;
    this.parent = null;
  }
}
