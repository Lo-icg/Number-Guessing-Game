package numguess.generator;

import java.util.Random;

public final class Num {
	
	static private int generate(int min, int max) {
		return new Random().nextInt((max - min) + 1) + min;
	}
	
	static public int generate() {
		return (generate(1, 100)); // inclusive range
	}
	
}
