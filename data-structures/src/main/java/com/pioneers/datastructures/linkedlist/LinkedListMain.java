package com.pioneers.datastructures.linkedlist;

import java.util.LinkedList;
import java.util.List;

public class LinkedListMain {
    public static void main(String[] args) {
        List<String> girlsStudents = new LinkedList<>();
        girlsStudents.add("Hamza");
        girlsStudents.add("Esraa");
        girlsStudents.add("Esraa");
        girlsStudents.add("Esraa");
        girlsStudents.add("Esraa");
        girlsStudents.add("Esraa");
        girlsStudents.add("Esraa");
        girlsStudents.add("Esraa");
        girlsStudents.add("Esraa");
        girlsStudents.add("Esraa");

        System.out.println(girlsStudents);
        girlsStudents.add("Menna");
        System.out.println(girlsStudents);

        girlsStudents.remove("Esraa");
        System.out.println(girlsStudents);

        girlsStudents.clear();
        System.out.println(girlsStudents);

        girlsStudents.add("Menna");
        girlsStudents.add("Esraa");

        girlsStudents.add(1, "Salma");
        System.out.println(girlsStudents);

        String student = girlsStudents.get(2);
        System.out.println(student);


        girlsStudents.set(2, "Israa");
        System.out.println(girlsStudents);


        List<String> guysStudents = new LinkedList<>();
        guysStudents.add("Khaled");
        guysStudents.add("Kareem");
        guysStudents.add("Dief");

        System.out.println(guysStudents);

        guysStudents.addAll(0, girlsStudents);
        System.out.println(guysStudents);

        guysStudents.removeAll(girlsStudents);
        System.out.println(guysStudents);

        if (guysStudents.contains("Menna")) {
            System.out.println("Menna exists in the list!!");
        } else {
            System.out.println("Menna does not exist in the list!!");
        }

        List<String> allStudents = new LinkedList<>(girlsStudents);
        allStudents.addAll(guysStudents);

        System.out.println(allStudents);

        List<String> subList = allStudents.subList(1, 5);
        System.out.println(subList);

        System.out.println(subList.indexOf("Israa"));

    }
}
