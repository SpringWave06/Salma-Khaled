package com.pioneers.datastructures.arraylist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProblemSolving {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(2, 1, 3, 1, 4, 6, 10, 7, 5, 8, 9, 10));

        List<Integer> distinctList = distinct(list);

        List<Integer> sorteddistinctList = sortBestPractice(distinctList);

        printList(sorteddistinctList);
    }



    // Achieves Mutation Reference (Very very very very very very bad practice)
    public static void sortBadPractice(List<Integer> distinctList) {
        distinctList.sort(Integer::compareTo);
    }

    public static List<Integer> sortBestPractice(List<Integer> distinctList) {
        List<Integer> sortedList = new ArrayList<>(distinctList);
        sortedList.sort(Integer::compareTo);
        return sortedList;
    }

    private static void printList(List<Integer> distinctList) {
        distinctList.forEach(ProblemSolving::printWithSpace);
    }

    private static void printWithSpace(Integer element) {
        System.out.print(element + " ");
    }

    private static List<Integer> distinct(List<Integer> list) {
        List<Integer> uniqueList = new ArrayList<>();
        for (int element : list) {
            if (!uniqueList.contains(element)) {
                uniqueList.add(element);
            }
        }
        return uniqueList;
    }
}
