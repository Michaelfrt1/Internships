import java.util.Arrays;

/*The SuperCipher class inherits from BaseCipher class in order to decrypt many ciphers*/
public class SuperCipher extends BaseCipher {
    private BaseCipher[] cipherArr;

    /*
    @param BaseCipher[] ciphersArr
    constructor initializes the object SuperCipher using the super reference variable.
    */
    public SuperCipher(BaseCipher[] ciphersArr) {
        super("Super Cipher");
        this.cipherArr = ciphersArr;
    }

    /*
    The isValid method checks to make sure that each Base cipher is valid
    @return true if valid, otherwise return false.
     */
    public boolean isValid() {
        for (int i = 0; i < cipherArr.length; i++) {
            if (!cipherArr[i].isValid()) {
                return false;
            }
        }
        return true;
    }

    /*
    @param String message, text that gets encrypted.
    The encrypt method uses the encrypt method from the BaseCipher class to encrypt the many ciphers.
    @return String encryptMess, returns the encrypted String.
     */
    public String encrypt(String message) {
        String encryptMess = this.cipherArr[0].encrypt(message);
        for (int i = 0; i < this.cipherArr.length - 1; i++) {
            encryptMess = this.cipherArr[i + 1].encrypt(encryptMess);
        }
        return encryptMess;
    }

    /*
    @param String message, text that gets decrypted.
    Does the same thing as the function above but in reverse order in order to decrypt the message.
    @return String decryptMess, returns the decrypted String.
    */
    public String decrypt(String message) {
        String decryptMess = this.cipherArr[1].decrypt(message);
        for (int i = cipherArr.length - 1; i >= 0; i--) {
            decryptMess = this.cipherArr[i].decrypt(decryptMess);
        }
        return decryptMess;
    }

    /*
    @returns String, The String displays SuperCipher as well as which Class of cipher was used.
    */
    public String toString() {
        String cipherString = "";
        for (int i = 0; i < cipherArr.length; i++) {
            cipherString += cipherArr[i].toString();
            if (cipherArr.length != 1 && i != cipherArr.length - 1) {
                cipherString += " | ";
            }
        }

        return "SuperCipher" + "(" + cipherString + ")";
    }

    /*
   @param other Object, is the other object presumably a cipher
   the equals method finds out if the SuperCipher and another SuperCipher are equal.
   @return boolean true if the two objects are equal and false otherwise.
    */
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        } else if (other == null) {
            return false;
        } else if (other instanceof SuperCipher) {
            SuperCipher othCipherArr = (SuperCipher) other;
            if (Arrays.equals(this.cipherArr, othCipherArr.cipherArr)) {
                return true;
            }
        }
        return false;
    }


}
