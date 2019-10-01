package com.hackerrank.test.queueusingtwostacks.exception;

public class TechnicalException extends ApplicationException {

    public TechnicalException(String message, Throwable cause) {
        super(message, cause);
    }

    public TechnicalException(String message) {
        super(message);
    }
}
