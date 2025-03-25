package com.medisanaspace.healthx.dataloft.smartwearables.crypto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Encryptor {

    private final String encryptionKey;

    @Autowired
    public Encryptor(@Value("${swc.encryption.aes.key}") String encryptionKey) {
        this.encryptionKey = encryptionKey;
    }

    public final String encrypt(String inputText) {
        return EncryptionUtils.encryptWithSpring(inputText, encryptionKey);
    }

    public final String decrypt(String cipherText) {
        return EncryptionUtils.decryptWithSpring(cipherText, encryptionKey);
    }
}
