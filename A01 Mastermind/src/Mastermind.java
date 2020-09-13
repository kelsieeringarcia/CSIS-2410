package mastermind;

import java.util.ArrayList;
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
	 * increments when the code is wrong, and triggers the win when the code
	 * is broken.
	 * 
	 * @param player Instantiated player
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
				System.out.println("not quite - Give feedback here");//TODO Give Feedback
			}
			
			player.incrementCurrentTurn();

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
}
