/**
 * This class represents a bag of all the letters from the alphabet and a period.
 * The class can add remove get count get size and toString as well as get a random letter from the bag.
 * Similar to a lot of ADTs.
 */

import java.util.Random;
public class CharBag {

    private char[] charBag;
    private int size;
    private int[] countChar;

    /**
     * Constructor
     * initializes the charBag to contain all the letter elements and a period.
     * initializes the size of the bag to be zero.
     * initializes the counting of the letters array to be empty but hold 27 spots, one for each letter.
     * countChar counts how many times a letter shows up in the array.
     */
    public CharBag() {
        charBag = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '.'};
        size = 0;
        countChar = new int[27];
    }



    /**
     * Traversal char is used to add to the count at the appropriate index and size of the charBag.
     * @param c char
     */
    public void add(char c) {
        size++;
        countChar[traversalChar(c)]++;
    }

    /**
     * The function remove checks if the counterChar array at a specific index isn't equal to zero.
     * Traversal char is used to remove the count at the appropriate index and decrease size of the charBag by one.
     * @param c char
     */
    public void remove(char c) {
        if (countChar[traversalChar(c)] != 0) {
            size--;
            countChar[traversalChar(c)]--;
        }
    }

    /**
     * Uses teh traversalChar helper function to get the appropriate count of the letter.
     * @param c char
     * @return counts how many of a specific letter are in the array, type ints.
     */
    public int getCount(char c) {
        return countChar[traversalChar(c)];
    }

    /**
     * @return the size of the array, type int.
     */
    public int getSize() {
        return size;
    }

    /**
     * This function creates a new string so that CharBag can be readable.
     * The string is different according to how many items are in the bag, for example commas will be added if their are more items.
     * @return retVal, the new String with readable data, type String.
     */
    public String toString() {
        String retVal = "CharBag{";
        for (int i = 0; i < charBag.length; i++) {
            retVal += charBag[i] + ":" + getCount(charBag[i]);
            if (i < charBag.length - 1) {
                retVal += ", ";
            }
        }
        if (size != 0) {
            retVal = retVal.substring(0, retVal.length());
        }
        retVal += "}";
        return retVal;
    }

    /**
     * If the char bag is empty it will return '.'.
     * Uses import Random to select a random char from the bag.
     * @return a random Char from charBag using the random function, type char.
     */
    public char getRandomChar() {
        int sum = 0;
        for (int count : countChar) {
            sum += count;
        }
        if (sum == 0) {
            return LetterSample.STOP;
        }
        int r = new java.util.Random().nextInt(sum);
        for (int i = 0; i < 27; i++) {
            if (r < countChar[i]) {
                return charBag[i];
            }
            r -= countChar[i];
        }
        return LetterSample.STOP;
    }

    /**
     * turns the letter to a lowercase c.
     * Checks if the letter is
     * @param c char
     * @return the index of the where the letter passed in was located.
     */
    public int traversalChar(char c) {
        if (Character.isAlphabetic(c) == false) {
            c = LetterSample.STOP;
        }
        c = Character.toLowerCase(c);
        for (int i = 0; i < charBag.length; i++) {
            if (c == charBag[i]) {
                return i;
            }
        }
        return -1;
    }

}
