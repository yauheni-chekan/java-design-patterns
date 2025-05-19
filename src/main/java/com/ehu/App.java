package com.ehu;

import java.util.List;
import java.util.Optional;

import com.ehu.design_patterns.data_reader.CsvFileReader;
import com.ehu.design_patterns.data_reader.DataReader;
import com.ehu.design_patterns.exception.FigureCreationException;
import com.ehu.design_patterns.factory.FigureFactory;
import com.ehu.design_patterns.factory.impl.DefaultFigureFactory;
import com.ehu.design_patterns.figure.Figure;
import com.ehu.design_patterns.figure.impl.Ellipse;
import com.ehu.design_patterns.repository.FigureRepository;
import com.ehu.design_patterns.repository.impl.InMemoryFigureRepository;
import com.ehu.design_patterns.specification.Specification;
import com.ehu.design_patterns.specification.impl.NameSortSpecification;
import com.ehu.design_patterns.specification.impl.TypeSpecification;

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
        FigureRepository repository = new InMemoryFigureRepository();
        logger.info("Reading data from file: {}", FILE_PATH);
        List<String> lines = reader.readData(FILE_PATH);
        Optional<Figure> figure = java.util.Optional.empty();

        for (String line : lines) {
            try {
                String[] parts = line.split(",");
                figure = factory.create(parts);
                if (figure.isPresent()) {
                    repository.save(figure.get());
                    logger.info("Created figure: {}", figure.get());
                }
            } catch (FigureCreationException e) {
                logger.warn("Error creating figure: {}", e.getMessage());
            }
        }

        // Retrieve all figures
        for (Figure existingFigure : repository.findAll()) {
            logger.info(existingFigure.toString());
        }
        // Sort the ellipses by name
        Specification<Figure> ellipseSpec = new TypeSpecification(Ellipse.class);
        List<Figure> ellipses = repository.find(ellipseSpec, new NameSortSpecification());
        logger.info("Ellipses sorted by name:");
        for (Figure ellipse : ellipses) {
            logger.info(ellipse.toString());
        }
    }
}
