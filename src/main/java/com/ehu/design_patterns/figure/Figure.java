package com.ehu.design_patterns.figure;

/**
 * Common interface for all geometric figures.
 * Defines the basic contract that all figures must implement.
 */
public interface Figure {
    /**
     * Gets the id of the figure.
     * @return the id of the figure
     */
    Long getId();

    /**
     * Sets the id of the figure.
     * @param id the id of the figure
     */
    void setId(Long id);

    /**
     * Gets the name of the figure.
     * @return the name of the figure
     */
    String getName();

    /**
     * Returns a string representation of the figure.
     * @return string representation of the figure
     */
    @Override
    String toString();

    /**
     * Checks if this figure is equal to another object.
     * @param other the object to compare with
     * @return true if the figures are equal, false otherwise
     */
    @Override
    boolean equals(Object other);

    /**
     * Returns the hash code of the figure.
     * @return the hash code
     */
    @Override
    int hashCode();
} 