package com.ehu.design_patterns.factory;

import com.ehu.design_patterns.figure.Ellipse;
import com.ehu.design_patterns.figure.Point;

public interface FigureFactory {
    Point createPoint(String name, double x, double y);
    Ellipse createEllipse(String name, Point center, double width, double height);
    Ellipse createEllipse(String name, Point point1, Point point2);
} 