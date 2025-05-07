package com.ehu.design_patterns.data_reader;

import java.util.List;

import com.ehu.design_patterns.exception.DataReadingException;

/**
 * Interface for reading data from various sources.
 */
public interface DataReader {
    /**
     * Reads data from the specified source.
     * @param source the source to read data from
     * @return a list of strings containing the read data
     * @throws DataReadingException if there is an error reading the data
     */
    List<String> readData(String source) throws DataReadingException;
}
