package com.colak.springannotationstutorial.aop.forannoation.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ExampleControllerTest {
    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    void testCheckStatusCard() {
        String url = "/api/aop/checkStatusCard/?card=1&id=2";
        ResponseEntity<String> responseEntity = testRestTemplate.getForEntity(url, String.class);
        assertNotNull(responseEntity.getBody());
    }
}
