
package csci2011.dotylab4;

/**
 * CSCI 2011 LAB 4
 * 
 * @author Jason Doty
 * 
 * The Rational class represents a rational number as a fraction.
 */
public class Rational extends Fractional implements Comparable<Rational>, Convertible {
    private int numerator;   // The numerator part of the fraction
    private int denominator; // The denominator part of the fraction

    /**
     * Constructor for creating a Rational number.
     * 
     * @param numerator The numerator of the fraction.
     * @param denominator The denominator of the fraction; must not be zero.
     */
    public Rational(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero.");
        }
        if (denominator < 0) {
            // Normalize the rational number to have a positive denominator
            numerator = -numerator;
            denominator = -denominator;
        }
        this.numerator = numerator;
        this.denominator = denominator;
    }

    // Implement abstract methods from Number and Fractional
    @Override
    public Number add(Number other) {
        Rational otherRational = (Rational) other;
        int newNumerator = this.numerator * otherRational.denominator + this.denominator * otherRational.numerator;
        int newDenominator = this.denominator * otherRational.denominator;
        return new Rational(newNumerator, newDenominator);
    }

    @Override
    public Number negate() {
        return new Rational(-this.numerator, this.denominator);
    }

    @Override
    public Number multiply(Number other) {
        Rational otherRational = (Rational) other;
        int newNumerator = this.numerator * otherRational.numerator;
        int newDenominator = this.denominator * otherRational.denominator;
        return new Rational(newNumerator, newDenominator);
    }

    @Override
    public Fractional reciprocal() {
        if (this.numerator == 0) {
            throw new ArithmeticException("Cannot take reciprocal of zero.");
        }
        return new Rational(this.denominator, this.numerator);
    }

    // Implement methods from the Comparable interface
    @Override
    public int compareTo(Rational other) {
        int lhs = this.numerator * other.denominator;
        int rhs = this.denominator * other.numerator;
        return Integer.compare(lhs, rhs);
    }

    // Implement methods from the Convertible interface
    @Override
    public int intValue() {
        return this.numerator / this.denominator; // Integer division for int representation
    }

    @Override
    public double doubleValue() {
        return (double) this.numerator / this.denominator; // Floating-point division for double representation
    }

    // Additional helper method to display the rational number as a string
    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }
}
