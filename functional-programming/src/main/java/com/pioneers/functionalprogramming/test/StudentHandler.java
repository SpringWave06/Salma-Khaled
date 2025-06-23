package com.pioneers.functionalprogramming.test;


import java.util.function.Function;

public final class StudentHandler {

    private StudentHandler() {
        throw new IllegalStateException("Utility class");
    }

    public static String getStudentInfo(Function<Student, String> function, Student student) {
        return function.apply(student);
    }

    public static String concatenateFullName(final Student student) {
        return student.firstName() + " " + student.lastName();
    }

    public static String getStudentEmail(final Student student) {
        return student.email();
    }
}
