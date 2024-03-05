package com.colak.springannotationstutorial.lifecycle.predestroy;

import jakarta.annotation.PreDestroy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.stereotype.Component;

/**
 * See <a href="https://medium.com/@lucaslazarinii/shutdown-routine-on-spring-application-9ea06af29156">...</a>
 * <p>
 * The @PreDestroy annotation is called before destroy() method
 */
@Component
@Slf4j
public class ShutdownRoutine implements DisposableBean {
    @Override
    public void destroy() {
        log.info("DisposableBean::destroy is called");
    }

    @PreDestroy
    public void preDestroy() {
        log.info("preDestroy annotation is called");
    }
}
