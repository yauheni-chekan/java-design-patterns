package com.ehu;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.ehu.design_patterns.data_reader.CsvFileReader;
import com.ehu.design_patterns.data_reader.DataReader;
import com.ehu.design_patterns.exception.FigureCreationException;
import com.ehu.design_patterns.factory.FigureFactory;
import com.ehu.design_patterns.factory.impl.DefaultFigureFactory;
import com.ehu.design_patterns.figure.Figure;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {
    private static final Logger logger = LoggerFactory.getLogger(App.class);
    private static final String FILE_PATH = "data/figures.csv";

    public static void main(String[] args) {
        logger.info("Starting application");
        DataReader reader = new CsvFileReader();
        // Create the factory with the path to your input file
        FigureFactory factory = new DefaultFigureFactory();
        logger.info("Reading data from file: {}", FILE_PATH);
        List<String> lines = reader.readData(FILE_PATH);
        List<Figure> figures = new ArrayList<>();
        Optional<Figure> figure = java.util.Optional.empty();

        for (String line : lines) {
            try {
                String[] parts = line.split(",");
                figure = factory.create(parts);
                if (figure.isPresent()) {
                    figures.add(figure.get());
                }
            } catch (FigureCreationException e) {
                logger.warn("Error creating figure: {}", e.getMessage());
            }
            logger.info("Created figure: {}", figure);
        }

        // Process the figures
        for (Figure existingFigure : figures) {
            System.out.println(existingFigure);
        }
    }
}
