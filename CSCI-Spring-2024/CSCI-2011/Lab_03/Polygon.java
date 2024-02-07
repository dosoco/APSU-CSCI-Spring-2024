
package csci2011.dotylab3;

/**
 * CSCI 2011 LAB 3
 * 
 * @author Jason Doty
 * 
 * Defines a Polygon class representing a generic polygon with a certain number of sides.
 */
public class Polygon {
// Private instance variable to hold the number of sides of the polygon.
    private int numSides;

    // Constructor that takes the number of sides as an argument.
    // If the number of sides is less than 3, it prints an error message and exits.
    public Polygon(int numSides) {
        if (numSides < 3) {
            System.out.println("Error: A polygon must have at least 3 sides.");
            System.exit(1);
        }
        this.numSides = numSides;
    }

    // Accessor method for the number of sides.
    public int getNumSides() {
        return numSides;
    }

    // Overrides the toString method of the Object class to return a string representation of the Polygon.
    @Override
    public String toString() {
        return "Number of sides: " + numSides;
    }
}
