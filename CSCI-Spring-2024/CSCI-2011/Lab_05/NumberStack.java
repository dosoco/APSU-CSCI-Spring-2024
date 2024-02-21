
package csci2011.dotylab5;

/**
 * CSCI 2011 LAB 5
 * 
 * @author Jason Doty
 * 
 * This class defines a simple stack data structure for numbers.
 */
public class NumberStack {
    private final double[] stackArray; // Array to store stack elements
    private int size; // The number of elements currently in the stack

    // Constructor to initialize the stack with a given capacity
    public NumberStack(int capacity) {
        stackArray = new double[capacity];
        size = 0; // Initially, the stack is empty
    }

    // toString method to display the stack contents
    @Override
    public String toString() {
        if (isEmpty()) {
            // If stack is empty, return "empty stack"
            return "empty stack";
        } else {
            // If stack is not empty, return all elements as a string
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < size; i++) {
                sb.append(stackArray[i]).append(" ");
            }
            return sb.toString().trim();
        }
    }

    // Method to check if the stack is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Method to check if the stack is full
    public boolean isFull() {
        return size == stackArray.length;
    }

    // Method to push a new number onto the stack
    public void push(double number) throws FullStackException {
        if (isFull()) {
            // If stack is full, throw FullStackException
            throw new FullStackException("Cannot add an item to a full stack.");
        }
        // If stack is not full, add element and increment size
        stackArray[size++] = number;
    }

    // Method to pop the top number from the stack
    public double pop() throws EmptyStackException {
        if (isEmpty()) {
            // If stack is empty, throw EmptyStackException
            throw new EmptyStackException("Cannot remove an item from an empty stack.");
        }
        // If stack is not empty, remove and return top element, decrement size
        return stackArray[--size];
    }
}
