package com.billing.util;

public class Validator {

    public static boolean isValidUser(String name) {
        return name != null && !name.trim().isEmpty();
    }
}
