package com.pioneers.datastructures.linkedlist;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LinkedListTest {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        System.out.println(list);
        System.out.println(list.size());

        int num1 = 2;
        Integer num2 = 2;

        list.remove(num1);
        System.out.println(list);

        // Iteration by indexed for
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        System.out.println("----------------------");

        // Iteration by enhanced for
        for (Integer element : list) {
            System.out.println(element);
        }

        System.out.println("----------------------");

        // Iteration by Iterator
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("----------------------");
        System.out.println("----------------------");

        // Iteration by forEach of Collection
        list.forEach(System.out::println);

        // (one function is being called && lambda expression param is passed as parameter) ||
        // (one function is being called && lambda expression param.innerMethod())

        System.out.println("----------------------");

//        sortBadPractice(new LinkedList<>());
        list.addFirst(5);
        list.addLast(9);
        System.out.println(list);
    }
}
