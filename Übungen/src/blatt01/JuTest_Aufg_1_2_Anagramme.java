package blatt01;

//JUnit 5 (Jupiter)
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;


public class JuTest_Aufg_1_2_Anagramme {

	
	@Test
	public void testAnagrammeTrue() {
		assertTrue( Aufg_1_2_Anagramme.sindAnagramme("WIEN", "WEIN") );
		assertTrue( Aufg_1_2_Anagramme.sindAnagramme("LAMPE", "PALME") );
		assertTrue( Aufg_1_2_Anagramme.sindAnagramme("PERMUTATION", "TRAUMPOETIN") );
		assertTrue( Aufg_1_2_Anagramme.sindAnagramme("SCHUTZUMSCHLAG", "UMZUGSSCHLACHT") );
	
	}		

	@Test
	public void testAnagrammeFalse() {
		assertFalse( Aufg_1_2_Anagramme.sindAnagramme("WIEN", "WEEN") );
		assertFalse( Aufg_1_2_Anagramme.sindAnagramme("LMPE", "PALME") );
		assertFalse( Aufg_1_2_Anagramme.sindAnagramme("PERMUTATION", "RRAUMPOETIX") );
		assertFalse( Aufg_1_2_Anagramme.sindAnagramme("SCHUTZUMSCHLAG", "UMZGSSSCHLACHT") );
	
	}	
}
