
package csci2011.dotylab9;

/**
 * CSCI 2011 Lab 9
 * 
 * @author Jason Doty
 * 
 * MovieActor class encapsulates actor and movie information
 */
public class MovieActor {
// Attributes of the MovieActor class
    final String actorName;
    final String movieName;
    final int year;

    // Parameterized constructor to initialize the instance variables
    public MovieActor(String actorName, String movieName, int year) {
        this.actorName = actorName;
        this.movieName = movieName;
        this.year = year;
    }

    // toString method to return the actor name, movie name, and movie year as a string
    @Override
    public String toString() {
        return actorName + " in " + movieName + ", " + year;
    }
}
