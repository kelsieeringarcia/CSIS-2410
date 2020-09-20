package mastermind;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * The Mastermind Class does not have a constructor, but it is the "brain" of the entire
 * game. Mastermind has a method playGame() that takes a Player as a parameter, and runs
 * through each player's choice to try and break the code. 
 * 
 * @author Chad Zuniga & Kelsie Garcia
 *
 */
public class Mastermind {
	private static ArrayList<Codes> codeToBreak;
	
	/**
	 * Given the players choices from the GUI, the checkForCodeBreak method checks
	 * to see if the player has won, or it will send a string back with the correct
	 * Feedback in order to produce the Feedback PNG image.
	 * 
	 * @param 		playerCodes provided by Board Class
	 * @return		String used to provide Feedback via Board Class
	 */
	public static String checkForCodeBreak(ArrayList<Codes> playerCodes) {
		String feedback = "";
		if(playerCodes.equals(codeToBreak)) {
			feedback = "BBBB";
		} else {
			feedback = convertFeedback(giveFeedback(playerCodes));
		}
		
		return feedback;
	}
	
	/**
	 * createCodeToBreak() initialized the game with the Code that needs to be broken
	 * by the user. It is called as the first method from the Board Class and acts as
	 * the "Computers" choices.
	 */
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
		
		//Printing winning code so we can show a win for Presentation.
		System.out.println("Winning Code: " + randomCode);
		
		setCodeToBreak(randomCode);
	}
	
	private static void setCodeToBreak(ArrayList<Codes> codes) {
		codeToBreak = codes;
	}
	

	private static ArrayList<Feedback> giveFeedback(ArrayList<Codes> playerCodes) {
		ArrayList<Codes> copyCodeToBreak = getCodeToBreak();
		ArrayList<Feedback> feedback = new ArrayList<>();

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

		return feedback;
	}
	
	private static String convertFeedback(ArrayList<Feedback> feedback) {
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
		
		return sb.toString();
	}
	
	private static ArrayList<Codes> getCodeToBreak() {
		ArrayList<Codes> code = new ArrayList<Codes>();
		code.addAll(codeToBreak);
		return code;
	}
}
