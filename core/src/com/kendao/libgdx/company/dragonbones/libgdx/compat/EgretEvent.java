package com.kendao.libgdx.company.dragonbones.libgdx.compat;

import com.kendao.libgdx.company.dragonbones.core.event.EventObject;
import com.kendao.libgdx.company.dragonbones.core.event.EventStringType;

public class EgretEvent {
  public EventObject data;

  public static void release(EgretEvent event) {
    throw new RuntimeException("Not implemented");
  }

  public static <T extends EgretEvent> T create(Class<T> egretEventClass, EventStringType type) {
    throw new RuntimeException("Not implemented");
  }
}
