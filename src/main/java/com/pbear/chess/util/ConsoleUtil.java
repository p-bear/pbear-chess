package com.pbear.chess.util;

public class ConsoleUtil {
  public static String to8x8BoardString(final long value) {
    String binaryString = padLeft(Long.toBinaryString(value), 64, '0');

    StringBuilder result = new StringBuilder();
    for (int i = 0; i < binaryString.length(); i += 8) {
      int end = Math.min(i + 8, binaryString.length());
      result.append(binaryString, i, end).append("\n");
    }
    return result.toString();
  }

  public static String padLeft(String input, int length, char padChar) {
    if (input == null || input.length() >= length) {
      return input;
    }
    int padLength = length - input.length();
    return String.valueOf(padChar).repeat(padLength) + input;
  }

  public static String toHexString(final String binaryString) {
    return Long.toHexString(Long.parseLong(binaryString
        .replace("\n", "")
        .replace("\r", "")
        .replace(" ", ""), 2))
        .toUpperCase();
  }
}
