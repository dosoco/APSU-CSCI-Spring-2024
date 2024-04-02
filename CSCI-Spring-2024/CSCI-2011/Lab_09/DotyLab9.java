
package csci2011.dotylab9;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * CSCI 2011 Lab 9
 * 
 * @author Jason Doty
 * 
 * 
 */
public class DotyLab9 {

    public static void main(String[] args) {
 Scanner keyboard = new Scanner(System.in);
        ArrayList<MovieActor> movieActors = new ArrayList<>();

        // Loop to read movie-actor information from the user
        boolean adding = true;
        while (adding) {
            MovieActor ma = readMovieActor(keyboard); // Read movie actor information
            movieActors.add(ma); // Add the MovieActor object to the ArrayList
            System.out.print("Enter another? (y/n): ");
            adding = keyboard.next().equalsIgnoreCase("y");
            keyboard.nextLine(); // Consume the leftover newline character
        }

        // Display all movie-actor information stored in the ArrayList
        System.out.println("ArrayList contents:");
        for (MovieActor ma : movieActors) {
            System.out.println(ma);
        }

        // Display unique movies
        displayMovies(movieActors);

        // Display unique actors
        displayActors(movieActors);
    }

    // Method to prompt the user and create a MovieActor object
    public static MovieActor readMovieActor(Scanner scanner) {
        System.out.println("Enter movie-actor information.");
        System.out.print("Enter name of actor: ");
        String actor = scanner.nextLine();
        System.out.print("Enter name of movie: ");
        String movie = scanner.nextLine();
        System.out.print("Enter movie release year: ");
        int year = scanner.nextInt();
        scanner.nextLine(); // Consume the leftover newline character
        return new MovieActor(actor, movie, year);
    }

    // Method to display unique movies using a HashMap
    public static void displayMovies(ArrayList<MovieActor> movieActors) {
        HashMap<String, Integer> movies = new HashMap<>();
        for (MovieActor ma : movieActors) {
            movies.put(ma.movieName, ma.year);
        }

        System.out.println("Unique movies:");
        for (String movie : movies.keySet()) {
            System.out.println(movie + " - " + movies.get(movie));
        }
    }

    // Method to display unique actors using a HashSet
    public static void displayActors(ArrayList<MovieActor> movieActors) {
        HashSet<String> actors = new HashSet<>();
        for (MovieActor ma : movieActors) {
            actors.add(ma.actorName);
        }

        System.out.println("Unique actors:");
        for (String actor : actors) {
            System.out.println(actor);
        }
    }
}
