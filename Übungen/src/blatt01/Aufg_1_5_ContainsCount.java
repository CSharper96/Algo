package blatt01;

import javafx.util.Pair;

import java.util.Arrays;

public class Aufg_1_5_ContainsCount {

	/** 
	 * Checks if value x is contained in arr[0..endIndex]
	 */
	public static boolean contains(double x, double[] arr, int endIndex) {
		if(endIndex >= 0 && endIndex < arr.length)
		{
			double value = arr[endIndex];
			if (value == x)
				return true;
			else return contains(x, arr, --endIndex);
		}
		return false;
	}

	/** 
	 * Determines how often character ch occurs in array arr 
	 */
	static int counter = 0;
	public static int count(char ch, char[] arr)
	{
		if(arr.length > 0)
		{
			char lastElement = arr[arr.length - 1];
			if (lastElement == ch) counter += 1;
			return count(ch, crop(arr));
		}
		return counter;
	}
	public static char[] crop(char[] arr)
	{
		char[] croppedArray = new char[arr.length - 1];
		for (int i = 0; i < arr.length - 1; i++)
			croppedArray[i] = arr[i];
		return croppedArray;
	}

	private void demo() {
		int[] array = new int[5];
		System.out.println(Arrays.toString(array)); // 0, 0, 0, 0, 0
		fillArray(array);
		System.out.println(Arrays.toString(array)); // 0, 1, 2, 3, 4
	}

	private void fillArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			array[i] = i;
		}
	}

	public static void demoContains() {
		double[] a0 = {};
		double[] a1 = { 3.0 };
		double[] a2 = { 3.0, 4.0, 8.0 };

		System.out.println("a0: " + Arrays.toString(a0));
		System.out.println("3.0 contained in a0 enthalten: "
				+ contains(3.0, a0, a0.length - 1));
		System.out.println("4.0 contained in a0 enthalten: "
				+ contains(4.0, a0, a0.length - 1));

		System.out.println("a1: " + Arrays.toString(a1));
		System.out.println("3.0 contained in a1 enthalten: "
				+ contains(3.0, a1, a1.length - 1));
		System.out.println("4.0 contained in a1 enthalten: "
				+ contains(4.0, a1, a1.length - 1));

		System.out.println("a2: " + Arrays.toString(a2));
		System.out.println("3.0 contained in a2 enthalten: "
				+ contains(3.0, a2, a2.length - 1));
		System.out.println("4.0 contained in a2 enthalten: "
				+ contains(4.0, a2, a2.length - 1));
		System.out.println("5.0 contained in a2 enthalten: "
				+ contains(5.0, a2, a2.length - 1));
		System.out.println("8.0 contained in a2 enthalten: "
				+ contains(8.0, a2, a2.length - 1));
	}

	public static void demoCount() {
		char[] c1 = "mississippi".toCharArray();
		for (char ch = 'a'; ch <= 'z'; ch++){
			counter = 0;
			System.out.println("Count " + ch + ": " + count(ch, c1));
		};
		
	}

	public static void main(String[] args) {
		demoContains();
		System.out.println();
		demoCount();
	}

}
