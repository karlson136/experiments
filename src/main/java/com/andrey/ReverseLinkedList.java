/*
 * Copyright
 * Andrei Razhkou
 */

package com.andrey;

import java.util.Iterator;

public class ReverseLinkedList {

    public static void main(String[] args) {
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        linkedList.addToTail(1);
        linkedList.addToTail(2);
        linkedList.addToTail(3);
        linkedList.addToTail(4);
        linkedList.addToTail(5);

        for (Integer i : linkedList) {
            System.out.println(i);
        }
        System.out.println(linkedList.head.data + " - " + linkedList.tail.data);
        linkedList.reverse();
        System.out.println("-----------------");
        for (Integer i : linkedList) {
            System.out.println(i);
        }
        System.out.println(linkedList.head.data + " - " + linkedList.tail.data);

        linkedList.addToTail(6);
        System.out.println("-----------------");
        for (Integer i : linkedList) {
            System.out.println(i);
        }
        System.out.println(linkedList.head.data + " - " + linkedList.tail.data);
    }

    static class MyLinkedList<T> implements Iterable<T> {
        ListItem head;
        ListItem tail;

        boolean isEmpty() {
            return head == null;
        }

        void addToTail(T data) {
            ListItem item = new ListItem();
            item.data = data;

            if (isEmpty()) {
                head = item;
            } else {
                tail.next = item;
            }

            tail = item;
        }

        void reverse() {
            if (isEmpty() || head.next == null) {
                return;
            }

            ListItem current = head.next;
            ListItem next;
            tail = head;
            head.next = null;

            while (current != null) {
                next = current.next;
                current.next = head;

                head = current;
                current = next;
            }
        }

        class ListItem {
            T data;
            ListItem next;
        }

        @Override
        public Iterator<T> iterator() {
            return new Iterator<>() {
                ListItem current = head;

                @Override
                public boolean hasNext() {
                    return current != null;
                }

                @Override
                public T next() {
                    T data = current.data;
                    current = current.next;
                    return data;
                }
            };
        }
    }

}