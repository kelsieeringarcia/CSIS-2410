package mastermind;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author czuniga10
 *
 */
public class MastermindApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Player player1 = new Player("Fred");
		int i = 0;
		
		ArrayList<Feedback> feedback = new ArrayList<Feedback>();
		System.out.println(feedback);
		System.out.println(Mastermind.convertFeedback(feedback));
	}

}
