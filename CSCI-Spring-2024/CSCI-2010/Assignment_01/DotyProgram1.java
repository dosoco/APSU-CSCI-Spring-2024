
package csci2010.dotyprogram1;

import java.util.Scanner;

/**
 *CSCI 2010 Programming Assignment 1
 * 
 * @author Jason Doty
 * 
 * This program creates and modifies album, song and playlist information
 */
public class DotyProgram1 {
    private static final Scanner keyboard = new Scanner(System.in);
    private static final AlbumCollection albumCollection = new AlbumCollection();
    private static final Playlist playlist = new Playlist();

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            displayMenu();
            int choice = keyboard.nextInt();
            keyboard.nextLine(); // Consume the newline left-over
            switch (choice) {
                case 1:
                    addAlbum();
                    break;
                case 2:
                    albumCollection.displayAlbums();
                    break;
                case 3:
                    albumCollection.displaySongs();
                    break;
                case 4:
                    albumCollection.sortAlbums();
                    System.out.println("Albums sorted successfully.");
                    break;
                case 5:
                    addSongToPlaylist();
                    break;
                case 6:
                    playlist.display();
                    break;
                case 7:
                    playlist.clear();
                    System.out.println("Playlist cleared.");
                    break;
                case 8:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        System.out.println("Exiting the program...");
    }

    // Displays the main menu
    private static void displayMenu() {
        System.out.println("\nWelcome to Jason Doty's music manager!");
        System.out.println("\nChoose one of the following:");
        System.out.println("1. Add an album to the collection");
        System.out.println("2. Display the albums in the collection");
        System.out.println("3. Display the songs in the collection");
        System.out.println("4. Sort the albums in the collection");
        System.out.println("5. Add a song to the playlist");
        System.out.println("6. Display the playlist");
        System.out.println("7. Clear playlist");
        System.out.println("8. Exit the program");
        System.out.print("Enter your choice: ");
    }
      // Adds an album to the collection
    private static void addAlbum() {
        System.out.println("Enter album details:");
        System.out.print("Title: ");
        String title = keyboard.nextLine();
        System.out.print("Artist: ");
        String artist = keyboard.nextLine();
        System.out.print("Number of songs: ");
        int numSongs = keyboard.nextInt();
        Song[] songs = new Song[numSongs];
        for (int i = 0; i < numSongs; i++) {
            songs[i] = getSongDetails();
        }
        Album newAlbum = new Album(title, artist, songs);
        albumCollection.addAlbum(newAlbum);
        System.out.println("Album added successfully.");
    }

    // Gets song details from the user
    private static Song getSongDetails() {
        System.out.println("Enter song details:");
        System.out.print("Title: ");
         keyboard.nextLine();
        String title = keyboard.nextLine();
        System.out.print("Artist: ");
        String artist = keyboard.nextLine();
        System.out.print("Length (minutes seconds): ");
        int minutes = keyboard.nextInt();
        int seconds = keyboard.nextInt();
        
        return new Song(title, artist, minutes, seconds);
    }

    // Adds a song to the playlist
    private static void addSongToPlaylist() {
        Song song = getSongDetails();
        if (playlist.addSong(song)) {
            System.out.println("Song added to playlist.");
        } else {
            System.out.println("Playlist is full.");
        }
    }

}

