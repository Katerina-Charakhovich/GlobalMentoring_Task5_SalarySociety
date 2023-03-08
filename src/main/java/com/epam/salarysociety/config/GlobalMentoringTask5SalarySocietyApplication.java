package com.epam.salarysociety.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = "com.epam")
@ComponentScan("com.epam")
@EntityScan(basePackages = {"com.epam"})
public class GlobalMentoringTask5SalarySocietyApplication {

    public static void main(String[] args) {
        SpringApplication.run(GlobalMentoringTask5SalarySocietyApplication.class, args);
    }
}

