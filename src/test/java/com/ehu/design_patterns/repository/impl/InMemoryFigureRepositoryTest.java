package com.ehu.design_patterns.repository.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ehu.design_patterns.figure.Figure;
import com.ehu.design_patterns.figure.impl.Ellipse;
import com.ehu.design_patterns.figure.impl.Point;
import com.ehu.design_patterns.specification.impl.NameSpecification;
import com.ehu.design_patterns.specification.impl.NameSortSpecification;
import com.ehu.design_patterns.specification.impl.IdSortSpecification;
import com.ehu.design_patterns.specification.impl.TypeSpecification;

import java.util.List;

public class InMemoryFigureRepositoryTest {

    private InMemoryFigureRepository repository;

    @BeforeEach
    void setUp() {
        repository = new InMemoryFigureRepository();
    }

    @Test
    void testClear() {
        repository.save(new Ellipse("Ellipse 1", new Point("", 0, 0), 10, 5));
        repository.save(new Ellipse("Ellipse 2", new Point("", 0, 0), 10, 5));
        repository.clear();
        assertEquals(0, repository.findAll().size());
    }

    @Test
    void testDeleteById() {
        Ellipse ellipse = new Ellipse("Ellipse 1", new Point("", 0, 0), 10, 5);
        repository.save(ellipse);
        repository.deleteById(ellipse.getId());
        assertEquals(0, repository.findAll().size());
    }

    @Test
    void testDelete() {
        Ellipse ellipse = new Ellipse("Ellipse 1", new Point("", 0, 0), 10, 5);
        repository.save(ellipse);
        repository.delete(new NameSpecification(ellipse.getName()));
        assertEquals(0, repository.findAll().size());
    }

    @Test
    void testExistsById() {
        Ellipse ellipse = new Ellipse("Ellipse 1", new Point("", 0, 0), 10, 5);
        repository.save(ellipse);
        assertTrue(repository.existsById(ellipse.getId()));
    }

    @Test
    void testExists() {
        Ellipse ellipse = new Ellipse("Ellipse 1", new Point("", 0, 0), 10, 5);
        repository.save(ellipse);
        assertTrue(repository.exists(new NameSpecification(ellipse.getName())));
    }

    @Test
    void testFindAll() {
        Ellipse ellipse = new Ellipse("Ellipse 1", new Point("", 0, 0), 10, 5);
        repository.save(ellipse);
        assertEquals(1, repository.findAll().size());
    }

    @Test
    void testFindById() {
        Ellipse ellipse = new Ellipse("Ellipse 1", new Point("", 0, 0), 10, 5);
        repository.save(ellipse);
        assertEquals(ellipse, repository.findById(ellipse.getId()).get());
    }

    @Test
    void testFind() {
        Ellipse ellipse = new Ellipse("Ellipse 1", new Point("", 0, 0), 10, 5);
        repository.save(ellipse);
        assertEquals(ellipse, repository.find(new NameSpecification(ellipse.getName())).get(0));
    }

    @Test
    void testSave() {
        Ellipse ellipse = new Ellipse("Ellipse 1", new Point("", 0, 0), 10, 5);
        repository.save(ellipse);
        assertEquals(ellipse, repository.findById(ellipse.getId()).get());
    }

    @Test
    void testUpdate() {
        Ellipse ellipse = new Ellipse("Ellipse 1", new Point("", 0, 0), 10, 5);
        repository.save(ellipse);
        Ellipse updatedEllipse = new Ellipse("Ellipse 1", new Point("", 0, 0), 15, 10);
        updatedEllipse.setId(ellipse.getId());
        repository.update(updatedEllipse);
        assertEquals(updatedEllipse, repository.findById(ellipse.getId()).get());
    }

    @Test
    void testFindAllWithNameSort() {
        // Create and save figures with different names
        Point point1 = new Point("Zebra", 0, 0);
        Point point2 = new Point("Apple", 0, 0);
        Point point3 = new Point("Banana", 0, 0);
        
        repository.save(point1);
        repository.save(point2);
        repository.save(point3);

        // Test ascending sort
        var sortedFigures = repository.findAll(new NameSortSpecification());
        assertEquals("Apple", sortedFigures.get(0).getName());
        assertEquals("Banana", sortedFigures.get(1).getName());
        assertEquals("Zebra", sortedFigures.get(2).getName());

        // Test descending sort
        sortedFigures = repository.findAll(new NameSortSpecification(false));
        assertEquals("Zebra", sortedFigures.get(0).getName());
        assertEquals("Banana", sortedFigures.get(1).getName());
        assertEquals("Apple", sortedFigures.get(2).getName());
    }

    @Test
    void testFindAllWithIdSort() {
        // Create and save figures
        Point point1 = new Point("Point1", 0, 0);
        Point point2 = new Point("Point2", 0, 0);
        Point point3 = new Point("Point3", 0, 0);
        
        repository.save(point1);
        repository.save(point2);
        repository.save(point3);

        // Test ascending sort
        var sortedFigures = repository.findAll(new IdSortSpecification());
        assertEquals(0L, sortedFigures.get(0).getId());
        assertEquals(1L, sortedFigures.get(1).getId());
        assertEquals(2L, sortedFigures.get(2).getId());

        // Test descending sort
        sortedFigures = repository.findAll(new IdSortSpecification(false));
        assertEquals(2L, sortedFigures.get(0).getId());
        assertEquals(1L, sortedFigures.get(1).getId());
        assertEquals(0L, sortedFigures.get(2).getId());
    }

    @Test
    void testFindWithSort() {
        // Create and save figures
        Point point1 = new Point("Point1", 0, 0);
        Point point2 = new Point("Point2", 0, 0);
        Ellipse ellipse = new Ellipse("Ellipse", new Point("", 0, 0), 10, 5);
        
        repository.save(point1);
        repository.save(point2);
        repository.save(ellipse);

        // Test finding all points and sorting by name
        List<Figure> sortedPoints = repository.find(
            new TypeSpecification(Point.class),
            new NameSortSpecification()
        );
        
        assertEquals(2, sortedPoints.size());
        assertEquals("Point1", sortedPoints.get(0).getName());
        assertEquals("Point2", sortedPoints.get(1).getName());
    }
}
