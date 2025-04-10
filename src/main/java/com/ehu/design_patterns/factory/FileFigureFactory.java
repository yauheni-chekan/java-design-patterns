package com.ehu.design_patterns.factory;

import com.ehu.design_patterns.figure.Ellipse;
import com.ehu.design_patterns.figure.Point;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class FileFigureFactory implements FigureFactory {
    private static final Logger logger = LoggerFactory.getLogger(FileFigureFactory.class.getName());
    private final String filePath;

    public FileFigureFactory(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public Point createPoint(String name, double x, double y) {
        return new Point(name, x, y);
    }

    @Override
    public Ellipse createEllipse(String name, Point center, double width, double height) {
        return new Ellipse(name, center, width, height);
    }

    @Override
    public Ellipse createEllipse(String name, Point point1, Point point2) {
        return new Ellipse(name, point1, point2);
    }

    private String generateName(String type) {
        return String.format("%s", UUID.randomUUID().toString().substring(0, 8));
    }

    public List<Object> createFiguresFromFile() {
        List<Object> figures = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length < 2) {
                    logger.warn("Invalid line format: {}", line);
                    continue;
                }

                String type = parts[0].trim();
                String name = parts[1].trim().isEmpty() ? generateName(type) : parts[1].trim();

                switch (type.toUpperCase()) {
                    case "POINT":
                        if (parts.length == 4) {
                            double x = Double.parseDouble(parts[2].trim());
                            double y = Double.parseDouble(parts[3].trim());
                            figures.add(createPoint(name, x, y));
                        }
                        break;
                    case "ELLIPSE":
                        if (parts.length == 6) {
                            // Format: ELLIPSE,name,centerX,centerY,width,height
                            Point center = new Point("Center", 
                                Double.parseDouble(parts[2].trim()),
                                Double.parseDouble(parts[3].trim()));
                            double width = Double.parseDouble(parts[4].trim());
                            double height = Double.parseDouble(parts[5].trim());
                            figures.add(createEllipse(name, center, width, height));
                        }
                        break;
                    default:
                        logger.warn("Unknown figure type: {}", type);
                }
            }
        } catch (IOException e) {
            logger.error("Error reading file: {}", e.getMessage());
        } catch (NumberFormatException e) {
            logger.error("Error parsing number: {}", e.getMessage());
        }
        return figures;
    }
} 