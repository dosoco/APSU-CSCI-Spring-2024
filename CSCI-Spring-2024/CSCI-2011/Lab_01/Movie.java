
package csci2011.dotylab1;

/**
 * CSCI 2011 Lab 1
 * 
 * @author Jason Doty
 * 
 * The Movie Class can be used to create and manage movie objects.
 */
public class Movie {
     // Private instance variables
    private String title;
    private String director;
    private int year;

    // Constructor
    public Movie() {
    }

    // Method to initialize the movie data
    public void initialize(String title, String director, int year) {
        this.title = title;
        this.director = director;
        this.year = year;
    }

    // Method to display movie information
    public void display() {
        System.out.println(this.title + " dir. " + this.director + " (" + this.year + ")");
    }

    // Accessor methods (getters)
    public String getTitle() {
        return title;
    }

    public String getDirector() {
        return director;
    }

    public int getYear() {
        return year;
    }

    // Mutator methods (setters)
    public void setTitle(String title) {
        this.title = title;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setYear(int year) {
        this.year = year;
    }

    // Equals method
    public boolean equals(Movie other) {
        if (other == null) {
            return false;
        }
        return this.title.equals(other.title) &&
               this.director.equals(other.director) &&
               this.year == other.year;
    }
}
