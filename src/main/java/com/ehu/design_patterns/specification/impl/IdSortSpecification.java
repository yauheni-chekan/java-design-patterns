package com.ehu.design_patterns.specification.impl;

import java.util.Comparator;

import com.ehu.design_patterns.figure.Figure;
import com.ehu.design_patterns.specification.SortSpecification;

/**
 * Specification for sorting figures by ID.
 */
public class IdSortSpecification implements SortSpecification<Figure> {
    private final boolean ascending;

    /**
     * Creates a new IdSortSpecification with ascending order.
     */
    public IdSortSpecification() {
        this(true);
    }

    /**
     * Creates a new IdSortSpecification with specified sort order.
     * @param ascending true for ascending order, false for descending
     */
    public IdSortSpecification(boolean ascending) {
        this.ascending = ascending;
    }

    @Override
    public Comparator<Figure> getComparator() {
        Comparator<Figure> comparator = Comparator.comparing(Figure::getId);
        return ascending ? comparator : comparator.reversed();
    }
} 