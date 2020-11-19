package blatt06.aufg6_3_prioqueue;

import java.util.Random;

/**
 * Beispiel f�r die Verwendung der Klasse HeapQueue
 */
public class PrioQueueDemo {

	private final static Random rand = new Random();

	/** Heapbasierte Priorit�tenwarteschlange testen */
	public static void main(String[] args) {
		final int ANZAHL = 10;
		IPriorityQueue<String> heapQueue = new HeapQueue<String>(2 * ANZAHL);
		testPrioQueue(heapQueue, ANZAHL);
	}

	/**
	 * Test f�r die Funktionsweise einer Priorit�tenwarteschlange (1) erst n
	 * Elemente mit insert einf�gen, (2) dann 100 mal insert/extractMin, (3) dann
	 * alle n Elemente mit extractMin entfernen
	 */
	public static void testPrioQueue(IPriorityQueue<String> prioQueue, int ANZAHL) {
		// zuf�llig gew�hlte Eintr�ge in der Warteschlange ablegen
		System.out.println(ANZAHL + " Zufallswerte einf�gen");
		for (int i = 0; i < ANZAHL; i++) {
			Eintrag<String> neu = randEintrag(1000);
			System.out.println("insert: " + neu);
			prioQueue.insert(neu);
		}
		System.out.println();

		// ANZAHL/2 viele Eintr�g entfernen (d.h. mit den kleinsten
		// Priorit�tswerten)
		System.out.println("Die " + (ANZAHL / 2) + " kleinsten Werte entnehmen:");
		for (int i = 0; i < ANZAHL / 2; i++) {
			Eintrag<String> eintrag = prioQueue.extractMin();
			System.out.println("entfernt: " + eintrag);
		}
		System.out.println();

		// nochmals ANZAHL viele Eintr�ge ablegen
		System.out.println("Nochmals " + ANZAHL + " Zufallswerte einf�gen");
		for (int i = ANZAHL; i < 2 * ANZAHL; i++) {
			Eintrag<String> neu = randEintrag(1000);
			System.out.println("insert: " + neu);
			prioQueue.insert(neu);
		}
		System.out.println();

		// Alle Eintr�ge aus der Warteschlange entfernen
		System.out.println("Alle Werte entfernen (sollte aufsteigend sortiert sein!)");
		while (!prioQueue.isEmpty()) {
			Eintrag<String> eintrag = prioQueue.extractMin();
			System.out.println("entfernt: " + eintrag);
		}
	}

	/** Eintrag mit zuf�llig gew�hlter Priorit�t erzeugen */
	public static Eintrag<String> randEintrag(int maxValue) {
		int prio = rand.nextInt(maxValue);
		return new Eintrag<String>("V" + prio, prio);
	}

}
