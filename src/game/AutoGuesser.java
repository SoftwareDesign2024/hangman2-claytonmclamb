package game;
// Clayton McLamb

public class AutoGuesser extends Guesser {
	// automatic guesser
	private static final String LETTERS_ORDERED_BY_FREQUENCY = "etaoinshrldcumfpgwybvkxjqz";
    private int myIndex;
	
	public AutoGuesser(int numGuesses) {
		// constructir
		super(numGuesses);
		myIndex = 0;
	}
	
	@Override
	public String createGuess() {
		// overriding how we create guess
		char myChar = LETTERS_ORDERED_BY_FREQUENCY.charAt(myIndex);
		myIndex++;
		return "" + myChar;
	}

}
