package com.kendao.libgdx.dragonbones.dto;

import java.util.ArrayList;
import java.util.List;

public class DragonBonesTextureDto {
  private String name;
  private List<SubTexture> SubTexture;
  private String imagePath;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<SubTexture> getSubTexture() {
    return SubTexture == null ? new ArrayList<>() : SubTexture;
  }

  public void setSubTexture(List<SubTexture> subTexture) {
    SubTexture = subTexture;
  }

  public String getImagePath() {
    return imagePath;
  }

  public void setImagePath(String imagePath) {
    this.imagePath = imagePath;
  }

  public static class SubTexture {
    private String name;
    private int x;
    private int y;
    private int width;
    private int height;

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public int getX() {
      return x;
    }

    public void setX(int x) {
      this.x = x;
    }

    public int getY() {
      return y;
    }

    public void setY(int y) {
      this.y = y;
    }

    public int getWidth() {
      return width;
    }

    public void setWidth(int width) {
      this.width = width;
    }

    public int getHeight() {
      return height;
    }

    public void setHeight(int height) {
      this.height = height;
    }
  }
}
