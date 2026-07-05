package com.cognizant.employee.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Configuration
public class EmployeeConfig {

    @Bean
    public ClassPathXmlApplicationContext context() {
        return new ClassPathXmlApplicationContext("employee.xml");
    }

}