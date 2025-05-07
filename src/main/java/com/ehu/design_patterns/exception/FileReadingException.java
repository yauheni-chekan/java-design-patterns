package com.ehu.design_patterns.exception;

/**
 * Exception thrown when there are errors reading from a file.
 */
public class FileReadingException extends DataReadingException {
    
    public FileReadingException(String filePath, String reason) {
        super(String.format("Error reading file '%s': %s", filePath, reason));
    }

    public FileReadingException(String filePath, String reason, Throwable cause) {
        super(String.format("Error reading file '%s': %s", filePath, reason), cause);
    }
} 