package com.medisanaspace.healthx.dataloft.smartwearables.crypto;

import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.security.crypto.keygen.KeyGenerators;

import javax.crypto.*;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.ByteBuffer;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;

public class EncryptionUtils {

    public static final String AES = "AES";
    public static final String PBKDF_2_WITH_HMAC_SHA_256 = "PBKDF2WithHmacSHA256";
    public static final String AES_CBC_PKCS_5_PADDING = "AES/CBC/PKCS5Padding";
    public static final String AES_GCM_NO_PADDING = "AES/GCM/NoPadding";
    public static final int IV_SIZE_IN_BYTES = 16;
    public static final int SPRING_SALT_SIZE_IN_HEX_CHARS = 16;

    private static final int PBKDF_2_SALT_SIZE = 16;

    private EncryptionUtils() {
    }

    /**
     * Creates a new AES encryption key from the given password and salt
     *
     * @param password The password to use
     * @return A key ready to use for AES encryption
     * @throws NoSuchAlgorithmException If the key generation algorithm can't be found
     * @throws InvalidKeySpecException  If the key specification is invalid
     */
    public static SecretKey createKeyFromPassword(String password, byte[] salt) throws NoSuchAlgorithmException, InvalidKeySpecException {
        SecretKeyFactory factory = SecretKeyFactory.getInstance(PBKDF_2_WITH_HMAC_SHA_256);
        KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 65536, 256);
        return new SecretKeySpec(factory.generateSecret(spec).getEncoded(), AES);
    }

    /**
     * Creates a new initial vector for AES encryption
     *
     * @return The initial vector
     */
    public static byte[] generateIv(int size) {
        byte[] iv = new byte[size];
        new SecureRandom().nextBytes(iv);
        return iv;
    }

    /**
     * Encrypts an input string with the AES/CBC/PKCS5Padding algorithm using the specified key and initialization vector
     *
     * @param input    The input string to be encrypted
     * @param password The encryption password
     * @return The encrypted cipher text
     * @throws NoSuchPaddingException if padding is not found
     * @throws NoSuchAlgorithmException if algorithm is not found
     * @throws InvalidAlgorithmParameterException if algorithm is invalid
     * @throws InvalidKeyException if key is invalid
     * @throws BadPaddingException if padding is invalid
     * @throws IllegalBlockSizeException if block size is invalid
     */
    public static String encrypt(String input, String password) throws NoSuchPaddingException,
            NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException, InvalidKeySpecException {

        return encrypt(input, AES_GCM_NO_PADDING, password);
    }

    /**
     * Encrypts an input string using the specified algorithm, key and initializtion vector
     *
     * @param input     The input string to be encrypted
     * @param algorithm The algorithm to use
     * @param password  The encryption password
     * @return The encrypted cipher text
     * @throws NoSuchPaddingException if padding is not found
     * @throws NoSuchAlgorithmException if algorithm is not found
     * @throws InvalidAlgorithmParameterException if algorithm is invalid
     * @throws InvalidKeyException if key is invalid
     * @throws BadPaddingException if padding is invalid
     * @throws IllegalBlockSizeException if block size is invalid
     */
    public static String encrypt(String input, String algorithm, String password) throws NoSuchPaddingException,
            NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException, InvalidKeySpecException {
        byte[] salt = new byte[PBKDF_2_SALT_SIZE];
        new SecureRandom().nextBytes(salt);

        SecretKey key = EncryptionUtils.createKeyFromPassword(password, salt);
        byte[] initializationVector = EncryptionUtils.generateIv(IV_SIZE_IN_BYTES);

        Cipher cipher = Cipher.getInstance(algorithm);
        cipher.init(Cipher.ENCRYPT_MODE, key, createSpecFor(algorithm, initializationVector));
        byte[] inputCipherText = cipher.doFinal(input.getBytes());
        byte[] cipherText = ByteBuffer.allocate(IV_SIZE_IN_BYTES + PBKDF_2_SALT_SIZE + inputCipherText.length)
                .put(initializationVector)
                .put(salt)
                .put(inputCipherText)
                .array();

        return Base64.getEncoder()
                .encodeToString(cipherText);
    }

    /**
     * Decrypts an input string with the AES/CBC/PKCS5Padding algorithm using the specified key and initialization vector
     *
     * @param cipherText The input string to be decrypted
     * @param password   The decryption password
     * @return The decrypted plain text
     * @throws NoSuchPaddingException if padding is not found
     * @throws NoSuchAlgorithmException if algorithm is not found
     * @throws InvalidAlgorithmParameterException if algorithm is invalid
     * @throws InvalidKeyException if key is invalid
     * @throws BadPaddingException if padding is invalid
     * @throws IllegalBlockSizeException if block size is invalid
     */
    public static String decrypt(String cipherText, String password) throws NoSuchPaddingException,
            NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException, InvalidKeySpecException {
        return decrypt(cipherText, AES_GCM_NO_PADDING, password);
    }

    /**
     * Decrypts an input cypher string using the specified algorithm, key and initializtion vector
     *
     * @param cipherText The input string to be decrypted
     * @param algorithm  The algorithm to use
     * @param password   The decryption password
     * @return The decrypted plain text
     * @throws NoSuchPaddingException if padding is not found
     * @throws NoSuchAlgorithmException if algorithm is not found
     * @throws InvalidAlgorithmParameterException if algorithm is invalid
     * @throws InvalidKeyException if key is invalid
     * @throws BadPaddingException if padding is invalid
     * @throws IllegalBlockSizeException if block size is invalid
     */
    public static String decrypt(String cipherText, String algorithm, String password) throws NoSuchPaddingException,
            NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException, InvalidKeySpecException {

        byte[] decoded = Base64.getDecoder().decode(cipherText);
        ByteBuffer buffer = ByteBuffer.wrap(decoded);

        byte[] initializationVector = new byte[IV_SIZE_IN_BYTES];
        buffer.get(initializationVector);

        byte[] salt = new byte[PBKDF_2_SALT_SIZE];
        buffer.get(salt);

        byte[] cypherText = new byte[buffer.remaining()];
        buffer.get(cypherText);

        SecretKey key = EncryptionUtils.createKeyFromPassword(password, salt);

        Cipher cipher = Cipher.getInstance(algorithm);
        cipher.init(Cipher.DECRYPT_MODE, key, createSpecFor(algorithm, initializationVector));
        byte[] plainText = cipher.doFinal(cypherText);
        return new String(plainText);
    }

    public static String encryptWithSpring(String input, String password) {
        if (input == null) {
            return null;
        }
        String salt = KeyGenerators.string().generateKey();
        TextEncryptor encryptor = Encryptors.delux(password, salt);
        if (salt.length() != SPRING_SALT_SIZE_IN_HEX_CHARS) {
            throw new UnexpectedSaltSizeException("Generated salt size does not match expectations and could lead to encryption issues. Salt size: " + salt.length() + ", Expected size: " + SPRING_SALT_SIZE_IN_HEX_CHARS);
        }
        return salt + encryptor.encrypt(input);
    }

    public static String decryptWithSpring(String encrypted, String password) {
        if (encrypted == null) {
            return null;
        }
        String salt = encrypted.substring(0, SPRING_SALT_SIZE_IN_HEX_CHARS);
        String cipherText = encrypted.substring(SPRING_SALT_SIZE_IN_HEX_CHARS);
        TextEncryptor encryptor = Encryptors.delux(password, salt);
        return encryptor.decrypt(cipherText);
    }

    private static AlgorithmParameterSpec createSpecFor(String algorithm, byte[] initializationVector) {
        return switch (algorithm) {
            case AES_CBC_PKCS_5_PADDING -> new IvParameterSpec(initializationVector);
            case AES_GCM_NO_PADDING -> new GCMParameterSpec(128, initializationVector);
            default -> new IvParameterSpec(initializationVector);
        };
    }

    private static class UnexpectedSaltSizeException extends RuntimeException {
        public UnexpectedSaltSizeException(String message) {
            super(message);
        }
    }
}
