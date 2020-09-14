package mastermind;

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
		
		while(i < 4) {
			Mastermind.playGame(player1);
			i++;
			System.out.printf("\n\n\n New Game!! \n\nWins: %d  Loses: %d\n\n",
					player1.getWins(), player1.getLoses());
		}
		
	}

}
