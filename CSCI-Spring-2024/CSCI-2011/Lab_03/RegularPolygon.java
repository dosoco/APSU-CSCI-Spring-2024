
package csci2011.dotylab3;

/**
 * CSCI 2011 LAB 3
 * 
 * @author Jason Doty
 * 
 * Extends the Polygon class to represent a regular polygon, where all sides have the same length.
 */
public class RegularPolygon extends Polygon {
    // Private instance variable to hold the length of each side.
    private double sideLength;

    // Constructor that takes the number of sides and the length of each side as arguments.
    // It uses the superclass constructor to initialize the number of sides and a mutator to set the side length.
    public RegularPolygon(int numSides, double sideLength) {
        super(numSides); // Call the superclass constructor to set the number of sides.
        setSideLength(sideLength); // Set the side length using the mutator method.
    }

    // Accessor method for the side length.
    public double getSideLength() {
        return sideLength;
    }

    // Mutator method for the side length.
    // If the length is less than or equal to zero, it prints an error message and exits.
    public final void setSideLength(double sideLength) {
        if (sideLength <= 0) {
            System.out.println("Error: Side length must be greater than zero.");
            System.exit(1);
        }
        this.sideLength = sideLength;
    }

    // Method to calculate and return the perimeter of the regular polygon.
    public double getPerimeter() {
        return getNumSides() * sideLength;
    }

    // Overrides the toString method to include information about the side length and perimeter, in addition to the number of sides.
    @Override
    public String toString() {
        return super.toString() + "\nSide length: " + sideLength + "\nPerimeter: " + getPerimeter();
    }
}
