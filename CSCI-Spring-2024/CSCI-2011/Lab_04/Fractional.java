
package csci2011.dotylab4;

/**
 * CSCI 2011 LAB 4
 * 
 * @author Jason Doty
 * 
 * Abstract class Fractional to represent fractional numbers.
 */
public abstract class Fractional extends Number {

    /**
     * Returns the reciprocal of the fractional number.
     * @return A new Fractional object that is the reciprocal of this number.
     */
    public abstract Fractional reciprocal();

    /**
     * Divides this fractional number by another fractional number.
     * Utilizes the reciprocal and multiply methods to perform the division.
     * @param other A Fractional object to divide this number by.
     * @return A new Fractional object representing the quotient.
     */
    public Fractional divide(Fractional other) {
        // Division is implemented as multiplication by the reciprocal of the other number
        return (Fractional) multiply(other.reciprocal());
    }
}
