
package csci2010.dotyprogram2;

/**
 * CSCI 2010 Program 2
 * 
 * @author Jason Doty
 * 
 * This class extends SubstitutionCipher, implementing a simple shift (Caesar) cipher.
 */
public class ShiftCipher extends SubstitutionCipher {
    private final int key;

    public ShiftCipher(int key) {
        this.key = key;
    }

    @Override
    public void reset() {
        // Shift cipher does not maintain state, so nothing to reset
    }

    @Override
    public char encryptChar(char ch) {
        return shiftChar(ch, key);
    }

    @Override
    public char decryptChar(char ch) {
        return shiftChar(ch, 26 - key);
    }
}
