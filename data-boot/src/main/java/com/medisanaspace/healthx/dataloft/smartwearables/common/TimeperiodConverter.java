package com.medisanaspace.healthx.dataloft.smartwearables.common;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class TimeperiodConverter implements AttributeConverter<TimePeriod, String> {

    @Override
    public String convertToDatabaseColumn(TimePeriod timePeriod) {
        return timePeriod.toString();
    }

    @Override
    public TimePeriod convertToEntityAttribute(String dbValue) {
        return TimePeriod.parse(dbValue);
    }
}
