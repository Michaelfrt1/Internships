import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Dictionary {
    /**
     * Get the words stored in words.txt
     * EAch word will be "cleaned" -- meaning we will convert it to lowercase and remove any non-alphabetic letter.
     * Generally you should put the words.txt file in the project folder, but NOT in the src folder.
     */
    public static String[] getWords() {
        // making a scanner from a file. Some new syntax but NBD
        Scanner scan = null;
        try {
            scan = new Scanner(new FileInputStream("words.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
            // If you are getting this error the words file isn't where it's expected to be.
        }

        // OK, so I'm using a list here. So sue me. You shouldn't use one.
        List<String> words = new ArrayList<>();
        while(scan.hasNext()) {
            words.add(cleanup(scan.next()));
        }

        // yeah this one is a bit confusing to me too. But that's how java says to call the function, and who am I to argue
        return words.toArray(new String[0]);

    }

    private static String cleanup(String input) {
        input = input.toLowerCase();
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (Character.isAlphabetic(c)) {
                output.append(c);
            }
        }
        return output.toString();
    }

    public static void main(String[] args) {
        // This serves as the dictionary file's test. It might seem weird to have a test for the dictionary file, but, if this doesn't work a lot of other things will fail.
        // Therefore, I figured we should have a way to confirm correctness.
        String[] words = getWords();
        System.out.println(words.length);
        for (int i = 0; i < words.length; i += words.length/15) {
            System.out.println("\"" + words[i] + "\"");
        }
    }
    /*
62876
"Aachen"
"Marrakesh"
"alarming"
"bouquets"
"concave"
"diminishes"
"facade"
"hallmarking"
"iodizes"
"misbehave"
"patellae"
"quizzes"
"scragglier"
"stipulating"
"tummies"
"zoological"
     */
}
