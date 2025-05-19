package com.ehu.design_patterns.validator.impl;

import java.util.Arrays;

import com.ehu.design_patterns.validator.FigureValidator;

public class EllipseValidator implements FigureValidator{

    @Override
    public boolean isValidFigure() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isValidFigure'");
    }

    @Override
    public boolean isValidParams(String[] params) {
        if (params.length != 6) {
            return false;
        }
        try {
            Double.parseDouble(params[2]);
            Double.parseDouble(params[3]);
            double width = Double.parseDouble(params[4]);
            double height = Double.parseDouble(params[5]);
            if (width <= 0 || height <= 0) {
                return false;
            }
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    @Override
    public String getErrorMessage(String[] params) {
        if (params.length != 6) {
            return String.format("Ellipse must have 6 parameters: type, name, x, y, width, height (Actual: %s)", Arrays.toString(params));
        }
        try {
            double width = Double.parseDouble(params[4]);
            double height = Double.parseDouble(params[5]);
            if (width <= 0 || height <= 0) {
                return String.format("Ellipse width and height must be positive: %s", Arrays.toString(params));
            }
        } catch (NumberFormatException e) {
            return String.format("Invalid parameters: %s", Arrays.toString(params));
        }
        return "";
    }
}
