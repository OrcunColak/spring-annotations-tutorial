package com.colak.springannotationstutorial.retryable;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MyRetryableServiceTest {

    @Autowired
    private MyRetryableService myRetryableService;

    @ParameterizedTest
    @EnumSource(MyRetryableService.ExceptionType.class)
    void testFetchDataFromRemote(MyRetryableService.ExceptionType exceptionType) throws Exception {
        String input = "input";
        String expectedValue = getExpectedValue(exceptionType, input);

        String result = myRetryableService.fetchDataFromRemote(exceptionType, input);
        Assertions.assertEquals(expectedValue, result);
    }

    private String getExpectedValue(MyRetryableService.ExceptionType exceptionType, String input) {
        return switch (exceptionType) {
            case NONE -> input;
            case MY_NETWORK_EXCEPTION -> "Default " + input;
            case MY_TIMEOUT_EXCEPTION -> "Default 2 " + input;
        };
    }

}
