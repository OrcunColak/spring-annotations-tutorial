package com.colak.springannotationstutorial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;

@SpringBootApplication
@EnableRetry
public class SpringAnnotationsTutorialApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringAnnotationsTutorialApplication.class, args);
    }

}
