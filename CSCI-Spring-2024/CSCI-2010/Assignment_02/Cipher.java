
package csci2010.dotyprogram2;

/**
 * CSCI 2010 Program 2
 * 
 * @author Jason Doty
 * 
 * This defines a standard for encrypting and decrypting messages.
 */
public interface Cipher {
    String encrypt(String plaintext);
    String decrypt(String ciphertext);
}
