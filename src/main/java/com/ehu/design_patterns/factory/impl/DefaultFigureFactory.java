package com.ehu.design_patterns.factory.impl;

import java.util.Arrays;
import java.util.Optional;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ehu.design_patterns.exception.InvalidFigureParametersException;
import com.ehu.design_patterns.exception.InvalidFigureTypeException;
import com.ehu.design_patterns.figure.Figure;
import com.ehu.design_patterns.figure.impl.Ellipse;
import com.ehu.design_patterns.figure.impl.Point;
import com.ehu.design_patterns.factory.FigureFactory;
import com.ehu.design_patterns.validator.FigureValidatorFactory;
import com.ehu.design_patterns.validator.impl.DefaultFigureValidatorFactory;

/**
 * Default implementation of the FigureFactory interface.
 * Provides concrete implementations for creating and validating geometric figures.
 */
public class DefaultFigureFactory implements FigureFactory {
    private static final Logger logger = LoggerFactory.getLogger(DefaultFigureFactory.class);
    private final FigureValidatorFactory validatorFactory;

    public DefaultFigureFactory() {
        this.validatorFactory = new DefaultFigureValidatorFactory();
    }

    public DefaultFigureFactory(FigureValidatorFactory validatorFactory) {
        this.validatorFactory = validatorFactory;
    }

    @Override
    public Optional<Figure> create(String[] params) {
        if (params == null || params.length == 0) {
            throw new InvalidFigureParametersException("unknown", "Parameters array cannot be null or empty");
        }

        if (params[1].isEmpty()) {
            params[1] = UUID.randomUUID().toString().substring(0, 8);
        }

        String figureType = params[0].toUpperCase();
        if (!Arrays.asList(validatorFactory.getSupportedFigureTypes()).contains(figureType)) {
            throw new InvalidFigureTypeException(figureType);
        }

        var validator = validatorFactory.getValidator(figureType);
        if (!validator.isValidParams(params)) {
            String errorMessage = validator.getErrorMessage(params);
            throw new InvalidFigureParametersException(figureType, errorMessage);
        }

        return switch (figureType) {
            case "POINT" -> {
                yield Optional.of(createPoint(
                    params[1],
                    Double.parseDouble(params[2]),
                    Double.parseDouble(params[3])
                ));
            }
            case "ELLIPSE" -> {
                yield Optional.of(createEllipse(
                    params[1],
                    createPoint("default", Double.parseDouble(params[2]), Double.parseDouble(params[3])),
                    Double.parseDouble(params[4]),
                    Double.parseDouble(params[5])
                ));
            }
            default -> {
                logger.error("Unsupported figure type: {}. Skipping figure creation.", Arrays.toString(params));
                yield Optional.empty();
            }
        };
    }

    @Override
    public Point createPoint(String name, double x, double y) {
        logger.debug("Creating point: {} with x: {} and y: {}", name, x, y);
        return new Point(name, x, y);
    }

    @Override
    public Ellipse createEllipse(String name, Point center, double width, double height) {
        logger.debug("Creating ellipse: {} with center: {} and width: {} and height: {}", name, center, width, height);
        return new Ellipse(name, center, width, height);
    }

    @Override
    public Ellipse createEllipse(String name, Point point1, Point point2) {
        logger.debug("Creating ellipse: {} with point1: {} and point2: {}", name, point1, point2);
        return new Ellipse(name, point1, point2);
    }

    @Override
    public boolean validateParameters(String[] params) {
        if (params == null || params.length == 0) {
            return false;
        }
        String figureType = params[0].toUpperCase();
        if (!Arrays.asList(validatorFactory.getSupportedFigureTypes()).contains(figureType)) {
            return false;
        }
        return validatorFactory.getValidator(figureType).isValidParams(params);
    }

    @Override
    public String[] getSupportedFigureTypes() {
        return validatorFactory.getSupportedFigureTypes();
    }
} 