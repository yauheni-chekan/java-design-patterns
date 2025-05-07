package com.ehu.design_patterns.data_reader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ehu.design_patterns.exception.FileReadingException;
import com.ehu.design_patterns.exception.InvalidDataFormatException;

/**
 * Implementation of DataReader that reads data from CSV files.
 */
public class CsvFileReader implements DataReader {
    private static final Logger logger = LoggerFactory.getLogger(CsvFileReader.class);

    @Override
    public List<String> readData(String filePath) throws FileReadingException {
        List<String> lines = new ArrayList<>();
        Path path = Paths.get(filePath);
        
        try {
            if (Files.exists(path)) {
                logger.info("Reading data from file: {}", filePath);
                lines = Files.readAllLines(path);
                if (lines.isEmpty()) {
                    logger.error("File is empty: {}", filePath);
                    throw new InvalidDataFormatException(filePath, "File is empty");
                }
            } else {
                logger.error("File not found: {}", filePath);
                throw new FileReadingException(filePath, "File not found");
            }
        } catch (FileNotFoundException e) {
            logger.error("File not found: {}", filePath);
            throw new FileReadingException(filePath, "File not found", e);
        } catch (IOException e) {
            logger.error("Error reading file: {}", e.getMessage());
            throw new FileReadingException(filePath, e.getMessage(), e);
        }
        return lines;
    }
}
