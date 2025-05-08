package com.ehu.design_patterns.specification.impl;

import com.ehu.design_patterns.figure.Figure;
import com.ehu.design_patterns.specification.Specification;

public class TypeSpecification implements Specification<Figure> {
    private final Class<?> type;

    /**
     * Constructor for TypeSpecification.
     * @param type the type of the figure to be satisfied by
     */
    public TypeSpecification(Class<?> type) {
        this.type = type;
    }

    @Override
    public boolean isSatisfiedBy(Figure figure) {
        return type.isInstance(figure);
    }
}
