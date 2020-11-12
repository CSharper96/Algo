package blatt05.aufg_5_4_radixsort;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Person implements Comparable<Person> 
{
	private String name;
	private String taxID; //key = 11 digit tax ID (Steuer ID)
	
	public static final int ID_LENGTH = 11;
	
	public Person(String name, String taxID) {
		this.name = name;
		this.taxID = taxID;
	}
	
	public String getId() {
		return taxID;
	}

	public String toString() {
		return name + ", ID: " + taxID;
	}

	/** Sort an array of persons using radixsort with taxId as key.
	 */
	public static void taxIdSort(Person[] alist) {
		final int RADIX = alist.length;

		// declare and initialize bucket[]
		List<Person>[] bucket = new ArrayList[RADIX];

		for (int i = 0; i < bucket.length; i++) {
			bucket[i] = new ArrayList<Person>();
		}

		// sort
		boolean maxLength = false;
		long tmp = -1, placement = 1;
		while (!maxLength) {
			maxLength = true;

			// split input between lists
			for (Person p : alist) {
				tmp = Long.parseLong(p.taxID) / placement;
				bucket[(int) (tmp % RADIX)].add(p);
				if (maxLength && tmp > 0) {
					maxLength = false;
				}
			}

			// empty lists into input array
			int a = 0;
			for (int b = 0; b < RADIX; b++) {
				for (Person p : bucket[b]) {
					alist[a++] = p;
				}
				bucket[b].clear();
			}

			// move to next digit
			placement *= RADIX;

		}
	}
	
	
	@Override
	public int compareTo(Person other) {
		return taxID.compareTo(other.taxID);
	}
	
	
	/** generates randomly an array containing the specified number of persons with random tax IDs */
	public static Person[] generatePersonList(int number) {
		Person[] aliste = new Person[number];
		
		Random rand = new Random();
		
		for (int i = 0; i < aliste.length; i++) {
			String name = "Person_" + i;
			//generate random tax ID
			String taxID = "";
			for (int pos = 0; pos < ID_LENGTH; pos++) {
				taxID += rand.nextInt(10);
			}
			
			aliste[i] = new Person(name, taxID);
		}
		
		return aliste;
	}
	


	
}
