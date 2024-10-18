package game;
// Author - Clayton McLamb

import util.ConsoleReader;

public class Guesser {
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    // how many guesses are remaining
    private int myNumGuessesLeft;
    // tracks letters guessed
    private StringBuilder myLettersLeftToGuess;
    
    public Guesser(int numGuesses) {
    	// constructor
    	myNumGuessesLeft = numGuesses;
    	myLettersLeftToGuess = new StringBuilder(ALPHABET);
    }
    
    // Process a guess by updating the necessary internal state.
    public void makeGuess(char guess, Executioner executioner) {
        // do not count repeated guess as a miss
    	executioner.cheat(guess);
        int index = myLettersLeftToGuess.indexOf("" + guess);
        if (index >= 0) {
            recordGuess(index);
            if (! executioner.checkGuessInSecret(guess)) {
                myNumGuessesLeft -= 1;
            }
        }
    }
    
    public String createGuess() {
    	// crates guess from input - DEFAULT behavior no auto behavior
    	String input = ConsoleReader.promptString("Make a guess: ");
    	return input;
    }
    
    // Record that a specific letter was guessed
    private void recordGuess (int index) {
        myLettersLeftToGuess.deleteCharAt(index);
    }
  
    public boolean zeroGuessesLeft() {
    	// returns true if there are zero guesses left
    	return myNumGuessesLeft == 0;
    }
    
    
    public int getGuessesLeft() {
    	// returns the number of guesses left
    	return myNumGuessesLeft;
    }
    
    public StringBuilder getLettersLeft() {
    	// returns the of letters left
    	return myLettersLeftToGuess;
    }
    


}
