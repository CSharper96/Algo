package blatt06.aufg6_3_prioqueue;

import java.util.Random;

import javax.swing.JOptionPane;

public class PrioQueueMessung {

	private final static Random rand = new Random();


	/** F�hrt Laufzeitmessungen f�r die Priorit�tswarteschlange durch */
	public static void main(String[] args) {
		//int maxN = 1000000;
		int maxN = Integer.parseInt(JOptionPane.showInputDialog("Messung bis zur Gr��e n = ", "1000000"));

		System.out.println("HeapQueue:");
		for (int n = 100; n <= maxN; n *= 10) {
			IPriorityQueue<String> prioq = new HeapQueue<String>(n+1);
			laufzeitMessung(prioq, n);
		}
		
		System.out.println("- fertig -");	
	}

	
	
	/** erzeugt einen Eintrag mit eine zuf�llig gew�hlten Priorit�t 
	 */
	public static Eintrag<String> randEintrag(int maxValue) {
		int prio = rand.nextInt(maxValue);
		return new Eintrag<String>("V" + prio, prio);
	}

    /** Misst die Zeiten f�r einen Testlauf folgender Art:
     *  <ol>
     * 	    <item>n-1 Elemente mit zuf�llig erzeugter Priorit�t werden eingetragen </item> 
     *      <item>100 mal wird jeweils ein Element eingef�gt und dann wieder ein Element entfernt </item> 
     *      <item>
     *  </ol>
     */
	public static void laufzeitMessung(IPriorityQueue<String> prioq, int n) {
		// PrioQueue mit n Elementen f�llen
		//System.out.println("n = " + n + " Eintr�ge: ");

		long s1 = System.nanoTime();
		for (int i = 0; i < n; i++) {

			prioq.insert(randEintrag(Integer.MAX_VALUE));
		}
		long e1 = System.nanoTime();
		System.out.printf("%10d insert: %7.2f ms | ", n, ((e1 - s1) / 1e6));

		
		//zun�chst 100 Eintr�ge mit zuf�lliger Priorit�t erzeugen
		Eintrag<String>[] eNeu = new Eintrag[100];
		for (int i = 0; i < eNeu.length; i++) {
			eNeu[i] = randEintrag(Integer.MAX_VALUE);
		}

		//100 mal ein zuf�lliges Element eintragen und ein Element entfernen. 
		//Die Gesamtzeit daf�r wird gemessen.
		long ta = System.nanoTime();
		for (int i = 0; i < eNeu.length; i++) {
			prioq.insert(eNeu[i]);
			Eintrag<String> next = prioq.extractMin();
		}
		long tb = System.nanoTime();
		
    	System.out.printf("%4d insert+extractMin: %7.2f ms | ", eNeu.length, (tb-ta)/1e6 );

		// alle n Eintr�ge aus der Warteschlange wieder entfernen
		long s3 = System.nanoTime();
		while (!prioq.isEmpty()) {
			Eintrag<String> next = prioq.extractMin();
		}
		long e3 = System.nanoTime();

		System.out.printf("%10d extractMin: %7.2f msec. %n", n, (e3 - s3) / 1e6);


	}
}
