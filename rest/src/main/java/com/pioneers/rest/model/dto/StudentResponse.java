package com.pioneers.rest.model.dto;

import java.util.Objects;

public class StudentResponse {
    private String name;
    private Integer age;
    private String address;

    public StudentResponse(String name, Integer age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        StudentResponse that = (StudentResponse) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(age, that.age) &&
                Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, address);
    }

    @Override
    public String toString() {
        return "StudentResponse{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }
}
