package blatt06.aufg6_3_prioqueue;

/**
 * HeapQueue:
 *        100 insert:    4,37 ms |  100 insert+extractMin:    1,82 ms |        100 extractMin:    0,51 msec.
 *       1000 insert:    9,85 ms |  1000 insert+extractMin:    2,52 ms |       1000 extractMin:    7,66 msec.
 *      10000 insert:  276,42 ms |  10000 insert+extractMin:   19,26 ms |      10000 extractMin:  406,69 msec.
 *     100000 insert: 41116,74 ms |  100000 insert+extractMin:  219,66 ms |     100000 extractMin: 57809,65 msec.
 *     1000000 insert: zu lange! |  1000000 insert+extractMin:  zu lange! |     1000000 extractMin: zu lange!
 */

/**
 * Implementiert eine heapbasierte Priot�tenwarteschlange.
 */
public class HeapQueue<E> implements IPriorityQueue<E> {
	/** Feld zur Speicherung der Heap-Elemente */
	private Eintrag<E>[] arr;

	/** Anzahl der Elemente in der Warteschlange */
	private int count = 0;

	@SuppressWarnings("unchecked")
	public HeapQueue(int maxSize) {
		arr = new Eintrag[maxSize];
	}

	@Override
	public void insert(Eintrag<E> e)
	{
		int prio = e.gibPrio();
		// Fügt an letzter Position das neue Element ein
		int actPosition = 0;
		for (Eintrag<E> eintrag : arr)
		{
			if (eintrag == null)
			{
				arr[actPosition] = e;
				break;
			}
			actPosition++;
		}
		// Sortiert das Array!
		for(int i = actPosition - 1; i >= 0; i--)
		{
			if(arr[actPosition].gibPrio() < arr[i].gibPrio())
			{
				swap(actPosition, i);
				actPosition = i;
			}
			else continue;
		}

	}
	private void swap(int actPos, int nextPos)
	{
		Eintrag<E> tmp = arr[nextPos];
		arr[nextPos] = arr[actPos];
		arr[actPos] = tmp;
	}

	@Override
	public Eintrag<E> extractMin()
	{
		if(isEmpty()) return null;
		//Popt erstes Element und setzt letztes an erste Stelle
		Eintrag<E> min = arr[0];
		for(int i = arr.length - 1; i >= 0; i--)
			if(arr[i] != null) {
				arr[0] = arr[i];
				arr[i] = null;
				break;
			}
		//Sortiert Array
		int nextPos = 1;
		for(int i = 0; i < arr.length; i++)
		{
			if(arr[nextPos] == null) break;
			if(arr[i].gibPrio() > arr[nextPos].gibPrio())
			{
				swap(i, nextPos);
				nextPos++;
			}
		}

		return  min;
	}
	private Eintrag<E> getLast()
	{
		for(int i = arr.length - 1; i >= 0; i--)
			if(arr[i] != null) {
				Eintrag<E> tmp = arr[i];
				arr[i] = null;
				return tmp;
			}
			return null;
	}

	@Override
	public boolean isEmpty() {
		for(Eintrag<E> e : arr)
			if(e != null)
				return false;
		return true;
	}

	@Override
	public boolean isFull() {
		for(Eintrag<E> e : arr)
			if(e != null)
				return true;
		return false;
	}

	public int size() {
		return count;
	}
}
