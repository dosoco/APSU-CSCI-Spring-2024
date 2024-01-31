
package csci2010.dotyprogram1;

/**
 *CSCI 2010 Programming Assignment 1
 * 
 * @author Jason Doty
 * 
 * This program creates and modifies album, song and playlist information
 */
public class Playlist {
    // Public constant for maximum number of songs
    public static final int MAX_SONGS = 500;

    // Private instance variables
    private Song[] songs;
    private int numSongs;

    // Constructor
    public Playlist() {
        songs = new Song[MAX_SONGS];
        numSongs = 0;
    }

    // Add a song to the playlist
    public boolean addSong(Song song) {
        if (numSongs >= MAX_SONGS) {
            return false;
        }
        songs[numSongs++] = song;
        return true;
    }

    // Display the playlist
    public void display() {
        for (int i = 0; i < numSongs; i++) {
            songs[i].display();
        }
        System.out.println("Total time: " + getFormattedLength());
    }

    // Clear the playlist
    public void clear() {
        numSongs = 0;
    }

    // Get total length of the playlist
    public String getFormattedLength() {
        int totalLength = 0;
        for (int i = 0; i < numSongs; i++) {
            totalLength += songs[i].getLengthInSeconds();
        }
        int minutes = totalLength / 60;
        int seconds = totalLength % 60;
        return String.format("%d:%02d", minutes, seconds);
    }
}

