package com.kendao.libgdx.company.dragonbones.libgdx.compat;

import com.kendao.libgdx.company.dragonbones.core.event.EventStringType;

import java.util.function.Consumer;

public class EgretEventDispatcher {
  public void dispatchEvent(EgretEvent event) {
    throw new RuntimeException("Not implemented");
  }

  public boolean hasEventListener(EventStringType type) {
    throw new RuntimeException("Not implemented");
  }

  public void addEventListener(EventStringType type, Consumer<EgretEvent> listener, Object target) {
    throw new RuntimeException("Not implemented");
  }

  public void removeEventListener(EventStringType type, Consumer<EgretEvent> listener, Object target) {
    throw new RuntimeException("Not implemented");
  }
}
