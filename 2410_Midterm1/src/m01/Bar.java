package m01;
/**
 * This class constructs a object of bar
 * which is a given symbol and length of how many symbols
 * @author kelsiegarcia
 *
 */
public class Bar {
	private static int length;
	private static char symbol;
	
	public Bar(int length, char symbol) {
		super();
		if(length < 0 || length > 25 ) {
			throw new IllegalArgumentException("Length may not be longer than 25 or below 0.");
		}else {
		this.length = length;
		}
		this.symbol = symbol;
	}

	/**
	 * Gets the length of the bar constructed
	 * @return length of the bar.
	 */
	public static int getLength() {
		return length;
	}

	/**
	 * Gets the symbol from the bar constructed.
	 * @return symbol provided in constructor
	 */
	public static char getSymbol() {
		return symbol;
	}

	/**
	 * It returns a string that displays the bar with the specified character <symbol> 
	 * one character per length unit.
	 * @return bar of symbols.
	 */
	public String display() {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < length; i++) {
			sb.append(symbol);	
		}
		return sb.toString();
	}

	/**
	 * Prints out the bar that is constructed.
	 */
	@Override
	public String toString() {
		return  symbol + "(" +length + ")"; 
	}
	
}
