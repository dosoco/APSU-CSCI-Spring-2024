
package csci2010.dotyprogram3;

/**
 * CSCI 2010 Program 3
 * 
 * @author Jason Doty
 * 
 * The HanoiTower class represents a single tower in the Towers of Hanoi puzzle.
 */
public class HanoiTower {
    // An array to represent the discs on the tower.
    private final int[] discs;
    // The number of discs currently on the tower.
    private int discCount;
    // The name of the tower (e.g., "A", "B", "C").
    private String name;

    // Constructor for the HanoiTower class.
    public HanoiTower(int maxDiscs, String name) {
        // Initialize the discs array with the maximum number of discs.
        this.discs = new int[maxDiscs];
        // Initially, there are no discs on the tower.
        this.discCount = 0;
        // Set the name of the tower.
        this.name = name;
    }

    // The push method adds a disc to the tower.
    public void push(int disc) throws TowerOverflowException, IllegalPushException {
        // Check if the tower is full.
        if (discCount == discs.length) {
            throw new TowerOverflowException("Tower is full. Cannot add more discs.");
        }
        // Check if the disc can be legally placed on the tower.
        if (discCount > 0 && discs[discCount - 1] < disc) {
            throw new IllegalPushException("Cannot place a larger disc on top of a smaller one.");
        }
        // Add the disc to the tower and increment the disc count.
        discs[discCount] = disc;
        discCount++;
    }

    // The pop method removes the top disc from the tower.
    public int pop() throws EmptyTowerException {
        // Check if the tower is empty.
        if (discCount == 0) {
            throw new EmptyTowerException("Tower is empty. Cannot remove a disc.");
        }
        // Decrement the disc count and return the top disc.
        discCount--;
        return discs[discCount];
    }

    // The toString method returns a string representation of the tower.
    @Override
    public String toString() {
        // Start with the name of the tower.
        StringBuilder output = new StringBuilder("Rod " + name + ":");
        // Add each disc to the string.
        for (int i = 0; i < discCount; i++) {
            output.append(" ").append(discs[i]);
        }
        return output.toString();
    }
}
