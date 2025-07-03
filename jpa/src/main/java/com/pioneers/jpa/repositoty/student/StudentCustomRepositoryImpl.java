package com.pioneers.jpa.repositoty.student;

import com.pioneers.jpa.model.dto.StudentDto;
import com.pioneers.jpa.model.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.sql.Date;
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

    @Override
    public Student createEsraa(StudentDto studentDto){
        
        Student student = new Student();
        student.setName("Esraa");
        student.setEmail(studentDto.email());
        student.setPhone(studentDto.phone());
        student.setEnrollmentDate(studentDto.enrolmentDate());
        student.setDegree(studentDto.degree());
        student.setGender(studentDto.gender());
        student.setAge(studentDto.age());

        entityManager.persist(student);
        return student;
    }

    @Override
    public Student updateEsraa(Float degree, Integer Age){
        Student student = entityManager.createQuery(
        "SELECT s FROM Student s WHERE s.name = :name", Student.class)
        .setParameter("name", "Esraa")
        .getSingleResult();

        student.setDegree(degree);
        student.setAge(Age);
        
        return student;
    }

    @Override
    public void deleteEsraa(){
        Student student = entityManager.createQuery(
        "SELECT s FROM Student s WHERE s.name = :name", Student.class)
        .setParameter("name", "Esraa")
        .getSingleResult();

        entityManager.remove(student);
    }

    @Override
    public List<Student> filterStudent(Integer age, Date enrollmentDate, String namePattern){
        return entityManager.createQuery(
        "SELECT s FROM Student s WHERE s.age = :age OR s.enrollmentDate = :enrollmentDate OR s.name LIKE :namePattern", Student.class)
        .setParameter("age", age)
        .setParameter("enrollmentDate", enrollmentDate)
        .setParameter("namePattern", "%" + namePattern + "%")
        .getResultList();  
    }
}
