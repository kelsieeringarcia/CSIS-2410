package mastermind;

public class test {
//	
//	/**
//	 * 
//	 */
//	package mastermind;
//
//	import java.util.ArrayList;
//	import java.util.Scanner;
//
//	/**
//	 * Player class acts as the games codebreaker. Player has a name, currentTurn, and 
//	 * counts the wins v. loses. The Player class also picks the codes (enum) to break during 
//	 * each turn.
//	 * 
//	 * @author czuniga10
//	 */
//	public class Player {
//		private String name;
//		private int currentTurn = 1;
//		private int MAXTURNS = 10;
//		private static int wins = 0;
//		private static int loses = 0;
//		
//		public Player(String name) {
//			setName(name);
//		}
//		
//		public ArrayList<Codes> pickCode() {
//			try (Scanner input = new Scanner(System.in)) {
//				System.out.println("Choose your codes....\n");
//				int count = 0;
//				ArrayList<Codes> codes = new ArrayList<>();
//				
//				do {
//					System.out.printf("Code Peg #%d ('W','B','G','R','Y','BLK') : ",count+1);
//					String userInput = input.nextLine();
//					
//					switch(userInput) {
//					case "W":
//						codes.add(Codes.WHITE);
//						break;
//					case "B":
//						codes.add(Codes.BLUE);
//						break;
//					case "G":
//						codes.add(Codes.GREEN);
//						break;
//					case "R":
//						codes.add(Codes.RED);
//						break;
//					case "Y":
//						codes.add(Codes.YELLOW);
//						break;
//					case "BLK":
//						codes.add(Codes.BLACK);
//						break;
//					default:
//						System.out.println("Not a valid response");
//						count--;
//						break;
//				}
//					
////				switch(userInput) {
////					case "W":
////						if(!codes.contains(Codes.WHITE)) {
////							codes.add(Codes.WHITE);
////						} else {
////							System.out.println("Cant have dups");
////						}
////						break;
////					case "B":
////						if(!codes.contains(Codes.BLUE)) {
////							codes.add(Codes.BLUE);
////						} else {
////							System.out.println("Cant have dups");
////						}
////						break;
////					case "G":
////						if(!codes.contains(Codes.GREEN)) {
////							codes.add(Codes.GREEN);
////						} else {
////							System.out.println("Cant have dups");
////						}
////						break;
////					case "R":
////						if(!codes.contains(Codes.RED)) {
////							codes.add(Codes.RED);
////						} else {
////							System.out.println("Cant have dups");
////						}
////						break;
////					case "Y":
////						if(!codes.contains(Codes.YELLOW)) {
////							codes.add(Codes.YELLOW);
////						} else {
////							System.out.println("Cant have dups");
////						}
////						break;
////					case "BLK":
////						if(!codes.contains(Codes.BLACK)) {
////							codes.add(Codes.BLACK);
////						} else {
////							System.out.println("Cant have dups");
////						}
////						break;
////					default:
////						System.out.println("Not a valid response");
////						break;
////				}
//					
//					count++;
//					
//				} while(count < 4);
//				
//				System.out.println("Users Choices: " + codes.toString());
//				
//				return codes;
//			} catch(Exception e) {
//				throw e;
//			}
//		}
//
//		/**
//		 * @return the name
//		 */
//		public String getName() {
//			return name;
//		}
//
//		/**
//		 * @param sets the Player name
//		 */
//		public void setName(String name) {
//			this.name = name;
//		}
//
//		/**
//		 * @return the currentTurn
//		 */
//		public int getCurrentTurn() {
//			return currentTurn;
//		}
//
//		/**
//		 * Increments Player currentTurn
//		 */
//		public void incrementCurrentTurn() {
//			if(this.currentTurn < this.MAXTURNS) {
//				this.currentTurn++;
//			} else {
//				System.out.println("Max Turns reached");
//			}
//		}
//		
//		/**
//		 * @return the currentTurn
//		 */
//		public int getMaxTurns() {
//			return MAXTURNS;
//		}
//
//		/**
//		 * @return the wins
//		 */
//		public static int getWins() {
//			return wins;
//		}
//
//		/**
//		 * Increments Player wins
//		 */
//		public static void incrementWins() {
//			Player.wins++;
//		}
//
//		/**
//		 * @return the loses
//		 */
//		public static int getLoses() {
//			return loses;
//		}
//
//		/**
//		 * Increments Player loses
//		 */
//		public static void incrementLoses() {
//			Player.loses++;
//		}
//		
//		
//	}


}
