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
	 * Given the players choices from the GUI, the checkForCodeBreak method checks
	 * to see if the player has won, or it will send a string back with the correct
	 * Feedback in order to produce the Feedback PNG image.
	 * 
	 * @param playerCodes
	 * @return		String 
	 */
	public static String checkForCodeBreak(ArrayList<Codes> playerCodes) {
		String feedback = "";
		if(playerCodes.equals(codeToBreak)) {
			System.out.println("win");
			Player.incrementWins();
			System.out.println(Player.getWins());
			feedback = "Win";
		} else {
			feedback = convertFeedback(giveFeedback(playerCodes));
		}
		
		return feedback;
	}
	
	public static void createCodeToBreak() {
		Random rand = new Random();
		ArrayList<Codes> randomCode = new ArrayList<>();
		int count = 1;
		
		while(count <= 4) {
			int randPick = rand.nextInt(6) + 1;
			
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
		
		setCodeToBreak(randomCode);
	}
	
	private static void setCodeToBreak(ArrayList<Codes> codes) {
		codeToBreak = codes;
	}
	
	//TODO CHAD line 129 board
	private static ArrayList<Feedback> giveFeedback(ArrayList<Codes> playerCodes) {
		ArrayList<Codes> copyCodeToBreak = getCodeToBreak();
		ArrayList<Feedback> feedback = new ArrayList<>();
		System.out.println("code to break: "+copyCodeToBreak);
		System.out.println("player picks: " +playerCodes);
		for(int i = 0; i < playerCodes.size(); i++) {
			if(playerCodes.get(i).equals(codeToBreak.get(i))) {
				feedback.add(Feedback.BLACK);
				copyCodeToBreak.set(i, Codes.NONE1);
				playerCodes.set(i, Codes.NONE2);
			}
		}
		
		for(int i = 0; i < playerCodes.size(); i++) {
			if(copyCodeToBreak.contains(playerCodes.get(i))) {
				feedback.add(Feedback.WHITE);
			}
		}
			
		
		Collections.sort(feedback);
		System.out.println("Feedback: " + feedback);

		return feedback;
	}
	
	public static String convertFeedback(ArrayList<Feedback> feedback) {
		StringBuilder sb = new StringBuilder();
		if(feedback.isEmpty()) {
			sb.append("EEEE");
		}
		
		for(int i = 0; i < feedback.size(); i++) {
			if(feedback.get(i).equals(Feedback.BLACK)) {
				sb.append("B");
			} else {
				sb.append("W");
			}
		}
		
		while(sb.length() < 4) {
			sb.append("E");
		}
		
		System.out.println(sb.toString());
		return sb.toString();
	}
	
	private static ArrayList<Codes> getCodeToBreak() {
		ArrayList<Codes> code = new ArrayList<Codes>();
		code.addAll(codeToBreak);
		return code;
	}
}
