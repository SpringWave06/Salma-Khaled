package com.pioneers.service.repository.student;

import com.pioneers.service.model.entity.Student;
import com.pioneers.service.util.StudentValidator;
import lombok.NonNull;
import lombok.Value;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static com.pioneers.service.util.StudentValidator.*;

@Value
@Component
public class StudentRepositoryImpl implements StudentRepository {

    Map<String, Student> students = new LinkedHashMap<>();

    public boolean isLoggedIn(final String id) {
        return students.containsKey(id);
    }

    public void insertStudent(final String id , final Student student) {
        students.put(id, student);
    }

    public void login(final String id) {
        students.get(id).setLoggedIn(true);
    }

    public void logout(final String id) {
        students.get(id).setLoggedIn(false);
    }

    public Optional<Student> findStudentByEmail(final String email) {
        return students.values()
                .stream()
                .filter(registeredStudent -> isNameMatched(registeredStudent.getEmail(), email))
                .findFirst();
    }

    public Optional<Student> findStudentByCredentials(@NonNull final String email, @NonNull final String password) {
        return students.values()
                .stream()
                .filter(student ->
                        isEmailMatched(student.getEmail(), email) && isPasswordMatched(student.getPassword(), password))
                .findFirst();
    }

    public Optional<Student> findByName(final String name) {
        return students.values()
                .stream()
                .filter(student -> StudentValidator.isNameMatched(student.getName(), name))
                .findFirst();
    }

    public List<Student> findByAge(final int age) {
        return students.values()
                .stream()
                .filter(student -> StudentValidator.isAgeMatched(student.getAge(), age))
                .toList();
    }

    public List<Student> findAll() {
        return students.values()
                .stream()
                .toList();
    }

    public Optional<Student> findFirst() {
        return students.values()
                .stream()
                .findFirst();
    }

    public void deleteAll() {
        students.clear();
    }

    public void deleteByAgeAndName(final int age, final String name) {
        students.values()
                .removeIf(student ->
                        StudentValidator.isNameMatched(student.getName(), name)
                                && StudentValidator.isAgeMatched(student.getAge(), age));
    }
}
