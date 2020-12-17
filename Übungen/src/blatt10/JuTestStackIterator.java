package blatt10;

//JUnit 5 (Jupiter)
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;

//JUnit 4
//import static org.junit.Assert.*;
//import org.junit.Before;
//import org.junit.Test;

import java.util.Random;

public class JuTestStackIterator {
	
	@Test
	public void test01() throws StackException {
		ArrayStack<String> stack = new ArrayStack<String>(10);
		stack.push("A");
		stack.push("B");
		stack.push("C");
		
		// einmal alle Einträge durchgehen (ausgehend von oben)
		Iterator<String> iter = stack.iterator();
		assertTrue(iter.hasNext());
		assertEquals("C", iter.next());
		assertTrue(iter.hasNext());
		assertEquals("B", iter.next());
		assertTrue(iter.hasNext());
		assertEquals("A", iter.next());
		assertFalse(iter.hasNext());
		
		// nochmal alle Einträge durchgehen (ausgehend von oben)
	    iter = stack.iterator();
		assertTrue(iter.hasNext());
		assertEquals("C", iter.next());
		assertTrue(iter.hasNext());
		assertEquals("B", iter.next());
		assertTrue(iter.hasNext());
		assertEquals("A", iter.next());
		assertFalse(iter.hasNext());
		
		
	}
	
	@Test
	public void test02() throws StackException {
		ArrayStack<String> stack = new ArrayStack<String>(10);
		stack.push("A");
		stack.push("B");
		stack.push("C");
		
		// einmal alle Einträge durchgehen (ausgehend von oben)
		String res = "";
		for (String str : stack) {
			res += str;
		}
		assertEquals("CBA", res);
	
		// nochmal alle Einträge durchgehen 
		res = "";
		for (String str : stack) {
			res += str;
		}
		assertEquals("CBA", res);
	
	}
}
