package com.ehu.design_patterns.specification.impl;

import com.ehu.design_patterns.figure.Figure;
import com.ehu.design_patterns.figure.impl.Ellipse;
import com.ehu.design_patterns.specification.Specification;

public class MajorAxisRangeSpecification implements Specification<Figure> {
    private final double min, max;

    /**
     * Constructor for MajorAxisRangeSpecification.
     * @param min the minimum major axis length
     * @param max the maximum major axis length
     */
    public MajorAxisRangeSpecification(double min, double max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public boolean isSatisfiedBy(Figure figure) {
        if (figure instanceof Ellipse ellipse) {
            double major = ellipse.getMajorAxis();
            return major >= min && major <= max;
        }
        return false;
    }
}
