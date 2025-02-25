/*
 * Copyright
 * Andrei Razhkou
 */

package com.andrey;

import java.util.Arrays;

public enum DayOfWeek {

    SUNDAY("Sunday"),
    MONDAY("Monday"),
    TUESDAY("Tuesday"),
    WEDNESDAY("Wednesday"),
    THURSDAY("Thursday"),
    FRIDAY("Friday"),
    SATURDAY("Saturday");

    private final String shortName;

    public String getShortName() {
        return shortName;
    }

    DayOfWeek(String shortName) {
        this.shortName = shortName;
    }

    public static DayOfWeek getByShortName(String shortName) {
        return Arrays.stream(values())
                .filter(day -> day.getShortName().equals(shortName))
                .findFirst()
                .orElse(null);
    }
}