package com.ehu.actions.impl;

import com.ehu.actions.GeometricCalculator;
import com.ehu.figures.Ellipse;

public class EllipsePerimeterCalculator implements GeometricCalculator<Ellipse> {

    /**
     * Calculates the perimeter of an ellipse using Ramanujan's second approximation.
     * @param figure the ellipse to calculate the perimeter of
     * @return the perimeter of the ellipse
     */
    @Override
    public double calculate(Ellipse figure) {
        double a = figure.getMajorAxis() / 2;
        double b = figure.getMinorAxis() / 2;
        double h = Math.pow(a - b, 2) / Math.pow(a + b, 2);
        return Math.PI * (a + b) * (1 + 3 * h / (10 + Math.sqrt(4 - 3 * h)));
    }
}