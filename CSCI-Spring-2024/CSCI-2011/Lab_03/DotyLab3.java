
package csci2011.dotylab3;

/**
 * CSCI 2011 LAB 3
 * 
 * @author Jason Doty
 * 
 * Main class for testing the Polygon, RegularPolygon, and RegularTriangle classes.
 */
public class DotyLab3 {

public static void main(String[] args) {
        // Test creating and displaying a Polygon object.
        System.out.println("Testing Polygon constructor");
        Polygon polygon = new Polygon(5);
        System.out.println(polygon);

        // Test creating and displaying a RegularPolygon object.
        System.out.println("Testing RegularPolygon constructor");
        RegularPolygon regularPolygon = new RegularPolygon(5, 1.0);
        System.out.println(regularPolygon);

        // Test modifying and displaying the side length of the RegularPolygon object.
        System.out.println("Testing side length mutator");
        regularPolygon.setSideLength(2.0);
        System.out.println(regularPolygon);

        // Test creating and displaying a RegularTriangle object.
        System.out.println("Testing RegularTriangle constructor");
        RegularTriangle regularTriangle = new RegularTriangle(4.0);
        System.out.println(regularTriangle);

        // Test modifying and displaying the height of the RegularTriangle object.
        System.out.println("Testing height mutator");
        regularTriangle.setHeight(3.0);
        System.out.println(regularTriangle);

        // Test modifying and displaying the side length of the RegularTriangle object again.
        System.out.println("Testing side length mutator");
        regularTriangle.setSideLength(4.0);
        System.out.println(regularTriangle);
    }
}
