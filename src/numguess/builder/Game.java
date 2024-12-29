package numguess.builder;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import numguess.builder.player.Player;
import numguess.generator.Num;

public class Game extends GameUtility {

	private Player player;
	private Num numToGuess;
	
	private Game() {
	
		while (playing) {
			
			player = new Player();
			numToGuess = Num.generate();
			
			player.setName(returnValues("Player name: "));
			Message.print1();

			player.setChoice(returnOption("Enter your choice: "));
			Message.print2(player.getChoice());

			// player guessing state
			while (player.haveChances() && player.notQuitting()) {

				player.setGuess(returnValue("Enter your guess: "));

				if (guessMatched()){
					Message.print3(player.getAttempt());
					break;
				} else {
					giveHint();
					player.reduceChances();
				}

				// if player runs out chances
				if (!player.haveChances()) {
					Message.print4();
					
					char selection = prompt("To continue type y or n to quit: ");

					if (selection == 'y') player.restoreChances();
					if (selection == 'n') player.quit();
				}
			}

			playersRecord.add(player);
			displayTopPlayers();
			
			char selection = prompt("do you want to play again, type y or n to quit the game: ");
			if (selection == 'y') numToGuess.reset();
			if (selection == 'n') playing = false;
		}
		
	}

	private List<Player> playersRecord = new LinkedList<>();

	private void displayTopPlayers() {

		Optional<Player> topPlayer = Optional.of(playersRecord.stream()
				.filter(p -> p.beenGuessed())
				.min(Comparator.comparingInt(Player::getAttempt)).orElse(new Player()));
		
		if (topPlayer.get().beenGuessed()) {
			
			var borderline = "-".repeat(topPlayer.get().getName().length() + 30);
			var record = "Player| " + topPlayer.get().getName() + " | Num of attempt| " + topPlayer.get().getAttempt() + " |";
			System.out.println("\nTop player -> ");
			System.out.println(borderline);
			System.out.println(record);
			System.out.println(borderline);
			
		} else {
			System.out.println("Top player -> ");
			System.out.println("--------");
			System.out.println("| None |");
			System.out.println("--------");
		}
		System.out.println();
	}
	
	private boolean guessMatched() {
		var m = guessMatched(numToGuess.get(), player.getGuess());
		if (m) player.hasGuessed();
		return m;
	}
	
	private void giveHint() {
		giveGuessHint(numToGuess.get(), player.getGuess());
	}

	public static void launch() {
		new Game();
	}

}
