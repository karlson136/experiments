package com.andrey;

import org.apache.commons.collections4.MapUtils;
import org.springframework.util.ObjectUtils;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;

public class IsEmptyComparison {
    public static void main( String[] args ) {
        mapIsEmptyComparison();
    }

    private static void mapIsEmptyComparison() {
        Map map = null;


        // TODO ObjectUtils in two times faster than MapUtils
        long startTime = System.nanoTime();
        for( int i = 0; i < 1000000; i++ ) {
            ObjectUtils.isEmpty(map);
//            mapIsEmptySpring(map);
        }
        System.out.println( System.nanoTime() - startTime );

        startTime = System.nanoTime();
        for( int i = 0; i < 1000000; i++ ) {
            MapUtils.isEmpty(map);
//            mapIsEmptyCollections(map);
        }
        System.out.println( System.nanoTime() - startTime );
    }

    private static boolean mapIsEmptySpring(Object obj) {
        if (obj == null) {
            return true;
        }

        if (obj instanceof Optional) {
            return !((Optional<?>) obj).isPresent();
        }
        if (obj instanceof CharSequence) {
            return ((CharSequence) obj).length() == 0;
        }
        if (obj.getClass().isArray()) {
            return Array.getLength(obj) == 0;
        }
        if (obj instanceof Collection) {
            return ((Collection<?>) obj).isEmpty();
        }
        if (obj instanceof Map) {
            return ((Map<?, ?>) obj).isEmpty();
        }

        // else
        return false;
    }

    private static boolean mapIsEmptyCollections(Map map) {
        return map == null || map.isEmpty();
    }
}
