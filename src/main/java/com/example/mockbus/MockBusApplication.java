package com.example.mockbus;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.example.mockbus") //to scan packages mentioned
//@EnableJpaRepositories(basePackages="com.example.mockbus.repositories") //to activate MongoDB repositories
public class MockBusApplication {


    public static void main(String[] args) {
        SpringApplication.run(MockBusApplication.class, args);
    }
}
