package com.research.util;

public class ValidationUtil {

    public static void requirePositive(int value, String field) {
        if (value <= 0)
            throw new IllegalArgumentException(field + " must be positive.");
    }

    public static void requireNotBlank(String value, String field) {
        if (value == null || value.isBlank())
            throw new IllegalArgumentException(field + " cannot be empty.");
    }
}
