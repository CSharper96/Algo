package blatt01;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;
import javax.swing.JOptionPane;

public class Aufg_1_2_Anagramme {

	
	public static boolean sindAnagramme(String s1, String s2)
	{
		char[] word1 = setLowerCase(s1.replaceAll("[\\s]", "").toCharArray());
		char[] word2 = setLowerCase(s2.replaceAll("[\\s]", "").toCharArray());
		Arrays.sort(word1);
		Arrays.sort(word2);
		return Arrays.equals(word1, word2);
	}
	private static char[] setLowerCase(char[] word)
	{
		char[] wordLowerCase = new char[word.length];
		for(int length = 0; length < word.length; length++)
		{
			if(Character.isUpperCase(word[length]))
				wordLowerCase[length] = Character.toLowerCase(word[length]);
			else
				wordLowerCase[length] = word[length];
		}
		return wordLowerCase;
	}

	private static Random rand = new Random();
	
	/**
	 * F�hrt Tests und Laufzeitmessungen für die Anagrammprüfung durch
	 * N = 100 => 0,2769 ms
	 * N = 1.000 => 1,0414 ms
	 * N = 10.000 => 1,8409 ms
	 * N = 100.000 => 6,5054 ms
	 * N = 1.000.000 => 19,7028 ms
	 */
	public static void main(String[] args) {
		simpleTests();
		
		String eingabe = JOptionPane.showInputDialog("maximale Länge für Anagrammtest:");
		if (eingabe == null) {
			System.out.println("Abgebrochen!");
			return;
		}
		int laenge = Integer.parseInt(eingabe);
		
		System.out.println("Anagramme: "); 
		for (int len = 100; len <= laenge; len *= 10) {
			String[] anas = erzeugeAnagramme(len);
			boolean result = testeAnagramme(anas[0], anas[1]);
			if (result == false) {
				throw new RuntimeException("Falsches Ergebnis beim Anagrammtest!");
			} else {
				System.out.println("O.K.");
			}

			System.out.println();
		}
		
		System.out.println();
		System.out.println("KEINE Anagramme:");
		for (int len = 100; len <= laenge; len *= 10) {
			String[] nonAnas = erzeugeNonAnagramme(len);
			boolean result = testeAnagramme(nonAnas[0], nonAnas[1]);
			if (result == true) {
				throw new RuntimeException("Falsches Ergebnis beim Anagrammtest!");
			} else {
				System.out.println("O.K.");
			}

			System.out.println();
		}
		
		System.out.println("fertig!");
	}
	
	


	
	/** Erzeugt einen String der angegebenen Länge aus zufüllig gewählten Zeichen zwischen 'A' und 'z'
	 */
	public static String erzeugeRandomString(int laenge) {
		//Zeichenkette aus zuf�lligen Zeichen erzeugen
		StringBuilder sb1 = new StringBuilder(laenge);
		for (int i = 0; i < laenge; i++) {
			char ch = (char) (rand.nextInt('z'-'A') + 'A');
			sb1.append(ch);
		}
		return sb1.toString();
	}
	
	/** Erzeugt zwei Strings der angegebenen Länge, die Anagramme sind */
	public static String[] erzeugeAnagramme(int laenge) {
		String s1 = erzeugeRandomString(laenge);

		//Permutation von s1 erzeugen
		
		//Zun�chst Kopie erzeugen
		StringBuilder sb2 = new StringBuilder(s1);
		for (int j = 0; j <= laenge / 4; j++) {
			//Zeichen an zwei zuf�llig gew�hlten Positionen
			//vertauschen
			int pos1 = rand.nextInt(laenge);
			int pos2 = rand.nextInt(laenge);
			char tmp1 = sb2.charAt(pos1);
			char tmp2 = sb2.charAt(pos2);
			sb2.setCharAt(pos1, tmp2);
			sb2.setCharAt(pos2, tmp1);
		}
	
		//beide Zeichenketten als Feld von zwei Strings zur�ck geben
		String s2 = sb2.toString();
		return new String[]{s1,s2};  //Feld mit s1 und s2 als Elementen zur�ckgeben
		
	}
	
	/** Erzeugt zwei Strings der angegebenen Länge, die keine Anagramme sind */
	public static String[] erzeugeNonAnagramme(int laenge) {
		String s1 = erzeugeRandomString(laenge);
		
		//Zun�chst von s1 Kopie erzeugen
		StringBuilder sb2 = new StringBuilder(s1);
			
		//letztes Zeichen ver�ndern
		int pos = sb2.length() - 1;
		if (sb2.charAt(pos) == 'X') {
			sb2.setCharAt(pos, 'a');
		} 
		else {
			sb2.setCharAt(pos, 'X');
		}
		
		//beide Zeichenketten als Feld von zwei Strings zur�ck geben
		String s2 = sb2.toString();
		return new String[]{s1,s2};  //Feld mit s1 und s2 als Elementen zur�ckgeben
		
	}
	
	
	/** Prüft, ob beide Strings s1 und s2 Anagramme sind und misst die Laufzeit für den Test */
	private static boolean testeAnagramme(String s1, String s2) {
		System.out.println("L�nge s1: " + s1.length());
		System.out.println("L�nge s2: " + s2.length());
		
		long tStart = System.nanoTime();
		boolean res = sindAnagramme(s1, s2);
		long tEnd = System.nanoTime();
		
		System.out.println("sind Anagramme?: " + res);
		
		System.out.println("Laufzeit: " + (tEnd - tStart)/1e6 + " msec.");
		return res;
	}
	
	
	/** einige einfache Tests für Anagramme */
	private static void simpleTests() {
		System.out.println("LAMPE/PALME: " + sindAnagramme("LAMPE", "PALME"));
		System.out.println("WIEN/WEIN: " + sindAnagramme("WIEN","WEIN"));
		System.out.println("SCHUTZUMSCHLAG/UMZUGSSCHLACHT: " + sindAnagramme("SCHUTZUMSCHLAG","UMZUGSSCHLACHT"));	
	}
}
