package com.ehu.actions.impl;

import com.ehu.actions.GeometricCalculator;
import com.ehu.figures.Point;

public class PointDistanceCalculator implements GeometricCalculator<Point>   {

    /**
     * Calculates the distance between two points. The distance is the length of the triangle's hypotenuse.
     * @param points the points to calculate the distance between
     * @return the distance between the two points
     */
    @Override
    public double calculate(Point[]  points) {
        if (points.length != 2) {
            throw new IllegalArgumentException("Two points are required to calculate the distance.");
        }
        return Math.sqrt(Math.pow(points[0].getX() - points[1].getX(), 2) + Math.pow(points[0].getY() - points[1].getY(), 2));
    }
}