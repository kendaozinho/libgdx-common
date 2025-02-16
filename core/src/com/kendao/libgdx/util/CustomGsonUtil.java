package com.kendao.libgdx.util;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Objects;

public final class CustomGsonUtil {
  private static final DateTimeFormatter LOCAL_DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
  private static final DateTimeFormatter LOCAL_DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

  public static Gson getGson() {
    return new GsonBuilder()
        .registerTypeAdapter(LocalDate.class, new LocalDateSerializer())
        .registerTypeAdapter(LocalDate.class, new LocalDateDeserializer())
        .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeSerializer())
        .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeDeserializer())
        .setPrettyPrinting()
        .create();
  }

  public static String objectToString(Object object) {
    return Objects.isNull(object) ? null : CustomGsonUtil.getGson().toJson(object);
  }

  public static <T> T stringToObject(String value, Class<T> clazz) {
    return CustomStringUtil.hasValue(value) ? CustomGsonUtil.getGson().fromJson(value, clazz) : null;
  }

  public static <T> T cloneObject(Object object, Class<T> clazz) {
    return CustomGsonUtil.stringToObject(CustomGsonUtil.objectToString(object), clazz);
  }

  private static class LocalDateSerializer implements JsonSerializer<LocalDate> {
    @Override
    public JsonElement serialize(LocalDate localDate, Type srcType, JsonSerializationContext context) {
      return new JsonPrimitive(CustomGsonUtil.LOCAL_DATE_FORMATTER.format(localDate));
    }
  }

  private static class LocalDateDeserializer implements JsonDeserializer<LocalDate> {
    @Override
    public LocalDate deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
        throws JsonParseException {
      return LocalDate.parse(
          json.getAsString(),
          CustomGsonUtil.LOCAL_DATE_FORMATTER.withLocale(Locale.ENGLISH)
      );
    }
  }

  private static class LocalDateTimeSerializer implements JsonSerializer<LocalDateTime> {
    @Override
    public JsonElement serialize(LocalDateTime localDateTime, Type srcType, JsonSerializationContext context) {
      return new JsonPrimitive(CustomGsonUtil.LOCAL_DATE_TIME_FORMATTER.format(localDateTime));
    }
  }

  private static class LocalDateTimeDeserializer implements JsonDeserializer<LocalDateTime> {
    @Override
    public LocalDateTime deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
        throws JsonParseException {
      return LocalDateTime.parse(
          json.getAsString(),
          CustomGsonUtil.LOCAL_DATE_TIME_FORMATTER.withLocale(Locale.ENGLISH)
      );
    }
  }
}
