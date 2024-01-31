
package csci2010.dotyprogram1;

/**
 *CSCI 2010 Programming Assignment 1
 * 
 * @author Jason Doty
 * 
 * This program creates and modifies album, song and playlist information
 */
public class AlbumCollection {
    // Public constant for maximum number of albums
    public static final int MAX_ALBUMS = 100;

    // Private instance variables
    private final Album[] albums;
    private int numAlbums;

    // Constructor
    public AlbumCollection() {
        albums = new Album[MAX_ALBUMS];
        numAlbums = 0;
    }

    // Add an album to the collection
    public boolean addAlbum(Album album) {
        if (numAlbums >= MAX_ALBUMS) {
            return false;
        }
        albums[numAlbums++] = album;
        return true;
    }

    // Find an album by title and artist
    public Album findAlbum(String title, String artist) {
        for (int i = 0; i < numAlbums; i++) {
            if (albums[i].getTitle().equalsIgnoreCase(title) && albums[i].getArtist().equalsIgnoreCase(artist)) {
                return albums[i];
            }
        }
        return null;
    }

    // Sort the albums in the collection
    public void sortAlbums() {
        for (int i = 0; i < numAlbums - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < numAlbums; j++) {
                if (albums[j].comesBefore(albums[minIndex])) {
                    minIndex = j;
                }
            }
            Album temp = albums[minIndex];
            albums[minIndex] = albums[i];
            albums[i] = temp;
        }
    }

    // Display all albums in the collection
    public void displayAlbums() {
        for (int i = 0; i < numAlbums; i++) {
            albums[i].displayAlbum();
        }
    }

    // Display all songs in the collection
    public void displaySongs() {
    for (int i = 0; i < numAlbums; i++) {
        System.out.println("Album: " + albums[i].getTitle());
        albums[i].displayTracklist();
    }
}
}
