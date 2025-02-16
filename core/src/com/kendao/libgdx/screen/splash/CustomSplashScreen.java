package com.kendao.libgdx.screen.splash;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.utils.Align;
import com.kendao.libgdx.assets.CustomAssetManager;
import com.kendao.libgdx.listener.CustomGameListener;
import com.kendao.libgdx.scenes.scene2d.ui.CustomLabel;
import com.kendao.libgdx.screen.base.CustomBaseScreen;
import com.kendao.libgdx.screen.base.CustomScreenManager;
import com.kendao.libgdx.screen.main.CustomMainScreen;

@Deprecated
public class CustomSplashScreen extends CustomBaseScreen {
  public CustomSplashScreen() {
  }

  @Override
  protected void load() {
    CustomLabel label = new CustomLabel("libgdx-common\n\ndeveloped by\nlunar bits", Color.WHITE, CustomLabel.Sizes.LARGE);
    label.setPosition((((CustomGameListener) Gdx.app.getApplicationListener()).getFullWidth() / 2) - (label.getWidth() / 2), (((CustomGameListener) Gdx.app.getApplicationListener()).getFullHeight() / 2) - (label.getHeight() / 2));
    label.setAlignment(Align.center);
    label.hide();

    super.getHudStage().addActor(label);

    label.addAction(
        Actions.sequence(
            Actions.delay(0.5f),
            Actions.fadeIn(1f),
            Actions.run(
                () -> CustomAssetManager.getInstance().loadAllAssets()
            ),
            Actions.delay(1f), // Waiting to load the assets
            Actions.fadeOut(1f),
            Actions.delay(0.5f),
            Actions.run(
                () -> CustomScreenManager.getInstance().setScreen(new CustomMainScreen())
            )
        )
    );
  }

  @Override
  public void handleInput() {
  }

  @Override
  public void update(float deltaTime) {
  }

  @Override
  protected void render() {
  }

  @Override
  protected void pause() {
  }

  @Override
  protected void resume() {
  }

  @Override
  protected void dispose() {
  }

  @Override
  public void swipeLeft() {
  }

  @Override
  public void swipeRight() {
  }

  @Override
  public void swipeUp() {
  }

  @Override
  public void swipeDown() {
  }

  @Override
  public void zoomIn() {
  }

  @Override
  public void zoomOut() {
  }

  @Override
  public void touchDown(float x, float y) {
  }

  @Override
  public void touchUp(float x, float y) {
  }

  @Override
  public void touchDragged(float x, float y) {
  }
}
