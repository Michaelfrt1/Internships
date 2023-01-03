//Michael Ginzburg
//CSCI 1913

/*
The WordReplacementCipher Class creates a cipher that replaces certain words with other words.
Inherits from BaseCipher.
*/
public class WordReplacementCipher extends BaseCipher {
    private String replaceF;
    private String replaceT;

    /*
    @param String replaceF, The real word we want
    @param String replaceT, The code word
    Constructor that initializes the WordReplacementCipher object using reference variable super
     */
    public WordReplacementCipher(String replaceF, String replaceT) {
        super("Word Replacement Cipher");
        this.replaceF = replaceF;
        this.replaceT = replaceT;
    }

    /*
     @param String message, text that gets encrypted.
     encrypts a message by replacing one word with the other.
     @return String encrypted, returns the encrypted String.
     */
    public String encrypt(String message) {
        message = message.replace(replaceF, replaceT);
        return message;
    }

    /*
     @param String message, text that gets decrypted.
     decrypts the message by replacing the word the opposite way.
     @return String decrypted, returns the decrypted String.
     */
    public String decrypt(String message) {
        message = message.replace(replaceT, replaceF);
        return message;
    }

    /*
    @return String, the String displays the name of the class as well as what words were used in the replacement.
    */
    public String toString() {
        return "WordReplacementCipher" + "(" + replaceF + ", " + replaceT + ")";
    }

    /*
   @param other Object, is the other object presumably a cipher
   the equals method finds out if the WordReplacementCipher and another WordReplacementCipher are equal.
   @return boolean true if the two objects are equal and false otherwise.
    */
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        } else if (other == null) {
            return false;
        } else if (other instanceof WordReplacementCipher) {
            WordReplacementCipher cipher = (WordReplacementCipher) other;
            if (replaceT.equals(cipher.replaceT) && this.replaceF.equals(cipher.replaceF)) {
                return true;
            }
        }

        return false;
    }
}



