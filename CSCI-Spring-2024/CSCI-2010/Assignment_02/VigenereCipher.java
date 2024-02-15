
package csci2010.dotyprogram2;

/**
 * CSCI 2010 Program 2
 * 
 * @author Jason Doty
 * 
 * This class extends SubstitutionCipher and implements a more complex cipher using a keyword.
 */
public class VigenereCipher extends SubstitutionCipher {
    private String keyword;
    private int keywordIndex;

    public VigenereCipher(String keyword) {
        if (keyword.isEmpty()) {
            throw new IllegalArgumentException("Keyword cannot be empty.");
        }
        this.keyword = keyword;
        this.keywordIndex = 0;
    }

    @Override
    public void reset() {
        keywordIndex = 0; // Reset the index for cycling through the keyword
    }

    @Override
    public char encryptChar(char ch) {
        if (!alphabetic(ch)) {
            return ch; // Non-alphabetic characters are not encrypted
        }
        int key = getKeyNum(keyword.charAt(keywordIndex));
        char encryptedChar = shiftChar(ch, key);
        incrementKeywordIndex();
        return encryptedChar;
    }

    @Override
    public char decryptChar(char ch) {
        if (!alphabetic(ch)) {
            return ch; // Non-alphabetic characters are not decrypted
        }
        int key = getKeyNum(keyword.charAt(keywordIndex));
        char decryptedChar = shiftChar(ch, 26 - key); // Subtract key from 26 for decryption
        incrementKeywordIndex();
        return decryptedChar;
    }

    // Helper method to increment the keyword index and wrap around if necessary
    private void incrementKeywordIndex() {
        keywordIndex = (keywordIndex + 1) % keyword.length();
    }
}

