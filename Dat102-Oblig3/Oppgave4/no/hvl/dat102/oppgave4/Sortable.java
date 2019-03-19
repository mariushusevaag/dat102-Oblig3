package no.hvl.dat102.oppgave4;

public interface Sortable<T> {
	public T[] insertionSort();
	public T[] selectionSort();
	public T[] bubbleSort();
	public T[] quickSort();
	public T[] mergeSort();
	public int[] radixSort();
}