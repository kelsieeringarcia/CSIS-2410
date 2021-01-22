package m01;

/******************************************************************************
 *  Compilation:  javac Stack.java
 *  Execution:    java Stack < input.txt
 *  Dependencies: StdIn.java StdOut.java
 *  Data files:   https://algs4.cs.princeton.edu/13stacks/tobe.txt
 *
 *  A generic stack, implemented using a singly linked list.
 *  Each stack element is of type Item.
 *
 *  This version uses a static nested class Node (to save 8 bytes per
 *  Node), whereas the version in the textbook uses a non-static nested
 *  class (for simplicity).
 *  
 *  % more tobe.txt 
 *  to be or not to - be - - that - - - is
 *
 *  % java Stack < tobe.txt
 *  to be not that or be (2 left on stack)
 *
 ******************************************************************************/

import java.util.Iterator;
import java.util.NoSuchElementException;


/**
 *  The {@code Stack} class represents a last-in-first-out (LIFO) stack of generic items.
 *  It supports the usual <em>push</em> and <em>pop</em> operations, along with methods
 *  for peeking at the top item, testing if the stack is empty, and iterating through
 *  the items in LIFO order.
 *  <p>
 *  This implementation uses a singly linked list with a static nested class for
 *  linked-list nodes. See {@link LinkedStack} for the version from the
 *  textbook that uses a non-static nested class.
 *  See {@link ResizingArrayStack} for a version that uses a resizing array.
 *  The <em>push</em>, <em>pop</em>, <em>peek</em>, <em>size</em>, and <em>is-empty</em>
 *  operations all take constant time in the worst case.
 *  <p>
 *  For additional documentation,
 *  see <a href="https://algs4.cs.princeton.edu/13stacks">Section 1.3</a> of
 *  <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 *
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 *
 *  @param <E> the generic type of an item in this stack
 */
public class Stack<E> implements Iterable<E> {
    private Node<E> first;     // top of stack
    private int n;                // size of the stack

    // helper linked list class
    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    /**
     * Initializes an empty stack.
     */
    public Stack() {
        first = null;
        n = 0;
    }

    /**
     * Returns true if this stack is empty.
     *
     * @return true if this stack is empty; false otherwise
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * Returns the number of items in this stack.
     *
     * @return the number of items in this stack
     */
    public int size() {
        return n;
    }

    /**
     * Adds the item to this stack.
     *
     * @param  item the item to add
     */
    public void push(E item) {
        Node<E> oldfirst = first;
        first = new Node<E>();
        first.item = item;
        first.next = oldfirst;
        n++;
    }

    /**
     * Removes and returns the item most recently added to this stack.
     *
     * @return the item most recently added
     * @throws NoSuchElementException if this stack is empty
     */
    public E pop() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        E item = first.item;        // save item to return
        first = first.next;            // delete first node
        n--;
        return item;                   // return the saved item
    }


    /**
     * Returns (but does not remove) the item most recently added to this stack.
     *
     * @return the item most recently added to this stack
     * @throws NoSuchElementException if this stack is empty
     */
    public E peek() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        return first.item;
    }
    
    /**
     * The method duplicate has no parameters and it returns a new 
     * Stack that includes the same stack elements, but each of them twice.
     * @return new stack with duplicates
     */
    public Stack<E> duplicate() {
    	if(isEmpty()) {
    		throw new NoSuchElementException("Stack underflow");
    	}
    	Stack<E> s = new Stack<>();
    	E temp = first.item;
    	for(int i = 0; i < n; i++) {
    		
    		s.push(temp);
    		s.push(temp);
    		temp = (E) first.next;
    		
    	}
    	return s;
    }
    
    /**
     * The method everyOther has no parameters and it returns a new 
     * Stack that includes the first, third, fifth, … element of the stack
     * @return
     */
    public Stack<E> everyOther() {
    	if(isEmpty()) {
    		throw new NoSuchElementException("Stack underflow");
    	}
    	Stack<E> s = new Stack<>();
    	E temp = first.item;
    	for(int i = 1; i < n; i++) {
    		if(i % 2 == 0) {
    			temp = (E) first.next;
    		}else {
    			s.push(temp);
    		}
    		
    	}
    	return s;
    }

    /**
     * Returns a string representation of this stack.
     *
     * @return the sequence of items in this stack in LIFO order, separated by spaces
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (E item : this) {
            s.append(item);
            s.append(' ');
        }
        return s.toString();
    }
       

    /**
     * Returns an iterator to this stack that iterates through the items in LIFO order.
     *
     * @return an iterator to this stack that iterates through the items in LIFO order
     */
    public Iterator<E> iterator() {
        return new LinkedIterator(first);
    }

    // an iterator, doesn't implement remove() since it's optional
    private class LinkedIterator implements Iterator<E> {
        private Node<E> current;

        public LinkedIterator(Node<E> first) {
            current = first;
        }

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public E next() {
            if (!hasNext()) throw new NoSuchElementException();
            E item = current.item;
            current = current.next; 
            return item;
        }
    }

}
