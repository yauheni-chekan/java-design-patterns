package com.ehu.design_patterns.action;

/**
 * Interface for geometric calculators. The interface is used to demonstrate the use of Strategy pattern.
 * @param <T> the type of figure to calculate the geometric property of
 */
public interface GeometricCalculator<T> {
    double calculate(T figure);
}
