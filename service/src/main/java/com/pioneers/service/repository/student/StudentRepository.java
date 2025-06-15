package com.pioneers.service.repository.student;

import com.pioneers.service.model.entity.Student;
import lombok.*;

import java.util.List;
import java.util.Optional;

/**
 * Repository class that include data operation with the runtime db.
 *
 * @author Abdelaziz Said
 */
public interface StudentRepository {

    /**
     * Check if the student is logged in.
     *
     * @param id The primary key of the student
     * @return The state of logging for the student
     */
    boolean isLoggedIn(final String id);

    void insertStudent(final String id , final Student student);

    void login(final String id);

    void logout(final String id);

    Optional<Student> findStudentByEmail(final String email);

    Optional<Student> findStudentByCredentials(@NonNull final String email, @NonNull final String password);

    Optional<Student> findByName(final String name);

    List<Student> findByAge(final int age);

    List<Student> findAll();
    
    Optional<Student> findFirst();

    void deleteAll();

    void deleteByAgeAndName(final int age, final String name);
}
