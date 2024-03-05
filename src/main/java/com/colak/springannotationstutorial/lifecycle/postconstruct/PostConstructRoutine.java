package com.colak.springannotationstutorial.lifecycle.postconstruct;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * See <a href="https://medium.com/@lucaslazarinii/shutdown-routine-on-spring-application-9ea06af29156">...</a>
 * <p>
 * The @PostConstruct annotation is called before afterPropertiesSet() method
 */
@Component
@Slf4j
public class PostConstructRoutine implements InitializingBean {

    @PostConstruct
    public void postConstruct() {
        log.info("postConstruct annotation is called");
    }

    @Override
    public void afterPropertiesSet() {
        log.info("afterPropertiesSet is called");
    }
}
