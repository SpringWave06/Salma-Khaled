package com.pioneers.datastructures.task.task1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * conditions to use method reference:
 * 1- One unique method used in the lambda expression && lambda expression parameter(s) passed in the unique method.
 * 2- One unique method used in the lambda expression && lambda expression parameter is called like this format (param.innerMethod())
 * Side note: innerMethod() must not contain any parameter
 */
public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(2, 1, 8, 7, 5, 10, 14, 9));

        getFirstEvenNumber(list)
                .ifPresent(System.out::println);

        getFirstOddNumber(list)
                .ifPresent(System.out::println);

        getMaxEvenNumber(list)
                .ifPresent(System.out::println);

        Integer evenNumber = findFirstEvenBadPractice(list);

        // Null check is a bad practice
        if (evenNumber != null) {
            System.out.println(evenNumber);
        }

    }

    public static Optional<Integer> findFirstEvenBestPractice(List<Integer> list) {
        for (Integer number : list) {
            if (number % 2 == 0) {
                return Optional.of(number);
            }
        }
        return Optional.empty();
    }

    public static Integer findFirstEvenBadPractice(List<Integer> list) {
        for (Integer num : list) {
            if (num != null && num % 2 == 0) {
                return num;
            }
        }
        return null;
    }

    public static Optional<Integer> getFirstEvenNumber(List<Integer> list) {
        return list.stream()
                .filter(Main::isEven)
                .findFirst();
    }

    public static Optional<Integer> getFirstOddNumber(List<Integer> list) {
        return list.stream()
                .filter(Main::isOdd)
                .findFirst();
    }

    public static Optional<Integer> getMaxEvenNumber(List<Integer> list) {
        return list.stream()
                .filter(Main::isEven)
                .max(Integer::compare);
    }

    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    public static boolean isOdd(int number) {
        return number % 2 != 0;
    }
}
