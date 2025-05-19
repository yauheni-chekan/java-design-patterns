package com.ehu.design_patterns.specification.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.ehu.design_patterns.figure.Figure;
import com.ehu.design_patterns.figure.impl.Ellipse;
import com.ehu.design_patterns.figure.impl.Point;

public class IdSortSpecificationTest {

    @Test
    void testAscendingSort() {
        // Create test figures with different IDs
        Point point1 = new Point("Point1", 0, 0);
        point1.setId(3L);
        Point point2 = new Point("Point2", 0, 0);
        point2.setId(1L);
        Point point3 = new Point("Point3", 0, 0);
        point3.setId(2L);

        List<Point> points = Arrays.asList(point1, point2, point3);
        points.sort(new IdSortSpecification().getComparator());

        // Verify ascending order
        assertEquals(1L, points.get(0).getId());
        assertEquals(2L, points.get(1).getId());
        assertEquals(3L, points.get(2).getId());
    }

    @Test
    void testDescendingSort() {
        // Create test figures with different IDs
        Point point1 = new Point("Point1", 0, 0);
        point1.setId(3L);
        Point point2 = new Point("Point2", 0, 0);
        point2.setId(1L);
        Point point3 = new Point("Point3", 0, 0);
        point3.setId(2L);

        List<Point> points = Arrays.asList(point1, point2, point3);
        points.sort(new IdSortSpecification(false).getComparator());

        // Verify descending order
        assertEquals(3L, points.get(0).getId());
        assertEquals(2L, points.get(1).getId());
        assertEquals(1L, points.get(2).getId());
    }

    @Test
    void testMixedFigureTypes() {
        // Create test figures of different types
        Point point = new Point("Point", 0, 0);
        point.setId(2L);
        Ellipse ellipse = new Ellipse("Ellipse", new Point("", 0, 0), 10, 5);
        ellipse.setId(1L);

        List<Figure> figures = Arrays.asList(point, ellipse);
        figures.sort(new IdSortSpecification().getComparator());

        // Verify sorting works across different figure types
        assertEquals(1L, figures.get(0).getId());
        assertEquals(2L, figures.get(1).getId());
    }
} 