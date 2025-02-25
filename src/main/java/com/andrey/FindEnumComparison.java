/*
 * Copyright
 * Andrei Razhkou
 */

package com.andrey;

import java.util.Arrays;
import java.util.List;

public class FindEnumComparison {

    public static void main(String[] args) {
        findDayOfWeekComparison();
    }

    private static void findDayOfWeekComparison() {
        List<String> daysOfWeekShortNames = Arrays.stream(DayOfWeek.values()).map(DayOfWeek::getShortName).toList();

        // Utils in ~10 times faster than inner finder
        long startTime = System.nanoTime();
        for (int i = 0; i < 1000000; i++) {
            DayOfWeek.getByShortName(daysOfWeekShortNames.get(i % daysOfWeekShortNames.size()));
        }
        System.out.println(System.nanoTime() - startTime);

        startTime = System.nanoTime();
        for (int i = 0; i < 1000000; i++) {
            DayOfWeekUtils.getDayOfWeekByShortName(daysOfWeekShortNames.get(i % daysOfWeekShortNames.size()));
        }
        System.out.println(System.nanoTime() - startTime);
    }
}