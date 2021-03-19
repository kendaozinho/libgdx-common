package com.kendao.libgdx.storage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.kendao.libgdx.listener.CustomGameListener;

public class CustomPreferences {
  // for Mobile
  private final Preferences preferences;

  // for Desktop
  // private final String configurationFileName = "config.ini";
  // private final Properties properties;

  public CustomPreferences(String id) {
    //if (Gdx.app.getType() == Application.ApplicationType.Desktop) {
    //  this.preferences = null;
    //  this.properties = new java.util.Properties();
    //  try {
    //    this.properties.load(CustomStorage.loadFile(this.configurationFileName).read());
    //  } catch (Throwable t) {
    //    throw new RuntimeException("Unable to load configuration file", t);
    //  }
    //} else {
    this.preferences = Gdx.app.getPreferences(id);
    //  this.properties = null;
    //}
  }

  public static CustomPreferences getInstance() {
    return ((CustomGameListener) Gdx.app.getApplicationListener()).getInstanceOf(CustomPreferences.class);
  }

  public String getPropertyAsString(String key, String defaultValue) {
    //if (Gdx.app.getType() == Application.ApplicationType.Desktop) {
    //  return this.properties.getProperty(key, defaultValue);
    //} else {
    return this.preferences.getString(key, defaultValue);
    //}
  }

  public void setPropertyAsString(String key, String value) {
    //if (Gdx.app.getType() == Application.ApplicationType.Desktop) {
    //  try {
    //    this.properties.setProperty(key, value);
    //    this.properties.store(
    //        new FileOutputStream(CustomStorage.loadFile(this.configurationFileName).file()),
    //        null
    //    );
    //  } catch (Throwable t) {
    //    throw new RuntimeException("Unable to set property in the configuration file", t);
    //  }
    //} else {
    this.preferences.putString(key, value);
    this.preferences.flush();
    //}
  }

  public Integer getPropertyAsInteger(String key, Integer defaultValue) {
    return this.preferences.getInteger(key, defaultValue);
  }

  public void setPropertyAsInteger(String key, Integer value) {
    this.preferences.putInteger(key, value);
    this.preferences.flush();
  }

  public Long getPropertyAsLong(String key, Long defaultValue) {
    return this.preferences.getLong(key, defaultValue);
  }

  public void setPropertyAsLong(String key, Long value) {
    this.preferences.putLong(key, value);
    this.preferences.flush();
  }

  public Float getPropertyAsFloat(String key, Float defaultValue) {
    return this.preferences.getFloat(key, defaultValue);
  }

  public void setPropertyAsFloat(String key, Float value) {
    this.preferences.putFloat(key, value);
    this.preferences.flush();
  }

  public Boolean getPropertyAsBoolean(String key, Boolean defaultValue) {
    return this.preferences.getBoolean(key, defaultValue);
  }

  public void setPropertyAsBoolean(String key, Boolean value) {
    this.preferences.putBoolean(key, value);
    this.preferences.flush();
  }

  public Boolean isAudioEnabled() {
    return this.getPropertyAsBoolean("audio-enabled", true);
  }

  public void setAudioEnabled(Boolean value) {
    this.setPropertyAsBoolean("audio-enabled", value);
  }
}
