package blatt06.aufg6_3_prioqueue;

/**
 * Klasse für einen einzelnen Eintrag in einer Prioritätenwarteschlange. Jeder
 * Eintrag besteht aus einem Wert und einer ganzzahligen Priorität Ein kleinerer
 * Wert bedeutet eine höhere Priorität.
 * 
 * @author G. Schied
 * 
 * @param <E> Typ für den Wert des Eintrags
 */
public class Eintrag<E> {
	/** Wert des Eintrags */
	private E wert;

	/** Priorität des Eintrags */
	private int prio;

	/**
	 * Erzeugt einen Eintrag mit Wert und Priorität wie angegeben
	 */
	public Eintrag(E wert, int prio) {
		this.wert = wert;
		this.prio = prio;
	}

	/** liefert den Wert des Eintrags */
	public E gibWert() {
		return wert;
	}

	/** liefert die Priorität des Eintrags */
	public int gibPrio() {
		return prio;
	}

	/** liefert eine Zeichenkettendarstellung des Eintrags */
	public String toString() {
		return wert.toString() + " (" + prio + ")";
	}
}
