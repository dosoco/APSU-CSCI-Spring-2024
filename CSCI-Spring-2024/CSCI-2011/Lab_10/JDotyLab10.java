/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package csci2011.jdotylab10;


import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author jdoty
 */
public class JDotyLab10 {

public static void doOperation(NumberStack stack, String operation) throws EmptyStackException, UnsupportedOperationException {
    if (stack.size() < 2) { // Ensure there are at least two numbers to perform the operation
        throw new UnsupportedOperationException("Too few operands");
    }
    double rightOperand = stack.pop();
    double leftOperand = stack.pop();
    switch (operation) {
        case "+":
            stack.push(leftOperand + rightOperand);
            break;
        case "-":
            stack.push(leftOperand - rightOperand);
            break;
        case "*":
            stack.push(leftOperand * rightOperand);
            break;
        case "/":
            if (rightOperand == 0) throw new UnsupportedOperationException("Division by zero");
            stack.push(leftOperand / rightOperand);
            break;
        default:
            stack.push(leftOperand); // Push back in the original order they were in
            stack.push(rightOperand);
            throw new UnsupportedOperationException("Unknown operation: " + operation);
    }
    System.out.println("Stack after operation '" + operation + "': " + stack); // Debugging line
}


public static void evaluateRPN(NumberStack stack, String expression) {
    System.out.println("input: " + expression);
    Scanner scanner = new Scanner(expression);
    try {
        while (scanner.hasNext()) {
            if (scanner.hasNextDouble()) {
                stack.push(scanner.nextDouble());
            } else {
                String operation = scanner.next();
                doOperation(stack, operation);
            }
        }
        if (stack.size() != 1) { // There should be exactly one result on the stack.
            throw new UnsupportedOperationException("Too many operands");
        }
        double result = stack.pop();
        System.out.println("result: " + result);
    } catch (EmptyStackException ese) {
        System.out.println("Too few operands");
    } catch (UnsupportedOperationException uoe) {
        System.out.println(uoe.getMessage());
    } finally {
        stack.clear();
        System.out.println();
    }
}



    public static void main(String[] args) {
        NumberStack arrayListStack = new ArrayListNumberStack();
        NumberStack linkedListStack = new LinkedNumberStack();

        // Test ArrayListNumberStack
        System.out.println("Testing ArrayListNumberStack:");
        arrayListStack.push(1.0);
        arrayListStack.push(2.0);
        arrayListStack.push(3.0);
        try {
            System.out.println("Pop from ArrayListNumberStack: " + arrayListStack.pop());
            System.out.println("Current size: " + arrayListStack.size());
        } catch (EmptyStackException ese) {
            System.out.println("Caught EmptyStackException: " + ese.getMessage());
        }
        arrayListStack.clear(); // Clear the stack after testing

        // Test LinkedNumberStack
        System.out.println("\nTesting LinkedNumberStack:");
        linkedListStack.push(4.0);
        linkedListStack.push(5.0);
        linkedListStack.push(6.0);
        try {
            System.out.println("Pop from LinkedNumberStack: " + linkedListStack.pop());
            System.out.println("Current size: " + linkedListStack.size());
        } catch (EmptyStackException ese) {
            System.out.println("Caught EmptyStackException: " + ese.getMessage());
        }
        linkedListStack.clear(); // Clear the stack after testing

        // Test doOperation method
        System.out.println("\nTesting doOperation method:");
        arrayListStack.push(10.0);
        arrayListStack.push(5.0);
        try {
            doOperation(arrayListStack, "+");
            System.out.println("Result after addition: " + arrayListStack.pop());
        } catch (EmptyStackException | UnsupportedOperationException e) {
            System.out.println("Caught exception: " + e.getMessage());
        }
        arrayListStack.clear(); // Clear the stack after testing

        // Test evaluateRPN method with different stacks and expressions
        System.out.println("\nTesting evaluateRPN method:");
    String[] expressions = {
        "23 21 +",   // Should output 44.0
        "11 78 73 - *", // Should output 55.0
        "8 +",         // Should throw "Too few operands"
        "7 2 %"        // Should throw "Unsupported operation"
    };
    for (String expression : expressions) {
        System.out.println("Using ArrayListNumberStack:");
        evaluateRPN(arrayListStack, expression);
        System.out.println("Using LinkedNumberStack:");
        evaluateRPN(linkedListStack, expression);
    }
    }
}
