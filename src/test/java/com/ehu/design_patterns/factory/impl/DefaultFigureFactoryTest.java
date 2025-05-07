package com.ehu.design_patterns.factory.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ehu.design_patterns.exception.InvalidFigureParametersException;
import com.ehu.design_patterns.exception.InvalidFigureTypeException;
import com.ehu.design_patterns.figure.Figure;
import com.ehu.design_patterns.figure.impl.Ellipse;
import com.ehu.design_patterns.figure.impl.Point;

class DefaultFigureFactoryTest {

    private DefaultFigureFactory factory;

    @BeforeEach
    void setUp() {
        factory = new DefaultFigureFactory();
    }

    @Test
    void create_ValidPoint_ReturnsPoint() {
        // Arrange
        String[] params = {"POINT", "testPoint", "1.0", "2.0"};

        // Act
        Optional<Figure> result = factory.create(params);

        // Assert
        assertTrue(result.isPresent());
        assertTrue(result.get() instanceof Point);
        Point point = (Point) result.get();
        assertEquals("testPoint", point.getName());
        assertEquals(1.0, point.getX());
        assertEquals(2.0, point.getY());
    }

    @Test
    void create_ValidEllipse_ReturnsEllipse() {
        // Arrange
        String[] params = {"ELLIPSE", "testEllipse", "1.0", "2.0", "3.0", "4.0"};

        // Act
        Optional<Figure> result = factory.create(params);

        // Assert
        assertTrue(result.isPresent());
        assertTrue(result.get() instanceof Ellipse);
        Ellipse ellipse = (Ellipse) result.get();
        assertEquals("testEllipse", ellipse.getName());
        assertEquals(3.0, ellipse.getMajorAxis());
        assertEquals(4.0, ellipse.getMinorAxis());
    }

    @Test
    void create_InvalidFigureType_ThrowsInvalidFigureTypeException() {
        // Arrange
        String[] params = {"INVALID", "test", "1.0", "2.0"};

        // Act & Assert
        assertThrows(InvalidFigureTypeException.class, () -> factory.create(params));
    }

    @Test
    void create_InvalidPointParameters_ThrowsInvalidFigureParametersException() {
        // Arrange
        String[] params = {"POINT", "testPoint", "invalid", "2.0"};

        // Act & Assert
        InvalidFigureParametersException exception = assertThrows(InvalidFigureParametersException.class,
            () -> factory.create(params));
        assertTrue(exception.getMessage().contains("Point coordinates must be valid numbers"));
    }

    @Test
    void create_InvalidEllipseParameters_ThrowsInvalidFigureParametersException() {
        // Arrange
        String[] params = {"ELLIPSE", "testEllipse", "1.0", "2.0", "-3.0", "4.0"};

        // Act & Assert
        InvalidFigureParametersException exception = assertThrows(InvalidFigureParametersException.class,
            () -> factory.create(params));
        assertTrue(exception.getMessage().contains("Ellipse width and height must be positive"));
    }

    @Test
    void createPoint_ValidParameters_ReturnsPoint() {
        // Act
        Point point = factory.createPoint("testPoint", 1.0, 2.0);

        // Assert
        assertEquals("testPoint", point.getName());
        assertEquals(1.0, point.getX());
        assertEquals(2.0, point.getY());
    }

    @Test
    void createEllipse_ValidParameters_ReturnsEllipse() {
        // Arrange
        Point center = factory.createPoint("center", 1.0, 2.0);

        // Act
        Ellipse ellipse = factory.createEllipse("testEllipse", center, 3.0, 4.0);

        // Assert
        assertEquals("testEllipse", ellipse.getName());
        assertEquals(center, ellipse.getCenter());
        assertEquals(3.0, ellipse.getMajorAxis());
        assertEquals(4.0, ellipse.getMinorAxis());
    }
} 