/**
 * Michael Ginzburg
 * CSCI 1913
 */

/**
 *This class constructs an algorithm that randomly generates words.
 * This class uses all the previous classes that I made.
 */
public class Gibberisher {
    private Trie<CharBag> tCharBag;
    private int segLength;
    private int letterCount;

    /**
     * constructor that initializes the private variables.
     * @param segLength the length of the word type int.
     */
    public Gibberisher(int segLength) {
        tCharBag = new Trie<>();
        this.segLength = segLength;
        letterCount = 0;
    }

    /**
     *The train class takes words from the Dictionary class and forms them into Strings the length of the wordLength.
     * stores the new Strings into the data type CharBag which was created.
     * creates a new charBag if the sample for the segment is new.
     * Add letters to the charBag.
     * @param input, an array of Strings that is used by the class LetterSample.
     */
    public void train(String[] input) {

        for (String word : input) {
            LetterSample[] samples = LetterSample.toSamples(word, word.length());
            for (LetterSample sample : samples) {
                CharBag charBag = tCharBag.get(sample.getSegment());

                if (charBag == null) {
                    charBag = new CharBag();
                    tCharBag.put(sample.getSegment(), charBag);
                }

                charBag.add(sample.getNextLetter());
                letterCount++;
            }
        }
    }


    /**
     * @return the amount of samples made by the train function
     */
    public int getSampleCount() {
        return letterCount;
    }

    /**
     * This function uses the RandomChar method from the class CharBag to make the letter generation random.
     * @returns a word based of the train method used earlier.
     */
    public String generate() {
        StringBuilder sb = new StringBuilder();
        String segment = "";
        while (true) {
            CharBag charBag = tCharBag.get(segment);
            if (charBag == null) {
                break;
            }
            char nextChar = charBag.getRandomChar();
            if (nextChar == '.') {
                break;
            }
            sb.append(nextChar);
            segment += nextChar;
        }
        return sb.toString();
    }

}







