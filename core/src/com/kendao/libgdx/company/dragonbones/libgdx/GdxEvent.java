package com.kendao.libgdx.company.dragonbones.libgdx;

import com.kendao.libgdx.company.dragonbones.core.animation.AnimationState;
import com.kendao.libgdx.company.dragonbones.core.armature.Armature;
import com.kendao.libgdx.company.dragonbones.core.armature.Bone;
import com.kendao.libgdx.company.dragonbones.core.armature.Slot;
import com.kendao.libgdx.company.dragonbones.core.event.EventObject;
import com.kendao.libgdx.company.dragonbones.core.event.EventStringType;
import com.kendao.libgdx.company.dragonbones.libgdx.compat.EgretEvent;

/**
 * Egret 事件。
 *
 * @version DragonBones 4.5
 * @language zh_CN
 */
class GdxEvent extends EgretEvent {
  /**
   * @see EventObject#SOUND_EVENT
   * @deprecated 已废弃，请参考 @see
   */
  public static final EventStringType SOUND = EventObject.SOUND_EVENT;
  /**
   * @see EventObject#START
   * @deprecated 已废弃，请参考 @see
   */
  public static EventStringType START = EventObject.START;
  /**
   * @see EventObject#LOOP_COMPLETE
   * @deprecated 已废弃，请参考 @see
   */
  public static EventStringType LOOP_COMPLETE = EventObject.LOOP_COMPLETE;
  /**
   * @see EventObject#COMPLETE
   * @deprecated 已废弃，请参考 @see
   */
  public static EventStringType COMPLETE = EventObject.COMPLETE;
  /**
   * @see EventObject#FADE_IN
   * @deprecated 已废弃，请参考 @see
   */
  public static EventStringType FADE_IN = EventObject.FADE_IN;
  /**
   * @see EventObject#FADE_IN_COMPLETE
   * @deprecated 已废弃，请参考 @see
   */
  public static EventStringType FADE_IN_COMPLETE = EventObject.FADE_IN_COMPLETE;
  /**
   * @see EventObject#FADE_OUT
   * @deprecated 已废弃，请参考 @see
   */
  public static EventStringType FADE_OUT = EventObject.FADE_OUT;
  /**
   * @see EventObject#FADE_OUT_COMPLETE
   * @deprecated 已废弃，请参考 @see
   */
  public static EventStringType FADE_OUT_COMPLETE = EventObject.FADE_OUT_COMPLETE;
  /**
   * @see EventObject#FRAME_EVENT
   * @deprecated 已废弃，请参考 @see
   */
  public static EventStringType FRAME_EVENT = EventObject.FRAME_EVENT;
  /**
   * @see EventObject#SOUND_EVENT
   * @deprecated 已废弃，请参考 @see
   */
  public static EventStringType SOUND_EVENT = EventObject.SOUND_EVENT;
  /**
   * @see EventObject#FRAME_EVENT
   * @deprecated 已废弃，请参考 @see
   */
  public static EventStringType ANIMATION_FRAME_EVENT = EventObject.FRAME_EVENT;
  /**
   * @see EventObject#FRAME_EVENT
   * @deprecated 已废弃，请参考 @see
   */
  public static EventStringType BONE_FRAME_EVENT = EventObject.FRAME_EVENT;
  /**
   * @see EventObject#FRAME_EVENT
   * @deprecated 已废弃，请参考 @see
   */
  public static EventStringType MOVEMENT_FRAME_EVENT = EventObject.FRAME_EVENT;

  /**
   * 事件对象。
   *
   * @version DragonBones 4.5
   * @language zh_CN
   * @see EventObject
   */
  public EventObject getEventObject() {
    return this.data;
  }

  /**
   * @see #getEventObject()
   * @see EventObject#animationState
   * @deprecated 已废弃，请参考 @see
   */
  public String getAnimationName() {
    AnimationState animationState = this.getEventObject().animationState;
    return animationState != null ? animationState.name : "";
  }

  /**
   * @see #getEventObject()
   * @see EventObject#armature
   * @deprecated 已废弃，请参考 @see
   */
  public Armature getArmature() {
    return this.getEventObject().armature;
  }

  /**
   * @see #getEventObject()
   * @see EventObject#bone
   * @deprecated 已废弃，请参考 @see
   */

  public Bone getBone() {
    return this.getEventObject().bone;
  }

  /**
   * @see #getEventObject()
   * @see EventObject#slot
   * @deprecated 已废弃，请参考 @see
   */

  public Slot getSlot() {
    return this.getEventObject().slot;
  }

  /**
   * @see #getEventObject()
   * @see EventObject#animationState
   * @deprecated 已废弃，请参考 @see
   */

  public AnimationState getAnimationState() {
    return this.getEventObject().animationState;
  }

  /**
   * @see EventObject#name
   * @deprecated 已废弃，请参考 @see
   */
  public String getFrameLabel() {
    return this.getEventObject().name;
  }

  /**
   * @see EventObject#name
   * @deprecated 已废弃，请参考 @see
   */
  public String getSound() {
    return this.getEventObject().name;
  }

  /**
   * @see #getAnimationName()
   * @deprecated 已废弃，请参考 @see
   */
  public String getMovementID() {
    return this.getAnimationName();
  }
}