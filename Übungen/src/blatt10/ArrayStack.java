package blatt10;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Stack begrenzter Kapazit�t f�r Objekte vom Typ E.
 * Mittels Array implementiert.
 */
public class ArrayStack<E> implements Iterable<E> {
	private E[] contents;
	private int topOfStack; // n�chster freier Platz

	public ArrayStack(int capacity) {
		contents = (E[]) new Object[capacity];
		topOfStack = 0;
	}

	/** Element oben auf dem Stack ablegen */
	public void push(E elem) throws StackException {
		if (topOfStack < contents.length) {
			contents[topOfStack] = elem;
			topOfStack++;
		} else
			throw new StackException("push: stack full!");
	}

	/** oberstes Element des Stacks entnehmen und zur�ckliefern */
	public E pop() throws StackException {
		if (topOfStack > 0) {
			topOfStack--;
			return contents[topOfStack];
		} else
			throw new StackException("pop: stack empty");
	}

	/** pr�fen, ob Stack leer ist */
	public boolean isEmpty() {
		return topOfStack == 0;

	}

	/** Anzahl der gerade gespeicherten Elemente */
	public int size() {
		return topOfStack;
	}

	public boolean isFull() {
		return topOfStack == contents.length;
	}

	public Iterator<E> iterator() {
		return new MyIterator();
	}

		class MyIterator implements Iterator<E> {

		private int counter;

		public MyIterator()
		{
			counter = topOfStack;
		}

		public boolean hasNext() {
			return counter > 0;
		}

		public E next() {
			if(!hasNext())
				throw new NoSuchElementException();
			else{
				return contents[--counter];
			}
		}
	}
}
