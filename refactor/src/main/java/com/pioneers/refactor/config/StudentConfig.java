package com.pioneers.refactor.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(StudentProperties.class)
public class StudentConfig {
}
