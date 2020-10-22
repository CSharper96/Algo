package blatt02;

import java.util.*;

public class Aufg2_3_GenStrings {

	public static TreeSet<String> generateStrings(char[] chSet, int length)
	{
		ArrayList<Character> chArray = new ArrayList<>();
		for(char chr : chSet) chArray.add(chr);
		Collections.sort(chArray);
		String start = "";
		String end = "";
		for(int i = 0; i < length; i++)
		{
			start += chArray.get(0);
			end += chArray.get(length);
		}
		return generateAllPossibleStrings(start, end);
	}

	
	public static void main(String[] args) {
		char[] characters = { 'A', 'B', 'C', 'D', 'E' };
		int count = 0;
		for (String sequence : generateStrings(characters, 4)) {
			count++;
			System.out.printf("%5d. %s%n", count, sequence);
		}
	}

	public static TreeSet<String> generateAllPossibleStrings(String start, String end) {
		if(start==null||end==null)
			return null;
		if (start.length() != end.length())
			return null;
		int n = start.length();
		TreeSet<String> variants = new TreeSet<String>();
		char startArray[] = start.toCharArray();
		char endArray[] = end.toCharArray();
		char currentArray[] = Arrays.copyOf(startArray, startArray.length);
		variants.add(new String(currentArray));

		boolean possible = true;
		for(int i = 0; i<n; i++)
			possible = possible && (startArray[i]<=endArray[i]);
		if (!possible)
			return variants;


		while(!end.equals(new String(currentArray))){
			currentArray[n-1]+=1;
			int i = n-1;
			while(currentArray[i]>endArray[i]){
				currentArray[i]=startArray[i];
				i--;
				currentArray[i]++;
			}
			variants.add(new String(currentArray));
		}

		System.out.println(Arrays.toString(variants.toArray()));
		return variants;
	}
}
