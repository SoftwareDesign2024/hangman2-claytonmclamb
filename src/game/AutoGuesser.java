package game;

public class AutoGuesser extends Guesser {
	private static final String LETTERS_ORDERED_BY_FREQUENCY = "etaoinshrldcumfpgwybvkxjqz";
    private int myIndex;
	
	public AutoGuesser(int numGuesses) {
		super(numGuesses);
		myIndex = 0;
	}
	
	@Override
	public String createGuess() {
		char myChar = LETTERS_ORDERED_BY_FREQUENCY.charAt(myIndex);
		myIndex++;
		return "" + myChar;
	}

}
