package com.pioneers.datastructures.set;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetMain {
    public static void main(String[] args) {
        Set<Integer> set = new TreeSet<>();
        set.add(1);
        set.add(2);
        set.add(2);
        set.add(3);
        set.add(12);
        set.add(4);
        set.add(7);
        set.add(9);

        System.out.println(set);

        List<Integer> list = new java.util.ArrayList<>(set.stream()
                .map(element -> element + 1)
                .toList());
        System.out.println(list);

        list.removeIf(element -> element > 4);

        list.forEach(System.out::println);
    }
}
