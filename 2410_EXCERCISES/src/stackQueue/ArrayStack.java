package stackQueue;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * Stack that is implemented with an array.
 * @author kelsiegarcia
 *
 */
public class ArrayStack {
	private String[] items;
	private int n; //number of items in the stack
	
	public ArrayStack(int capacity) {
		this.items = new String[capacity];
		
	}
	/**
	 * Adds an item on top of the stack
	 * @param item
	 */
	public void push(String item) {
		if(n == items.length) 
			throw new UnsupportedOperationException("Items cannot be pushed on a full stack.");
		
		items[n++] = item;
	}
	/**
	 * Removes top element from the stack. this is the element that
	 * was added last.
	 * @return the element on top of the stack.
	 */
	public String pop() {
		if(n == 0) 
			throw new NoSuchElementException("Cannot remove elements from a empty stack");
		
		String item = items[--n];
		items[n] = null;
		return item;
	}
	/**
	 * Looks at the element on top of the stack.
	 * that will be removed next when we call pop.
	 * @return element on top of the stack
	 */
	public String peek() {
		if(n == 0) 
			throw new NoSuchElementException("Cannot peek at elements from a empty stack.");
		return items[n - 1]; 
	}
	/**
	 * Determines the number of elements in this stack.
	 * @return number of stack elements
	 */
	public int size() {
		return n; 
	}

	public boolean isEmpty() {
		return n == 0;
	}

	@Override
	public String toString() {
		return Arrays.toString(items);
	}
	
	
	//= = = = = test client = = = = =
	public static void main(String[] args) {
		ArrayStack stack = new ArrayStack(5);
		stack.push("A");
		stack.push("B");
		stack.push("C");
		System.out.println("Peek: " + stack.peek());
		
		System.out.println("Pop: " + stack.pop());
		System.out.println("Peek: " + stack.peek());
		System.out.println("Pop: " + stack.pop());
		stack.push("D");
		System.out.println("Peek: " + stack.peek());
		System.out.println("Pop: " + stack.pop());
		System.out.println("Peek: " + stack.peek());
		System.out.println("Pop: " + stack.pop());
		
	}

}
