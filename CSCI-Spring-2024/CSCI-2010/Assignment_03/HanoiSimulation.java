
package csci2010.dotyprogram3;

/**
 * CSCI 2010 Program 3
 * 
 * @author Jason Doty
 * 
 * HanoiSimulation manages the process of solving the Towers of Hanoi puzzle.
 */
public class HanoiSimulation {
    // The number of discs in the simulation.
    private int numDiscs;
    // Three HanoiTower objects representing the rods A, B, and C.
    private HanoiTower rodA, rodB, rodC;

    // Constructor for HanoiSimulation.
    public HanoiSimulation(int numDiscs) {
        // Initialize the number of discs.
        this.numDiscs = numDiscs;
        // Initialize the towers with appropriate names.
        this.rodA = new HanoiTower(numDiscs, "A");
        this.rodB = new HanoiTower(numDiscs, "B");
        this.rodC = new HanoiTower(numDiscs, "C");

        // Add the discs to rod A in descending order (largest to smallest).
        try {
            for (int i = numDiscs; i > 0; i--) {
                rodA.push(i);
            }
        } catch (TowerOverflowException | IllegalPushException e) {
            // Since we are starting with an empty simulation, these exceptions should not occur.
            e.printStackTrace();
        }
    }

    // The runSim method starts the Towers of Hanoi simulation.
    public void runSim() {
        // Display the initial state of the towers.
        displayTowers();
        // Start the recursive process to move the discs from rod A to rod B.
        moveDiscs(numDiscs, rodA, rodB, rodC);
    }

    // The moveDiscs method is a recursive function that performs the actual disc movements.
    private void moveDiscs(int n, HanoiTower source, HanoiTower destination, HanoiTower auxiliary) {
        // Base case: if there's only one disc, move it directly to the destination.
        if (n == 1) {
            try {
                destination.push(source.pop());
                displayTowers();
            } catch (TowerOverflowException | IllegalPushException | EmptyTowerException e) {
                // Handle exceptions that occur during the disc move.
                e.printStackTrace();
            }
        } else {
            // Recursive case: move n-1 discs to the auxiliary rod.
            moveDiscs(n - 1, source, auxiliary, destination);
            // Move the nth disc to the destination rod.
            try {
                destination.push(source.pop());
                displayTowers();
            } catch (TowerOverflowException | IllegalPushException | EmptyTowerException e) {
                // Handle exceptions that occur during the disc move.
                e.printStackTrace();
            }
            // Move the n-1 discs from the auxiliary rod to the destination rod.
            moveDiscs(n - 1, auxiliary, destination, source);
        }
    }

    // The displayTowers method prints the state of each tower.
    private void displayTowers() {
        System.out.println(rodA);
        System.out.println(rodB);
        System.out.println(rodC);
        System.out.println(); // Print an empty line for better readability.
    }
}
