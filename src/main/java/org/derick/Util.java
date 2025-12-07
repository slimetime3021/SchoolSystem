package org.derick;

import java.util.Arrays;

public class Util {

    public static String toTitleCase(String str) {
        String[] words = str.split(" ");
        StringBuilder stringBuilder = new StringBuilder();

        for (String word : words) {
            word = word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
            stringBuilder.append(word).append(" ");
        }

        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }
}
