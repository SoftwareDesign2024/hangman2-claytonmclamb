package game;

import util.ConsoleReader;
import util.DisplayWord;
import util.HangmanDictionary;


/**
 * This class represents the traditional word-guessing game Hangman
 * that plays interactively with the user.
 *
 * @author Robert C. Duvall
 * @author Shannon Duvall
 */
public class HangmanGame {
	public Guesser guesser;
	public Executioner executioner;
	
    /**
     * Create Hangman game with the given dictionary of words to play a game with words 
     * of the given length and giving the user the given number of chances.
     */
    public HangmanGame (HangmanDictionary dictionary, int wordLength, int numGuesses) {
    	executioner = new Executioner(dictionary, wordLength);
    	guesser = new AutoGuesser(numGuesses);
    }
    
    public HangmanGame (Executioner e, Guesser g) {
    	executioner = e;
    	guesser = g;
    }

    /**
     * Play one complete game.
     */
    public void play () {
        boolean gameOver = false;
        while (!gameOver) {
            printStatus();
//            System.out.println(executioner.getSecretWord());
            String guess = guesser.createGuess();
            if (guess.length() == 1 && Character.isAlphabetic(guess.charAt(0))) {
                guesser.makeGuess(guess.toLowerCase().charAt(0), executioner);
                if (isGameLost()) {
                    System.out.println("YOU ARE HUNG!!!");
                    gameOver = true;
                }
                
                else if (isGameWon()) {
                    System.out.println("YOU WIN!!!");
                    gameOver = true;
                }
            }
            else {
                System.out.println("Please enter a single letter ...");
            }
        }
        System.out.println("The secret word was " + executioner.getSecretWord());
    }
    // Returns true only if the guesser has guessed all letters in the secret word.
    private boolean isGameWon () {
        return executioner.isDisplayComplete();
    }

    // Returns true only if the guesser has used up all their chances to guess.
    private boolean isGameLost () {
        return guesser.zeroGuessesLeft();
    }

    // Print game stats
    private void printStatus () {
        System.out.println(executioner.getDisplayWord());
        System.out.println("# misses left = " + guesser.getGuessesLeft());
        System.out.println("letters not yet guessed = " + guesser.getLettersLeft());
        // NOT PUBLIC, but makes it easier to test
        //System.out.println("*** " + mySecretWord);
        System.out.println();
    }
}
