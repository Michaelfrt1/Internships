/*Class EncryptUtils encrypts and decrypts multiple different ciphers stemming from the baseCipher class at one time.*/
public class EncryptUtils {

    /*
    @param BaseCipher cipher, and String[] messageArr.
    @param String[] messageArr.
    encrypts each message in the String array.
    @returns String[] the encrypted messages.
    */
    public static String[] encryptMany(BaseCipher cipher, String[] messagesArr) {
        String[] encryptMess = new String[messagesArr.length];
        for (int i = 0; i < messagesArr.length; i++) {
            encryptMess[i] = cipher.encrypt(messagesArr[i]);
        }
        return encryptMess;
    }

    /*
    @param BaseCipher cipher.
    @param String[] messageArr.
    decrypts each message in the String array.
    @returns String[] the decrypted messages.
    */
    public static String[] decryptMany(BaseCipher cipher, String[] messagesArr) {
        String[] decryptMess = new String[messagesArr.length];
        for (int i = 0; i < messagesArr.length; i++) {
            decryptMess[i] = cipher.decrypt(messagesArr[i]);
        }
        return decryptMess;
    }

}

