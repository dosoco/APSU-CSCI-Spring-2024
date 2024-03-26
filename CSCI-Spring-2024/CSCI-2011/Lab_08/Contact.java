
package csci2011.dotylab8;

import java.io.Serializable;

/**
 * CSCI 2011 Lab 8
 * 
 * @author Jason Doty
 * 
 * This class represents a Contact with a name and phone number.
 */

public class Contact implements Serializable {
    private static final long serialVersionUID = 1L; // Standard practice for Serializable classes
    private final String name;
    private final String phone;

    /**
     * Constructs a new Contact with the specified name and phone number.
     *
     * @param name  the name of the contact
     * @param phone the phone number of the contact
     */
    public Contact(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

     public String getName() {
            return name;
        }

        public String getPhone() {
            return phone;
        }
    /**
     * Returns a string representation of the Contact, including the name and phone number.
     *
     * @return a string representation of the Contact
     */
    @Override
    public String toString() {
        return "Contact: Name = " + name + ", Phone = " + phone;
    }

    // Getters and setters for name and phone if needed can be added here
}
