
package csci2011.dotylab4;

/**
 * CSCI 2011 LAB 4
 * 
 * @author Jason Doty
 * 
 * Abstract base class Number to define arithmetic operations.
 */
public abstract class Number {

    /**
     * Adds the current number with another number.
     * @param other Another Number object to add to this Number.
     * @return A new Number object representing the sum.
     */
    public abstract Number add(Number other);

    /**
     * Negates the current number.
     * @return A new Number object representing the negation of this Number.
     */
    public abstract Number negate();

    /**
     * Subtracts another number from the current number.
     * Utilizes the negate method to perform subtraction by addition.
     * @param other Another Number object to subtract from this Number.
     * @return A new Number object representing the difference.
     */
    public Number subtract(Number other) {
        // Subtracting other is equivalent to adding the negation of other
        return add(other.negate());
    }

    /**
     * Multiplies the current number with another number.
     * @param other Another Number object to multiply with this Number.
     * @return A new Number object representing the product.
     */
    public abstract Number multiply(Number other);
}
