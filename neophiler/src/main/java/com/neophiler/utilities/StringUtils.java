package com.neophiler.utilities;

public class StringUtils {
    public static boolean IsNullOrOnlyWhiteSpace(String toTest) {
        return toTest == null || toTest.trim().isEmpty();
    }

    public static boolean IsNotNullOrOnlyWhiteSpace(String toTest) {
        return !IsNullOrOnlyWhiteSpace(toTest);
    }
}
