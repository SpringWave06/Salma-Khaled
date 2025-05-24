package com.pioneers.refactor.util.pattern.builder;

public class Main {
    public static void main(String[] args) {
        Student student1 =
                new Student("Esraa", "Amr", "esraa.amr@techpioneershub.com", "+201012345678", "Female", 23, "Cairo");

        Student student = Student.builder()
                .firstName("Hamza")
                .lastName("Almatari")
                .email("hamza.almatari@techpioneershub.com")
                .phone("+31612345678")
                .gender("male")
                .age(22)
                .address("Netherlands")
                .build();

        System.out.println(student);

        Student student2 = Student.builder()
                .firstName("Hamza")
                .lastName("Almatari")
                .email("hamza.almatari@techpioneershub.com")
                .phone("+31612345678")
                .gender("male")
                .age(22)
                .address("Netherlands")
                .build();

        if (student.equals(student2)) {
            System.out.println("Students are equal");
        } else {
            System.out.println("Students are not equal");
        }

    }
}
