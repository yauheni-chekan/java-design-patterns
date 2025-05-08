package com.ehu.design_patterns.specification.impl;

import com.ehu.design_patterns.figure.Figure;
import com.ehu.design_patterns.figure.impl.Ellipse;
import com.ehu.design_patterns.figure.impl.Point;
import com.ehu.design_patterns.specification.Specification;

public class XCoordinateRangeSpecification implements Specification<Figure> {
    private final double minX, maxX;

    /**
     * Constructor for XCoordinateRangeSpecification.
     * @param minX the minimum x-coordinate
     * @param maxX the maximum x-coordinate
     */
    public XCoordinateRangeSpecification(double minX, double maxX) {
        this.minX = minX;
        this.maxX = maxX;
    }

    @Override
    public boolean isSatisfiedBy(Figure figure) {
        double x = 0;
        if (figure instanceof Point point) {
            x = point.getX();
        } else if (figure instanceof Ellipse ellipse) {
            x = ellipse.getCenter().getX();
        }
        return x >= minX && x <= maxX;
    }
}
