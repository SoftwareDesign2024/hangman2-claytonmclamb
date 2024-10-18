package game;
// Author - Clayton McLamb

import util.DisplayWord;
import util.HangmanDictionary;

public class Executioner {
	//what is shown to user
	protected DisplayWord myDisplayWord;
    // word that is being guessed
    protected String mySecretWord;
    
    public Executioner(HangmanDictionary dictionary, int wordLength) {
    	// constructor for executioner object
    	mySecretWord = makeSecretWord(dictionary, wordLength);
    	myDisplayWord = new DisplayWord(mySecretWord);
    }
    
    // Returns true only if given guess is in the secret word.
    public boolean checkGuessInSecret(char guess) {
        if (mySecretWord.indexOf(guess) >= 0) {
            myDisplayWord.update(guess, mySecretWord);
            return true;
        }
        return false;
    }
    
    // Returns a secret word.
    public String makeSecretWord (HangmanDictionary dictionary, int wordLength) {
        return dictionary.getRandomWord(wordLength).toLowerCase();
    }
    
    public boolean isDisplayComplete() {
    	// returns true if game is done
    	String display = myDisplayWord.toString().replace(" ", "");
    	return display.equals(mySecretWord);
    }
        
    public String getSecretWord(){
    	// returns the secret word
    	return mySecretWord;
    }
    
    public DisplayWord getDisplayWord() {
    	// returns the display word
    	return myDisplayWord;
    } 
}
