package com.ehu.design_patterns.validator.impl;

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
            return "Point must have 4 parameters: type, name, x, y";
        }
        try {
            Double.parseDouble(params[2]);
            Double.parseDouble(params[3]);
        } catch (NumberFormatException e) {
            return "Point coordinates must be valid numbers";
        }
        return "";
    }
}
