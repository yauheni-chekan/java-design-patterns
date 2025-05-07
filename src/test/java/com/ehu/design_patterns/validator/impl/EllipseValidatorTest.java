package com.ehu.design_patterns.validator.impl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EllipseValidatorTest {

    private EllipseValidator validator;

    @BeforeEach
    void setUp() {
        validator = new EllipseValidator();
    }

    @Test
    void isValidParams_ValidParameters_ReturnsTrue() {
        // Arrange
        String[] params = {"ELLIPSE", "testEllipse", "1.0", "2.0", "3.0", "4.0"};

        // Act
        boolean result = validator.isValidParams(params);

        // Assert
        assertTrue(result);
    }

    @Test
    void isValidParams_InvalidNumberOfParameters_ReturnsFalse() {
        // Arrange
        String[] params = {"ELLIPSE", "testEllipse", "1.0", "2.0", "3.0"};

        // Act
        boolean result = validator.isValidParams(params);

        // Assert
        assertFalse(result);
    }

    @Test
    void isValidParams_InvalidCoordinates_ReturnsFalse() {
        // Arrange
        String[] params = {"ELLIPSE", "testEllipse", "invalid", "2.0", "3.0", "4.0"};

        // Act
        boolean result = validator.isValidParams(params);

        // Assert
        assertFalse(result);
    }

    @Test
    void isValidParams_NegativeDimensions_ReturnsFalse() {
        // Arrange
        String[] params = {"ELLIPSE", "testEllipse", "1.0", "2.0", "-3.0", "4.0"};

        // Act
        boolean result = validator.isValidParams(params);

        // Assert
        assertFalse(result);
    }

    @Test
    void getErrorMessage_ValidParameters_ReturnsEmptyString() {
        // Arrange
        String[] params = {"ELLIPSE", "testEllipse", "1.0", "2.0", "3.0", "4.0"};

        // Act
        String result = validator.getErrorMessage(params);

        // Assert
        assertEquals("", result);
    }

    @Test
    void getErrorMessage_InvalidNumberOfParameters_ReturnsErrorMessage() {
        // Arrange
        String[] params = {"ELLIPSE", "testEllipse", "1.0", "2.0", "3.0"};

        // Act
        String result = validator.getErrorMessage(params);

        // Assert
        assertEquals("Ellipse must have 6 parameters: type, name, x, y, width, height", result);
    }

    @Test
    void getErrorMessage_NegativeDimensions_ReturnsErrorMessage() {
        // Arrange
        String[] params = {"ELLIPSE", "testEllipse", "1.0", "2.0", "-3.0", "4.0"};

        // Act
        String result = validator.getErrorMessage(params);

        // Assert
        assertEquals("Ellipse width and height must be positive", result);
    }

    @Test
    void getErrorMessage_InvalidCoordinates_ReturnsErrorMessage() {
        // Arrange
        String[] params = {"ELLIPSE", "testEllipse", "1.0", "2.0", "invalid", "4.0"};

        // Act
        String result = validator.getErrorMessage(params);

        // Assert
        assertEquals("Invalid parameters", result);
    }
} 