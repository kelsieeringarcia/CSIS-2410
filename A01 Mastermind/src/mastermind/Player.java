package mastermind;

import java.util.ArrayList;

/**
 * Player class acts as the games codebreaker. Player has a name, currentTurn, and 
 * counts the wins v. loses. The Player class also picks the codes (enum) to break during 
 * each turn.
 * 
 * @author czuniga10
 */
public class Player {
	private String name;
	private static int MAXTURNS = 10;
	private static int wins = 0;
	private static int loses = 0;
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
	
	public static void setPlayerPicks(ArrayList<Codes> playerPics) {
		playerPicks = playerPics;
	}
	
	public static ArrayList<Codes> getPlayerPicks() {
		return playerPicks;
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
	public static int getMaxTurns() {
		return MAXTURNS;
	}

	/**
	 * @return the wins
	 */
	public static int getWins() {
		return wins;
	}

	/**
	 * Increments Player wins
	 */
	public static void incrementWins() {
		wins++;
	}

	/**
	 * @return the loses
	 */
	public static int getLoses() {
		return loses;
	}

	/**
	 * Increments Player loses
	 */
	public static void incrementLoses() {
		loses++;
	}
	
}