
package csci2011.jdotylab10;

/**
 *
 * @author jdoty
 */
public class UnsupportedOperationException extends Exception {
    public UnsupportedOperationException(String operation) {
        super("Unsupported operation: " + operation);
    }
}
