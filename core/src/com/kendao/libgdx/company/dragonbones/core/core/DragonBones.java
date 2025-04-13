package com.kendao.libgdx.company.dragonbones.core.core;

import com.kendao.libgdx.company.dragonbones.core.animation.WorldClock;
import com.kendao.libgdx.company.dragonbones.core.armature.Armature;
import com.kendao.libgdx.company.dragonbones.core.event.EventObject;
import com.kendao.libgdx.company.dragonbones.core.event.IEventDispatcher;
import com.kendao.libgdx.company.dragonbones.core.util.Array;

/**
 * @private
 */
public class DragonBones {
  public static boolean yDown = true;
  public static boolean debug = false;
  public static boolean debugDraw = false;
  public static String VERSION = "5.1f";

  private final WorldClock _clock = new WorldClock();
  private final Array<EventObject> _events = new Array<>();
  private final Array<BaseObject> _objects = new Array<>();
  private IEventDispatcher _eventManager = null;

  public DragonBones(IEventDispatcher eventManager) {
    this._eventManager = eventManager;
  }

  public void advanceTime(float passedTime) {
    if (this._objects.size() > 0) {
      for (BaseObject object : this._objects) {
        object.returnToPool();
      }

      this._objects.clear();
    }

    this._clock.advanceTime(passedTime);

    if (this._events.size() > 0) {
      for (int i = 0; i < this._events.size(); ++i) {
        EventObject eventObject = this._events.get(i);
        Armature armature = eventObject.armature;

        armature.getEventDispatcher()._dispatchEvent(eventObject.type, eventObject);
        if (eventObject.type == EventObject.SOUND_EVENT) {
          this._eventManager._dispatchEvent(eventObject.type, eventObject);
        }

        this.bufferObject(eventObject);
      }

      this._events.clear();
    }
  }

  public void bufferEvent(EventObject value) {
    if (this._events.indexOf(value) < 0) {
      this._events.add(value);
    }
  }

  public void bufferObject(BaseObject object) {
    if (this._objects.indexOf(object) < 0) {
      this._objects.add(object);
    }
  }

  public WorldClock getClock() {
    return this._clock;
  }

  public IEventDispatcher getEventManager() {
    return this._eventManager;
  }
}
