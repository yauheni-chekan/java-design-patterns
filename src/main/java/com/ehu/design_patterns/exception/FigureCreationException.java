package com.ehu.design_patterns.exception;

/**
 * Base exception class for figure creation errors.
 */
public class FigureCreationException extends RuntimeException {
    
    public FigureCreationException(String message) {
        super(message);
    }

    public FigureCreationException(String message, Throwable cause) {
        super(message, cause);
    }
}