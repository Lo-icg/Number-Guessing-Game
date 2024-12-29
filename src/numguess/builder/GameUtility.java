package numguess.builder;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.function.Consumer;

import numguess.builder.player.Player;

class GameUtility {
	
	protected boolean playing = true;
	protected Consumer<String> print = System.out::print; // just a custom System.out.print
	private Scanner read = new Scanner(System.in);
	
	protected int returnOption(String label) {
		while (true) {
			int o = returnValue(label);
			if (o == 1 || o == 2 || o == 3) return o;
			else System.out.println("Invalid option\n");
		}
	}
	
	protected int returnValue(String label) {
		
		var valid = false;
		int i;
		System.out.print(label);
		do {
			try {
				i = read.nextInt();
				read.nextLine();
				return i;
			} catch (InputMismatchException e) {
				read.nextLine();
				System.out.println("Invalid input\n");
				System.out.print(label);
			} 
		} while (!valid);
		return 0;
	}
	
	protected String returnValues(String label) {
		System.out.print(label);
		return read.nextLine();
	}
	
	protected boolean guessMatched(int x, int y) {
		return x == y;
	}
	
	protected void giveGuessHint(int numToGuess, int playerGuess) {
		if (numToGuess < playerGuess) System.out.println("Incorrect! The number is less than " + playerGuess + ".\n");
		if (numToGuess > playerGuess) System.out.println("Incorrect! The number is greater than " + playerGuess + ".\n");
	}
	
	protected char prompt(String label) {
		
		var valid = false;
		char o = 'n';
		System.out.print(label);
		do {
			try {
				o = read.next().toLowerCase().charAt(0);
				read.nextLine();
				
				if (o == 'y' || o == 'n') {
					System.out.println();
					return o;
				}
				else System.out.print("Invalid input. type y to play again or n to quit: ");
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		} while (!valid);
		return o;
	}
	
	
}
