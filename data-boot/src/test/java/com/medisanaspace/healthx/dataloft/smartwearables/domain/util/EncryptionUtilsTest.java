package com.medisanaspace.healthx.dataloft.smartwearables.domain.util;

import com.medisanaspace.healthx.dataloft.smartwearables.crypto.EncryptionUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class EncryptionUtilsTest {

    @ParameterizedTest
    @ValueSource(strings = {EncryptionUtils.AES_CBC_PKCS_5_PADDING, EncryptionUtils.AES_GCM_NO_PADDING})
    void encryptsAndDecryptsStringValues(String algorithm) throws NoSuchAlgorithmException, InvalidKeySpecException, InvalidAlgorithmParameterException,
            NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException {
        String password = "secretKey42";
        String inputText = "Top Secret";

        String cipherText = EncryptionUtils.encrypt(inputText, algorithm, password);
        String decryptedText = EncryptionUtils.decrypt(cipherText, algorithm, password);

        Assertions.assertEquals(inputText, decryptedText);
    }

    @Test
    void encryptsWithSpringAndIntegratesSalt() {
        String password = "secretKey42";
        String inputText = "Top Secret";

        String cipherText = EncryptionUtils.encryptWithSpring(inputText, password);
        String decryptedText = EncryptionUtils.decryptWithSpring(cipherText, password);

        Assertions.assertEquals(inputText, decryptedText);
    }

    @Test
    void handlesNullValues() {
        String password = "secretKey42";
        EncryptionUtils.encryptWithSpring(null, password);
        EncryptionUtils.decryptWithSpring(null, password);
    }
}
