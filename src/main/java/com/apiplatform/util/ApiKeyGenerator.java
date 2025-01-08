// src/main/java/com/apiplatform/util/ApiKeyGenerator.java
package com.apiplatform.util;

import java.security.SecureRandom;
import java.util.Base64;

public class ApiKeyGenerator {
    private static final SecureRandom secureRandom = new SecureRandom();

    public static String generate() {
        byte[] bytes = new byte[32];
        secureRandom.nextBytes(bytes);
        return Base64.getUrlEncoder().withoutPadding().encodeToString(bytes);
    }
}