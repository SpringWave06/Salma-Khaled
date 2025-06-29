package com.pioneers.jpa.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column
    private UUID id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false, unique = true)
    private String phone;
    @Column(nullable = false)
    private int age;
    @Column(name = "enrollment_date", nullable = false)
    private Date enrollmentDate;
    @Column
    private float degree;
    @Column
    private String gender;
}
