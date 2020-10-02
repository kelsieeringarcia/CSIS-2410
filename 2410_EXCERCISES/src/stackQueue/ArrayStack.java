package stackQueue;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Stack that is implemented with an array.
 * @author kelsiegarcia
 *
 */
public class ArrayStack<E> implements Iterable<E>{
	private E[] items;
	private int n; //number of items in the stack
	
	public ArrayStack(int capacity) {
		this.items = (E[]) new Object[capacity];
		
	}
	
	/**
	 * Adds an item on top of the stack
	 * @param item
	 */
	public void push(E item) {
		if(n == items.length) 
			throw new UnsupportedOperationException("Items cannot be pushed on a full stack.");
		
		items[n++] = item;
	}
	
	/**
	 * Removes top element from the stack. this is the element that
	 * was added last.
	 * @return the element on top of the stack.
	 */
	public E pop() {
		if(n == 0) 
			throw new NoSuchElementException("Cannot remove elements from a empty stack");
		
		E item = items[--n];
		items[n] = null;
		return item;
	}
	
	/**
	 * Looks at the element on top of the stack.
	 * that will be removed next when we call pop.
	 * @return element on top of the stack
	 */
	public E peek() {
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

	/**
	 * Checks to see if the stack is empty
	 * @return if the string is empty.
	 */
	public boolean isEmpty() {
		return n == 0;
	}

	@Override
	public String toString() {
		return Arrays.toString(items);
	}
	
	@Override
	public Iterator<E> iterator() {
		
		return new ArrayStackIterator();
	}
	
	private class ArrayStackIterator implements Iterator<E>{
		private int index = n - 1;

		@Override
		public boolean hasNext() {
			return index >= 0;
		}

		@Override
		public E next() {
			return items[index--];
		}
		
	}
	
	//= = = = = test client = = = = =
	public static void main(String[] args) {
		System.out.println("Stack of numbers:");
		System.out.println("------------------");
		ArrayStack<Integer> stack2 = new ArrayStack<>(5);
		stack2.push(10);
		stack2.push(20);
		for(int el : stack2) {
			System.out.print(el + " ");
		}
		System.out.println();
		
		ArrayStack<String> stack = new ArrayStack<>(5);
		stack.push("A");
		stack.push("B");
		stack.push("C");
		
		System.out.println("Stack of strings: ");
		System.out.println("------------------");
		for(String s : stack) {
			System.out.print(s + " ");
		}
		
		System.out.println();
		
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
