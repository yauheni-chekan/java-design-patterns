package com.ehu;

import java.util.List;

import com.ehu.design_patterns.factory.FigureFactory;
import com.ehu.design_patterns.factory.FileFigureFactory;
import com.ehu.design_patterns.figure.Ellipse;
import com.ehu.design_patterns.figure.Point;


public class App 
{
    public static void main( String[] args )
    {
        // Create the factory with the path to your input file
        FigureFactory factory = new FileFigureFactory("src/main/resources/figures.txt");

        // Create figures from the file
        List<Object> figures = ((FileFigureFactory) factory).createFiguresFromFile();

        // Process the figures
        for (Object figure : figures) {
            if (figure instanceof Point) {
                Point point = (Point) figure;
                System.out.println(point);
            } else if (figure instanceof Ellipse) {
                Ellipse ellipse = (Ellipse) figure;
                System.out.println(ellipse);
            }
        }
    }
}
