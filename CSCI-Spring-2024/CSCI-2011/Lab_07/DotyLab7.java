

package csci2011.dotylab7;


import java.io.*;
import java.util.Scanner;

/**
 * CSCI 2011 Lab 7
 * 
 * @author Jason Doty
 * 
 * This class provides functionality to read from, write to, and append to text files.
 * It also includes methods to interact with the user through the console.
 */
public class DotyLab7 {

    public static void main(String[] args) {
// Open file for writing and write lines
        PrintWriter writer = openFileForWriting("testfile.txt");
        System.out.println("Opened file testfile.txt for writing");
        int linesWritten = writeLinesToFile(writer);
        System.out.println("Wrote " + linesWritten + " lines to testfile.txt");
        writer.close();

        // Open file for reading and read lines
        Scanner reader = openFileForReading("testfile.txt");
        System.out.println("Opened file testfile.txt for reading");
        int linesRead = readLinesFromFile(reader);
        System.out.println("Read " + linesRead + " lines from testfile.txt");
        reader.close();

        // Open file for appending and append lines
        PrintWriter appender = openFileForAppending("testfile.txt");
        System.out.println("Opened file testfile.txt for appending");
        linesWritten = writeLinesToFile(appender);
        System.out.println("Appended " + linesWritten + " lines to testfile.txt");
        appender.close();

        // Open file for reading after appending to check content
        reader = openFileForReading("testfile.txt");
        System.out.println("Opened file testfile.txt for reading after appending");
        linesRead = readLinesFromFile(reader);
        System.out.println("Read " + linesRead + " lines from testfile.txt after appending");
        reader.close();
    }

    /**
     * Opens a file for writing.
     * @param filename The name of the file to open.
     * @return A PrintWriter object to write to the file.
     */
    public static PrintWriter openFileForWriting(String filename) {
        try {
            return new PrintWriter(filename);
        } catch (FileNotFoundException e) {
            System.out.println("Error opening the file for writing: " + e.getMessage());
            System.exit(1);
        }
        return null; // This line will never be reached due to System.exit
    }

    /**
     * Opens a file for appending.
     * @param filename The name of the file to open.
     * @return A PrintWriter object to write to the file in append mode.
     */
    public static PrintWriter openFileForAppending(String filename) {
        try {
            return new PrintWriter(new FileOutputStream(new File(filename), true));
        } catch (FileNotFoundException e) {
            System.out.println("Error opening the file for appending: " + e.getMessage());
            System.exit(1);
        }
        return null; // This line will never be reached due to System.exit
    }

    /**
     * Opens a file for reading.
     * @param filename The name of the file to open.
     * @return A Scanner object to read from the file.
     */
    public static Scanner openFileForReading(String filename) {
        try {
            return new Scanner(new File(filename));
        } catch (FileNotFoundException e) {
            System.out.println("Error opening the file for reading: " + e.getMessage());
            System.exit(1);
        }
        return null; // This line will never be reached due to System.exit
    }

    /**
     * Reads lines from the file and prints them to the console.
     * @param scanner The Scanner object to read lines from the file.
     * @return The number of lines read from the file.
     */
    public static int readLinesFromFile(Scanner scanner) {
        int count = 0;
        while (scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
            count++;
        }
        return count;
    }

    /**
     * Writes lines from the console to the file.
     * It prompts the user to enter text and writes it to the file until an empty line is entered.
     * @param writer The PrintWriter object to write lines to the file.
     * @return The number of lines written to the file.
     */
    public static int writeLinesToFile(PrintWriter writer) {
        Scanner keyboard = new Scanner(System.in);
        int count = 0;
        System.out.println("Enter the text you want to write to the file. Enter a blank line when you are done.");

        while (true) {
            String inputLine = keyboard.nextLine();
            if (inputLine.isEmpty()) {
                break; // Exit the loop if a blank line is entered
            }
            writer.println(inputLine);
            count++;
        }

        writer.flush(); // Ensure all data is written to the file.
        return count;
    }
}