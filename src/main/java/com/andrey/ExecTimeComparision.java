/*
 * Copyright
 * Andrei Razhkou
 */

package com.andrey;

import java.util.Date;

public class ExecTimeComparision {

    public static void main(String[] args) throws Exception {
        long x = System.nanoTime();
        System.out.println(x);
        Thread.sleep(1);
        System.out.println(System.nanoTime() - x);

        long time = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            do1();
        }
        System.out.println(System.currentTimeMillis() - time);

        time = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            do2();
        }
        System.out.println(System.currentTimeMillis() - time);
    }

    private static long do1() throws Exception {
        long innerTime = new Date().getTime();
        Thread.sleep(2);
        return new Date().getTime() - innerTime;
    }

    private static long do2() throws Exception {
        long innerTime = System.currentTimeMillis();
        Thread.sleep(2);
        return System.currentTimeMillis() - innerTime;
    }
}