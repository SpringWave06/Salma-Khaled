package com.pioneers.datastructures.set;

import java.util.HashSet;
import java.util.Set;

public class HashSetMain {
    public static void main(String[] args) {
        Set<Integer> hashSet = new HashSet<>();
        hashSet.add(1);
        hashSet.add(2);
        hashSet.add(2);
        hashSet.add(1);
        hashSet.add(3);
        hashSet.add(3);
        hashSet.add(4);
        hashSet.add(4);
        hashSet.add(null);

        System.out.println(hashSet);
    }
}
