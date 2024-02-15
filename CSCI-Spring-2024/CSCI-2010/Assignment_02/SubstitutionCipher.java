
package csci2010.dotyprogram2;

/**
 * CSCI 2010 Program 2
 * 
 * @author Jason Doty
 * 
 * This abstract class provides a framework for ciphers that perform substitution.
 */
public abstract class SubstitutionCipher implements Cipher {
    // Encrypt a single character
    public abstract char encryptChar(char ch);

    // Decrypt a single character
    public abstract char decryptChar(char ch);

    // Reset the cipher to its initial state
    public abstract void reset();

    // Check if a character is alphabetic
    public static boolean alphabetic(char ch) {
        return (ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z');
    }

    // Get key number from a character
    public static int getKeyNum(char ch) {
        if (ch >= 'A' && ch <= 'Z') return ch - 'A';
        if (ch >= 'a' && ch <= 'z') return ch - 'a';
        return -1;
    }

    // Shift a character by a given key
    public static char shiftChar(char ch, int key) {
        if (alphabetic(ch)) {
            char base = Character.isUpperCase(ch) ? 'A' : 'a';
            return (char)((ch - base + key + 26) % 26 + base);
        }
        return ch;
    }

    // Encrypt a plaintext string
    @Override
    public String encrypt(String plaintext) {
        reset();
        String ciphertext = "";
        for (char ch : plaintext.toCharArray()) {
            ciphertext += encryptChar(ch);
        }
        return ciphertext;
    }

    // Decrypt a ciphertext string
    @Override
    public String decrypt(String ciphertext) {
        reset();
        String plaintext = "";
        for (char ch : ciphertext.toCharArray()) {
            plaintext += decryptChar(ch);
        }
        return plaintext;
    }
}
