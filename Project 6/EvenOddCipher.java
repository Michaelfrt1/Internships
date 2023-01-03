//Michael Ginzburg
//CSCI 1913

/*EvenOddCipher is a class that makes a code using the even and odd places in a string by inheriting from the BaseCipher class*/
public class EvenOddCipher extends BaseCipher {

    /*constructor initializes the object EvenOddCipher using the super reference variable.*/
    public EvenOddCipher() {
        super("Even Odd Cipher");
    }

    /*
    @param String message, text that gets encrypted.
    The encrypt method adds all the even places in the string first and all the odd places in the string second.
    @return String encryptMess, returns the encrypted String.
     */
    public String encrypt(String message) {
        String encryptMess = "";
        for (int i = 0; i < message.length(); i += 2) {
            encryptMess += message.charAt(i);
        }
        for (int i = 0; i < message.length() - 1; i += 2) {
            encryptMess += message.charAt(i + 1);
        }
        return encryptMess;

    }

    /*
    @param String message, text that gets decrypted.
    The decrypted method divides the message in half and places the odd positioned chars in the first position than even then odd etc.
    @return String decryptMess, returns the decrypted String.
     */
    public String decrypt(String message) {
        int messMid = (message.length() + 1) / 2;
        String firstH = message.substring(0, messMid);
        String secH = message.substring(messMid);

        int firstHCount = 0;
        int secondHCount = 0;
        String decryptMess = "";

        for (int i = 0; i < message.length(); i++) {
            if (i % 2 == 1) {
                decryptMess += secH.charAt(secondHCount);
                secondHCount++;
            } else if (i % 2 == 0) {
                decryptMess += firstH.charAt(firstHCount);
                firstHCount++;
            }
        }
        return decryptMess;
    }

    /* @returns String "EvenOddCipher" */
    public String toString() {
        return "EvenOddCipher";
    }

    /*
    @param other Object, is the other object presumably a cipher
    the equals method finds out if the EvenOddCipher and another EvenOddCipher are equal.
    @return boolean true if the two objects are equal and false otherwise.
     */
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        } else if (other == null) {
            return false;
        } else if (other instanceof EvenOddCipher) {
            return true;
        }
        return false;
    }
}

