
package csci2011.dotylab2;

/**
 * CSCI 2011 Lab 2
 * 
 * @author Jason Doty
 * 
 * The Record Class represents a music record with a title, artist, and year of release
 */

public class Record {
    private final String title; // The title of the record
    private final String artist; // The artist of the record
    private final int year; // The year the record was released

    // Constructor initializes the Record object with provided title, artist, and year
    public Record(String title, String artist, int year) {
        this.title = title;
        this.artist = artist;
        this.year = year;
    }

    // Accessor method for the title
    public String getTitle() {
        return title;
    }

    // Accessor method for the artist
    public String getArtist() {
        return artist;
    }

    // Accessor method for the year
    public int getYear() {
        return year;
    }

    // Displays the record information in the specified format
    public void display() {
        System.out.println(title + " - " + artist + " (" + year + ")");
    }

    // Determines if this record comes before another record
    public boolean comesBefore(Record other) {
        int artistComparison = this.artist.compareToIgnoreCase(other.artist);
        if (artistComparison < 0) {
            return true;
        } else if (artistComparison == 0) {
            return this.year < other.year;
        }
        return false;
    }
}

