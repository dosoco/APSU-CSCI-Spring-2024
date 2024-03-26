
package csci2011.dotylab8;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * CSCI 2011 Lab 8
 * 
 * @author Jason Doty
 * 
 * Allows adding, finding, updating, and deleting contacts in a binary file.
 */

public class DotyLab8 {

private static final String CONTACTS_FILE = "contacts.dat";
    private static final Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {
        displayMenu();
    }

    public static void displayMenu() {
        int choice;
        do {
            System.out.println("\nContact Management System");
            System.out.println("1. Add Contact");
            System.out.println("2. Find Contact");
            System.out.println("3. Update Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Exit");
            System.out.print("Please enter your choice: ");

            choice = keyboard.nextInt();
            keyboard.nextLine(); // Consume newline left-over

            switch (choice) {
                case 1:
                    addContact();
                    break;
                case 2:
                    findContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    deleteContact();
                    break;
                case 5:
                    System.out.println("Thank you for using the application!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 5);
    }

    public static void addContact() {
        System.out.print("Enter contact name: ");
        String name = keyboard.nextLine();
        System.out.print("Enter contact phone number: ");
        String phone = keyboard.nextLine();

        Contact newContact = new Contact(name, phone);

        List<Contact> contacts = readContactsFromFile();
        contacts.add(newContact);
        writeContactsToFile(contacts);
        System.out.println("Contact added successfully!");
    }

    public static void findContact() {
        System.out.print("Enter the name of the contact to find: ");
        String name = keyboard.nextLine();

        List<Contact> contacts = readContactsFromFile();
        Optional<Contact> matchingContact = contacts.stream()
                .filter(contact -> contact.getName().equalsIgnoreCase(name))
                .findFirst();

        if (matchingContact.isPresent()) {
            System.out.println("Contact found: " + matchingContact.get());
        } else {
            System.out.println("Contact not found.");
        }
    }

    public static void updateContact() {
        System.out.print("Enter the name of the contact to update: ");
        String name = keyboard.nextLine();

        List<Contact> contacts = readContactsFromFile();
        List<Contact> updatedContacts = new ArrayList<>();

        boolean isUpdated = false;
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                System.out.print("Enter new contact phone number: ");
                String newPhone = keyboard.nextLine();
                updatedContacts.add(new Contact(contact.getName(), newPhone));
                isUpdated = true;
            } else {
                updatedContacts.add(contact);
            }
        }

        if (isUpdated) {
            writeContactsToFile(updatedContacts);
            System.out.println("Contact updated successfully!");
        } else {
            System.out.println("Contact does not exist.");
        }
    }

    public static void deleteContact() {
        System.out.print("Enter the name of the contact to delete: ");
        String name = keyboard.nextLine();

        List<Contact> contacts = readContactsFromFile();
        boolean found = false;

        for (Iterator<Contact> iterator = contacts.iterator(); iterator.hasNext();) {
            Contact contact = iterator.next();
            if (contact.getName().equalsIgnoreCase(name)) {
                iterator.remove();
                found = true;
            }
        }

        if (found) {
            writeContactsToFile(contacts);
            System.out.println("Contact deleted successfully.");
        } else {
            System.out.println("Contact does not exist.");
        }
    }

    private static List<Contact> readContactsFromFile() {
        List<Contact> contacts = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(CONTACTS_FILE))) {
            contacts = (List<Contact>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("No contacts found. Starting a new contact list.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("An error occurred while reading contacts from file.");
            e.printStackTrace();
        }
        return contacts;
    }

    private static void writeContactsToFile(List<Contact> contacts) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(CONTACTS_FILE))) {
            oos.writeObject(contacts);
        } catch (IOException e) {
            System.err.println("An error occurred while writing contacts to file.");
            e.printStackTrace();
        }
    }
}
