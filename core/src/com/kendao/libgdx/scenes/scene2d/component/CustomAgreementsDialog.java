package com.kendao.libgdx.scenes.scene2d.component;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.Align;
import com.kendao.libgdx.scenes.scene2d.ui.CustomDialog;
import com.kendao.libgdx.scenes.scene2d.ui.CustomLabel;
import com.kendao.libgdx.scenes.scene2d.ui.CustomTable;
import com.kendao.libgdx.scenes.scene2d.ui.CustomTextButton;
import com.kendao.libgdx.screen.base.CustomScreenManager;
import com.kendao.libgdx.storage.CustomPreferences;

public class CustomAgreementsDialog {
  private final CustomDialog dialog;

  public CustomAgreementsDialog(String termsAndConditionsUrl, String privacyPolicyUrl, Runnable callback, int width, int height) {
    CustomLabel label = new CustomLabel(
        "FIRST OF ALL, YOU NEED TO\nACCEPT OUR TERMS OF SERVICE AND\nREAD OUR PRIVACY POLICY.",
        CustomLabel.Sizes.EXTRA_SMALL
    ) {{
      super.setAlignment(Align.center);
    }};
    CustomTextButton termsAndConditions = new CustomTextButton("TERMS & CONDITIONS", new ChangeListener() {
      @Override
      public void changed(ChangeEvent event, Actor actor) {
        Gdx.net.openURI(termsAndConditionsUrl);
      }
    });
    CustomTextButton privacyPolicy = new CustomTextButton("PRIVACY POLICY", new ChangeListener() {
      @Override
      public void changed(ChangeEvent event, Actor actor) {
        Gdx.net.openURI(privacyPolicyUrl);
      }
    });

    this.dialog = new CustomDialog(
        "WELCOME!",
        new CustomTable() {{
          super.addRow(label);
          super.addRow(termsAndConditions);
          super.addRow(privacyPolicy);
        }},
        CustomDialog.createButton("ACCEPT", Color.LIME),
        width, height
    ) {
      @Override
      public void result(Object response) {
        CustomPreferences.getInstance().setAgreementsAccepted(true);

        callback.run();

        remove();
      }
    };
  }

  /***
   * @return if dialog was opened.
   */
  public boolean validate() {
    if (!CustomPreferences.getInstance().isAgreementsAccepted()) {
      CustomScreenManager.getInstance().getScreen().getHudStage().addActor(this.dialog);
      return true;
    } else {
      return false;
    }
  }
}
