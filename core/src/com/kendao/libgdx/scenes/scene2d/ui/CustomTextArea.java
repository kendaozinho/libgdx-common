package com.kendao.libgdx.scenes.scene2d.ui;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.TextArea;

public class CustomTextArea extends ScrollPane {
  public CustomTextArea(int x, int y, int width, int height) {
    super(
        new TextArea("", CustomSkin.getInstance()) {
          {
            super.setDisabled(true);
          }

          @Override
          public float getPrefHeight() {
            return ((super.getLines() + 1) * super.getStyle().font.getLineHeight());
          }
        },
        CustomSkin.getInstance()
    );

    super.setPosition(x, y);
    super.setSize(width, height);

    super.setFadeScrollBars(Gdx.app.getType() != Application.ApplicationType.Desktop);
    super.setFlickScroll(true);
  }

  public void scrollDown() {
    super.addAction(
        Actions.sequence(
            Actions.delay(0.05f),
            new Action() {
              @Override
              public boolean act(float delta) {
                layout();
                scrollTo(0, 0, 0, 0);

                return true;
              }
            }
        )
    );
  }

  public void addText(String text) {
    if (super.getActor() instanceof TextArea) {
      ((TextArea) super.getActor()).setText(((TextArea) super.getActor()).getText() + text + "\n");
    }

    this.scrollDown();
  }

  public void clearText() {
    this.setText("");
  }

  public void setText(String text) {
    if (super.getActor() instanceof TextArea) {
      ((TextArea) super.getActor()).setText(text);
    }

    this.showScroll();
  }

  public void showScroll() {
    super.addAction(
        Actions.sequence(
            Actions.delay(0.05f),
            new Action() {
              @Override
              public boolean act(float delta) {
                layout();
                return true;
              }
            }
        )
    );
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
