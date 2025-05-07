package com.ehu.design_patterns.validator;

public interface FigureValidator {
    boolean isValidFigure();
    boolean isValidParams(String[] params);
    String getErrorMessage(String[] params);
}
