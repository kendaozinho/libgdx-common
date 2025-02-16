package com.kendao.libgdx.scenes.scene2d.ui;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.kendao.libgdx.assets.CustomAssetManager;
import com.kendao.libgdx.storage.CustomPreferences;

public class CustomCheckBox extends CheckBox {
  private final Object value;
  private boolean enableSound = true;

  public CustomCheckBox(String text, boolean checked) {
    super(" " + (text == null ? "" : text.toUpperCase()), CustomSkin.getInstance());
    super.getCells().get(0).size(25, 25);
    super.setChecked(checked);
    this.value = null;
    this.addListeners();
  }

  public CustomCheckBox(String text, boolean checked, Object id) {
    super(" " + (text == null ? "" : text.toUpperCase()), CustomSkin.getInstance());
    super.getCells().get(0).size(25, 25);
    super.setChecked(checked);
    this.value = id;
    this.addListeners();
  }

  private void addListeners() {
    super.addListener(new ClickListener() {
      @Override
      public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
        if (!isDisabled()) {
          if (enableSound && CustomPreferences.getInstance().isAudioEnabled()) {
            CustomAssetManager.getInstance().getConfirmSound().play();
          }
        }
        return true;
      }
    });
  }

  public void setEnableSound(boolean enableSound) {
    this.enableSound = enableSound;
  }

  public Object getValue() {
    return this.value;
  }

  public String getId() {
    return super.getName();
  }

  public void setId(String id) {
    super.setName(id);
  }

  /**
   * @deprecated Use {@link #getId()} method
   */
  @Deprecated
  @Override
  public String getName() {
    return this.getId();
  }

  /**
   * @deprecated Use {@link #setId(String name)} method
   */
  @Deprecated
  @Override
  public void setName(String name) {
    this.setId(name);
  }
}
