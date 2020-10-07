package linked;

import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * Queue is implemented with a linked
 * @author kelsie garcia
 *
 */
public class LinkedQueue<E> implements Iterable<E>{
	
	private int n;// number of elements in queue
	private Node head;
	private Node tail;
	
	private class Node {
		E data;
		Node next;
		
		Node(E data, Node next){
			this.data = data;
			this.next = next;
		}
	}
	
	/**
	 * Determines the number of items in the Queue
	 * 
	 * @return the number of items in queue.
	 */
	public int size() {
		return n;
	}
	
	/**
	 * Determines if the queue is empty or not
	 * 
	 * @return boolean if it is empty or not.
	 */
	public boolean isEmpty() {
		return n == 0;
	}
	
	/**
	 * This puts the data into the end of the queue.
	 * @param data
	 */
	public void enqueue(E data) {
		Node newNode = new Node(data, null);
		
		if(isEmpty()) 
			head = newNode;
		else 
			tail.next = newNode;

		tail = newNode;
		n++;
	}
	
	/**
	 *Removes the first element from the queue.
	 * 
	 * @return the element removed from the queue.
	 */
	public E dequeue() {
		if(isEmpty()) 
			throw new NoSuchElementException("Cant remove an element from an empty queue.");
		E data = head.data;
		head = head.next;
		if(n == 1) {			
			tail = null;
		}
		n--;	
			return data;
	}
	
	/**
	 * Creates a new queue that includes the first <count> elements
	 * of this queue
	 * If the count is greater than the number of element in the queue,
	 * an IllegalArgumentException should be thrown
	 * 
	 * @param count
	 * @return
	 */
	public LinkedQueue<E> take(int count){
		if(count > n)
			throw new IllegalArgumentException("Can't take more elements than are in the queue.");
		LinkedQueue<E> result = new LinkedQueue<>();
		Node current = head;
		for(int i = 0; i < count; i++) {
			result.enqueue(current.data);
			current = current.next;
		}
		return result;
	}
	
	/**
	 * Creates a new queue that includes the last <count> elements
	 * of this queue
	 * If the count is greater than the number of element in the queue,
	 * an IllegalArgumentException should be thrown
	 * 
	 * @param count
	 * @return
	 */
	public LinkedQueue<E> takeLast(int count){
		if(count > n)
			throw new IllegalArgumentException("Can't take more elements than are in the queue.");
		LinkedQueue<E> result = new LinkedQueue<>();
		Node current = head;
		for(int j = 0; j < n - count; j++) {
			current = current.next;
		}
		for(int i = n - count; i < n; i++) {
				result.enqueue(current.data);
				current = current.next;
		}
		
		return result;
	}

	@Override
	public String toString() {
		if(isEmpty())
			return " ";
		Node current = head;
		StringBuilder sb = new StringBuilder();
		
		sb.append(current.data);
		for(int i = 1; i < n; i++) {
			current = current.next;
			sb.append(" ").append(current.data);
	
		}
		return sb.toString();
	}

	@Override
	public Iterator<E> iterator() {
		return new LinkedQueueIterator();
	}
	
	private class LinkedQueueIterator implements Iterator<E>{
		private Node current = head;
		
		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public E next() {
			E data = current.data;
			current = current.next;
			return data;
		}
		
	}
	
	//= = = = = = = = = Test Client = = = = = = = = = 

	public static void main(String[] args) {
		System.out.println("Queue of strings:");
		System.out.println("-----------------");
		LinkedQueue<String> queue = new LinkedQueue<>();
		
		queue.enqueue("V");
		queue.enqueue("W");
		queue.enqueue("X");
		queue.enqueue("Y");
		queue.enqueue("Z");
		
		for(String s : queue) {
			System.out.print(s + " ");
		}
		System.out.println();
		
		System.out.println("toString: [" + queue + "]");
		System.out.println("take(0): [" + queue.take(0) + "]");
		System.out.println("take(1): [" + queue.take(1) + "]");
		System.out.println("take(5): [" + queue.take(5) + "]");
		//System.out.println("take(6): [" + queue.take(6) + "]");
		System.out.println("takeLast(0): [" + queue.takeLast(0) + "]");
		System.out.println("takeLast(1): [" + queue.takeLast(1) + "]");
		System.out.println("takeLast(5): [" + queue.takeLast(5) + "]");
		//System.out.println("takeLast(6): [" + queue.takeLast(6) + "]");
		
		
//		
//		System.out.println();
//		
//		System.out.println("Dequeue 3 times.");
//		queue.dequeue();
//		queue.dequeue();
//		queue.dequeue();
//		
//		
//		System.out.println("Size: " + queue.size());
//		System.out.println("The queue " + (queue.isEmpty() ? "is " : "is not ") + "empty");
//		
//		System.out.println();
//		
//		System.out.println("Queue of Characters:");
//		System.out.println("--------------------");
//		LinkedQueue<Character> queue2 = new LinkedQueue<>();
//		queue2.enqueue('J');
//		queue2.enqueue('K');
//		
//		for(Character c : queue2) {
//			System.out.print(c + " ");
//		}
//		System.out.println();
		

	}

}
