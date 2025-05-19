package com.ehu.design_patterns.specification.impl;

import java.util.Comparator;

import com.ehu.design_patterns.figure.Figure;
import com.ehu.design_patterns.specification.SortSpecification;

/**
 * Specification for sorting figures by name.
 */
public class NameSortSpecification implements SortSpecification<Figure> {
    private final boolean ascending;

    /**
     * Creates a new NameSortSpecification with ascending order.
     */
    public NameSortSpecification() {
        this(true);
    }

    /**
     * Creates a new NameSortSpecification with specified sort order.
     * @param ascending true for ascending order, false for descending
     */
    public NameSortSpecification(boolean ascending) {
        this.ascending = ascending;
    }

    @Override
    public Comparator<Figure> getComparator() {
        Comparator<Figure> comparator = Comparator.comparing(Figure::getName);
        return ascending ? comparator : comparator.reversed();
    }
} 