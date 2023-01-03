/**
 * @Author Kluver 2022 All rights reserved.
 */
public class LetterSample {
    /**
     * This char represents the "end of string" It will be added in the toSamples function and you'll need to use it in
     * your Gibberisher algorithm.
     */
    public static final char STOP = '.';

    private String segment;
    private char nextLetter;

    /**
     * Constructor -- takes the segment and nextLetter values.
     * These cannot be changed after construction.
     *
     * Each sample represents a small example of english text. The segment is a series of letters we saw in a real word
     * and the nextLetter is what letter we saw following it (or STOP to indicate it was the end of the word!)
     */
    public LetterSample(String segment, char nextLetter) {
        this.segment = segment;
        this.nextLetter = nextLetter;
    }

    public String getSegment() {
        return segment;
    }

    public char getNextLetter() {
        return nextLetter;
    }

    @Override
    public String toString() {
        return '"'+segment+"\" -> "+nextLetter;
    }

    /**
     * Takes a string and generates samples for the Gibberisher class's train method.
     * Each sample here represents a small segment of english text, and what letter tends to
     * follow it.
     * @param input the word to split into samples. This is assumed to be "clean" (free of punctuation etc.)
     * @param segmentSize the size of samples to generate.
     * @return an array of Letter samples indicating, for each letter in the string, which letters preceeded it.
     */
    public static LetterSample[] toSamples(String input, int segmentSize) {
        input += STOP;

        LetterSample[] retVal = new LetterSample[input.length()];
        for (int i = 0; i < input.length(); i++) {
            int segmentLength = Math.min(i, segmentSize);
            String segment = input.substring(i-segmentLength, i);
            char nextLetter = input.charAt(i);
            retVal[i] = new LetterSample(segment, nextLetter);
        }
        return retVal;
    }
}
