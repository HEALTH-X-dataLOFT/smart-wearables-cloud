package com.medisanaspace.healthx.dataloft.smartwearables.common;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeParseException;

import static java.time.temporal.ChronoUnit.*;

public class TimePeriodTest {

    public static final String EUROPE_BERLIN = "Europe/Berlin";
    public static final ZoneId GERMANY = ZoneId.of(EUROPE_BERLIN);
    public static final ZoneId ZONE_ID = ZoneId.of("Europe/Berlin");

    @Test
    void parsesPeriodFromStartAndEndTimestamp() {
        Instant start = LocalDate.of(2024, 1, 2)
                .atStartOfDay(GERMANY)
                .toInstant();
        Instant end = LocalDate.of(2024, 2, 2)
                .atStartOfDay(GERMANY)
                .toInstant();
        String input = "2024-01-01T23:00:00Z/2024-02-01T23:00:00Z";

        TimePeriod result = TimePeriod.parse(input);

        Assertions.assertNull(result.getPeriod());
        Assertions.assertEquals(start, result.getStart());
        Assertions.assertEquals(end, result.getEnd());
        Assertions.assertEquals(start, result.getFrom());
        Assertions.assertEquals(end, result.getTo());
    }

    @Test
    void parsesPeriodFromStartTimestampAndPeriodString() {
        Instant start = LocalDate.of(2024, 1, 2)
                .atStartOfDay(GERMANY)
                .toInstant();
        Instant end = LocalDate.of(2025, 3, 3)
                .atStartOfDay(GERMANY)
                .toInstant();
        String input = "2024-01-01T23:00:00Z/P1Y2M1D";

        TimePeriod result = TimePeriod.parse(input);

        Assertions.assertNull(result.getEnd());
        Assertions.assertEquals(Period.of(1, 2, 1), result.getPeriod());
        Assertions.assertEquals(start, result.getStart());
        Assertions.assertEquals(start, result.getFrom());
        Assertions.assertEquals(end, result.getTo());
    }

    @Test
    void parsesPeriodFromEndTimestampAndPeriodString() {
        Instant start = LocalDate.of(2024, 1, 1)
                .atStartOfDay(GERMANY)
                .toInstant();
        Instant end = LocalDate.of(2025, 3, 2)
                .atStartOfDay(GERMANY)
                .toInstant();
        String input = "P1Y2M1D/2025-03-01T23:00:00Z";

        TimePeriod result = TimePeriod.parse(input);

        Assertions.assertNull(result.getStart());
        Assertions.assertEquals(Period.of(1,2,1), result.getPeriod());
        Assertions.assertEquals(end, result.getEnd());
        Assertions.assertEquals(start, result.getFrom());
        Assertions.assertEquals(end, result.getTo());
    }

    @Test
    void parsesPeriodFromPeriodString() {
        Instant end = Instant.now();
        Instant from = end
                .atZone(GERMANY)
                .minus(Period.of(1,2,1))
                .toInstant();
        String input = "P1Y2M1D";

        TimePeriod result = TimePeriod.parse(input);

        Assertions.assertNull(result.getStart());
        Assertions.assertNull(result.getEnd());
        Assertions.assertEquals(Period.of(1,2,1), result.getPeriod());
        // Can't be exactly equal due to small time offset when evaluating both statements
        Assertions.assertEquals(from.truncatedTo(SECONDS), result.getFrom().truncatedTo(SECONDS));
        Assertions.assertEquals(end.truncatedTo(SECONDS), result.getTo().truncatedTo(SECONDS));
    }

    @Test
    void ensuresStartBeforeEnd() {
        Instant start = LocalDate.of(2024, 1, 1)
                .atStartOfDay(GERMANY)
                .toInstant();
        Instant end = LocalDate.of(2025, 3, 2)
                .atStartOfDay(GERMANY)
                .toInstant();

        TimePeriod normal = TimePeriod.of(start, end);
        TimePeriod reversed = TimePeriod.of(end, start);

        Assertions.assertEquals(start, normal.getStart());
        Assertions.assertEquals(start, normal.getFrom());
        Assertions.assertEquals(start, reversed.getStart());
        Assertions.assertEquals(start, reversed.getFrom());

        Assertions.assertEquals(end, normal.getEnd());
        Assertions.assertEquals(end, normal.getTo());
        Assertions.assertEquals(end, reversed.getEnd());
        Assertions.assertEquals(end, reversed.getTo());
    }

    @Test
    void throwsOnInvalidInputValues() {
        String tooManyParts = "2024-01-01T23:00:00Z/P1Y2M1D/2024-02-01T23:00:00Z";
        String wrongDelimiter = "2024-01-01T23:00:00Z\\P1Y2M1D";
        String singleTimestamp = "2024-01-01T23:00:00Z";
        String twoPeriods = "P1Y2M1D/P1Y6M3D";
        String emptyString = "";

        Assertions.assertThrows(TimePeriod.InvalidTimePeriodFormat.class, () -> TimePeriod.parse(tooManyParts));
        Assertions.assertThrows(DateTimeParseException.class, () -> TimePeriod.parse(wrongDelimiter));
        Assertions.assertThrows(DateTimeParseException.class, () -> TimePeriod.parse(singleTimestamp));
        Assertions.assertThrows(DateTimeParseException.class, () -> TimePeriod.parse(twoPeriods));
        Assertions.assertThrows(DateTimeParseException.class, () -> TimePeriod.parse(emptyString));
        Assertions.assertThrows(NullPointerException.class, () -> TimePeriod.parse(null));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "2024-01-01T23:00:00Z/2024-02-01T23:00:00Z",
            "2024-01-01T23:00:00Z/P1Y2M1D",
            "P1Y2M1D/2025-03-01T23:00:00Z",
            "P1Y2M1D"
    })
    void convertsToString(String input) {
        Assertions.assertEquals(input, TimePeriod.parse(input).toString());
    }

    @Test
    void splitsPeriodIntoSlices() {
        LocalDate day = LocalDate.of(2025,2,6);
        Instant startOfDay = day.atStartOfDay(ZONE_ID).toInstant();
        Instant endOfDay = day.atStartOfDay(ZONE_ID)
                .plusDays(1)
                .toInstant();
        TimePeriod dayPeriod = TimePeriod.of(startOfDay, endOfDay);

        Assertions.assertEquals(24, dayPeriod.splitInto(HOURS).size());
        Assertions.assertEquals(24*60, dayPeriod.splitInto(MINUTES).size());
        Assertions.assertEquals(24*60*60, dayPeriod.splitInto(SECONDS).size());

        TimePeriod eightHourPeriod = TimePeriod.of(startOfDay, startOfDay.plus(8, HOURS));
        Assertions.assertEquals(8, eightHourPeriod.splitInto(HOURS).size());

        TimePeriod twoAndAHalfHourPeriod = TimePeriod.of(startOfDay, startOfDay.plus(150, MINUTES));
        Assertions.assertThrows(TimePeriod.TimePeriodExeption.class, () -> twoAndAHalfHourPeriod.splitInto(HOURS));
        Assertions.assertEquals(2.5*60, twoAndAHalfHourPeriod.splitInto(MINUTES).size());
        Assertions.assertEquals(2.5*60*60, twoAndAHalfHourPeriod.splitInto(SECONDS).size());
    }
}
