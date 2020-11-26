package blatt07;


/** JUnit testcases for class SearchTree
 * 
 */

//JUnit 5
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

////JUnit 4
//import org.junit.*;
//import static org.junit.Assert.*;


import java.util.ArrayList;

public class JuTestSearchTree {
	//beide Felder enthalten die gleichen Werte 1 bis 10, allerdings in
	//unterschiedlicher Reihenfolge
	public final static int[] werte1 = {4,2,1,7,5,8,9,3,10,6};
	public final static int[] werte2 = {9,10,8,6,4,2,1,7,5,3};
	
	/** sum-Methode für Bäume prüfen, Reihenfolge 1 */
	@Test
	public void testSum1() {
		//Suchbaum erzeugen
		SearchTree tree1 = new SearchTree();

		//Leere Baum liefert Summe 0
		assertEquals(0, tree1.sum());

		//Werte 1 bis 10 eintragen (in unterschiedlicher Reihenfolge)
		for (int n : werte1) {
			tree1.insert(n);
		}
						
		//Summe der Werte von 1 bis 10 ist 55
		assertEquals(55, tree1.sum());
		
		//Wert 3 einfügen (war schon enthalten)
		assertEquals(false, tree1.insert(3));	
		
		//Wert 42 einfügen (bisher noch nicht enthalten)
		assertEquals(true,  tree1.insert(42));
		assertEquals(97, tree1.sum());
	}

	/** sum-Methode für Bäume prüfen,  Reihenfolge 2  */
	@Test
	public void testSum2() {
		//Zwei Suchbäume erzeugen
		SearchTree tree2 = new SearchTree();

		//Leere Baum liefert Summe 0
		assertEquals(0, tree2.sum());

		//Werte 1 bis 10 eintragen (in unterschiedlicher Reihenfolge)
		for (int n : werte2) {
			tree2.insert(n);
		}
						
		//Summe der Werte von 1 bis 10 ist 55
		assertEquals(55, tree2.sum());
		
		//Wert 3 einfügen (war schon enthalten)
		assertEquals(false, tree2.insert(3));	
		
		//Wert 42 einfügen (bisher noch nicht enthalten)
		assertEquals(true,  tree2.insert(42));
		assertEquals(97, tree2.sum());
	}

	
	/** numOfLeaves-Methode für Bäume prüfen */
	@Test
	public void testNumOfLeaves1() {
		SearchTree t1 = new SearchTree();

		//leere Baum hat 0 Blätter
		assertEquals(0, t1.leaves());
		
		//Baum mit einem Knoten hat 1 Blatt
		t1.insert(1);
		assertEquals(1, t1.leaves());
		
		//degenerierten, listenartigen Baum erzeugen, der nur ein Blatt hat
		for (int n = 2; n <= 10; n++) {
			t1.insert(n);
		}	
		
		System.out.println("testNumOfLeaves1 - t1:");
		t1.print();
		int n1 = t1.leaves();
		System.out.println("NumOfLeaves: " + n1);
		
		assertEquals(1, n1);
	}
	

	/** numOfLeaves-Methode für Bäume prüfen */
	@Test
	public void testNumOfLeaves2() {
		//vollständigen Baum der Höhe 2 (d.h. mit 4 Blättern)
		//erzeugen
		//         5
		//       /   \
		//      3     7
		//     / \   / \
		//    2   4 6   8
		SearchTree t2 = new SearchTree();
		t2.insert(5);
		t2.insert(3);
		t2.insert(7);
		
		t2.insert(2);
		t2.insert(4);
		t2.insert(6);
		t2.insert(8);

		System.out.println("testNumOfLeaves2 - t2:");
		t2.print();
		int n2 = t2.leaves();
		System.out.println("NumOfLeaves: " + n2);
		assertEquals(4, n2);
	}
	
	/** numOfLeaves-Methode für Bäume prüfen */
	@Test
	public void testNumOfLeaves3() {
		//Baum mit zwei Blättern erzeugen	
		//		
		//		  5
		//      /   \
		//     3     7
		//    /     /
		//   2     6
		//
		SearchTree t3 = new SearchTree();
		t3.insert(5);
		t3.insert(3);
		t3.insert(7);
		t3.insert(2);
		t3.insert(6);

		System.out.println("testNumOfLeaves3 - t3:");
		t3.print();
		int n3 = t3.leaves();
		System.out.println("numOfLeaves: " + n3);

		assertEquals(n3, 2);
	}
	
	
	@Test
	public void testInsertIter1() {
		SearchTree t1 = new SearchTree();
		
		for (int n : werte1) {
			t1.insertIter(n);
		}
		
		for (int v = 1; v <= 10; v++) {
			TreeNode res = t1.searchNode(v);
			assertEquals(v, res.info);
		}
		
		assertEquals(null, t1.searchNode(42));
	}
	
	
	@Test
	public void testInsertIter2() {
		SearchTree t1 = new SearchTree();
		
		for (int i = 1; i <= 10; i++) {
			t1.insertIter(i);
		}
		
		for (int v = 1; v <= 10; v++) {
			TreeNode res = t1.searchNode(v);
			assertEquals(v, res.info);
		}
		
		assertEquals(null, t1.searchNode(42));
	}
	
	@Test
	public void testInsertIter3() {
		SearchTree t1 = new SearchTree();
		
		for (int i = 10; i >= 1; i--) {
			t1.insertIter(i);
		}
		
		for (int v = 1; v <= 10; v++) {
			TreeNode res = t1.searchNode(v);
			assertEquals(v, res.info);
		}
		
		assertEquals(null, t1.searchNode(42));
	}
	
	

