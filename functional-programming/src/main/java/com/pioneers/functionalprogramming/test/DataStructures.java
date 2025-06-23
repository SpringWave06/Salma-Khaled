package com.pioneers.functionalprogramming.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataStructures {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        list.stream()
                .map(DataStructures::multiplyTwo)
                .forEach(System.out::println);

    }


    public static int addOne(int number) {
        return number + 1;
    }

    public static int subtractOne(int number) {
        return number - 1;
    }

    public static int multiplyTwo(int number) {
        return number * 2;
    }

    public static int add(int number1, int number2) {
        return number1 + number2;
    }
}
