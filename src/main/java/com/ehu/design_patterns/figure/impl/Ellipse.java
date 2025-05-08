package com.ehu.design_patterns.figure.impl;

import com.ehu.design_patterns.figure.Figure;

public class Ellipse implements Figure {

    private Long id = 0L;
    private final String name;
    private Point center;
    private double majorAxis;
    private double minorAxis;

    public Ellipse(String name, Point center, double width, double height) {
        this.name = name;
        this.center = center;
        this.majorAxis = width;
        this.minorAxis = height;
    }

    public Ellipse(String name, Point rect1, Point rect2) {
        this.name = name;
        this.center = new Point("Center", (rect1.getX() + rect2.getX()) / 2, (rect1.getY() + rect2.getY()) / 2);
        this.majorAxis = Math.abs(rect1.getX() - rect2.getX());
        this.minorAxis = Math.abs(rect1.getY() - rect2.getY());
    }

    public Point getCenter() {
        return center;
    }

    public double getMajorAxis() {
        return majorAxis;
    }

    public double getMinorAxis() {
        return minorAxis;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public void setMajorAxis(double majorAxis) {
        this.majorAxis = majorAxis;
    }   

    public void setMinorAxis(double minorAxis) {
        this.minorAxis = minorAxis;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("Ellipse %s: center=%s, majorAxis=%.2f, minorAxis=%.2f", name, center, majorAxis, minorAxis);
    }
    @Override
    public boolean equals(Object other) {
        if (other == null || !(other instanceof Ellipse)) {
            return false;
        }
        if (this == other) {
            return true;
        }
        Ellipse otherEllipse = (Ellipse) other;
        return name.equals(otherEllipse.name) && center.equals(otherEllipse.center) && majorAxis == otherEllipse.majorAxis && minorAxis == otherEllipse.minorAxis;
    }

    @Override
    public int hashCode() {
        int multiplier = 31;
        return multiplier * (multiplier * (multiplier * name.hashCode() + center.hashCode()) + Double.hashCode(majorAxis)) + Double.hashCode(minorAxis);
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
