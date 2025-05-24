package com.pioneers.refactor.util.pattern.builder;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
public class Student {
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String phone;
    private final String gender;
    private final int age;
    private final String address;

    /*public Student(StudentBuilder studentBuilder) {
        this.firstName = studentBuilder.firstName;
        this.lastName = studentBuilder.lastName;
        this.email = studentBuilder.email;
        this.phone = studentBuilder.phone;
        this.gender = studentBuilder.gender;
        this.age = studentBuilder.age;
        this.address = studentBuilder.address;
    }

    public static StudentBuilder builder() {
        return new StudentBuilder();
    }

    public static class StudentBuilder {
        private String firstName;
        private String lastName;
        private String email;
        private String phone;
        private String gender;
        private int age;
        private String address;

        public StudentBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public StudentBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public StudentBuilder email(String email) {
            this.email = email;
            return this;
        }

        public StudentBuilder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public StudentBuilder gender(String gender) {
            this.gender = gender;
            return this;
        }

        public StudentBuilder age(int age) {
            this.age = age;
            return this;
        }

        public StudentBuilder address(String address) {
            this.address = address;
            return this;
        }

        public Student build() {
            return new Student(this);
        }
    }*/
}
