package com.pioneers.datastructures.set;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class LinkedHashSetMain {
    public static void main(String[] args) {
        Set<Integer> set = new LinkedHashSet();
        set.add(1);
        set.add(2);
        set.add(2);
        set.add(3);
        set.add(null);
        set.add(12);
        set.add(4);
        set.add(7);
        set.add(9);

        System.out.println(set);

        List<Integer> list = set.stream().toList();
        list.forEach(System.out::println);
    }
}
