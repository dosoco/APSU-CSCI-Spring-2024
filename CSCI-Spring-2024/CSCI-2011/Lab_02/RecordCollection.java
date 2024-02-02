
package csci2011.dotylab2;

/**
 * CSCI 2011 Lab 2
 * 
 * @author Jason Doty
 * 
 * The RecordCollection Class is designed to manage a collection of Record objects
 */

public class RecordCollection {
    private int numRecords; // Number of records currently in the collection
    private final Record[] records; // Array to store the records

    // Constructor to initialize the collection with a maximum size
    public RecordCollection(int maxSize) {
        this.numRecords = 0;
        this.records = new Record[maxSize];
    }

    // Accessor for the number of records
    public int getNumRecords() {
        return numRecords;
    }

    // Display all records in the collection
    public void display() {
        if (numRecords == 0) {
            System.out.println("No records in the collection");
        } else {
            for (int i = 0; i < numRecords; i++) {
                records[i].display();
            }
        }
    }

    // Add a record to the collection
    public boolean addRecord(Record record) {
        if (record == null || numRecords >= records.length) {
            return false; // Do not add if the record is null or collection is full
        }
        records[numRecords++] = record; // Add the record and increment the count
        return true;
    }

    // Find a record in the collection by title and artist
    public Record findRecord(String title, String artist) {
        for (int i = 0; i < numRecords; i++) {
            if (records[i].getTitle().equalsIgnoreCase(title) && 
                records[i].getArtist().equalsIgnoreCase(artist)) {
                return records[i];
            }
        }
        return null; // Return null if no match is found
    }

    // Sort the records in the collection using selection sort
    public void sortRecords() {
        for (int i = 0; i < numRecords - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < numRecords; j++) {
                if (records[j].comesBefore(records[minIndex])) {
                    minIndex = j;
                }
            }
            // Swap the records
            Record temp = records[minIndex];
            records[minIndex] = records[i];
            records[i] = temp;
        }
    }
}

