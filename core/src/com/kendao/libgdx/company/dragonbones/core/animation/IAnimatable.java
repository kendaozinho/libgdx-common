package com.kendao.libgdx.company.dragonbones.core.animation;

public interface IAnimatable {
  /**
   * 更新时间。
   *
   * @param passedTime 前进的时间。 (以秒为单位)
   * @version DragonBones 3.0
   * @language zh_CN
   */
  void advanceTime(float passedTime);

  /**
   * 当前所属的 WordClock 实例。
   *
   * @version DragonBones 5.0
   * @language zh_CN
   */
  WorldClock getClock();

  void setClock(WorldClock value);
}
