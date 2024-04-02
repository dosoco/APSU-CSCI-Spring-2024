
package csci2010.dotyprogram5;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * CSCI 2010 Program Assignment 5
 * 
 * @author Jason Doty
 * 
 * This program demonstrates use of linked lists and generics
 */
public class DotyProgram5 {

    public static void main(String[] args) {
    // Linked lists for storing stadium names and game revenues
        LinkedList<String> stadiumNames = new LinkedList<>();
        LinkedList<Double> gameRevenue = new LinkedList<>();

        Scanner keyboard = new Scanner(System.in); // Scanner for reading user input
        System.out.println("Enter the data now.\nOn each line enter a stadium name and the game revenue\nEnter done when you are finished");

        // Input loop for reading game data
        while (keyboard.hasNextLine()) {
            String input = keyboard.nextLine();
            if (input.equalsIgnoreCase("done")) break; // Exits the loop if user types "done"
            
            String[] parts = input.split(" "); // Splits the input into parts
            String stadium = parts[0];
            double revenue = Double.parseDouble(parts[1]);

            stadiumNames.add(stadium); // Adds the stadium name to the list
            gameRevenue.add(revenue); // Adds the game revenue to the list
        }

        System.out.println("Enter the name of a stadium to get the total revenue for:");
        String searchStadium = keyboard.nextLine(); // Reads the stadium name for which to calculate total revenue
        
        // Calculates and prints the total revenue for the specified stadium
        double totalRevenue = calculateTotalRevenue(stadiumNames, gameRevenue, searchStadium);
        System.out.println("The total revenue is " + totalRevenue);
    }

    // Method for calculating total revenue for a specific stadium
    private static double calculateTotalRevenue(LinkedList<String> stadiumNames, LinkedList<Double> gameRevenue, String stadium) {
        double total = 0;
        for (int i = 0; i < stadiumNames.size(); i++) {
            if (stadiumNames.get(i).equalsIgnoreCase(stadium)) {
                total += gameRevenue.get(i); // Adds revenue if the stadium name matches
            }
        }
        return total;
    }
}
