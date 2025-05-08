package com.ehu.design_patterns.specification.impl;

import com.ehu.design_patterns.figure.Figure;
import com.ehu.design_patterns.figure.impl.Ellipse;
import com.ehu.design_patterns.figure.impl.Point;
import com.ehu.design_patterns.specification.Specification;

public class YCoordinateRangeSpecification implements Specification<Figure> {
    private final double minY, maxY;

    /**
     * Constructor for YCoordinateRangeSpecification.
     * @param minY the minimum y-coordinate
     * @param maxY the maximum y-coordinate
     */
    public YCoordinateRangeSpecification(double minY, double maxY) {
        this.minY = minY;
        this.maxY = maxY;
    }

    @Override
    public boolean isSatisfiedBy(Figure figure) {
        double y = 0;
        if (figure instanceof Point point) {
            y = point.getY();
        } else if (figure instanceof Ellipse ellipse) {
            y = ellipse.getCenter().getY();
        }
        return y >= minY && y <= maxY;
    }
}
