package com.ehu.design_patterns.validator.impl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PointValidatorTest {

    private PointValidator validator;

    @BeforeEach
    void setUp() {
        validator = new PointValidator();
    }

    @Test
    void isValidParams_ValidParameters_ReturnsTrue() {
        // Arrange
        String[] params = {"POINT", "testPoint", "1.0", "2.0"};

        // Act
        boolean result = validator.isValidParams(params);

        // Assert
        assertTrue(result);
    }

    @Test
    void isValidParams_InvalidNumberOfParameters_ReturnsFalse() {
        // Arrange
        String[] params = {"POINT", "testPoint", "1.0"};

        // Act
        boolean result = validator.isValidParams(params);

        // Assert
        assertFalse(result);
    }

    @Test
    void isValidParams_InvalidCoordinates_ReturnsFalse() {
        // Arrange
        String[] params = {"POINT", "testPoint", "invalid", "2.0"};

        // Act
        boolean result = validator.isValidParams(params);

        // Assert
        assertFalse(result);
    }

    @Test
    void getErrorMessage_ValidParameters_ReturnsEmptyString() {
        // Arrange
        String[] params = {"POINT", "testPoint", "1.0", "2.0"};

        // Act
        String result = validator.getErrorMessage(params);

        // Assert
        assertEquals("", result);
    }

    @Test
    void getErrorMessage_InvalidNumberOfParameters_ReturnsErrorMessage() {
        // Arrange
        String[] params = {"POINT", "testPoint", "1.0"};

        // Act
        String result = validator.getErrorMessage(params);

        // Assert
        assertEquals("Point must have 4 parameters: type, name, x, y (Actual: [POINT, testPoint, 1.0])", result);
    }

    @Test
    void getErrorMessage_InvalidCoordinates_ReturnsErrorMessage() {
        // Arrange
        String[] params = {"POINT", "testPoint", "invalid", "2.0"};

        // Act
        String result = validator.getErrorMessage(params);

        // Assert
        assertEquals("Point coordinates must be valid numbers: [POINT, testPoint, invalid, 2.0]", result);
    }
} 