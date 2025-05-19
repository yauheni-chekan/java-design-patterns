package com.ehu.design_patterns.validator.impl;

import java.util.Arrays;

import com.ehu.design_patterns.validator.FigureValidator;

public class PointValidator implements FigureValidator{

    @Override
    public boolean isValidFigure() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isValidFigure'");
    }

    @Override
    public boolean isValidParams(String[] params) {
        if (params.length != 4) {
            return false;
        }
        try {
            Double.parseDouble(params[2]);
            Double.parseDouble(params[3]);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    @Override
    public String getErrorMessage(String[] params) {
        if (params.length != 4) {
            return String.format("Point must have 4 parameters: type, name, x, y (Actual: %s)", Arrays.toString(params));
        }
        try {
            Double.parseDouble(params[2]);
            Double.parseDouble(params[3]);
        } catch (NumberFormatException e) {
            return String.format("Point coordinates must be valid numbers: %s", Arrays.toString(params));
        }
        return "";
    }
}
