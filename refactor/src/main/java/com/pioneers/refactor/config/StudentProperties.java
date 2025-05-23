package com.pioneers.refactor.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "student.egyptian")
public class StudentProperties {
    private String userName;
    private String age;
    private String email;
    private Address address;

    @Data
    public static class Address {
        private String continent;
        private String country;
        private String governorate;
        private String city;
        private String street;
        private int buildingNumber;
        private int floor;
        private int apartmentNumber;
    }
}
