package com.ehu.figures;

public class Ellipse {

    private final String NAME;
    private Point center;
    private double width;
    private double height;

    public Ellipse(String name, Point center, double width, double height) {
        this.NAME = name;
        this.center = center;
        this.majorAxis = width;
        this.minorAxis = height;
    }

    public Ellipse(String name, Point rect1, Point rect2) {
        this.NAME = name;
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
        return NAME;
    }

    @Override
    public String toString() {
        return String.format("Ellipse %s: center=%s, majorAxis=%.2f, minorAxis=%.2f", NAME, center, majorAxis, minorAxis);
    }

    @Override
    public boolean equals(Ellipse other) {
        return NAME.equals(other.NAME) && center.equals(other.center) && majorAxis == other.majorAxis && minorAxis == other.minorAxis;
    }

    @Override
    public int hashCode() {
        int multiplier = 31;
        return multiplier * (multiplier * (multiplier * NAME.hashCode() + center.hashCode()) + Double.hashCode(majorAxis)) + Double.hashCode(minorAxis);
    }
}
