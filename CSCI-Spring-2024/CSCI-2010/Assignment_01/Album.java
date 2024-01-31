
package csci2010.dotyprogram1;

/**
 *CSCI 2010 Programming Assignment 1
 * 
 * @author Jason Doty
 * 
 * This program creates and modifies album, song and playlist information
 */
public class Album {
    // Private instance variables
    private final String title;
    private final String artist;
    private final Song[] tracklist;

    // Constructor
    public Album(String title, String artist, Song[] tracklist) {
        this.title = title;
        this.artist = artist;
        this.tracklist = new Song[tracklist.length];
        System.arraycopy(tracklist, 0, this.tracklist, 0, tracklist.length);
    }

    // Accessor methods
    public String getTitle() { return title; }
    public String getArtist() { return artist; }

    // Get number of tracks on the album
    public int getNumTracks() {
        return tracklist.length;
    }

    // Get a track by number
    public Song getTrack(int trackNumber) {
        if (trackNumber < 1 || trackNumber > tracklist.length) {
            return null;
        }
        return tracklist[trackNumber - 1];
    }

    // Compare this album with another album
    public boolean comesBefore(Album other) {
        int artistComparison = artist.compareToIgnoreCase(other.artist);
        if (artistComparison != 0) {
            return artistComparison < 0;
        }
        return title.compareToIgnoreCase(other.title) < 0;
    }

    // Display album details
    public void displayAlbum() {
        System.out.printf("%s - %s (%d tracks)\n", title, artist, getNumTracks());
    }

    // Display tracklist of the album
    public void displayTracklist() {
        for (int i = 0; i < tracklist.length; i++) {
            System.out.printf("%2d. ", i + 1);
            tracklist[i].display();
        }
    }
}
