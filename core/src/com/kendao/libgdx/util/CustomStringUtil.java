package com.kendao.libgdx.util;

public final class CustomStringUtil {
  private CustomStringUtil() {
  }

  public static String breakPhraseInLines(String phrase, byte wordsPerLine) {
    StringBuilder response = new StringBuilder();

    byte count = 0;
    for (String word : phrase.split(" ")) {
      response.append(word);

      if (count == (wordsPerLine - 1)) {
        response.append("\n");
        count = 0;
      } else {
        response.append(" ");
        count++;
      }
    }

    if (response.toString().endsWith("\n") || response.toString().endsWith(" ")) {
      response = new StringBuilder(response.substring(0, response.length() - 1));
    }

    return response.toString();
  }
}
