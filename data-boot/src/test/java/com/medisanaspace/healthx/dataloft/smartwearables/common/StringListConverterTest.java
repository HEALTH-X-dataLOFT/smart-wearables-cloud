package com.medisanaspace.healthx.dataloft.smartwearables.common;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringListConverterTest {

    @Test
    void handlesNullValues() {
        StringListConverter converter = new StringListConverter();
        Assertions.assertNull(converter.convertToDatabaseColumn(null));
        Assertions.assertNull(converter.convertToEntityAttribute(null));
    }

}
