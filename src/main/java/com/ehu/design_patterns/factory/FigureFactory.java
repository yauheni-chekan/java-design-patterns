package com.ehu.design_patterns.factory;

import java.util.Optional;

import com.ehu.design_patterns.figure.Figure;
import com.ehu.design_patterns.figure.impl.Ellipse;
import com.ehu.design_patterns.figure.impl.Point;

/**
 * Factory interface for creating and managing geometric figures.
 * Provides methods for creating different types of figures and managing their lifecycle.
 */
public interface FigureFactory {
    /**
     * Creates a new figure based on the provided parameters.
     * @param params the parameters needed to create the figure
     * @return the created figure
     * @throws IllegalArgumentException if the figure type is not supported or parameters are invalid
     */
    Optional<Figure> create(String[] params);

    /**
     * Creates a point with the specified parameters.
     * @param name the name of the point
     * @param x the x-coordinate
     * @param y the y-coordinate
     * @return the created point
     */
    Point createPoint(String name, double x, double y);

    /**
     * Creates an ellipse with center point and dimensions.
     * @param name the name of the ellipse
     * @param center the center point
     * @param width the width (major axis)
     * @param height the height (minor axis)
     * @return the created ellipse
     */
    Ellipse createEllipse(String name, Point center, double width, double height);

    /**
     * Creates an ellipse defined by two points.
     * @param name the name of the ellipse
     * @param point1 the first point
     * @param point2 the second point
     * @return the created ellipse
     */
    Ellipse createEllipse(String name, Point point1, Point point2);

    /**
     * Validates if the given parameters are valid for creating a figure of the specified type.
     * @param params the parameters to validate
     * @return true if the parameters are valid, false otherwise
     */
    boolean validateParameters(String[] params);

    /**
     * Gets the list of supported figure types.
     * @return array of supported figure type names
     */
    String[] getSupportedFigureTypes();
}