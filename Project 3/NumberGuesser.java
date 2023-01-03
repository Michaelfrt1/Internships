import java.util.Random;
//The NumberGuesser class is designed for people and computers to be able to play the guessing number game
//extends from the Game class

//the class contains the variable rng(type random) and the int variable maxNumber as well as int variable maxGuesses
//rng is from the class random and gets a random number. maxNumber is the highest number that rng can use
//maxGuesses will be how many guess the computer or player gets.
public class NumberGuesser extends Game {

    private Random rng;
    private int maxNumber;
    private int maxGuesses;

    //variables that are not contained in the constructor but are used later in the program
    //variables used each round
    private int secretNum;
    private int numGuess;
    private boolean won;

    //constructor containing previous mentioned variables
    public NumberGuesser(Random rng, int maxNumber, int maxGuesses) {
        this.rng = rng;
        this.maxNumber = maxNumber;
        this.maxGuesses = maxGuesses;


    }

    //the prepToPlay function starts the game
    //returns a message that inform the player what numbers the secretNum is in between and how many guesses are given.
    @Override
    protected String prepToPlay() {
        secretNum = rng.nextInt(maxNumber) + 1;
        numGuess = 0;
        won = false;
        return "I've picked a number 1 to " + maxNumber + ". You get " + maxGuesses + " guesses to guess it";

    }

    //isOver function checks if the player ran out of guesses or guessed the correct number.
    // When returns true game ends, when returns false game continues
    @Override
    protected boolean isOver() {

        return numGuess == maxGuesses || won;



    }
    //isValid function checks if the move is valid by being positive
    //also checks and make sures it's a digit
    //returns false if otherwise and true if move is valid
    @Override
    protected boolean isValid(String move) {

        if (move.charAt(0) == '-') {
            return false;
        }
        if (move.length() == 0) {
            return false;
        }
        for (int i = 0; i < move.length(); i++) {
            char c = move.charAt(i);
            if (!Character.isDigit(c)) {
                return false;
            }
        }

        return true;
    }
    /*the proccessMove function lets the player play the game by letting them guess numbers and then directing
    the player by telling them to go higher or lower simultaneously counting the number of guesses attempted.
    sets win to true if the player guesses the correct number*/
    @Override
    protected String processMove(String move) {

        int guess = Integer.parseInt(move);
        if (guess == secretNum) {
            won = true;
            return "That's it!";
        } else if (guess > secretNum) {
            won = false;
            numGuess++;
            return "Too High";

        } else {
            won = false;
            numGuess++;
            return "Too Low";
        }


    }

    //returns a string that states what the number the player was trying to guess was
    @Override
    protected String finalMessage() {
        return "The number was: " + secretNum;
    }

    // returns the name of the game
    @Override
    public String getName() {
        return "NumberGuesser";
    }

}
