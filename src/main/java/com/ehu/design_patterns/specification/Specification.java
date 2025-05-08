package com.ehu.design_patterns.specification;

public interface Specification<T> {
    /**
     * Checks if the given object satisfies the specification.
     * @param t the object to check
     * @return true if the object satisfies the specification, false otherwise
     */
    boolean isSatisfiedBy(T t);

    /**
     * Combines two specifications using the AND operator.
     * @param other the other specification to combine with
     * @return a new specification that is the result of the AND operation
     */
    default Specification<T> and(Specification<T> other) {
        return t -> this.isSatisfiedBy(t) && other.isSatisfiedBy(t);
    }

    /**
     * Combines two specifications using the OR operator.
     * @param other the other specification to combine with
     * @return a new specification that is the result of the OR operation
     */
    default Specification<T> or(Specification<T> other) {
        return t -> this.isSatisfiedBy(t) || other.isSatisfiedBy(t);
    }

    /**
     * Returns a new specification that is the negation of the current specification.
     * @return a new specification that is the result of the NOT operation
     */
    default Specification<T> not() {
        return t -> !this.isSatisfiedBy(t);
    }
}
