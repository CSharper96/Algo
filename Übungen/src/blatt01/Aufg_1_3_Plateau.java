package blatt01;

import java.util.Arrays;
import java.util.Random;

public class Aufg_1_3_Plateau {

	/** prüft, wie lang in einem aufsteigend oder absteigend sortierten Feld
	 *  das längste Plateau ist.
	 *  
	 *  Ein Plateau ist eine Folge von aufeinander folgenden
	 *  Elementen mit gleichem Wert.
	 *  
	 *    @param a  sortiertes Feld
	 *    @return   Länge des längsten Plateaus
	 */
	public static int plateauLength(int[] a) {
		// TODO
		// TODO
		// TODO
		// TODO
		// TODO		
		return -1;
	}
	

	public static final int MAX_LEN = 100000000;

	public static void main(String[] args) {
		int[] f1 = {1, 2, 2, 3, 4, 4, 4, 4, 5, 5, 6 };
		System.out.println("Längstes Plateau in f1: " + plateauLength(f1));
		System.out.println("  erwartet: 4");
		System.out.println();
		
		int[] f2 = {9, 9, 9, 9, 9, 4, 4, 4, 3, 2, 2, 2, 2 };
		System.out.println("Längstes Plateau in f2: " + plateauLength(f2));
		System.out.println("  erwartet: 5");
		System.out.println();
		
		int[] f3 = {1, 2, 3, 4, 5, 6 };
		System.out.println("Längstes Plateau in f3: " + plateauLength(f3));
		System.out.println("  erwartet: 1");
		System.out.println();
		
		int[] f4 = {1, 1, 1, 1};
		System.out.println("Längstes Plateau in f4: " + plateauLength(f4));
		System.out.println("  erwartet: 4");
		System.out.println();
		
		//sortiertes Feld mit Zufallsdaten erzeugen
		Random rnd = new Random(42);
		int[] f5 = new int[MAX_LEN];
		int limit = (int)Math.sqrt(MAX_LEN);
		for (int i = 0; i < f5.length; i++) {
			f5[i] = rnd.nextInt(limit);
		}
		Arrays.sort(f5);
		
		System.out.println("Feldlänge f5:" + f5.length);
		System.out.println("Längstes Plateau in f5: " + plateauLength(f5));
		System.out.println();
		
		int[] f6 = {2, 2, 1, 3, 1};
		System.out.println("Längstes Plateau in f6: " + plateauLength(f6));
		System.out.println("  erwartet: 2");
		System.out.println();
		
		
		System.out.println("- fertig -");
	}

}
