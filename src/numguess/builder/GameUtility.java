package numguess.builder;

import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import numguess.player.Player;

public class GameUtility {

	protected boolean playing = true;
	protected Scanner read = new Scanner(System.in);

	// return integer literal
	protected int returnInt(String label) {

		System.out.print(label);
		do {
			try {
				var in = read.nextInt();
				read.nextLine();
				return in;
			} catch (InputMismatchException e) {
				read.nextLine();
				System.out.print("Invalid input\n" + label);
			} 
		} while (true);
	}

	// return either 1, 2 or 3 literal
	protected int returnOption(String label) {
		while (true) {
			int i = returnInt(label);
			if (i == 1 || i == 2 || i == 3) return i;
			else System.out.println("Invalid option\n");
		}
	}

	// return String literal
	protected String returnString(String label) {
		System.out.print(label);
		return read.nextLine();
	}

	// return character literal
	protected char returnChar(String label) {

		char v;
		System.out.print(label);
		do {
			v = read.next().toLowerCase().charAt(0);
			read.nextLine();

			if (v == 'y' || v == 'n') break;
			else System.out.print("Invalid input. type y to play again or n to quit: ");

		} while (true);

		System.out.println();
		return v;
	}

	protected boolean guessMatched(int x, int y) {
		return x == y;
	}

	protected void giveGuessHint(int numToGuess, int playerGuess) {
		if (numToGuess < playerGuess) System.out.println("Incorrect! The number is less than " + playerGuess + ".\n");
		if (numToGuess > playerGuess) System.out.println("Incorrect! The number is greater than " + playerGuess + ".\n");
	}

	protected void displayTopPlayers(List<Player> players) {

		Optional<Player> topPlayer = Optional.ofNullable(players.stream()
				.filter(p -> p.hasGuessed())
				.min(Comparator.comparingInt(Player::getAttempt)).orElse(null));

		String record = null;
		String borderLine = null;

		if (topPlayer.isPresent()) {

			record =
					"| Player: " + topPlayer.get().getName()
					+ " | Num of attempt: "+ topPlayer.get().getAttempt()
					+ " | Mode: " + topPlayer.get().getChoice() + " |";

			borderLine = "-".repeat(record.length());

		} else {
			record = "| None |";
			borderLine = "-".repeat(record.length());
		}

		System.out.println("\nTop player ->");
		System.out.println(borderLine);
		System.out.println(record);
		System.out.println(borderLine);
		System.out.println();
	}

	public enum Difficulty {
		EASY, MEDIUM, HARD;
	}
}
