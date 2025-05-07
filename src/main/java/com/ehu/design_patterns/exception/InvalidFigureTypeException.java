package com.ehu.design_patterns.exception;

/**
 * Exception thrown when an invalid figure type is specified.
 */
public class InvalidFigureTypeException extends FigureCreationException {
    
    public InvalidFigureTypeException(String figureType) {
        super(String.format("Invalid figure type: %s", figureType));
    }

    public InvalidFigureTypeException(String figureType, Throwable cause) {
        super(String.format("Invalid figure type: %s", figureType), cause);
    }
} 