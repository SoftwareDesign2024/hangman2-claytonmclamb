import game.AutoGuesser;
import game.CheatingExecutioner;
import game.Executioner;
import game.Guesser;
import game.HangmanGame;
import game.HangmanGameAutoGuesser;
import game.HangmanGameCheatingComputer;
import util.HangmanDictionary;


/**
 * This class launches the Hangman game and plays once.
 * 
 * @author Michael Hewner
 * @author Mac Mason
 * @author Robert C. Duvall
 * @author Shannon Duvall
 * Clayton McLamb
 */
public class Main {
    public static final String DICTIONARY = "data/lowerwords.txt";
    public static final int NUM_LETTERS = 6;
    public static final int NUM_MISSES = 8;


    public static void main (String[] args) {
    	Guesser guesser = new AutoGuesser(NUM_MISSES);
    	Executioner executioner = new CheatingExecutioner(new HangmanDictionary(DICTIONARY), NUM_LETTERS);
    	new HangmanGame(executioner, guesser).play();
//        new HangmanGameInteractiveGuesser(new HangmanDictionary(DICTIONARY), NUM_LETTERS, NUM_MISSES).play();
//        new HangmanGameAutoGuesser(new HangmanDictionary(DICTIONARY), NUM_LETTERS, NUM_MISSES).play();
//    	new HangmanGameCheatingComputer(new HangmanDictionary(DICTIONARY), NUM_LETTERS, NUM_MISSES).play();
    }
}
