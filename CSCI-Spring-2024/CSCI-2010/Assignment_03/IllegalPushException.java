
package csci2010.dotyprogram3;

/**
 * CSCI 2010 Program 3
 * 
 * @author Jason Doty
 * 
 * Exception thrown when an illegal push operation is attempted (placing a larger disc on a smaller one).
 */
public class IllegalPushException extends Exception {
    // Constructor with a custom message.
    public IllegalPushException(String message) {
        super(message);
    }
}
