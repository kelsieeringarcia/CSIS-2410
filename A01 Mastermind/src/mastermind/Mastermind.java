package mastermind;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * The Mastermind Class does not have a constructor, but it is the "brain" of the entire
 * game. Mastermind has a method playGame() that takes a Player as a parameter, and runs
 * through each player's choice to try and break the code. 
 * 
 * @author czuniga10
 *
 */
public class Mastermind {
	private static ArrayList<Codes> codeToBreak;
	public static boolean gameOver;
	
	/**
	 * playGame() method resets the player's game prior to starting a new game,
	 * then runs through each player's chance to try and break the code, 
	 * increments when the code is wrong, gives the player feedback, and triggers 
	 * the win if/when the code is broken.
	 * 
	 * @param player      Instantiated player
	 */
	public static void playGame(Player player) {
		resetGame(player);
		setCodeToBreak(createCodeToBreak());
		
		while(!gameOver) {
			ArrayList<Codes> playersChoices = new ArrayList<>();
			
			playersChoices = player.pickCode();
			
			if(playersChoices.equals(codeToBreak)) {
				System.out.println("win");
				gameOver = !gameOver;
				player.incrementWins();
				System.out.println(player.getWins());
			} else {
				giveFeedback(playersChoices);
				player.incrementCurrentTurn();
			}
		}
	}
	
	private static ArrayList<Codes> createCodeToBreak() {
		Random rand = new Random();
		ArrayList<Integer> used = new ArrayList<>();
		ArrayList<Codes> randomCode = new ArrayList<>();
		int count = 1;
		
		while(count <= 4) {
			int randPick = rand.nextInt(6) + 1;
			
			while(used.contains(randPick)) {
				randPick = rand.nextInt(6) + 1;
			}
			
			used.add(randPick);
			
			switch(randPick) {
				case 1:
					randomCode.add(Codes.WHITE);
					break;
				case 2:
					randomCode.add(Codes.YELLOW);
					break;
				case 3:
					randomCode.add(Codes.BLUE);
					break;
				case 4:
					randomCode.add(Codes.GREEN);
					break;
				case 5:
					randomCode.add(Codes.RED);
					break;
				case 6:
					randomCode.add(Codes.BLACK);
					break;
			}
			
			count++;
		}
		System.out.println(randomCode);
		return randomCode;
	}
	
	private static void setCodeToBreak(ArrayList<Codes> codes) {
		codeToBreak = codes;
	}
	
	private static void resetGame(Player player) {
		player.resetPlayerForNewGame();
		gameOver = false;
	}
	
	private static ArrayList<Feedback> giveFeedback(ArrayList<Codes> playerCodes) {
		ArrayList<Feedback> feedback = new ArrayList<>();
		for(Codes el : playerCodes) {
			if(el.equals(codeToBreak.get(playerCodes.indexOf(el)))) {
				feedback.add(Feedback.BLACK);
			} else if(codeToBreak.contains(el)) {
				feedback.add(Feedback.WHITE);
			}
		}

		Collections.sort(feedback);
		System.out.println("Feedback: " + feedback);

		return feedback;
	}
}
