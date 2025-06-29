package com.pioneers.jpa.repositoty.student;

import com.pioneers.jpa.model.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentCustomRepositoryImpl implements StudentCustomRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Student> findAllCustom() {
        String sql = "SELECT s FROM Student s";
        return entityManager.createQuery(sql, Student.class).getResultList();
    }

    @Override
    public Student findByEmailCustom(String email) {
        String sql = "SELECT s FROM Student s WHERE s.email = :theEmail";
        return entityManager.createQuery(sql, Student.class)
                .setParameter("theEmail", email)
                .getSingleResult();
    }
}
