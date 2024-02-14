
package csci2011.dotylab4;

/**
 * CSCI 2011 LAB 4
 * 
 * @author Jason Doty
 * 
 * Main class for the project, containing tests for Rational class operations.
 */
public class DotyLab4 {

    public static void main(String[] args) {
        // Test the Rational class by creating instances and calling methods
        // Replace 'yourlastname' with your actual last name
        
        // Create some Rational objects for testing
        Rational r1 = new Rational(1, 2); // Represents 1/2
        Rational r2 = new Rational(3, 4); // Represents 3/4

        // Test addition
        Rational sum = (Rational) r1.add(r2);
        System.out.println("Addition Test: " + r1 + " + " + r2 + " = " + sum);

        // Test negation
        Rational negation = (Rational) r1.negate();
        System.out.println("Negation Test: -(" + r1 + ") = " + negation);

        // Test subtraction
        Rational difference = (Rational) r1.subtract(r2);
        System.out.println("Subtraction Test: " + r1 + " - " + r2 + " = " + difference);

        // Test multiplication
        Rational product = (Rational) r1.multiply(r2);
        System.out.println("Multiplication Test: " + r1 + " * " + r2 + " = " + product);

        // Test division
        Rational quotient = (Rational) r1.divide(r2);
        System.out.println("Division Test: " + r1 + " / " + r2 + " = " + quotient);

        // Test reciprocal
        Rational reciprocal = (Rational) r1.reciprocal();
        System.out.println("Reciprocal Test: 1/(" + r1 + ") = " + reciprocal);

        // Test compareTo
        int comparisonResult = r1.compareTo(r2);
        String comparisonMessage = comparisonResult < 0 ? "less than" : (comparisonResult > 0 ? "greater than" : "equal to");
        System.out.println("Comparison Test: " + r1 + " is " + comparisonMessage + " " + r2);

        // Test Convertible methods
        int intValue = r1.intValue();
        double doubleValue = r1.doubleValue();
        System.out.println("Convertible Test (int): " + r1 + " = " + intValue);
        System.out.println("Convertible Test (double): " + r1 + " = " + doubleValue);
    }
}
