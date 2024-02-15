
package csci2010.dotyprogram2;

/**
 * CSCI 2010 Program 2
 * 
 * @author Jason Doty
 * 
 * This is the main entry point for the cipher program. It interacts with the user,
 * allowing them to choose between different ciphers for encryption and decryption of messages.
 */
import java.util.Scanner;

public class DotyProgram2 {

 public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        Cipher cipher = null;

        System.out.println("Welcome to Jason Doty's Cipher Program!");

        boolean running = true;
        while (running) {
            System.out.print("Do you want to [E]ncrypt or [D]ecrypt? (E/D): ");
            String mode = keyboard.nextLine().toUpperCase();

            System.out.print("Do you want to use a [S]hift cipher or a [V]igenere cipher? (S/V): ");
            String cipherType = keyboard.nextLine().toUpperCase();

            if (cipherType.equals("S")) {
                System.out.print("Please enter a number between 0 and 25 to use as a key: ");
                int key = Integer.parseInt(keyboard.nextLine());
                cipher = new ShiftCipher(key);
            } else if (cipherType.equals("V")) {
                System.out.print("Please enter a keyword: ");
                String keyword = keyboard.nextLine();
                cipher = new VigenereCipher(keyword);
            }

            String inputText;
            String outputText;

            if (mode.equals("E")) {
                System.out.print("Please enter the plaintext to be encrypted: ");
                inputText = keyboard.nextLine();
                outputText = cipher.encrypt(inputText);
                System.out.println("The corresponding ciphertext is: " + outputText);
            } else if (mode.equals("D")) {
                System.out.print("Please enter the ciphertext to be decrypted: ");
                inputText = keyboard.nextLine();
                outputText = cipher.decrypt(inputText);
                System.out.println("The corresponding plaintext is: " + outputText);
            }

            System.out.print("Do you want to continue (Y/N)? ");
            String continueChoice = keyboard.nextLine().toUpperCase();
            if (!continueChoice.equals("Y")) {
                running = false;
            }
        }

        System.out.println("Thank you for using Jason Doty's Cipher Program.");
        keyboard.close();
    }
}
