package com.ehu.figures;

public class Point {
    private final String NAME;
    private final double x;
    private final double y;

    public Point(String name, double x, double y) {
        this.NAME = name;
        this.x = x;
        this.y = y;
    }

    public String getName() {
        return NAME;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public String toString() {
        return String.format("Point %s: (%.2f, %.2f)", NAME, x, y);
    }

    @Override
    public boolean equals(Point other) {
        return NAME.equals(other.NAME) && x == other.x && y == other.y;
    }

    @Override
    public int hashCode() {
        int multiplier = 31;
        return multiplier * (multiplier * NAME.hashCode() + Double.hashCode(x)) + Double.hashCode(y);
    }
}
