package mastermind;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Player class acts as the games codebreaker. Player has a name, currentTurn, and 
 * counts the wins v. loses. The Player class also picks the codes (enum) to break during 
 * each turn.
 * 
 * @author czuniga10
 */
public class Player {
	private String name;
	private int currentTurn;
	private int MAXTURNS = 10;
	private int wins = 0;
	private int loses = 0;
	private static ArrayList<Codes> playerPicks = new ArrayList<Codes>();
	/**
	 * Player class instantiates a new Player, and sets the name of Player. It is needed
	 * prior to being able to play the Mastermind game.
	 * 
	 * @param name Name of Player
	 */
	public Player(String name) {
		setName(name);
	}
	
	/**
	 * pickCode method allows the Player to try and break the code. The pickCode method
	 * does not allow the player to choose duplicate Codes, and it returns an ArrayList
	 * of Codes. 
	 * 
	 * @return ArrayList<Codes> returns an array list of Codes as the players
	 * 			choices to try and break the code. 
	 */
	@SuppressWarnings("resource")
	public ArrayList<Codes> pickCode() {
		Scanner input = new Scanner(System.in);
		System.out.println("Choose your codes....\n");
		int count = 0;
		ArrayList<Codes> codes = new ArrayList<>();
		
		do {
			System.out.printf("Code Peg #%d ('W','B','G','R','Y','BLK') : ",count+1);
			String userInput = input.nextLine();
			
			switch(userInput) {
				case "W":
					codes.add(Codes.WHITE);
					break;
				case "B":
					codes.add(Codes.BLUE);
					break;
				case "G":
					codes.add(Codes.GREEN);
					break;
				case "R":
					codes.add(Codes.RED);
					break;
				case "Y":
					codes.add(Codes.YELLOW);
					break;
				case "BLK":
					codes.add(Codes.BLACK);
					break;
				default:
					System.out.println("Not a valid response");
					count--;
					break;
			}
			
			count++;
			
		} while(count < 4);
		
		System.out.println("Users Choices: " + codes.toString());
		
		return codes;
	}
	
	public static void setPlayerPicks(ArrayList<Codes> playerPics) {
		playerPicks = playerPics;
	}
	
	public static ArrayList<Codes> getPlayerPicks() {
		return playerPicks;
	}
	
	/**
	 * Resets players current turn back to 1 so the player can restart the game.
	 */
	public void resetPlayerForNewGame() {
		this.currentTurn = 1;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param sets the Player name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the currentTurn
	 */
	public int getCurrentTurn() {
		return currentTurn;
	}

	/**
	 * Increments Player currentTurn
	 */
	public void incrementCurrentTurn() {
		if(this.currentTurn < this.MAXTURNS) {
			this.currentTurn++;
		} else {
			System.out.println("Max Turns reached - Game Over -  You Lose");
			this.incrementLoses();
			Mastermind.gameOver = true;
		}
	}
	
	/**
	 * @return the currentTurn
	 */
	public int getMaxTurns() {
		return MAXTURNS;
	}

	/**
	 * @return the wins
	 */
	public int getWins() {
		return wins;
	}

	/**
	 * Increments Player wins
	 */
	public void incrementWins() {
		wins++;
	}

	/**
	 * @return the loses
	 */
	public int getLoses() {
		return loses;
	}

	/**
	 * Increments Player loses
	 */
	public void incrementLoses() {
		loses++;
	}
	
}