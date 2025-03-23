package com.ehu.actions.impl;

import com.ehu.actions.GeometricCalculator;
import com.ehu.figures.Ellipse;

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
