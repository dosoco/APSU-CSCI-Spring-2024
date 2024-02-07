
package csci2011.dotylab3;

/**
 * CSCI 2011 LAB 3
 * 
 * @author Jason Doty
 * 
 * Extends the RegularPolygon class to specifically represent a regular triangle.
 */
public class RegularTriangle extends RegularPolygon {
    // Private instance variable for the height of the triangle.
    private double height;

    // Constructor that takes the side length as an argument.
    // Initializes the number of sides to 3 and sets the side length using the superclass constructor.
    // The height is calculated based on the side length.
    public RegularTriangle(double sideLength) {
        super(3, sideLength); // Call the superclass constructor with 3 sides.
        this.height = Math.sqrt(3) * sideLength / 2; // Calculate the height of the triangle.
    }

    // Accessor method for the height.
    public double getHeight() {
        return height;
    }

    // Mutator method for the height.
    // If the provided height is less than or equal to zero, it prints an error message and exits.
    // It also recalculates and sets the side length based on the new height.
    public void setHeight(double height) {
        if (height <= 0) {
            System.out.println("Error: Height must be greater than zero.");
            System.exit(1);
        }
        this.height = height;
        setSideLength(2 * height / Math.sqrt(3)); // Recalculate and set the side length.
    }

    // Method to calculate and return the area of the triangle.
    public double getArea() {
        return 0.5 * getSideLength() * height;
    }

    // Overrides the toString method to add information about the height and area of the triangle.
    @Override
    public String toString() {
        return super.toString() + "\nHeight: " + height + "\nArea: " + getArea();
    }
}
