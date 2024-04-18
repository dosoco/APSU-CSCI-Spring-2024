
package csci2011.jdotylab10;

/**
 *
 * @author jdoty
 */
import java.util.ArrayList;

// ArrayListNumberStack.java
public class ArrayListNumberStack implements NumberStack {
    private ArrayList<Double> stack;

    public ArrayListNumberStack() {
        this.stack = new ArrayList<>();
    }

    @Override
    public void push(double item) {
        stack.add(item);
    }

    @Override
    public double pop() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stack.remove(stack.size() - 1);
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    public int size() {
        return stack.size();
    }

    @Override
    public void clear() {
        stack.clear();
    }
    
    @Override
    public String toString() {
        return "Stack: " + stack.toString();
    }

}

