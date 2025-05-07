package com.ehu.design_patterns.validator.impl;

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
            double x = Double.parseDouble(params[2]);
            double y = Double.parseDouble(params[3]);
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
            return "Ellipse must have 6 parameters: type, name, x, y, width, height";
        }
        try {
            double width = Double.parseDouble(params[4]);
            double height = Double.parseDouble(params[5]);
            if (width <= 0 || height <= 0) {
                return "Ellipse width and height must be positive";
            }
        } catch (NumberFormatException e) {
            return "Invalid parameters";
        }
        return "";
    }
}
