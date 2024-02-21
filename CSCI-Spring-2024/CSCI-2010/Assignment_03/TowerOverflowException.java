
package csci2010.dotyprogram3;

/**
 * CSCI 2010 Program 3
 * 
 * @author Jason Doty
 * 
 * Exception thrown when a push operation is attempted on a full tower.
 */
public class TowerOverflowException extends Exception {
    // Constructor with a custom message.
    public TowerOverflowException(String message) {
        super(message);
    }
}
