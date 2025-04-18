package com.kendao.libgdx.screen.main;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.kendao.libgdx.assets.CustomAssetManager;
import com.kendao.libgdx.screen.base.CustomBaseScreen;

@Deprecated
public class CustomMainScreen extends CustomBaseScreen {
  private Image image;

  public CustomMainScreen() {
  }

  @Override
  protected void load() {
    this.image = new Image(CustomAssetManager.getInstance().getTexture("badlogic.jpg"));

    super.getMainStage().addActor(this.image);
  }

  @Override
  public void handleInput() {
    if (Gdx.input.isKeyJustPressed(Input.Keys.UP)) {
      this.image.setY(this.image.getY() + 10);
    } else if (Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)) {
      this.image.setX(this.image.getX() + 10);
    } else if (Gdx.input.isKeyJustPressed(Input.Keys.DOWN)) {
      this.image.setY(this.image.getY() - 10);
    } else if (Gdx.input.isKeyJustPressed(Input.Keys.LEFT)) {
      this.image.setX(this.image.getX() - 10);
    }
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
