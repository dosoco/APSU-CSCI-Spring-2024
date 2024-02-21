/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package csci2011.dotylab5;

/**
 * CSCI 2011 LAB 5
 * 
 * @author Jason Doty
 * 
 * This file defines an exception for handling full stack scenarios.
 */
// Class that represents an exception thrown when trying to push onto a full stack
public class FullStackException extends Exception {
    // Default constructor with a default error message
    public FullStackException() {
        super("Stack is full.");
    }

    // Constructor with a parameter to set a custom error message
    public FullStackException(String msg) {
        super(msg);
    }
}
