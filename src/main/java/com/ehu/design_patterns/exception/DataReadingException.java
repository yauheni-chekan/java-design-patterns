package com.ehu.design_patterns.exception;

/**
 * Base exception class for data reading errors.
 */
public class DataReadingException extends RuntimeException {
    
    public DataReadingException(String message) {
        super(message);
    }

    public DataReadingException(String message, Throwable cause) {
        super(message, cause);
    }
} 