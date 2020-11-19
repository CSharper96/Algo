package blatt06.aufg6_3_prioqueue;

/**
 * Schnittstelle für eine Prioritätenwarteschlange mit beschränkter Kapazität
 */
public interface IPriorityQueue<E> {
	/**
	 * Eintrag (mit Wert und Priorität) in die Prioritätenwarteschlange aufnehmen
	 */
	void insert(Eintrag<E> e);

	/**
	 * Den Eintrag mit der höchsten Priorität (= kleinster wert für Priorität) aus
	 * der Warteschlange entnehmen
	 * 
	 * @return entnommener Eintrag (bzw. null, wenn Warteschlange leer
	 */
	Eintrag<E> extractMin();

	/** Prüft, ob Warteschlange leer ist */
	boolean isEmpty();

	/** Prüft, ob Warteschlange voll ist */
	boolean isFull();
}
