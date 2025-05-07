package com.ehu.design_patterns.validator;

/**
 * Factory interface for creating figure validators.
 */
public interface FigureValidatorFactory {
    /**
     * Gets a validator for the specified figure type.
     * @param figureType the type of figure to validate
     * @return the appropriate validator for the figure type
     * @throws IllegalArgumentException if the figure type is not supported
     */
    FigureValidator getValidator(String figureType);

    /**
     * Gets the list of supported figure types.
     * @return array of supported figure type names
     */
    String[] getSupportedFigureTypes();
} 