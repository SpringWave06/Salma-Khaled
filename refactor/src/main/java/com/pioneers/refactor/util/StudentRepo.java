package com.pioneers.refactor.util;

import com.pioneers.refactor.model.entity.Student;

import java.util.*;

/**
 * StudentRepo Utility Class.
 *
 * @author Abdelaziz Said
 */
public class StudentRepo {
    private static final Map<String, Student> students = new LinkedHashMap<>();

    private StudentRepo() {
        throw new IllegalStateException("StudentRepo is a Utility class");
    }

    public static boolean isLoggedIn(final String id) {
        return students.containsKey(id);
    }

    public static void insertStudent(final String id , final Student student) {
        students.put(id, student);
    }

    public static void login(final String id) {
        students.get(id).setLoggedIn(true);
    }

    public static void logout(final String id) {
        students.get(id).setLoggedIn(false);
    }

    public static void deleteAll() {
        students.clear();
    }

    public static Map<String, Student> getStudents() {
        return students;
    }
}
