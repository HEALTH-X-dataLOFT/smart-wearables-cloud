package com.medisanaspace.healthx.dataloft.smartwearables.common;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.time.Period;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Getter
@Setter
public class TimePeriod {

    public static final String PERIOD_PREFIX = "P";
    public static final String DELIMITER = "/";
    public static final String ZONE_ID = "Europe/Berlin";
    public static final ZoneId EUROPE_BERLIN = ZoneId.of(ZONE_ID);

    private Period period;
    private Instant start;
    private Instant end;

    public static TimePeriod of(Period period) {
        TimePeriod timePeriod = new TimePeriod();
        timePeriod.setPeriod(period);
        return timePeriod;
    }

    public static TimePeriod of(Instant start, Period period) {
        TimePeriod timePeriod = TimePeriod.of(period);
        timePeriod.setStart(start);
        return timePeriod;
    }

    public static TimePeriod of(Period period, Instant end) {
        TimePeriod timePeriod = TimePeriod.of(period);
        timePeriod.setEnd(end);
        return timePeriod;
    }

    public static TimePeriod of(Instant first, Instant second) {
        TimePeriod timePeriod = new TimePeriod();
        if (first.isBefore(second)) {
            timePeriod.setStart(first);
            timePeriod.setEnd(second);
            return timePeriod;
        }
        timePeriod.setStart(second);
        timePeriod.setEnd(first);
        return timePeriod;
    }

    public static TimePeriod parse(String text) {
        String[] parts = text.split(DELIMITER);

        String first = parts[0];

        // If no delimiter exists, the given string must correspond to a period
        if (parts.length == 1) {
            return TimePeriod.of(Period.parse(text));
        }

        // If exactly on delimiter is found, identify the period portion and set the fields accordingly
        if (parts.length == 2) {
            String second = parts[1];
            if (isPeriodString(first)) {
                return TimePeriod.of(Period.parse(first), Instant.parse(second));
            }
            if (isPeriodString(second)) {
                return TimePeriod.of(Instant.parse(first), Period.parse(second));
            }
            return TimePeriod.of(Instant.parse(first), Instant.parse(second));
        }

        throw new InvalidTimePeriodFormat("Could not parse time period from invalid input string: " + text);
    }

    static boolean isPeriodString(String text) {
        return text.startsWith(PERIOD_PREFIX);
    }

    public Instant getFrom() {
        if (start != null) {
            return start;
        }
        Instant endTime = end != null ? end : Instant.now();
        return endTime
                .atZone(EUROPE_BERLIN)
                .minus(period)
                .toInstant();
    }

    public Instant getTo() {
        if (end != null) {
            return end;
        }
        if (start != null) {
            return start
                    .atZone(EUROPE_BERLIN)
                    .plus(period)
                    .toInstant();
        }
        return Instant.now();
    }

    static class InvalidTimePeriodFormat extends IllegalArgumentException {
        public InvalidTimePeriodFormat(String s) {
            super(s);
        }
    }

    static class TimePeriodExeption extends IllegalArgumentException {
        public TimePeriodExeption(String s) {
            super(s);
        }
    }

    public List<TimePeriod> splitInto(ChronoUnit unit) {
        List<TimePeriod> periods = new LinkedList<>();
        Instant current = this.start;
        while(current.isBefore(this.end)) {
            var potentialEnd = current.plus(1, unit);
            // If potential end matches the time period's end the loop should terminate.
            // If it continues the slices don't make up the TimePeriod exactly.
            if(potentialEnd.isAfter(this.end)) {
                throw new TimePeriodExeption("""
                        Failed to split TimePeriod into equally sized slices without remaining fraction.
                        Last slice's end: %s
                        TimePeriod's end: %s""".formatted(potentialEnd, this.end));
            }
            periods.add(TimePeriod.of(current, potentialEnd));
            current = potentialEnd;
        }
        return periods;
    }

    public boolean contains(Instant timestamp) {
        return !timestamp.isBefore(this.start) && timestamp.isBefore(this.end);
    }

    @Override
    public String toString() {
        return Stream.of(start, period, end)
                .filter(Objects::nonNull)
                .map(Objects::toString)
                .collect(Collectors.joining("/"));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TimePeriod that)) return false;
        return Objects.equals(period, that.period) && Objects.equals(start, that.start) && Objects.equals(end, that.end);
    }

    @Override
    public int hashCode() {
        return Objects.hash(period, start, end);
    }
}
