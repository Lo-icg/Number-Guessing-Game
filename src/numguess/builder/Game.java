package numguess.builder;

import java.util.List;
import java.util.LinkedList;

import numguess.generator.Num;
import numguess.player.Player;

public class Game extends GameUtility {

	private Player player;  // player
	private int numToGuess; // number to guess
	
	// list of players who played, just to track the top player
	private List<Player> playersRecord = new LinkedList<>();
	
	private Game() {
	
		while (playing) {
			
			player = new Player();
			numToGuess = Num.generate();
			
			player.setName(returnString("Player name: "));
			Message.print1();

			player.setChoice(returnOption("Enter your choice: "));
			Message.print2(player.getChoice());

			// player guessing state
			while (player.haveChances() && player.notQuitting()) {

				player.setGuess(returnInt("Enter your guess: "));

				if (guessMatched()) {
					Message.print3(player.getAttempt());
					break;
				} else {
					giveHint();
					player.reduceChances();
				}

				// if player runs out chances
				if (!player.haveChances()) {
					
					Message.print4();
					char selection = returnChar("To continue type (y) or (n) to quit: ");

					if (selection == 'y') player.restoreChances();
					if (selection == 'n') player.quit();
				}
			}

			playersRecord.add(player);
			displayTopPlayers(playersRecord);
			
			char selection = returnChar("do you want to play again and beat the top player...\ntype (y) to play again or (n) to quit the game: ");
			if (selection == 'y') numToGuess = Num.generate();
			if (selection == 'n') playing = false;
		}
		read.close();
	}

	private boolean guessMatched() {
		var m = guessMatched(numToGuess, player.getGuess());
		if (m) player.guessMacthed();
		return m;
	}
	
	private void giveHint() {
		giveGuessHint(numToGuess, player.getGuess());
	}

	// run this program
	public static void launch() {
		new Game();
	}

}
