package com.pioneers.functionalprogramming.registration.service.student;

import com.pioneers.functionalprogramming.registration.model.dto.StudentDto;
import com.pioneers.functionalprogramming.registration.model.entity.Student;
import com.pioneers.functionalprogramming.registration.service.FailureCallback;
import com.pioneers.functionalprogramming.registration.service.SuccessCallback;

public interface StudentService {

    void registerStudent(StudentDto student, SuccessCallback<Student> successCallback, FailureCallback failureCallback);
}
