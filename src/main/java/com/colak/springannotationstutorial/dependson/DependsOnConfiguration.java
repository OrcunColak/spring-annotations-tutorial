package com.colak.springannotationstutorial.dependson;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

@Slf4j
@Configuration
public class DependsOnConfiguration {


    @Bean(name = "bean1")
    @DependsOn("bean2")
    public String bean1() {
        log.info("Creating bean1");
        // Create and configure your bean here
        // It will only be created after the initialization of "bean2"
        return "bean1";
    }

    @Bean(name = "bean2")
    public String bean2() {
        log.info("Creating bean2");
        // Create and configure your bean here
        return "bean2()";
    }
}
