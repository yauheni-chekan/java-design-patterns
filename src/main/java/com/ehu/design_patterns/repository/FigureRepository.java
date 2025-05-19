package com.ehu.design_patterns.repository;

import java.util.List;
import java.util.Optional;

import com.ehu.design_patterns.figure.Figure;
import com.ehu.design_patterns.specification.Specification;
import com.ehu.design_patterns.specification.SortSpecification;

public interface FigureRepository {
    Figure save(Figure figure);
    List<Figure> find(Specification<Figure> specification);
    List<Figure> find(Specification<Figure> specification, SortSpecification<Figure> sortSpec);
    Optional<Figure> findById(Long id);
    List<Figure> findAll();
    List<Figure> findAll(SortSpecification<Figure> sortSpec);
    Figure update(Figure figure);
    boolean delete(Specification<Figure> specification);
    boolean exists(Specification<Figure> specification);
    boolean existsById(Long id);
    boolean deleteById(Long id);
    void clear();
}
