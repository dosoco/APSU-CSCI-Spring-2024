
package csci2010.dotyprogram3;

/**
 * CSCI 2010 Program 3
 * 
 * @author Jason Doty
 * 
 * This is the entry point of the program that simulates the Towers of Hanoi problem.
 */

import java.util.Scanner;

public class DotyProgram3 {

     public static void main(String[] args) {
        // Welcome message.
        System.out.println("Welcome to Jason Doty's Hanoi tower simulation!");

        Scanner keyboard = new Scanner(System.in);
        String userInput;
        do {
            // Prompt the user for the number of discs.
            System.out.println("\nHow many discs do you wish to simulate?");
            int numDiscs = keyboard.nextInt();

            // Create a HanoiSimulation object with the specified number of discs.
            HanoiSimulation simulation = new HanoiSimulation(numDiscs);
            
            // Run the simulation.
            simulation.runSim();

            // Ask the user if they want to run another simulation.
            System.out.println("Would you like to run another simulation? (Y/N)");
            userInput = keyboard.next();
        } while (userInput.equalsIgnoreCase("Y"));

        // Thank you message.
        System.out.println("Thank you for using Jason Doty's Hanoi tower simulation.");
        keyboard.close();
    }
}
