package com.ehu.design_patterns.data_reader;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import com.ehu.design_patterns.exception.FileReadingException;
import com.ehu.design_patterns.exception.InvalidDataFormatException;

class CsvFileReaderTest {

    private CsvFileReader reader;
    
    @TempDir
    Path tempDir;

    @BeforeEach
    void setUp() {
        reader = new CsvFileReader();
    }

    @Test
    void readData_ValidFile_ReturnsLines() throws IOException {
        // Arrange
        Path testFile = tempDir.resolve("test.csv");
        List<String> expectedLines = List.of(
            "POINT,point1,1.0,2.0",
            "ELLIPSE,ellipse1,3.0,4.0,5.0,6.0"
        );
        Files.write(testFile, expectedLines);

        // Act
        List<String> actualLines = reader.readData(testFile.toString());

        // Assert
        assertEquals(expectedLines, actualLines);
    }

    @Test
    void readData_EmptyFile_ThrowsInvalidDataFormatException() throws IOException {
        // Arrange
        Path testFile = tempDir.resolve("empty.csv");
        Files.createFile(testFile);

        // Act & Assert
        assertThrows(InvalidDataFormatException.class, () -> reader.readData(testFile.toString()));
    }

    @Test
    void readData_NonExistentFile_ThrowsFileReadingException() {
        // Arrange
        String nonExistentFile = tempDir.resolve("nonexistent.csv").toString();

        // Act & Assert
        FileReadingException exception = assertThrows(FileReadingException.class, 
            () -> reader.readData(nonExistentFile));
        assertTrue(exception.getMessage().contains("File not found"));
    }
} 