package com.kendao.libgdx.scenes.scene2d.ui;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.utils.Align;

public class CustomTextField extends TextField {
  private final int defaultWidth = 120;
  private final int defaultHeight = 25;

  private boolean isUpperCase = false;

  public CustomTextField() {
    super("", CustomSkin.getInstance());
    this.instantiate(50, false, false, CharTypes.ALL);
  }

  public CustomTextField(CharTypes type) {
    super("", CustomSkin.getInstance());
    this.instantiate(50, false, false, type);
  }

  public CustomTextField(CharTypes type, int maxLength) {
    super("", CustomSkin.getInstance());
    this.instantiate(maxLength, false, false, type);
  }

  public CustomTextField(CharTypes type, int maxLength, boolean isUpperCase) {
    super("", CustomSkin.getInstance());
    this.instantiate(maxLength, isUpperCase, false, type);
  }

  public CustomTextField(CharTypes type, int maxLength, boolean isUpperCase, boolean isPassword) {
    super("", CustomSkin.getInstance());
    this.instantiate(maxLength, isUpperCase, isPassword, type);
  }

  public void clearText() {
    super.setText("");
  }

  /**
   * @deprecated Use {@link #getPlaceholder()} method
   */
  @Override
  @Deprecated
  public String getMessageText() {
    return null;
  }

  /**
   * @deprecated Use {@link #setPlaceholder(String)} method
   */
  @Override
  @Deprecated
  public void setMessageText(String text) {
  }

  /**
   * @return Never null, might be an empty string.
   */
  public String getPlaceholder() {
    String placeholder = super.getMessageText();
    if (placeholder == null) {
      return "";
    }
    return placeholder.trim();
  }

  public void setPlaceholder(String text) {
    super.setMessageText(text);
  }

  @Override
  protected InputListener createInputListener() {
    return new TextFieldClickListener() {
      @Override
      public boolean keyTyped(InputEvent event, char character) {
        return super.keyTyped(event, isUpperCase ? Character.toUpperCase(character) : character);
      }
    };
  }

  @Override
  public void setText(String str) {
    super.setText(this.isUpperCase ? str.toUpperCase() : str);
    super.setCursorPosition(super.getText().length());
  }

  public void focus(Boolean showOnScreenKeyBoard) {
    if (super.getStage() != null) {
      super.getStage().setKeyboardFocus(this);
      super.setCursorPosition(super.getText().length());
      if (showOnScreenKeyBoard) {
        super.getOnscreenKeyboard().show(true);
      }
    }
  }

  private void instantiate(int maxLength, boolean isUpperCase, boolean isPassword, final CharTypes type) {
    super.setPosition(0, 0);
    super.setSize(this.defaultWidth, this.defaultHeight);

    super.setAlignment(Align.left);
    super.setMaxLength(maxLength);

    this.isUpperCase = isUpperCase;

    // Block the tab button
    super.setFocusTraversal(false);

    if (isPassword) {
      super.setPasswordMode(true);
      super.setPasswordCharacter('*');
    }

    if (!type.equals(CharTypes.ALL)) {
      super.setTextFieldFilter((textField, c) -> {
        final String numbers = "0123456789";
        final String letters = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";

        char[] acceptedChars = null;

        if (type.equals(CharTypes.ONLY_NUMBERS)) {
          acceptedChars = numbers.toCharArray();
        } else if (type.equals(CharTypes.ONLY_LETTERS)) {
          acceptedChars = letters.toCharArray();
        } else if (type.equals(CharTypes.ONLY_LETTERS_WITH_SPACE)) {
          acceptedChars = (letters + " ").toCharArray();
        } else if (type.equals(CharTypes.ONLY_LETTERS_AND_NUMBERS)) {
          acceptedChars = (numbers + letters).toCharArray();
        }

        if (acceptedChars != null) {
          for (char a : acceptedChars) {
            if (a == c) {
              return true;
            }
          }
        }

        return false;
      });
    }
  }

  public enum CharTypes {ONLY_LETTERS, ONLY_NUMBERS, ONLY_LETTERS_WITH_SPACE, ONLY_LETTERS_AND_NUMBERS, ALL}
}
