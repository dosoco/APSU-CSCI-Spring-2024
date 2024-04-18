
package csci2011.jdotylab10;

/**
 *
 * @author jdoty
 */
// NumberStack.java
public interface NumberStack {
    void push(double item);
    double pop() throws EmptyStackException;
    boolean isEmpty();
    int size();
    void clear();
}

