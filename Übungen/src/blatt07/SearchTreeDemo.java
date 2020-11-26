package blatt07;

import java.util.Random;

public class SearchTreeDemo {

	public static void main(String[] args) {
		beispiel1();
		System.out.println();

		beispiel2();
		System.out.println();

		demoEquals();
		System.out.println();
		measureInsertExtractMin();
		System.out.println();

		runtimeEquals();
	}

	/** Bildet einen Baum aus 10 Werten */
	public static void beispiel1() {
		System.out.println("Beispiel 1:");

		// final int[] werte = {4,2,1,7,5,8,9,3,10,6};
		final int[] werte = { 4, 2, 12, 1, 7, 11, 5, 8, 15, 9, 13, 14, 3, 10, 6, };

		SearchTree tree1 = new SearchTree();

		for (int n : werte) {
			tree1.insertIter(n);
		}

		tree1.print();
		// System.out.println("- size: " + tree1.size());
		System.out.println("- height: " + tree1.height());
		System.out.println("- sum: " + tree1.sum());
		System.out.println("- numOfLeaves: " + tree1.leaves());
		System.out.print("- alle Werte: ");
		for (int n : tree1.toSortedList()) {
			System.out.print(n + ", ");
		}
		System.out.println();

	}

	/**
	 * Verwendungsbeispiel f�r bin�re Suchb�ume Baut einen Baum aus 100 zuf�llig
	 * gew�hlte Werte auf und gibt die Eigenschaften des Baums aus
	 */
	public static void beispiel2() {
		System.out.println("Beispiel 2:");

		SearchTree tree2 = new SearchTree();
		// n zuf�llige Werte (von 0 bis 999) in den Baum einf�gen
		for (int i = 0; i < 100; i++) {
			int v = (int) (Math.random() * 1000);
			tree2.insert(v); // rekursive einf�gen
		}

		tree2.print();
		// System.out.println("- size: " + tree2.size());
		System.out.println("- height: " + tree2.height());
		System.out.println("- sum: " + tree2.sum());
		System.out.println("- numOfLeaves: " + tree2.leaves());
		System.out.println("- alle Werte: ");
		for (int v : tree2.toSortedList()) {
			System.out.println("\t" + v);
		}
		System.out.println();

		int min = tree2.extractMin();
		System.out.println("- extractMin: " + min);
		System.out.println();
		tree2.print();

	}

	public static void demoEquals() {
		final int[] werte1 = { 4, 2, 12, 1, 7, 11, 5, 8, 15, 9, 13, 14, 3, 10, 6 };
		final int[] werte2 = { 7, 11, 5, 8, 4, 2, 12, 1, 15, 14, 3, 10, 6, 9, 13 }; // gleiche Menge wie werte1, andere
																					// Reihenfolge
		final int[] werte3 = { 7, 11, 5, 8, 4, 2, 12, 1, 55, 14, 3, 10, 6, 9, 13 }; // andere Wertemenge

		SearchTree tree1 = new SearchTree();
		for (int n : werte1) {
			tree1.insert(n);
		}

		SearchTree tree2 = new SearchTree();
		for (int n : werte2) {
			tree2.insert(n);
		}

		SearchTree tree3 = new SearchTree();
		for (int n : werte3) {
			tree3.insert(n);
		}

		System.out.println("tree1.equals(tree2) [expected true] = " + tree1.equals(tree2));
		System.out.println("tree2.equals(tree1) [expected true] = " + tree2.equals(tree1));
		System.out.println("tree1.equals(tree3) [expected false] = " + tree1.equals(tree3));
		System.out.println("tree3.equals(tree2) [expected false] = " + tree3.equals(tree2));

	}

	public static final int MAX_N = 1000000;
	public static final int REPEAT = 100;

	public static void measureInsertExtractMin() {
		System.out.println("Runtime insert/extractMin(), repeated " + REPEAT + " times:");

		for (int n = 100; n <= MAX_N; n *= 10) {
			int[] values1 = generateRandomValues(n);
			int[] values2 = generateRandomValues(REPEAT);

			// fill tree with n values
			SearchTree tree = new SearchTree();
			for (int v : values1) {
				tree.insertIter(v);
			}

			// insert and later extract a fixed number (REPEAT) of values
			long t1 = System.nanoTime();
			for (int v : values2) {
				tree.insertIter(v);
			}
			long t2 = System.nanoTime();
			int res = 0;
			for (int i = 0; i < REPEAT; i++) {
				res = tree.extractMin();
			}
			long t3 = System.nanoTime();
			double timeInsertMS = (t2 - t1) / 1e6;
			double timeExtractMS = (t3 - t2) / 1e6;

			System.out.printf("n = %9d: insert: %8.3f ms, extractMin: %8.3f ms%n", n, timeInsertMS, timeExtractMS);
		}
		System.out.println("--- finished ---");

	}

	public static void runtimeEquals() {
		System.out.println("Runtime equals():");

		for (int n = 100; n <= MAX_N; n *= 10) {
			// generate two trees with the same set of values
			int[] values1 = generateRandomValues(n);
			SearchTree t1 = new SearchTree();
			SearchTree t2 = new SearchTree();

			int last = values1.length - 1;
			for (int j = 0; j <= last; j++) {
				t1.insert(values1[j]);
				t2.insert(values1[last - j]);
			}
			long start = System.nanoTime();
			boolean res = t1.equals(t2);
			long end = System.nanoTime();
			System.out.printf("n = %9d: result=%b, time %8.2f ms%n", n, res, (end - start) / 1e6);
		}
		System.out.println("--- finished ---");
	}

	private static Random rand = new Random();

	public static int[] generateRandomValues(int n) {
		int[] values = new int[n];
		for (int i = 0; i < values.length; i++) {
			values[i] = rand.nextInt(100 * n);
		}
		return values;
	}

}
