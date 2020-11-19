package blatt06.aufg6_3_prioqueue;

/**
 * Schnittstelle f�r eine Priorit�tenwarteschlange mit beschr�nkter Kapazit�t
 */
public interface IPriorityQueue<E> {
	/**
	 * Eintrag (mit Wert und Priorit�t) in die Priorit�tenwarteschlange aufnehmen
	 */
	void insert(Eintrag<E> e);

	/**
	 * Den Eintrag mit der h�chsten Priorit�t (= kleinster wert f�r Priorit�t) aus
	 * der Warteschlange entnehmen
	 * 
	 * @return entnommener Eintrag (bzw. null, wenn Warteschlange leer
	 */
	Eintrag<E> extractMin();

	/** Pr�ft, ob Warteschlange leer ist */
	boolean isEmpty();

	/** Pr�ft, ob Warteschlange voll ist */
	boolean isFull();
}
