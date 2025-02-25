/*
 * Copyright
 * Andrei Razhkou
 */

package com.andrey;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public final class DayOfWeekUtils {
    private DayOfWeekUtils() {
    }

    private static final Map<String, DayOfWeek> dayOfWeekByShortName = Arrays.stream(DayOfWeek.values())
            .collect(Collectors.toMap(DayOfWeek::getShortName, e -> e));

    public static DayOfWeek getDayOfWeekByShortName(String shortName) {
        return dayOfWeekByShortName.get(shortName);
    }
}