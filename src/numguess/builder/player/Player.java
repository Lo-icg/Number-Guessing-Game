package numguess.builder.player;

public class Player {

	private String name;
	private int chances;
	private int attempt;
	private int guess;
	private Difficulty choice;
	
	public int getAttempt() {
		return attempt;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void reduceChances() {
		chances--;
	}
	public int getChances() {
		return chances;
	}
	public Difficulty getChoice() {
		return choice;
	}
	public void setChoice(int choice) {
		switch (choice) {
		case 1:
			this.choice = Difficulty.EASY;
			chances = 10;
			break;
		case 2:
			this.choice = Difficulty.MEDIUM;
			chances = 5;
			break;
		case 3:
			this.choice = Difficulty.HARD;
			chances = 3;
		}
	}	
	public int getGuess() {
		return guess;
	}
	public void setGuess(int guess) {
		this.guess = guess;
		attempt++;
	}

	public enum Difficulty {
		EASY, MEDIUM, HARD;
	}


	private boolean playing = true;

	public boolean notQuitting() {
		return playing;
	}
	public void quit() {
		playing = false;
	}

	public boolean haveChances() {
		return chances != 0;
	}

	public void restoreChances() {
		switch (choice) {
		case EASY -> chances = 10;
		case MEDIUM -> chances = 5;
		case HARD -> chances = 3;
		}
	}

	private boolean guessed;

	public boolean hasGuessed() {
		return guessed = true;
	}
	
	public boolean beenGuessed() {
		return guessed;
	}
	
	public Player() {
		setName("unknown");
	}

}
