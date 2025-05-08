package com.ehu.design_patterns.repository.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ehu.design_patterns.figure.impl.Ellipse;
import com.ehu.design_patterns.figure.impl.Point;
import com.ehu.design_patterns.specification.impl.NameSpecification;

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
}
