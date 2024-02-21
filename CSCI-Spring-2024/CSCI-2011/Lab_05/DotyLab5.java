
package csci2011.dotylab5;

/**
 *CSCI 2011 LAB 5
 * 
 * @author Jason Doty
 * 
 * This is the main class file for lab 5. It tests the NumberStack class.
 */
public class DotyLab5 {

public static void main(String[] args) {
        // Create a new NumberStack object with a capacity of 5
        NumberStack stack = new NumberStack(5);

        // Test the push method to add elements to the stack
        try {
            stack.push(1.0); // Push the first element
            stack.push(2.0); // Push the second element
            stack.push(3.0); // Push the third element
            stack.push(4.0); // Push the fourth element
            stack.push(5.0); // Push the fifth element, stack should be full now
            stack.push(6.0); // Attempting to push another element should throw FullStackException
        } catch (FullStackException fse) {
            // Catch and print the message from FullStackException
            System.out.println(fse.getMessage());
        }

        // Test the pop method to remove elements from the stack
        try {
            while (!stack.isEmpty()) {
                // Remove and print each element until the stack is empty
                System.out.println(stack.pop());
            }
            // Attempting to pop from an empty stack should throw EmptyStackException
            System.out.println(stack.pop());
        } catch (EmptyStackException ese) {
            // Catch and print the message from EmptyStackException
            System.out.println(ese.getMessage());
        }
    }
}
