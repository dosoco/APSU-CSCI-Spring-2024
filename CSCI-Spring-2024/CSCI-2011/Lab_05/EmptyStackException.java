
package csci2011.dotylab5;

/**
 * CSCI 2011 LAB 5
 * 
 * @author Jason Doty
 * 
 * This file defines an exception for handling empty stack scenarios.
 */
// Class that represents an exception thrown when trying to pop from an empty stack
public class EmptyStackException extends Exception {
    // Default constructor with a default error message
    public EmptyStackException() {
        super("Stack is empty.");
    }

    // Constructor with a parameter to set a custom error message
    public EmptyStackException(String msg) {
        super(msg);
    }
}
