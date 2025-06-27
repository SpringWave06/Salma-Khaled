package com.pioneers.functionalprogramming.registration.repository;

import com.pioneers.functionalprogramming.registration.model.entity.Student;
import com.pioneers.functionalprogramming.registration.service.FailureCallback;
import com.pioneers.functionalprogramming.registration.service.SuccessCallback;

public interface StudentRepository {

    void findByEmail(String email, SuccessCallback<Student> successCallback, FailureCallback failureCallback);

    void save(Student student, SuccessCallback<Student> successCallback, FailureCallback failureCallback);
}
