package com.kendao.libgdx.util;

public final class CustomStringUtil {
  private CustomStringUtil() {
  }

  public static String breakPhraseInLines(String phrase, byte wordsPerLine) {
    StringBuilder response = new StringBuilder();

    byte count = 0;
    for (String word : phrase.split(" ")) {
      response.append(word).append(" ");

      if (count == (wordsPerLine - 1)) {
        count = 0;
        response.append("\n");
      } else {
        count++;
      }
    }

    return response.toString();
  }
}
