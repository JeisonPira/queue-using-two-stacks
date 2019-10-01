package com.hackerrank.test.queueusingtwostacks.exception;

public class ApplicationException extends Exception {

    ApplicationException(String message, Throwable cause) {
        super(message, cause);
    }

    public ApplicationException(String message) {
        super(message);
    }
}
