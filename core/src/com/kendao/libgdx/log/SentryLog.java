package com.kendao.libgdx.log;

import com.kendao.libgdx.util.CustomStringUtil;
import io.sentry.Sentry;

import java.util.Arrays;

public final class SentryLog {
  private SentryLog() {
  }

  public static void initialize(String dsn) {
    Sentry.init(options -> {
      options.setDsn(dsn);
      options.setTracesSampleRate(1.0);
    });
  }

  public static void close() {
    Sentry.close();
  }

  public static void write(String message) {
    if (!CustomStringUtil.hasValue(message)) {
      return;
    }

    System.out.println(message);
    Sentry.captureMessage(message);
  }

  public static void write(String message, String details) {
    if (!CustomStringUtil.hasValue(message) || !CustomStringUtil.hasValue(details)) {
      return;
    }

    SentryLog.write(message, new RuntimeException(details));
  }

  public static void write(String message, Throwable throwable) {
    SentryLog.write(message, throwable, false);
  }

  public static void write(String message, Throwable throwable, boolean showStackTrace) {
    if (!CustomStringUtil.hasValue(message)) {
      return;
    }

    String sentryMessage =
        message + " -> " + throwable.toString() + (showStackTrace ? ("\n" + Arrays.toString(throwable.getStackTrace())) : "");

    System.err.println(sentryMessage);
    Sentry.captureMessage(sentryMessage);
  }
}

