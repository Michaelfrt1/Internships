mport java.util.Random;
import java.util.Scanner;

/**
 * This class represents a reusable menu system which can be used with multiple classes
 */
public class GameGrabber {
    // the games
    private Game[] games;
    // the Scanner for interacting with the user.
    private Scanner user;

    /**
     * Create a new Game menu for the list of games, using the provided
     * Scanner for interacting with the user.
     */
    public GameGrabber(Game[] games, Scanner user) {
        this.games = games;
        this.user = user;
    }

    /**
     * The primary menu function -- call this to start the fun!
     */
    public void doMenu() {
        Game pick;
        do { // loop until "exit" choice.
            pick = pickGame();
            if (pick != null) {
                pick.play(user);
            }
        } while (pick != null);
        System.out.println("goodbye");
    }

    /**
     * Private helper function -- picks the game and returns it.
     *
     * @return
     */
    private Game pickGame() {
        printMenu();
        int pick;
        do {
            System.out.print("Pick a game (0-" + games.length + ") ");
            pick = user.nextInt();
        } while (pick < 0 || pick > games.length);
        if (pick == games.length) {
            return null;
        } else {
            return games[pick];
        }
    }

    /**
     * Helper function -- print the menu.
     */
    private void printMenu() {
        for (int i = 0; i < games.length; i++) {
            System.out.println("" + i + ") " + games[i].getName());
        }
        System.out.println("" + games.length + ") Quit");
    }

    public static void main(String[] args) {
        Random rng = new Random();
        GameGrabber grabber = new GameGrabber(new Game[]{
                new MathTestGame(rng, 1, 10, '+'),
                new MathTestGame(rng, 1, 10, '*'),
                new MathTestGame(rng, 1, 10, '-'),
                new MathTestGame(rng, 1, 10, '/'),
                new Hangman(new WordsList(rng), 4, 7, 14),
                new NumberGuesser(rng, 20, 5)
        }, new Scanner(System.in));
        grabber.doMenu();
    }
}
