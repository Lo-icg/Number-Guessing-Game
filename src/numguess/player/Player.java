package numguess.player;

import numguess.builder.GameUtility.Difficulty;

public class Player {

	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	private Difficulty choice;
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
	
	private int guess;
	public int getGuess() {
		return guess;
	}
	public void setGuess(int guess) {
		this.guess = guess;
		attempt++;
	}
	
	private int chances;
	public int getChances() {
		return chances;
	}
	public void reduceChances() {
		chances--;
	}
	public boolean haveChances() {
		return chances != 0;
	}
	public void restoreChances() {
		switch (this.choice) {
		case EASY -> chances = 10;
		case MEDIUM -> chances = 5;
		case HARD -> chances = 3;
		}
	}
	
	private int attempt;
	public int getAttempt() {
		return attempt;
	}
	
	private boolean playing = true;
	public boolean notQuitting() {
		return playing;
	}
	public void quit() {
		playing = false;
	}

	private boolean guessed = false;
	public boolean guessMacthed() {
		return guessed = true;
	}
	public boolean hasGuessed() {
		return guessed;
	}
	
	public Player() {}
	
}
