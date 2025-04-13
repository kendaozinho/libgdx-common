package com.kendao.libgdx.company.dragonbones.core.core;

/**
 * @private
 */
public enum ActionType {
  Play(0),
  Frame(10),
  Sound(11);

  public static ActionType[] values = values();
  public final int v;

  ActionType(int v) {
    this.v = v;
  }
}
