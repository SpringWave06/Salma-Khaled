package com.pioneers.datastructures.arraylist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Streams {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(2, 1, 3, 1, 4, 6, 10, 7, 5, 8, 9, 10, 2));
        int firstNumber = list.stream()
                .distinct()
                .sorted()
                .filter(element -> element % 2 != 0)
                .filter(element -> element <= 4)
                .findFirst()
                .get();
        System.out.println(firstNumber);


        /*if (getNumber(list).isPresent()) {
            int number = getNumber(list).get();
            System.out.println(number);
        }*/

        int num = getNumber(list)
                .orElseThrow(() -> new RuntimeException("No number found"));
        System.out.println(num);
    }

    public static Optional<Integer> getNumber(List<Integer> list) {
        Integer num = null;
        return Optional.ofNullable(num);
    }
}
