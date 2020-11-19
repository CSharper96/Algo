package blatt06.aufg6_3_prioqueue;

/**
 * Klasse f�r einen einzelnen Eintrag in einer Priorit�tenwarteschlange. Jeder
 * Eintrag besteht aus einem Wert und einer ganzzahligen Priorit�t Ein kleinerer
 * Wert bedeutet eine h�here Priorit�t.
 * 
 * @author G. Schied
 * 
 * @param <E> Typ f�r den Wert des Eintrags
 */
public class Eintrag<E> {
	/** Wert des Eintrags */
	private E wert;

	/** Priorit�t des Eintrags */
	private int prio;

	/**
	 * Erzeugt einen Eintrag mit Wert und Priorit�t wie angegeben
	 */
	public Eintrag(E wert, int prio) {
		this.wert = wert;
		this.prio = prio;
	}

	/** liefert den Wert des Eintrags */
	public E gibWert() {
		return wert;
	}

	/** liefert die Priorit�t des Eintrags */
	public int gibPrio() {
		return prio;
	}

	/** liefert eine Zeichenkettendarstellung des Eintrags */
	public String toString() {
		return wert.toString() + " (" + prio + ")";
	}
}
