package com.ehu.design_patterns.specification.impl;

import com.ehu.design_patterns.figure.Figure;
import com.ehu.design_patterns.specification.Specification;

public class NameSpecification implements Specification<Figure> {
    private final String name;

    /**
     * Constructor for NameSpecification.
     * @param name the name of the figure to be satisfied by
     */
    public NameSpecification(String name) {
        this.name = name;
    }

    @Override
    public boolean isSatisfiedBy(Figure figure) {
        return figure.getName().equals(name);
    }
}
