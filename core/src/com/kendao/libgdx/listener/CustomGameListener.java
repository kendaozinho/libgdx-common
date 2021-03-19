package com.kendao.libgdx.listener;

public interface CustomGameListener {
  public Integer getFullWidth();

  public Integer getFullHeight();

  public <T> T getInstanceOf(Class<T> clazz);
}
