package blatt01;

//JUnit 5 (Jupiter)
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class JuTest_Aufg_1_4_AlleEnthalten {

	private long[] m0 = {};
	private long[] m1 = {1,2,5};
	private long[] m2 = {2,5,1,5};
	private long[] m3 = {2,3,5};
	private long[] m4 = {1,5,7,2,9};
	
	private long[] a1;
	private long[] a2;
	
	public static final int LEN = 1000000;
	
	@BeforeEach
	public void setup() {
		a1 = new long[LEN];
		a2 = new long[LEN];
		
		for (int i = 0; i < LEN; i++) {
			a1[i] = i;
			a2[LEN - 1 - i] = i;
		}
	}
	
	@Test
	public void testTeilmenge0() {
		assertTrue(Aufg_1_4_Enthalten.alleEnthalten(m0, m0));
		assertTrue(Aufg_1_4_Enthalten.alleEnthalten(m0, m1));
		assertTrue(Aufg_1_4_Enthalten.alleEnthalten(m0, m2));
		assertTrue(Aufg_1_4_Enthalten.alleEnthalten(m0, m3));
		assertTrue(Aufg_1_4_Enthalten.alleEnthalten(m0, m4));
	}

	@Test
	public void testTeilmenge1() {
		assertFalse(Aufg_1_4_Enthalten.alleEnthalten(m1, m0));
		assertTrue(Aufg_1_4_Enthalten.alleEnthalten(m1, m1));
		assertTrue(Aufg_1_4_Enthalten.alleEnthalten(m1, m2));
		assertFalse(Aufg_1_4_Enthalten.alleEnthalten(m1, m3));
		assertTrue(Aufg_1_4_Enthalten.alleEnthalten(m1, m4));
	}
	
	@Test
	public void testTeilmenge2() {
		assertFalse(Aufg_1_4_Enthalten.alleEnthalten(m2, m0));
		assertTrue(Aufg_1_4_Enthalten.alleEnthalten(m2, m1));
		assertTrue(Aufg_1_4_Enthalten.alleEnthalten(m2, m2));
		assertFalse(Aufg_1_4_Enthalten.alleEnthalten(m2, m3));
		assertTrue(Aufg_1_4_Enthalten.alleEnthalten(m2, m4));
	}

	@Test
	public void testTeilmenge3() {
		assertFalse(Aufg_1_4_Enthalten.alleEnthalten(m3, m0));
		assertFalse(Aufg_1_4_Enthalten.alleEnthalten(m3, m1));
		assertFalse(Aufg_1_4_Enthalten.alleEnthalten(m3, m2));
		assertTrue(Aufg_1_4_Enthalten.alleEnthalten(m3, m3));
		assertFalse(Aufg_1_4_Enthalten.alleEnthalten(m3, m4));
	}

	@Test
	public void testTeilmenge4() {
		assertFalse(Aufg_1_4_Enthalten.alleEnthalten(m4, m0));
		assertFalse(Aufg_1_4_Enthalten.alleEnthalten(m4, m1));
		assertFalse(Aufg_1_4_Enthalten.alleEnthalten(m4, m2));
		assertFalse(Aufg_1_4_Enthalten.alleEnthalten(m4, m3));
		assertTrue(Aufg_1_4_Enthalten.alleEnthalten(m4, m4));
	}

	@Test
	public void testTeilmenge5() {
		assertTrue(Aufg_1_4_Enthalten.alleEnthalten(a1, a2));
		assertTrue(Aufg_1_4_Enthalten.alleEnthalten(a2, a1));
	}		

}
