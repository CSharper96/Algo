package blatt05.aufg_5_4_radixsort;

import java.util.Arrays;

public class TaxIDSortMeasurement {

	public static final int MIN_N = 10;
	public static final int MAX_N = 1000000;
	
	/** Measure runtime of sorting lists of products using radixsort and standard Java sort. */
	public static void main(String[] args) {
		for (int n = MIN_N; n <= MAX_N; n *= 10) {
			if(n==10)
			{
				measureSortWithOutput(n);
			}
			else
				measureSort(n);
		}
		
		System.out.println("--- done ---");

	}
	
	public static void measureSort(int n) {
		System.out.printf("generate list of n = %10d persons ", n);
		Person[] alist1 = Person.generatePersonList(n);
		Person[] alist2 = alist1.clone();

		System.out.print("taxIdSort(): ");
		long start1 = System.nanoTime();
		Person.taxIdSort(alist1);
		long end1 = System.nanoTime();
		double time1ms = (end1 - start1)/10e6;
		System.out.printf("%8.2f ms ", time1ms);
		
		
		System.out.print("| Arrays.sort(): ");
		long start2 = System.nanoTime();
		Arrays.sort(alist2);
		long end2 = System.nanoTime();
		double time2ms = (end2 - start2)/10e6;
		System.out.printf("%8.2f ms %n", time2ms);
		
	}
	public static void measureSortWithOutput(int n) {
		System.out.printf("generate list of n = %10d persons ", n);
		Person[] alist1 = Person.generatePersonList(n);
		Person[] alist2 = alist1.clone();

		System.out.print("taxIdSort(): ");
		long start1 = System.nanoTime();
		Person.taxIdSort(alist1);
		long end1 = System.nanoTime();
		double time1ms = (end1 - start1)/10e6;
		System.out.printf("%8.2f ms ", time1ms);


		System.out.print("| Arrays.sort(): ");
		long start2 = System.nanoTime();
		Arrays.sort(alist2);
		long end2 = System.nanoTime();
		double time2ms = (end2 - start2)/10e6;
		System.out.printf("%8.2f ms %n", time2ms);

		System.out.println("\ntaxIdSort() solution:");
		for(Person p : alist1)
		{
			System.out.println(p.getId());
		}
		System.out.println();
	}

}
