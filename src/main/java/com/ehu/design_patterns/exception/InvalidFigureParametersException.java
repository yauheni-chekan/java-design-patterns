package com.ehu.design_patterns.exception;

/**
 * Exception thrown when invalid parameters are provided for figure creation.
 */
public class InvalidFigureParametersException extends FigureCreationException {
    
    public InvalidFigureParametersException(String figureType, String reason) {
        super(String.format("Invalid parameters for %s: %s", figureType, reason));
    }

    public InvalidFigureParametersException(String figureType, String reason, Throwable cause) {
        super(String.format("Invalid parameters for %s: %s", figureType, reason), cause);
    }
} 