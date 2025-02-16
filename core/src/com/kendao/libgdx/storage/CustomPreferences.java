package com.kendao.libgdx.storage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.kendao.libgdx.listener.CustomGameListener;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CustomPreferences {
  // for Mobile
  private final Preferences preferences;
  private final DateTimeFormatter localDateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
  private final DateTimeFormatter localDateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

  // for Desktop
  // private final String configurationFileName = "config.ini";
  // private final Properties properties;

  public CustomPreferences() {
    this.preferences = Gdx.app.getPreferences("my-gdx-game");
  }

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

  public LocalDate getPropertyAsLocalDate(String key, LocalDate defaultValue) {
    return LocalDate.parse(this.preferences.getString(key, this.localDateFormatter.format(defaultValue)));
  }

  public LocalDate getPropertyAsLocalDate(String key, String defaultValue) {
    return LocalDate.parse(this.preferences.getString(key, defaultValue));
  }

  public void setPropertyAsLocalDate(String key, LocalDate value) {
    this.preferences.putString(key, this.localDateFormatter.format(value));
    this.preferences.flush();
  }

  public LocalDateTime getPropertyAsLocalDateTime(String key, LocalDate defaultValue) {
    return LocalDateTime.parse(this.preferences.getString(key, this.localDateTimeFormatter.format(defaultValue)));
  }

  public LocalDateTime getPropertyAsLocalDateTime(String key, String defaultValue) {
    return LocalDateTime.parse(this.preferences.getString(key, defaultValue));
  }

  public void setPropertyAsLocalDateTime(String key, LocalDate value) {
    this.preferences.putString(key, this.localDateTimeFormatter.format(value));
    this.preferences.flush();
  }

  public void clear() {
    this.preferences.clear();
    this.preferences.flush();
  }

  public Boolean isAudioEnabled() {
    return this.getPropertyAsBoolean("audio-enabled", true);
  }

  public void setAudioEnabled(Boolean value) {
    this.setPropertyAsBoolean("audio-enabled", value);
  }

  public Boolean isAgreementsAccepted() {
    return this.getPropertyAsBoolean("agreements-accepted", false);
  }

  public void setAgreementsAccepted(Boolean value) {
    this.setPropertyAsBoolean("agreements-accepted", value);
  }
}
