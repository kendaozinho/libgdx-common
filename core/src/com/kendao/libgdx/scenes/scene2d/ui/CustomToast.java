package com.kendao.libgdx.scenes.scene2d.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;
import com.badlogic.gdx.utils.Align;
import com.kendao.libgdx.listener.CustomGameListener;
import com.kendao.libgdx.screen.base.CustomBaseScreen;
import com.kendao.libgdx.screen.base.CustomScreenManager;

public class CustomToast {
  private static void showToast(String message, NotificationTypes type) {
    CustomBaseScreen screen = CustomScreenManager.getInstance().getScreen();

    if (screen != null && screen.getHudStage() != null) {
      int padding = 15;

      // set label

      CustomLabel label = new CustomLabel(message) {{
        this.setPosition(
            (((CustomGameListener) Gdx.app.getApplicationListener()).getFullWidth() / 2) - (super.getWidth() / 2),
            ((CustomGameListener) Gdx.app.getApplicationListener()).getFullHeight() + padding
        );
        this.setAlignment(Align.center);
      }};

      switch (type) {
        case ERROR:
          label.setColor(Color.SCARLET);
          break;
        case SUCCESS:
          label.setColor(Color.LIME);
          break;
        case ALERT:
          label.setColor(Color.GOLD);
          break;
        case INFO:
          label.setColor(Color.ROYAL);
          break;
        default:
          label.setColor(Color.WHITE);
          break;
      }

      // set background

      CustomImage background = new CustomImage(Color.BLACK,
          0, ((CustomGameListener) Gdx.app.getApplicationListener()).getFullHeight(),
          ((CustomGameListener) Gdx.app.getApplicationListener()).getFullWidth(), (int) (label.getHeight() + padding + padding)) {{
        this.getColor().a = 0.80f;
      }};

      // add background actions
      background.addAction(
          new SequenceAction(
              new MoveToAction() {{
                this.setPosition(background.getX(), ((CustomGameListener) Gdx.app.getApplicationListener()).getFullHeight() - background.getHeight());
                this.setDuration(0.30f);
              }},
              Actions.delay(4.0f),
              new MoveToAction() {{
                this.setPosition(background.getX(), ((CustomGameListener) Gdx.app.getApplicationListener()).getFullHeight());
                this.setDuration(0.70f);
              }},
              Actions.removeActor()
          )
      );

      screen.getHudStage().addActor(background);

      // add label actions
      label.addAction(
          new SequenceAction(
              new MoveToAction() {{
                this.setPosition(label.getX(), ((CustomGameListener) Gdx.app.getApplicationListener()).getFullHeight() - label.getHeight() - padding);
                this.setDuration(0.30f);
              }},
              Actions.delay(4.0f),
              new MoveToAction() {{
                this.setPosition(label.getX(), ((CustomGameListener) Gdx.app.getApplicationListener()).getFullHeight() + padding);
                this.setDuration(0.70f);
              }},
              Actions.removeActor()
          )
      );

      screen.getHudStage().addActor(label);
    }
  }

  public static void info(String message) {
    showToast(message, NotificationTypes.INFO);
  }

  public static void success(String message) {
    showToast(message, NotificationTypes.SUCCESS);
  }

  public static void alert(String message) {
    showToast(message, NotificationTypes.ALERT);
  }

  public static void error(String message) {
    CustomToast.error(message, null);
  }

  public static void error(String message, Throwable t) {
    showToast(message + (t == null ? "" : (": " + t)), NotificationTypes.ERROR);
  }

  public enum NotificationTypes {
    SUCCESS, ERROR, INFO, ALERT
  }
}
