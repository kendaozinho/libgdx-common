package com.kendao.libgdx.scenes.scene2d;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.kendao.libgdx.listener.CustomGameListener;

public class CustomStage extends Stage {
  private final Boolean enableCameraFeatures;
  private final Float minZoomValue, maxZoomValue;

  public CustomStage(Boolean enableCameraFeatures, Float minZoomValue, Float maxZoomValue) {
    super(new StretchViewport(
        ((CustomGameListener) Gdx.app.getApplicationListener()).getFullWidth(),
        ((CustomGameListener) Gdx.app.getApplicationListener()).getFullHeight(),
        new OrthographicCamera(
            ((CustomGameListener) Gdx.app.getApplicationListener()).getFullWidth(),
            ((CustomGameListener) Gdx.app.getApplicationListener()).getFullHeight()
        )
    ));
    this.enableCameraFeatures = enableCameraFeatures;
    this.minZoomValue = minZoomValue;
    this.maxZoomValue = maxZoomValue;
  }

  public void updateCameraPosition(int x, int y, int z) {
    super.getViewport().getCamera().position.set(x, y, z);
    super.getViewport().getCamera().update();
  }

  @Override
  public boolean scrolled(float amountX, float amountY) {
    boolean response = super.scrolled(amountX, amountY);

    if (Boolean.TRUE.equals(this.enableCameraFeatures)) {
      if (amountX == -1 || amountY == -1) {
        this.zoomIn();
      } else if (amountX == 1 || amountY == 1) {
        this.zoomOut();
      }
    }

    return response;
  }

  public void zoomIn() {
    this.zoomIn(0.25f);
  }

  public void zoomIn(float quantity) {
    if (this.minZoomValue != null && ((OrthographicCamera) super.getViewport().getCamera()).zoom > this.minZoomValue /* 1.0f is default */) {
      ((OrthographicCamera) super.getViewport().getCamera()).zoom -= quantity;
    }
  }

  public void zoomOut() {
    this.zoomOut(0.25f);
  }

  public void zoomOut(float quantity) {
    if (this.maxZoomValue != null && ((OrthographicCamera) super.getViewport().getCamera()).zoom < this.maxZoomValue /* 1.0f is default */) {
      ((OrthographicCamera) super.getViewport().getCamera()).zoom += quantity;
    }
  }

  public Boolean getEnableCameraFeatures() {
    return this.enableCameraFeatures;
  }

  public Float getMinZoomValue() {
    return this.minZoomValue;
  }

  public Float getMaxZoomValue() {
    return this.maxZoomValue;
  }
}
