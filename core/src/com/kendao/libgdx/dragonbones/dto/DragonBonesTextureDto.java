package com.kendao.libgdx.dragonbones.dto;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.*;
import java.util.stream.Collectors;

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

  public List<String> getAnimationTypes() {
    Set<String> animationTypes = new HashSet<>();

    for (SubTexture subTexture : this.getSubTexture()) {
      String name = subTexture.getName();
      int underscoreIndex = name.indexOf('_');
      if (underscoreIndex > 0) {
        String animationType = name.substring(0, underscoreIndex);
        animationTypes.add(animationType);
      }
    }

    return new ArrayList<>(animationTypes)
        .stream()
        .sorted()
        .collect(Collectors.toList());
  }

  public Map<String, List<TextureRegion>> getTextureRegionsByAnimationType(
      Texture spriteSheet
  ) {
    Map<String, List<TextureRegion>> animations = new HashMap<>();

    for (SubTexture sub : this.getSubTexture()) {
      String fullName = sub.getName();
      String animationName = fullName.contains("_") ? fullName.substring(0, fullName.indexOf("_")) : fullName;

      TextureRegion region = new TextureRegion(
          spriteSheet,
          sub.getX(),
          sub.getY(),
          sub.getWidth(),
          sub.getHeight()
      );

      animations
          .computeIfAbsent(animationName, k -> new ArrayList<>())
          .add(region);
    }

    return animations;
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
