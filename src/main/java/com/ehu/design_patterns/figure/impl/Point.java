package com.ehu.design_patterns.figure.impl;

import com.ehu.design_patterns.figure.Figure;

public class Point implements Figure {
    private final String name;
    private final double x;
    private final double y;
    private Long id = 0L;

    public Point(String name, double x, double y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }

    public String getName() {
        return name;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public String toString() {
        return String.format("Point %s: (x: %.2f, y: %.2f)", name, x, y);
    }

    @Override
    public boolean equals(Object other) {
        if (other == null || !(other instanceof Point)) {
            return false;
        }
        if (this == other) {
            return true;
        }
        Point otherPoint = (Point) other;
        return name.equals(otherPoint.name) && x == otherPoint.x && y == otherPoint.y;
    }

    @Override
    public int hashCode() {
        int multiplier = 31;
        return multiplier * (multiplier * name.hashCode() + Double.hashCode(x)) + Double.hashCode(y);
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
}
