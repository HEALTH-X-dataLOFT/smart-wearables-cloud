package com.medisanaspace.healthx.dataloft.smartwearables.common;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import java.util.Arrays;
import java.util.List;

@Converter
public class StringListConverter implements AttributeConverter<List<String>, String> {

    public static final String DELIMITER = ",";

    @Override
    public String convertToDatabaseColumn(List<String> strings) {
        if(strings == null) {
            return null;
        }
        return String.join(DELIMITER, strings);
    }

    @Override
    public List<String> convertToEntityAttribute(String dbListString) {
        if(dbListString == null) {
            return null;
        }
        return Arrays.asList(dbListString.split(DELIMITER));
    }
}