	/** toList-Methode für Bäume prüfen */
	@Test
	public void testToSortedList1() {
		SearchTree tree = new SearchTree();
		ArrayList<Integer> list;
		
		//leerer Baum sollte leere Liste ergeben
		list = tree.toSortedList();
		assertEquals(0, list.size());

		//10 unterschiedliche Werte (von 1 bis 10) in den Baum einfügen
		for (int n : werte1) {
			tree.insert(n);
		}
		
		//Baum sollte jetzt Liste der Länge 10 ergeben
		list = tree.toSortedList();

		//Liste sollte aus den Elementen 1 bis 10 aufsteigend bestehen
		assertEquals(10, list.size());
		for (int i = 0; i < 10; i++) {
			int wert = list.get(i);
			assertEquals(i+1, wert);
		}	
	}

	/** toList-Methode für Bäume prüfen */
	@Test
	public void testToSortedList2() {
		SearchTree tree = new SearchTree();
		ArrayList<Integer> list;
		
		//10 unterschiedliche Werte (von 1 bis 10) in den Baum einfügen
		//Reihenfolge entsprechend Feld
		for (int n : werte2) {
			tree.insert(n);
		}
		
		//Baum sollte jetzt Liste der Länge 10 ergeben
		list = tree.toSortedList();

		//Liste sollte aufsteigend aus den Elementen 1 bis 10 bestehen
		assertEquals(10, list.size());
		for (int i = 0; i < 10; i++) {
			int wert = list.get(i);
			assertEquals(i+1, wert);
		}	
	}

	
	/** extractMin-Methode für Suchbäume prüfen */
	@Test
	public void testExtractMin_1() {
		//Baum mit 10 Werten aus dem Feld werte1 erzeugen
		SearchTree tree1 = new SearchTree();				
		for (int n : werte1) {
			tree1.insert(n);
		}
		
		//Baum mit Werten aus dem Feld werte2 erzeugen
		SearchTree tree2 = new SearchTree();
		for (int n : werte2) {
			tree2.insert(n);
		}

		//Baum mit Werten von 1 bis 10 erzeugen
		SearchTree tree3 = new SearchTree();
		for (int n = 1; n <= 10; n++) {
			tree3.insert(n);
		}
		
		//nacheinander jeweils die 10 kleisnten Elemente aus
		//den Bäumen entnehmen. Sollt bei allen drei Bäumen die Folge der
		//Zahlen von 1 bis 10 liefern
		for (int expected = 1; expected <= 10; expected++) {
			assertEquals(expected, tree1.extractMin());
			assertEquals(expected, tree2.extractMin());
			assertEquals(expected, tree3.extractMin());
		}
		
		//nun sollten die Bäume alle leer sein
		assertTrue(tree1.isEmpty());
		assertTrue(tree2.isEmpty());
		assertTrue(tree3.isEmpty());
	}
	
	/** extractMin-Methode für Suchbäume prüfen */
	@Test
	public void testExtractMin_2() {
		//Baum mit 10 Werten aus dem Feld werte1 erzeugen
		SearchTree tree = new SearchTree();				
		for (int n : werte1) {
			tree.insert(n);
		}

		//die 5 kleinsten Werte entnehmen (1,2,..,5)
		assertEquals(1, tree.extractMin());
		assertEquals(2, tree.extractMin());
		assertEquals(3, tree.extractMin());
		assertEquals(4, tree.extractMin());
		assertEquals(5, tree.extractMin());
		
		//erneut die Werte 1 .. 5 eintragen
		tree.insertIter(5);
		tree.insertIter(2);
		tree.insertIter(4);
		tree.insertIter(1);
		tree.insertIter(3);
		
		//alle Werte mit extractMin entnehmen. Sollte 10 bis 1 liefern
		for (int n = 1; n <= 10; n++) {
			int next = tree.extractMin();
			assertEquals(n, next);
		}
		
		assertTrue(tree.isEmpty());
	}
	
	
	
	/** equals-Methode für Bäume prüfen */
	@Test
	public void testEquals_1() {
	   	final int[] data1 = {4,2,12,1,7,11,5,8,15,9,13,14,3,10,6};
    	final int[] data2 = {7,11,5,8,4,2,12,1,15,14,3,10,6,9,13}; // gleiche Menge wie werte1, andere Reihenfolge
    	final int[] data3 = {7,11,5,8,4,2,12,1,55,14,3,10,6,9,13}; // andere Wertemenge

		//Bäume mit den gleichen Werten, aber unterschiedlicher
		//Struktur aufbauen
		SearchTree tree1 = new SearchTree();
		for (int n : data1) {
			tree1.insert(n);
		}
		
		SearchTree tree2 = new SearchTree();		
		for (int n : data2) {
			tree2.insert(n);
		}
			
		SearchTree tree3 = new SearchTree();		
		for (int n : data3) {
			tree3.insert(n);
		}
		
		assertTrue(tree1.equals(tree2));
		assertTrue(tree2.equals(tree1));
		
		assertFalse(tree1.equals(tree3));
		assertFalse(tree3.equals(tree1));

		assertFalse(tree2.equals(tree3));
		assertFalse(tree3.equals(tree2));

	}
		
	/** equals-Methode für Bäume prüfen */
	@Test
	public void testEquals_2() {
		//Baum mit den Werten 1 bis 10 erzeugen
		SearchTree tree1 = new SearchTree();
		for (int n : werte1) {
			tree1.insert(n);
		}
	
		
		//zweiten Baum mit den Werten 1 bis 10 erzeugen
		SearchTree tree2 = new SearchTree();		
		for (int n : werte2) {
			tree2.insert(n);
		}
		
		assertTrue(tree1.equals(tree2));
		
		tree1.insert(42);
		//Beide Bäume sollten nicht mehr gleich sein
		
		assertFalse(tree1.equals(tree2));
	}
	
}
