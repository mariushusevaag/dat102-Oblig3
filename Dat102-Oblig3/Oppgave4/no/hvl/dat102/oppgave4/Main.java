package no.hvl.dat102.oppgave4;

import java.util.Random;

public class Main {

	public static void sortTest(Comparable[] testArr, String algoritme) {
		System.out.println("\nTest av " + algoritme);

		for (int i = 0; i < testArr.length; i++) {
			//System.out.println(testArr[i]);
		}
	}

	public static void sortTest(int[] testArr, String algoritme) {
		System.out.println("\nTest av " + algoritme);

		for (int i = 0; i < testArr.length; i++) {
			//System.out.println(testArr[i]);
		}
	}

	public static void main(String[] args) {
		Table<Integer> t = new Table<Integer>(150000);
		Random rand = new Random(1024);
		int n = 8000;

		// Legger til elementer i tabell for sortering
		for (int i = 0; i < n; i++) {
			t.add(rand.nextInt(100));
		}

		System.out.println("----- Kjøring 1 -----");

		sortTest(t.insertionSort(), "sortering ved innsetting");
		sortTest(t.selectionSort(), "sortering ved utvalg");
		sortTest(t.bubbleSort(), "boblesortering");
		sortTest(t.quickSort(), "quick-sort");
		sortTest(t.mergeSort(), "flettesortering");
		sortTest(t.radixSort(), "radix-sortering");


		System.out.println("\n\n----- Kjøring 2 -----");

		sortTest(t.insertionSort(), "sortering ved innsetting");
		sortTest(t.selectionSort(), "sortering ved utvalg");
		sortTest(t.bubbleSort(), "boblesortering");
		sortTest(t.quickSort(), "quick-sort");
		sortTest(t.mergeSort(), "flettesortering");
		sortTest(t.radixSort(), "radix-sortering");
	}
}
