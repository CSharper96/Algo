package blatt01;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Aufg_1_4_Enthalten {

	public static boolean alleEnthalten(long[] a1, long[] a2) {
		long tmp = 0;
		for (long l1: a1)
		{
			for(long l2 : a2)
			{
				if(l1 == l2)
				{
					tmp++;
					break;
				}
			}
		}
		if(a1.length == tmp)
			return true;
		else return false;
	}
	
	
	public static final int MAX_LEN = 1000000;

	public static void main(String[] args) {
		long[] m0 = {};
		long[] m1 = { 1, 2, 5 };
		long[] m2 = { 4, 3, 2, 1, 8, 7, 6, 5 };
		long[] m3 = { 2, 1, 5 };
		long[] m4 = { 2, 1, 4, 3, 2 };
		long[] m5 = { 1,2,5};
		long[] m6 = { 1,2,4};
		
		System.out.println("m0 Teilmenge von m1: Ergebnis " + alleEnthalten(m0, m1) + " | erwartet: true");
		System.out.println("m0 Teilmenge von m2: Ergebnis " + alleEnthalten(m0, m2) + " | erwartet: true");
		System.out.println("m0 Teilmenge von m3: Ergebnis " + alleEnthalten(m0, m3) + " | erwartet: true");
		System.out.println("m0 Teilmenge von m4: Ergebnis " + alleEnthalten(m0, m4) + " | erwartet: true");
		System.out.println("m1 Teilmenge von m0: Ergebnis " + alleEnthalten(m1, m0) + " | erwartet: false");
		System.out.println("m1 Teilmenge von m2: Ergebnis " + alleEnthalten(m1, m2) + " | erwartet: true");
		System.out.println("m2 Teilmenge von m1: Ergebnis " + alleEnthalten(m2, m1) + " | erwartet: false");
		System.out.println("m0 Teilmenge von m0: Ergebnis " + alleEnthalten(m0, m0) + " | erwartet: true");
		System.out.println("m1 Teilmenge von m1: Ergebnis " + alleEnthalten(m1, m1) + " | erwartet: true");
		System.out.println("m1 Teilmenge von m3: Ergebnis " + alleEnthalten(m1, m3) + " | erwartet: true");
		System.out.println("m3 Teilmenge von m1: Ergebnis " + alleEnthalten(m3, m1) + " | erwartet: true");
		System.out.println("m4 Teilmenge von m0: Ergebnis " + alleEnthalten(m4, m0) + " | erwartet: false");
		System.out.println("m4 Teilmenge von m1: Ergebnis " + alleEnthalten(m4, m1) + " | erwartet: false");
		System.out.println("m4 Teilmenge von m2: Ergebnis " + alleEnthalten(m4, m2) + " | erwartet: true");
		System.out.println("m4 Teilmenge von m3: Ergebnis " + alleEnthalten(m4, m3) + " | erwartet: false");
		System.out.println("m4 Teilmenge von m4: Ergebnis " + alleEnthalten(m4, m4) + " | erwartet: true");
		System.out.println("m6 Teilmenge von m5: Ergebnis " + alleEnthalten(m6, m5) + " | erwartet: false");
		System.out.println("m5 Teilmenge von m6: Ergebnis " + alleEnthalten(m5, m6) + " | erwartet: false");

		
		
		
		// Performanztest:
		for (int len = 100; len <= MAX_LEN; len *= 10) {
			System.out.println("Feldlänge " + len + ": ");
			long[] a1 = new long[len];
			long[] a2 = new long[len];
			fuelle2(a1,a2,len);
			
			long start = System.nanoTime();
			boolean result = alleEnthalten(a1, a2);
			long ende = System.nanoTime();
			
			System.out.println("\ta1 Teilmenge von a2: " + result + " Laufzeit: "
					+ ((ende - start) / 1e6) + " msec.");
		}
	}

	public static void fuelle1(long[] a1, long[] a2, int len) {
		for (int i = 0; i < len; i++) {
			a1[i] = i;
			a2[len - 1 - i] = i;
		}
	}
	
	public static void fuelle2(long[] a1, long[] a2, int len) {
		for (int i = 0; i < len/2; i++) {
			a1[i] = i;
			a2[i] = 0;
			a1[len/2 + i] = i;
			a2[len/2 + i] = i;
		}
	
	}
}
