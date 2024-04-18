
package csci2011.jdotylab10;

/**
 *
 * @author jdoty
 */
// LinkedNumberStack.java
public class LinkedNumberStack implements NumberStack {
    private static class Node {
        double number;
        Node next;

        Node(double number, Node next) {
            this.number = number;
            this.next = next;
        }
    }

    private Node head;
    private int count;

    public LinkedNumberStack() {
        this.head = null;
        this.count = 0;
    }

    @Override
    public void push(double item) {
        head = new Node(item, head);
        count++;
    }

    @Override
    public double pop() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        double number = head.number;
        head = head.next;
        count--;
        return number;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public void clear() {
        head = null;
        count = 0;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Stack: ");
        Node current = head;
            while (current != null) {
            sb.append(current.number).append(" ");
            current = current.next;
        }
        return sb.toString().trim();
    }

}

