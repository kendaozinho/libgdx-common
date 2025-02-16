package com.kendao.libgdx.input;

import com.badlogic.gdx.input.GestureDetector;
import com.kendao.libgdx.listener.CustomGestureListener;

public class CustomGestureDetector extends GestureDetector {
  public CustomGestureDetector(CustomGestureListener directionListener) {
    super(new CustomGestureAdapter(directionListener));
  }
}
