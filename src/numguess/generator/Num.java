package numguess.generator;

import java.util.Random;

public final class Num {
	
	private int numToGuess;
	
	public int get() {
		return numToGuess;
	}
	
	public void reset() {
		numToGuess = generate(1, 100);
	}
	
	private Num(int x) {
		numToGuess = x;
	}
	
	static private int generate(int min, int max) {
		return new Random().nextInt((max - min) + 1) + min;
	}
	
	public static Num generate() {
		return new Num(generate(1, 100));
	}
	
}
