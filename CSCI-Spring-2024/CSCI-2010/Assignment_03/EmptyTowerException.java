
package csci2010.dotyprogram3;

/**
 * CSCI 2010 Program 3
 * 
 * @author Jason Doty
 * 
 * Exception thrown when a pop operation is attempted on an empty tower.
 */
public class EmptyTowerException extends Exception {
    // Constructor with a custom message.
    public EmptyTowerException(String message) {
        super(message);
    }
}
