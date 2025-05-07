package com.ehu.design_patterns.validator.impl;

import com.ehu.design_patterns.validator.FigureValidator;
import com.ehu.design_patterns.validator.FigureValidatorFactory;

/**
 * Default implementation of the FigureValidatorFactory interface.
 */
public class DefaultFigureValidatorFactory implements FigureValidatorFactory {
    private static final String[] SUPPORTED_TYPES = {"POINT", "ELLIPSE"};

    @Override
    public FigureValidator getValidator(String figureType) {
        return switch (figureType.toUpperCase()) {
            case "POINT" -> new PointValidator();
            case "ELLIPSE" -> new EllipseValidator();
            default -> throw new IllegalArgumentException("Unsupported figure type: " + figureType);
        };
    }

    @Override
    public String[] getSupportedFigureTypes() {
        return SUPPORTED_TYPES.clone();
    }
}