
package csci2010.dotyprogram1;

/**
 *CSCI 2010 Programming Assignment 1
 * 
 * @author Jason Doty
 * 
 * This program creates and modifies album, song and playlist information
 */
public class Song {
    // Private instance variables
    private final String title;
    private final String artist;
    private final int lengthInSeconds;

    // Constructor
    public Song(String title, String artist, int minutes, int seconds) {
        this.title = title;
        this.artist = artist;
        this.lengthInSeconds = minutes * 60 + seconds;
    }

    // Accessor methods
    public String getTitle() { return title; }
    public String getArtist() { return artist; }
    public int getLengthInSeconds() { return lengthInSeconds; }

    // Display song details
    public void display() {
        int minutes = lengthInSeconds / 60;
        int seconds = lengthInSeconds % 60;
        System.out.printf("%s - %s (%d:%02d)\n", title, artist, minutes, seconds);
    }
}
