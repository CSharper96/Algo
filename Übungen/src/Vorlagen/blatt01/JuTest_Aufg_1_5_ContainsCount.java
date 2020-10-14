package blatt01;


//JUnit 5 (Jupiter)
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class JuTest_Aufg_1_5_ContainsCount {

	@Test
	public void testContains0() {
		double[] a0 = {};
		assertEquals(false, Aufg_1_5_ContainsCount.contains(3.0, a0, a0.length-1));
	}
		
	@Test
	public void testContains1() {
		double[] a1 = { 3.0 };

		assertEquals(true, Aufg_1_5_ContainsCount.contains(3.0, a1, a1.length-1));
		assertEquals(false, Aufg_1_5_ContainsCount.contains(4.0, a1, a1.length-1));
		
	}
		
	@Test
	public void testContains2() {
		
		double[] a2 = { 3.0, 4.0, 8.0 };
		assertEquals(true, Aufg_1_5_ContainsCount.contains(3.0, a2, a2.length-1));
		assertEquals(true, Aufg_1_5_ContainsCount.contains(4.0, a2, a2.length-1));
		assertEquals(false, Aufg_1_5_ContainsCount.contains(5.0, a2, a2.length-1));
		assertEquals(true, Aufg_1_5_ContainsCount.contains(8.0, a2, a2.length-1));
	}


	
	@Test
	public void testCount1() {
		char[] c1 = {'a'};
		
		assertEquals(1, Aufg_1_5_ContainsCount.count('a', c1));
		assertEquals(0, Aufg_1_5_ContainsCount.count('b', c1));
	}
	
	@Test
	public void testCount2() {
		char[] c1 = {'a', 'b', 'b', 'a', 'c', 'a',  'd' };
		
		assertEquals(3, Aufg_1_5_ContainsCount.count('a', c1));
		assertEquals(2, Aufg_1_5_ContainsCount.count('b', c1));
		assertEquals(1, Aufg_1_5_ContainsCount.count('c', c1));
		assertEquals(1, Aufg_1_5_ContainsCount.count('d', c1));
		assertEquals(0, Aufg_1_5_ContainsCount.count('x', c1));


	}

	
}
