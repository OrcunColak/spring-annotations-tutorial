package com.colak.springannotationstutorial.retryable;

public class MyTimeoutException extends Exception {
    public MyTimeoutException(String message) {
        super(message);
    }
}
