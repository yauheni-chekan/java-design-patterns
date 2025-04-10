package com.ehu.design_patterns.action.impl;

import com.ehu.design_patterns.action.GeometricCalculator;
import com.ehu.design_patterns.figure.Ellipse;

public class EllipseAreaCalculator implements GeometricCalculator<Ellipse> {

    /**
     * Calculates the area of an ellipse.
     * @param figure the ellipse to calculate the area of
     * @return the area of the ellipse
     */
    @Override
    public double calculate(Ellipse figure) {
        return Math.PI * (figure.getMajorAxis() / 2) * (figure.getMinorAxis() / 2);
    }
}
