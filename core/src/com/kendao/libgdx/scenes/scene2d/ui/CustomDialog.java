package com.kendao.libgdx.scenes.scene2d.ui;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Cell;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.Align;
import com.kendao.libgdx.assets.CustomAssetManager;
import com.kendao.libgdx.listener.CustomGameListener;
import com.kendao.libgdx.storage.CustomPreferences;

import java.util.AbstractMap;
import java.util.Map;

public class CustomDialog extends Dialog {
  private final Color defaultRedColor = Color.SCARLET;
  private final Color defaultGreenColor = Color.LIME;
  private final Color defaultBlueColor = Color.ROYAL;

  public CustomDialog(String title, String message, boolean twoButtons, int width, int height) {
    super("\n\n" + title.toUpperCase(), CustomSkin.getInstance());

    this.load(
        new CustomLabel(message),
        CustomDialog.createButton("OK", twoButtons ? this.defaultGreenColor : this.defaultBlueColor),
        twoButtons ? CustomDialog.createButton("CANCEL", this.defaultRedColor) : null,
        width, height
    );
  }

  public CustomDialog(String title, String message, Map.Entry<String, Color> button, int width, int height) {
    super("\n\n" + title.toUpperCase(), CustomSkin.getInstance());

    this.load(new CustomLabel(message), button, null, width, height);
  }

  public CustomDialog(String title, String message, Map.Entry<String, Color> firstButton, Map.Entry<String, Color> secondButton, int width, int height) {
    super("\n\n" + title.toUpperCase(), CustomSkin.getInstance());

    this.load(new CustomLabel(message), firstButton, secondButton, width, height);
  }

  public CustomDialog(String title, CustomTable table, boolean twoButtons, int width, int height) {
    super("\n\n" + title.toUpperCase(), CustomSkin.getInstance());

    this.load(
        table,
        CustomDialog.createButton("OK", twoButtons ? this.defaultGreenColor : this.defaultBlueColor),
        twoButtons ? CustomDialog.createButton("CANCEL", this.defaultRedColor) : null,
        width, height
    );
  }

  public CustomDialog(String title, CustomTable table, Map.Entry<String, Color> button, int width, int height) {
    super("\n\n" + title.toUpperCase(), CustomSkin.getInstance());

    this.load(table, button, null, width, height);
  }

  public CustomDialog(String title, CustomTable table, Map.Entry<String, Color> firstButton, Map.Entry<String, Color> secondButton, int width, int height) {
    super("\n\n" + title.toUpperCase(), CustomSkin.getInstance());

    this.load(table, firstButton, secondButton, width, height);
  }

  public static Map.Entry<String, Color> createButton(String text, Color color) {
    return new AbstractMap.SimpleEntry<>(text, color);
  }

  private void load(Actor actor, Map.Entry<String, Color> firstButton, Map.Entry<String, Color> secondButton, int width, int height) {
    // super.debug();

    super.getTitleLabel().setAlignment(Align.center);

    super.getContentTable().add(new CustomLabel("\n"));
    super.getContentTable().row();
    super.getContentTable().add(actor);

    int buttonWidth = width / 2;
    int buttonHeight = 54;

    super.button(firstButton.getKey(), true, this.getTextButtonStyle(buttonWidth, buttonHeight, firstButton.getValue())).pad(5); // sends "true" as the result
    // super.key(Keys.ENTER, true); // sends "true" when the ENTER key is pressed

    if (secondButton != null) {
      super.button(secondButton.getKey(), false, this.getTextButtonStyle(buttonWidth, buttonHeight, secondButton.getValue())).pad(5); // sends "false" as the result
      // super.key(Keys.ESCAPE, false); // sends "false" when the ESCAPE key is pressed
    }

    super.setSize(width, height);

    super.setModal(true);
    super.setMovable(false);
    super.setResizable(false);

    super.setPosition((((CustomGameListener) Gdx.app.getApplicationListener()).getFullWidth() / 2) - (getWidth() / 2), (((CustomGameListener) Gdx.app.getApplicationListener()).getFullHeight() / 2) - (getHeight() / 2));

    super.addListener(new InputListener() {
      @Override
      public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
        if (x >= 0 && x <= getWidth() && y >= 0 && y <= (buttonHeight + 10) /* padding */) {
          cancel();

          if (Gdx.app.getType() == Application.ApplicationType.Android) {
            Gdx.input.setOnscreenKeyboardVisible(false);
          }

          if (isEnabled()) {
            if (CustomPreferences.getInstance().isAudioEnabled()) {
              if (secondButton == null) {
                CustomAssetManager.getInstance().getConfirmSound().play();
              } else {
                if (x <= (getWidth() / 2)) {
                  CustomAssetManager.getInstance().getConfirmSound().play();
                } else {
                  CustomAssetManager.getInstance().getCancelSound().play();
                }
              }
            }
          }
        }
        return true;
      }
    });

    // Close the dialog when player click outside it
    /*
     * addListener(new InputListener() { public boolean touchDown(InputEvent event,
     * float x, float y, int pointer, int button) { if (x < 0 || x > getWidth() || y
     * < 0 || y > getHeight()) { hide(); } return true; } });
     */
  }

  public void enableButtons() {
    for (Cell cell : super.getButtonTable().getCells()) {
      if (cell.getActor() instanceof Button) {
        ((Button) cell.getActor()).setDisabled(false);
      }
    }
  }

  public Boolean isEnabled() {
    for (Cell cell : super.getButtonTable().getCells()) {
      if (cell.getActor() instanceof Button) {
        return !(((Button) cell.getActor()).isDisabled());
      }
    }
    return null;
  }

  public void disableButtons() {
    for (Cell cell : super.getButtonTable().getCells()) {
      if (cell.getActor() instanceof Button) {
        ((Button) cell.getActor()).setDisabled(true);
      }
    }
  }

  public Boolean isDisabled() {
    for (Cell cell : super.getButtonTable().getCells()) {
      if (cell.getActor() instanceof Button) {
        return (((Button) cell.getActor()).isDisabled());
      }
    }
    return null;
  }

  private TextButton.TextButtonStyle getTextButtonStyle(int width, int height, Color color) {
    TextButton.TextButtonStyle buttonStyle =
        new TextButton.TextButtonStyle(CustomSkin.getInstance().get(TextButton.TextButtonStyle.class));

    buttonStyle.up = new CustomImage(color, 0, 0, width, height).getDrawable();
    buttonStyle.down = new CustomImage(Color.GRAY, 0, 0, width, height).getDrawable();
    buttonStyle.over = new CustomImage(Color.LIGHT_GRAY, 0, 0, width, height).getDrawable();
    buttonStyle.disabled = new CustomImage(Color.DARK_GRAY, 0, 0, width, height).getDrawable();

    return buttonStyle;
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
