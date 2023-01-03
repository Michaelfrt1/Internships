/*
CaesarCipher is a class that encrypts an inputted message by shifting each letter by the same amount
The class is also able to decrypt an inputted message using the value of the amount shifted.
inherits from BaseCipher Class
 */
public class CaesarCipher extends BaseCipher {
    private int keyVal;

    /*
    @param int keyVal, for the value of the shift of the letters later in the code.
    constructor class.
    */
    public CaesarCipher(int keyVal) {
        super("Caesar Cipher");
        this.keyVal = keyVal;
    }

    /*
    Checks if the keyVal variable is a valid alphabet character between a and z.
    @return true, if not valid returns false.
    */
    public boolean isValid() {
        if (keyVal >= 1 && keyVal <= 25) {
            return true;
        }
        return false;
    }

    /*
    @param String message, text that gets encrypted.
    the encrypt method uses the keyVal to rotate/add what the character is in the String by the int assigned to keyVal.
    @returns String message, returns the encrypted message
     */
    public String encrypt(String message) {
        message = message.toLowerCase();
        String output = "";
        for (int i = 0; i < message.length(); i++) {
            char letter = message.charAt(i);
            if (Character.isAlphabetic(letter)) {
                char newLetter = (char) (letter + keyVal);
                if (newLetter > 'z') {
                    output += (char) (letter - (26 - keyVal));
                } else {
                    output += newLetter;
                }
            } else {
                output += letter;
            }
        }
        return output;
    }

    /*
    @param String message, the function decodes using the keyVal as the value change back to the original word.
    Decrypt does the exact opposite of the previous function, by subtracting the keyVal instead of adding.
    @Return String output, returns readable String.
    */
    public String decrypt(String message) {
        message = message.toLowerCase();
        String output = "";
        for (int i = 0; i < message.length(); i++) {
            char letter = message.charAt(i);
            if (Character.isAlphabetic(letter)) {
                char newLetter = (char) (letter - keyVal);
                if (newLetter < 'a') {
                    output += (char) (letter + (26 - keyVal));
                } else {
                    output += newLetter;
                }
            } else {
                output += letter;
            }
        }
        return output;
    }

    /* @return String "Caesar(int(keyvals))" in a string format. */
    public String toString() {
        return "Caesar" + "(" + keyVal + ")";
    }

    /*
    @param other Object, is the other object presumably a cipher
    the equals method finds out if the CaesarCipher and another CaesarCipher are equal.
    @return boolean true if the two objects are equal and false otherwise.
    */
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        } else if (other == null) {
            return false;
        }
        if (other instanceof CaesarCipher) {
            CaesarCipher cipher = (CaesarCipher) other;
            return this.keyVal == cipher.keyVal;
        }
        return false;
    }

}
