package com.kendao.libgdx.scenes.scene2d.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;

public class CustomTextField extends TextField {
  private final int defaultWidth = 120;
  private final int defaultHeight = 25;

  private boolean isUpperCase = false;

  public CustomTextField(String title) {
    super("", CustomSkin.getInstance());
    this.instantiate(title, 50, false, false, CharTypes.ALL);
  }

  public CustomTextField(String title, CharTypes type) {
    super("", CustomSkin.getInstance());
    this.instantiate(title, 50, false, false, type);
  }

  public CustomTextField(String title, CharTypes type, int maxLength) {
    super("", CustomSkin.getInstance());
    this.instantiate(title, maxLength, false, false, type);
  }

  public CustomTextField(String title, CharTypes type, int maxLength, boolean isUpperCase) {
    super("", CustomSkin.getInstance());
    this.instantiate(title, maxLength, isUpperCase, false, type);
  }

  public CustomTextField(String title, CharTypes type, int maxLength, boolean isUpperCase, boolean isPassword) {
    super("", CustomSkin.getInstance());
    this.instantiate(title, maxLength, isUpperCase, isPassword, type);
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
    return this.getPlaceholder();
  }

  /**
   * @deprecated Use {@link #setPlaceholder(String)} method
   */
  @Override
  @Deprecated
  public void setMessageText(String text) {
    this.setPlaceholder(text);
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
        // Pressing ENTER
        // if (character == '\n' || character == '\r') {
        //   unfocus();
        //   return true;
        // }
        return super.keyTyped(event, isUpperCase ? Character.toUpperCase(character) : character);
      }
    };
  }

  @Override
  public void setText(String str) {
    super.setText(str == null ? "" : (this.isUpperCase ? str.toUpperCase() : str));
    super.setCursorPosition(super.getText().length());
  }

  public void focus() {
    super.getListeners().forEach(listener -> {
      if (listener instanceof ClickListener) {
        ((ClickListener) listener).clicked(null, 0, 0); // Call click event manually
      }
    });
  }

  private void instantiate(String title, int maxLength, boolean isUpperCase, boolean isPassword, final CharTypes type) {
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

    // Disable default virtual keyboard
    super.setOnscreenKeyboard(visible -> {
      // do nothing
    });

    super.addListener(new ClickListener() {
      @Override
      public void clicked(InputEvent event, float x, float y) {
        // click effect
        selectAll(); // or setCursorPosition(getText().length());

        Gdx.input.getTextInput(new Input.TextInputListener() {
          @Override
          public void input(String text) {
            setText(text);
          }

          @Override
          public void canceled() {
            // do nothing
          }
        }, title, getText(), "");
      }
    });
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

  public enum CharTypes {ONLY_LETTERS, ONLY_NUMBERS, ONLY_LETTERS_WITH_SPACE, ONLY_LETTERS_AND_NUMBERS, ALL}
}
