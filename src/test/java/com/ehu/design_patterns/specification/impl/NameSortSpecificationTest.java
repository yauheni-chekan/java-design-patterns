package com.ehu.design_patterns.specification.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.ehu.design_patterns.figure.Figure;
import com.ehu.design_patterns.figure.impl.Ellipse;
import com.ehu.design_patterns.figure.impl.Point;

public class NameSortSpecificationTest {

    @Test
    void testAscendingSort() {
        // Create test figures with different names
        Point point1 = new Point("Zebra", 0, 0);
        Point point2 = new Point("Apple", 0, 0);
        Point point3 = new Point("Banana", 0, 0);

        List<Point> points = Arrays.asList(point1, point2, point3);
        points.sort(new NameSortSpecification().getComparator());

        // Verify ascending order
        assertEquals("Apple", points.get(0).getName());
        assertEquals("Banana", points.get(1).getName());
        assertEquals("Zebra", points.get(2).getName());
    }

    @Test
    void testDescendingSort() {
        // Create test figures with different names
        Point point1 = new Point("Zebra", 0, 0);
        Point point2 = new Point("Apple", 0, 0);
        Point point3 = new Point("Banana", 0, 0);

        List<Point> points = Arrays.asList(point1, point2, point3);
        points.sort(new NameSortSpecification(false).getComparator());

        // Verify descending order
        assertEquals("Zebra", points.get(0).getName());
        assertEquals("Banana", points.get(1).getName());
        assertEquals("Apple", points.get(2).getName());
    }

    @Test
    void testMixedFigureTypes() {
        // Create test figures of different types
        Point point = new Point("Zebra", 0, 0);
        Ellipse ellipse = new Ellipse("Apple", new Point("", 0, 0), 10, 5);

        List<Figure> figures = Arrays.asList(point, ellipse);
        figures.sort(new NameSortSpecification().getComparator());

        // Verify sorting works across different figure types
        assertEquals("Apple", figures.get(0).getName());
        assertEquals("Zebra", figures.get(1).getName());
    }
} 