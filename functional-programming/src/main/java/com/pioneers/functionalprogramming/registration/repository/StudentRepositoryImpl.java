package com.pioneers.functionalprogramming.registration.repository;

import com.pioneers.functionalprogramming.registration.model.entity.Student;
import com.pioneers.functionalprogramming.registration.service.FailureCallback;
import com.pioneers.functionalprogramming.registration.service.SuccessCallback;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class StudentRepositoryImpl implements StudentRepository {

    private final Map<String, Student> students;

    public StudentRepositoryImpl() {
        this.students = new HashMap<>();
    }

    @Override
    public void findByEmail(String email, SuccessCallback<Student> successCallback, FailureCallback failureCallback) {
        Optional<Student> optionalStudent = students.values()
                .stream()
                .filter(student -> student.email().equals(email))
                .findFirst();

        if (optionalStudent.isPresent()) {
            failureCallback.onFailure("Student with email: " + email + " already registered!!");
            return;
        }

        successCallback.onSuccess(students.get(email));
    }

    @Override
    public void save(Student student, SuccessCallback<Student> successCallback, FailureCallback failureCallback) {
        if (students.containsKey(student.id())) {
            failureCallback.onFailure(String.format("Student with id: %s already registered!!", student.id()));
            return;
        }
        students.put(student.id(), student);
        successCallback.onSuccess(student);
    }
}
