package com.kendao.libgdx.company.dragonbones.libgdx;

import com.kendao.libgdx.company.dragonbones.core.animation.WorldClock;
import com.kendao.libgdx.company.dragonbones.core.armature.Armature;
import com.kendao.libgdx.company.dragonbones.core.armature.Slot;
import com.kendao.libgdx.company.dragonbones.core.core.BaseObject;
import com.kendao.libgdx.company.dragonbones.core.core.DragonBones;
import com.kendao.libgdx.company.dragonbones.core.factory.BaseFactory;
import com.kendao.libgdx.company.dragonbones.core.factory.BuildArmaturePackage;
import com.kendao.libgdx.company.dragonbones.core.model.DisplayData;
import com.kendao.libgdx.company.dragonbones.core.model.DragonBonesData;
import com.kendao.libgdx.company.dragonbones.core.model.SlotData;
import com.kendao.libgdx.company.dragonbones.core.model.TextureAtlasData;
import com.kendao.libgdx.company.dragonbones.core.util.Array;
import com.kendao.libgdx.company.dragonbones.core.util.Console;
import com.kendao.libgdx.company.dragonbones.libgdx.compat.EgretBitmap;
import com.kendao.libgdx.company.dragonbones.libgdx.compat.EgretGlobals;
import com.kendao.libgdx.company.dragonbones.libgdx.compat.EgretMesh;
import com.kendao.libgdx.company.dragonbones.libgdx.compat.EgretTexture;

/**
 * Egret 工厂。
 *
 * @version DragonBones 3.0
 * @language zh_CN
 */
public class GdxFactory extends BaseFactory {
  private static float _time = 0;
  private static DragonBones _dragonBones = null;
  private static GdxFactory _factory = null;

  /**
   * @inheritDoc
   */
  public GdxFactory() {
    super();

    if (GdxFactory._dragonBones == null) {
      GdxArmatureDisplay eventManager = new GdxArmatureDisplay();
      GdxFactory._dragonBones = new DragonBones(eventManager);
      GdxFactory._dragonBones.getClock().time = (float) (EgretGlobals.getTimer() * 0.001);
      EgretGlobals.startTick(GdxFactory::_clockHandler);
    }

    this._dragonBones = GdxFactory._dragonBones;
  }

  private static boolean _clockHandler(double time) {
    time *= 0.001f;
    double passedTime = time - GdxFactory._time;
    GdxFactory._dragonBones.advanceTime((float) passedTime);
    GdxFactory._time = (float) time;

    return false;
  }

  /**
   * 一个可以直接使用的全局 WorldClock 实例。(由引擎驱动)
   *
   * @version DragonBones 5.0
   * @language zh_CN
   */
  public static WorldClock getClock() {
    return GdxFactory._dragonBones.getClock();
  }

  /**
   * 一个可以直接使用的全局工厂实例。
   *
   * @version DragonBones 4.7
   * @language zh_CN
   */
  public static GdxFactory getFactory() {
    if (GdxFactory._factory == null) {
      GdxFactory._factory = new GdxFactory();
    }

    return GdxFactory._factory;
  }

  /**
   * @private
   */
  protected boolean _isSupportMesh() {
    return true;
  }

  @Override
  protected TextureAtlasData _buildTextureAtlasData(TextureAtlasData textureAtlasData, Object textureAtlas) {
    return _buildTextureAtlasData((GdxTextureAtlasData) textureAtlasData, textureAtlas);
  }

  /**
   * @private
   */
  //protected GdxTextureAtlasData _buildTextureAtlasData( GdxTextureAtlasData textureAtlasData, Texture textureAtlas) {
  protected GdxTextureAtlasData _buildTextureAtlasData(GdxTextureAtlasData textureAtlasData, Object textureAtlas) {
    if (textureAtlasData != null) {
      textureAtlasData.setRenderTexture((EgretTexture) textureAtlas);
    } else {
      textureAtlasData = BaseObject.borrowObject(GdxTextureAtlasData.class);
    }

    return textureAtlasData;
  }

  /**
   * @private
   */
  protected Armature _buildArmature(BuildArmaturePackage dataPackage) {
    Armature armature = BaseObject.borrowObject(Armature.class);
    GdxArmatureDisplay armatureDisplay = new GdxArmatureDisplay();

    armature.init(
        dataPackage.armature,
        armatureDisplay, armatureDisplay, this._dragonBones
    );

    return armature;
  }

  /**
   * @private
   */
  protected Slot _buildSlot(BuildArmaturePackage dataPackage, SlotData slotData, Array<DisplayData> displays, Armature armature) {
    //dataPackage;
    //armature;
    GdxSlot slot = BaseObject.borrowObject(GdxSlot.class);
    slot.init(
        slotData, displays,
        new EgretBitmap(), new EgretMesh()
    );

    return slot;
  }

