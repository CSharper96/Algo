package blatt06.aufg6_3_prioqueue;

//JUnit 5 (Jupiter)
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

//JUnit 4
//import static org.junit.Assert.*;
//import org.junit.Before;
//import org.junit.Test;

import java.util.Random;

public class JuTestHeapQueue {
 
	public static int ANZAHL = 100;

	 
	
	@Test
	public void test01EmptyFull() {
		IPriorityQueue<String> prioQueue = new HeapQueue<String>(ANZAHL);
		 
		//Prioritätenwarteschlange am Anfang leer
		assertTrue(prioQueue.isEmpty());
		assertFalse(prioQueue.isFull());
		
		//Eintrags einfügen ==> nicht mehr leer
		prioQueue.insert(new Eintrag<String>("Xaver", 4));
		assertFalse(prioQueue.isEmpty());
		assertFalse(prioQueue.isFull());

		//noch einen Eintrag einfügen ==> nicht leer
		prioQueue.insert(new Eintrag<String>("Yvonne", 3));
		assertFalse(prioQueue.isEmpty());
		assertFalse(prioQueue.isFull());
		
		//einen Eintrag entfernen ==> noch nicht leer
		prioQueue.extractMin();
		assertFalse(prioQueue.isEmpty());
		assertFalse(prioQueue.isFull());
		
		//Eintrag einfügen ==> 
		prioQueue.insert(new Eintrag<String>("Zoe", 1));
		assertFalse(prioQueue.isEmpty());
		assertFalse(prioQueue.isFull());

		//einen Eintrag entfernen ==> noch nicht leer
		prioQueue.extractMin();
		assertFalse(prioQueue.isEmpty());
		assertFalse(prioQueue.isFull());
		
		//noch einen Eintrag entfernen ==> jezt wieder leer
		prioQueue.extractMin();
		assertTrue(prioQueue.isEmpty());
		assertFalse(prioQueue.isFull());

	}

	
	@Test
	public void test02insertExtractMin() {
		IPriorityQueue<String> prioQueue = new HeapQueue<String>(ANZAHL);

		Eintrag<String> e1a = new Eintrag<String>("E1a", 1);
		Eintrag<String> e1b = new Eintrag<String>("E1b", 1);
		Eintrag<String> e2a = new Eintrag<String>("E2a", 2);
		Eintrag<String> e2b = new Eintrag<String>("E2b", 2);
		Eintrag<String> e3 = new Eintrag<String>("E3", 3);
		Eintrag<String> e4 = new Eintrag<String>("E4", 4);
		Eintrag<String> e5 = new Eintrag<String>("E5", 5);
		Eintrag<String> e6 = new Eintrag<String>("E6", 6);
		
		//einige Werte eintragen
		prioQueue.insert(e3);
		prioQueue.insert(e2a);
		prioQueue.insert(e5);
		prioQueue.insert(e1a);
		prioQueue.insert(e2b);
		
		//Inhalt jetzt: {e1a, e2a, e2b,e3, e5}
		
		//Wert entfernen, sollte Priorität 1 haben
		Eintrag<String> emin = prioQueue.extractMin();
		assertEquals(1, emin.gibPrio());
		
		//Inhalt jetzt: {e2a, e2b,e3, e5}
		
		//Wert entfernen, sollte Priorität 2 haben
		emin = prioQueue.extractMin();
		assertEquals(2, emin.gibPrio());
				
		//Inhalt jetzt: {e2b,e3, e5}
		
		//Werte einfügen
		prioQueue.insert(e4);
		prioQueue.insert(e1b);
		
		//Inhalt jetzt: {e1b, e2b, e3, e4, e5}
		
		//Wert entfernen, sollte Priorität 1 haben
		emin = prioQueue.extractMin();
		assertEquals(1, emin.gibPrio());
		
		//Wert entfernen, sollte Priorität 2 haben
		emin = prioQueue.extractMin();
		assertEquals(2, emin.gibPrio());
		
		//Wert entfernen, sollte Priorität 3 haben
		emin = prioQueue.extractMin();
		assertEquals(3, emin.gibPrio());
		
		//Inhalt jetzt: {e4, e5}
		
		//Werte einfügen
		prioQueue.insert(e6);

		//Inhalt jetzt: {e4, e5, e6}

		
		//Wert entfernen, sollte Priorität 4 haben
		emin = prioQueue.extractMin();
		assertEquals(4, emin.gibPrio());

		//Wert entfernen, sollte Priorität 5 haben
		emin = prioQueue.extractMin();
		assertEquals(5, emin.gibPrio());


		//Wert entfernen, sollte Priorität 6 haben
		emin = prioQueue.extractMin();
		assertEquals(6, emin.gibPrio());

		//Warteschlange sollte jetzt leer sein
		assertTrue(prioQueue.isEmpty());	
	}
	
	
	@Test
	public void test03Random() {
		IPriorityQueue<String> prioQueue = new HeapQueue<String>(ANZAHL);

		//zufällig gewählte Einträge in der Warteschlange ablegen 
		for (int i = 0; i < ANZAHL; i++) {
			Eintrag<String> neu = randEintrag(1000);
			prioQueue.insert(neu);
		}		

		assertTrue(prioQueue.isFull());
		
		// Alle Einträge entfernen, müssen nach Priorität geordnet sein
		Eintrag<String> current = prioQueue.extractMin();
		Eintrag<String> previous;
		int count = 1;
		while (! prioQueue.isEmpty()) {
			previous = current;
			Eintrag<String> next = prioQueue.extractMin();
			assertTrue(next.gibPrio() >= previous.gibPrio());
			count++;
		}
		assertEquals(ANZAHL, count);
	
	}

	public static Random rand = new Random();
	
	public static Eintrag<String> randEintrag(int maxValue) {
		int prio = rand.nextInt(maxValue); 
		return new Eintrag<String>("V"+prio, prio);
	}
	
}
