package com.colak.springannotationstutorial.retryable;

public class MyNetworkException extends Exception {

    public MyNetworkException(String message) {
        super(message);
    }
}