  /**
   * 创建一个指定名称的骨架。
   *
   * @param armatureName     骨架名称。
   * @param dragonBonesName  龙骨数据名称，如果未设置，将检索所有的龙骨数据，如果多个数据中包含同名的骨架数据，可能无法创建出准确的骨架。
   * @param skinName         皮肤名称，如果未设置，则使用默认皮肤。
   * @param textureAtlasName 贴图集数据名称，如果未设置，则使用龙骨数据。
   * @returns 骨架的显示容器。
   * @version DragonBones 4.5
   * @language zh_CN
   * @see GdxArmatureDisplay
   */

  public GdxArmatureDisplay buildArmatureDisplay(String armatureName, String dragonBonesName, String skinName, String textureAtlasName) {
    Armature armature = this.buildArmature(armatureName, dragonBonesName, skinName, textureAtlasName);
    if (armature != null) {
      this._dragonBones.getClock().add(armature);
      return (GdxArmatureDisplay) armature.getDisplay();
    }

    return null;
  }


  public GdxArmatureDisplay buildArmatureDisplay(String armatureName) {
    return buildArmatureDisplay(armatureName, null, null, null);
  }

  /**
   * 获取带有指定贴图的显示对象。
   *
   * @param textureName      指定的贴图名称。
   * @param textureAtlasName 指定的贴图集数据名称，如果未设置，将检索所有的贴图集数据。
   * @version DragonBones 3.0
   * @language zh_CN
   */

  public EgretBitmap getTextureDisplay(String textureName, String textureAtlasName) {
    GdxTextureData textureData = (GdxTextureData) this._getTextureData(textureAtlasName != null ? textureAtlasName : "", textureName);
    if (textureData != null && textureData.renderTexture != null) {
      return new EgretBitmap(textureData.renderTexture);
    }

    return null;
  }

  public EgretBitmap getTextureDisplay(String textureName) {
    return getTextureDisplay(textureName, null);
  }

  /**
   * 获取全局声音事件管理器。
   *
   * @version DragonBones 4.5
   * @language zh_CN
   */
  public GdxArmatureDisplay getSoundEventManager() {
    return (GdxArmatureDisplay) this._dragonBones.getEventManager();
  }

  /**
   * @see BaseFactory#addDragonBonesData(DragonBonesData, String)
   * @deprecated 已废弃，请参考 @see
   */
  public void addSkeletonData(DragonBonesData dragonBonesData, String dragonBonesName) {
    Console.warn("已废弃，请参考 @see");
    this.addDragonBonesData(dragonBonesData, dragonBonesName);
  }

  public void addSkeletonData(DragonBonesData dragonBonesData) {
    addSkeletonData(dragonBonesData, null);
  }

  /**
   * @see BaseFactory#getDragonBonesData(String)
   * @deprecated 已废弃，请参考 @see
   */
  public DragonBonesData getSkeletonData(String dragonBonesName) {
    Console.warn("已废弃，请参考 @see");
    return this.getDragonBonesData(dragonBonesName);
  }

  /**
   * @see BaseFactory#removeDragonBonesData(String)
   * @deprecated 已废弃，请参考 @see
   */
  public void removeSkeletonData(String dragonBonesName) {
    Console.warn("已废弃，请参考 @see");
    this.removeDragonBonesData(dragonBonesName);
  }

  /**
   * @see BaseFactory#addTextureAtlasData(TextureAtlasData, String)
   * @deprecated 已废弃，请参考 @see
   */
  public void addTextureAtlas(TextureAtlasData textureAtlasData, String dragonBonesName) {
    Console.warn("已废弃，请参考 @see");
    this.addTextureAtlasData(textureAtlasData, dragonBonesName);
  }

  public void addTextureAtlas(TextureAtlasData textureAtlasData) {
    addTextureAtlas(textureAtlasData, null);
  }

  /**
   * @see BaseFactory#getTextureAtlasData(String)
   * @deprecated 已废弃，请参考 @see
   */
  public Array<TextureAtlasData> getTextureAtlas(String dragonBonesName) {
    Console.warn("已废弃，请参考 @see");
    return this.getTextureAtlasData(dragonBonesName);
  }

  /**
   * @see BaseFactory#removeTextureAtlasData(String, boolean)
   * @deprecated 已废弃，请参考 @see
   */
  public void removeTextureAtlas(String dragonBonesName) {
    Console.warn("已废弃，请参考 @see");
    this.removeTextureAtlasData(dragonBonesName);
  }

  /**
   * @see BaseFactory#buildArmature(String)
   * @deprecated 已废弃，请参考 @see
   */

  public Armature buildFastArmature(String armatureName, String dragonBonesName, String skinName) {
    Console.warn("已废弃，请参考 @see");
    return this.buildArmature(armatureName, dragonBonesName, skinName, null);
  }


  public Armature buildFastArmature(String armatureName) {
    return buildFastArmature(armatureName, null, null);
  }

  /**
   * @see BaseFactory#clear()
   * @deprecated 已废弃，请参考 @see
   */
  public void dispose() {
    Console.warn("已废弃，请参考 @see");
    this.clear();
  }

  /**
   * @see GdxFactory#getSoundEventManater()
   * @deprecated 已废弃，请参考 @see
   */
  public GdxArmatureDisplay getSoundEventManater() {
    return this.getSoundEventManager();
  }
}