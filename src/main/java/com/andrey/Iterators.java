/*
 * Copyright
 * Andrei Razhkou
 */

package com.andrey;

import java.util.Iterator;
import java.util.List;

public class Iterators<E> implements Iterator<E> {

    Iterator<E> it1;
    Iterator<E> it2;

    public Iterators(Iterator<E> it1, Iterator<E> it2) {
        this.it1 = it1;
        this.it2 = it2;
    }

    @Override
    public boolean hasNext() {
        return it1.hasNext() || it2.hasNext();
    }

    @Override
    public E next() {
        if (it1.hasNext()) {
            return it1.next();
        }
        if (it2.hasNext()) {
            return it2.next();
        }
        return null;
    }

    public static void main(String[] args) {
        Iterator<Integer> list = List.of(1, 2, 3, 4, 5).iterator();
        Iterator<Integer> list1 = List.of(6, 7).iterator();
        Iterator<String> list2 = List.of("a").iterator();
        Iterator<Integer> iterators = new Iterators<>(list, list1);

        while (iterators.hasNext()) {
            System.out.println(iterators.next());
        }
    }
}