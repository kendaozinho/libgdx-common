package com.kendao.libgdx.listener;

public interface CustomGameListener {
  Integer getFullWidth();

  Integer getFullHeight();

  <T> T getInstanceOf(Class<T> clazz);
}
