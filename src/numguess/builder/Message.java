package numguess.builder;

import numguess.builder.GameUtility.Difficulty;

final class Message {

	public static void print1() {
		var msg1 = "\nWelcome to the Number Guessing Game!\n"
				+ "I'm thinking of a number between 1 and 100.\n"
				+ "You have 5 chances to guess the correct number.\n\n"

				+ "Please select the difficulty level:\n"
				+ "1. Easy   (10 chances)\n"
				+ "2. Medium (5 chances)\n"
				+ "3. Hard   (3 chances)\n";
		System.out.println(msg1);
	}

	public static void print2(Difficulty d) {
		var s  = d.toString().charAt(0) +  d.toString().toLowerCase().substring(1, d.toString().length());
		System.out.println("\nGreat! You have selected the "+ s + " difficulty level.\n"
				+ "Let's start the game!\n");
	}

	public static void print3(int attempt) {
		System.out.println("\nCongratulations! You guessed the correct number in " + attempt + " attempts.");
	}
	
	public static void print4() {
		System.out.println("Your remaning guess chances is already run out.\n");
	}
}
