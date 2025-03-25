package com.medisanaspace.healthx.dataloft.smartwearables.crypto;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashUtils {

    public static final String SHA_256 = "SHA-256";

    public static String createSHA256Hash(String value) throws NoSuchAlgorithmException {
        byte[] hash = createSHA256HashBytes(value);
        StringBuilder hexString = new StringBuilder(2 * hash.length);
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString().toUpperCase();
    }

    private static byte[] createSHA256HashBytes(String value) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance(SHA_256);
        return digest.digest(value.getBytes(StandardCharsets.UTF_8));
    }
}
