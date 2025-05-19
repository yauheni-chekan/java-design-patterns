package com.ehu.design_patterns.specification;

import java.util.Comparator;

/**
 * Interface for sorting specifications.
 * Defines the contract for sorting objects of type T.
 * @param <T> the type of object to sort
 */
public interface SortSpecification<T> {
    /**
     * Gets the comparator for sorting objects of type T.
     * @return the comparator to use for sorting
     */
    Comparator<T> getComparator();

    /**
     * Combines two sort specifications using the AND operator.
     * The second sort specification will be applied after the first one.
     * @param other the other sort specification to combine with
     * @return a new sort specification that applies both sorting criteria
     */
    default SortSpecification<T> and(SortSpecification<T> other) {
        return () -> this.getComparator().thenComparing(other.getComparator());
    }
}