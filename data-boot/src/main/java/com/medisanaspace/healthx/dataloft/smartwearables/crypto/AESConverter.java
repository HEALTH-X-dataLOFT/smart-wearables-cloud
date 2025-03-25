package com.medisanaspace.healthx.dataloft.smartwearables.crypto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
@Component
public class AESConverter implements AttributeConverter<String, String> {

    private static Encryptor encryptor;

    @Autowired
    public void setEncryptor(Encryptor encryptor) {
        AESConverter.encryptor = encryptor;
    }

    @Override
    public String convertToDatabaseColumn(String plainText) {
        return encryptor.encrypt(plainText);
    }

    @Override
    public String convertToEntityAttribute(String dbData) {
        return encryptor.decrypt(dbData);
    }
}
