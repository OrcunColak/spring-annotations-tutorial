package com.colak.springannotationstutorial.retryable;

import lombok.extern.slf4j.Slf4j;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MyRetryableService {

    public enum ExceptionType {

        NONE,

        MY_NETWORK_EXCEPTION,

        MY_TIMEOUT_EXCEPTION

    }

    // Use Multiple Recovery Paths
    @Retryable(
            listeners = "myRetryListenerBean",
            retryFor = {MyNetworkException.class, MyTimeoutException.class},
            maxAttempts = 2,
            backoff = @Backoff(delay = 100, multiplier = 2)
    )
    public String fetchDataFromRemote(ExceptionType exceptionType, String input) throws Exception {
        log.info("fetchDataFromRemote is called with {}", input);

        if (exceptionType == ExceptionType.MY_NETWORK_EXCEPTION) {
            throw new MyNetworkException("MyNetworkException");
        } else if (exceptionType == ExceptionType.MY_TIMEOUT_EXCEPTION) {
            throw new MyTimeoutException("MyTimeoutException");
        }
        return input;
    }

    @Recover
    public String recover(MyNetworkException exception, ExceptionType exceptionType, String input) {
        // Fallback logic
        return "Default " + input;
    }

    @Recover
    public String recover(MyTimeoutException exception, ExceptionType exceptionType, String input) {
        // Fallback logic
        return "Default 2 " + input;
    }
}
