package com.colak.springannotationstutorial.controller_responsebody.controller;

import com.colak.springannotationstutorial.controller_responsebody.dto.ProductCatalogDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductCatalogControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    void testPing() {
        ResponseEntity<String> responseEntity = testRestTemplate.getForEntity("/ping", String.class);
        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
    }

    @Test
    void testGetProductCatalog() {
        ResponseEntity<List<ProductCatalogDto>> responseEntity =
                testRestTemplate.exchange(
                        "/productCatalog",
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<>() {
                        }
                );
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

        List<ProductCatalogDto> body = responseEntity.getBody();
        assert body != null;
        assertEquals(2, body.size());
    }
}
