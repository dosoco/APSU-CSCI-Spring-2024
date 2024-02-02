
package csci2011.dotylab2;

/**
 * CSCI 2011 Lab 2
 * 
 * @author Jason Doty
 * 
 * The Main Class includes methods to test the functionality of both the Record
 * and RecordCollection classes
 */
public class DotyLab2 {

public static void main(String[] args) {
        // Test Records
        Record record1 = new Record("Unknown Pleasures", "Joy Division", 1979);
        Record record2 = new Record("Closer", "Joy Division", 1980);
        Record record3 = new Record("Disintegration", "The Cure", 1989);
        Record record4 = new Record("New Day Rising", "Hüsker Dü", 1985);

        // Test comesBefore method
        testComesBefore(record1, record2);
        testComesBefore(record4, record1);
        testComesBefore(record2, record3);

        // Test RecordCollection display
        RecordCollection collection = new RecordCollection(5);
        testRCDisplay(collection);

        // Test addRecord method
        testAddRecord(collection, record1);
        testAddRecord(collection, record2);
        testAddRecord(collection, record3);
        testAddRecord(collection, record4);

        // Test findRecord method
        testFindRecord(collection, "New Day Rising", "Hüsker Dü");
        testFindRecord(collection, "Nevermind", "Nirvana");

        // Test sortRecords method
        testSortRecords(collection);
    }

    // Unit test for comesBefore
    public static void testComesBefore(Record record1, Record record2) {
        System.out.println("Testing comesBefore:");
        if (record1.comesBefore(record2)) {
            System.out.println(record1.getTitle() + " comes before " + record2.getTitle());
        } else {
            System.out.println(record1.getTitle() + " does not come before " + record2.getTitle());
        }
    }

    // Unit test for RecordCollection display
    public static void testRCDisplay(RecordCollection collection) {
        System.out.println("Testing display:");
        collection.display();
        System.out.println("Number of records: " + collection.getNumRecords());
    }

    // Unit test for addRecord
    public static void testAddRecord(RecordCollection collection, Record record) {
        System.out.println("\nTesting addRecord");
        if (collection.addRecord(record)) {
            System.out.println("Adding " + record.getTitle() + " - " + record.getArtist() + " (" + record.getYear() + ")");
        } else {
            System.out.println("Failed to add record");
        }
        collection.display();
        System.out.println("Number of records: " + collection.getNumRecords());
    }

    // Unit test for findRecord
    public static void testFindRecord(RecordCollection collection, String title, String artist) {
        System.out.println("\nTesting findRecord");
        Record found = collection.findRecord(title, artist);
        if (found != null) {
            System.out.println("Found: " + found.getTitle() + " - " + found.getArtist() + " (" + found.getYear() + ")");
        } else {
            System.out.println("Record not found for " + title + " by " + artist);
        }
    }

    // Unit test for sortRecords
    public static void testSortRecords(RecordCollection collection) {
        System.out.println("\nTesting sortRecords");
        collection.sortRecords();
        collection.display();
    }
}
