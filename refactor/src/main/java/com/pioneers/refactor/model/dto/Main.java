package com.pioneers.refactor.model.dto;

public class Main {
    public static void main(String[] args) {
        Student student =
                new Student("Esraa", "Amr", "esraa.amr@techpioneershub.com", "+201012345678", "Female", 23, "Cairo");

        System.out.println(student);

        Student student2 = new Student("Khaled", "Atef", "khaled.atef@techpioneershub.com");

        Employee employee = new Employee("Esraa", "Amr", "esraa.amr@techpioneershub.com",
                "+201012345678", "Female", "1/1/2005", 100000.0F);

        employee.printEmployeeInfo();
    }
}
