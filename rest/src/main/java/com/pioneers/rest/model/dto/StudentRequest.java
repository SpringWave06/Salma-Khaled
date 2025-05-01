package com.pioneers.rest.model.dto;

import java.util.Objects;

public class StudentRequest {
    private String name;
    private Integer age;
    private String address;
    private String password;

    public StudentRequest(String name, Integer age, String address, String password) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        StudentRequest that = (StudentRequest) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(age, that.age) &&
                Objects.equals(address, that.address) &&
                Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, address, password);
    }

    @Override
    public String toString() {
        return "StudentDto{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }
}
