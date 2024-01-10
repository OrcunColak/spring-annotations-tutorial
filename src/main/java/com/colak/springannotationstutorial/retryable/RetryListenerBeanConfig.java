package com.colak.springannotationstutorial.retryable;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RetryListenerBeanConfig {

    @Bean
    public MyRetryListenerBean myRetryListenerBean() {
        return new MyRetryListenerBean();
    }
}
