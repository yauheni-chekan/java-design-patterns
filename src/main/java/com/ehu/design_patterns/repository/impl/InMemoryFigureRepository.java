package com.ehu.design_patterns.repository.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.ehu.design_patterns.figure.Figure;
import com.ehu.design_patterns.repository.FigureRepository;
import com.ehu.design_patterns.specification.Specification;
import com.ehu.design_patterns.specification.SortSpecification;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InMemoryFigureRepository implements FigureRepository {
    private static final Logger logger = LoggerFactory.getLogger(InMemoryFigureRepository.class);
    private Long idCounter = 0L;
    private final Map<Long, Figure> figures = new HashMap<>();
    
    @Override
    public Figure save(Figure figure) {
        if (figure.getId() == 0L) {
            figure.setId(idCounter++);
        }

        figures.put(figure.getId(), figure);
        logger.debug("Figure saved: {}", figure);
        return figure;
    }
    
    @Override
    public List<Figure> find(Specification<Figure> specification) {
        return figures.values().stream()
            .filter(specification::isSatisfiedBy)
            .toList();
    }

    @Override
    public List<Figure> find(Specification<Figure> specification, SortSpecification<Figure> sortSpec) {
        return figures.values().stream()
            .filter(specification::isSatisfiedBy)
            .sorted(sortSpec.getComparator())
            .toList();
    }
    
    @Override
    public List<Figure> findAll() {
        return new ArrayList<>(figures.values());
    }

    @Override
    public List<Figure> findAll(SortSpecification<Figure> sortSpec) {
        return figures.values().stream()
            .sorted(sortSpec.getComparator())
            .toList();
    }
    
    @Override
    public boolean delete(Specification<Figure> specification) {
        List<Long> keysToRemove = figures.values().stream()
            .filter(specification::isSatisfiedBy)
            .map(Figure::getId)
            .toList();

        keysToRemove.forEach(figures::remove);

        return !keysToRemove.isEmpty();
    }
    
    @Override
    public boolean deleteById(Long id) {
        return figures.remove(id) != null;
    }

    @Override
    public boolean exists(Specification<Figure> specification) {
        return figures.values().stream()
            .anyMatch(specification::isSatisfiedBy);
    }

    @Override
    public boolean existsById(Long id) {
        return figures.containsKey(id);
    }
    
    @Override
    public void clear() {
        figures.clear();
    }

    @Override
    public Optional<Figure> findById(Long id) {
        return Optional.ofNullable(figures.get(id));
    }

    @Override
    public Figure update(Figure figure) {
        figures.put(figure.getId(), figure);
        return figure;
    }
}
