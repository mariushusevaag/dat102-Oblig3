package no.hvl.dat102.oppgave4;

public class Table<T extends Comparable<T>> implements Sortable<T> {

	private T[] table;
	private int length;

	public Table(int n) {
		table = ((T[]) new Comparable[5]);
	}

	// Legger til et element på enden av tabellen
	public void add(T s) {
		if (length == table.length)
			this.expand();

		table[length] = s;
		length++;
	}

	// Utvider tabellen
	public void expand() {
		T[] t = ((T[]) new Comparable[table.length * 2]);

		for (int i = 0; i < table.length; i++) {
			t[i] = table[i];
		}

		table = t;
	}

	// Sorteringsmetoder
	public T[] insertionSort() {
		T[] arr = ((T[]) new Comparable[length]);

		for (int i = 0; i < length; i++) {
			arr[i] = table[i];
		}

		long t_0, t_1;

		t_0 = System.nanoTime();

		T temp;
		for (int i = 1; i < arr.length; i++) {
			for (int j = i; j > 0; j--) {
				if (arr[j].compareTo(arr[j - 1]) < 0) {
					temp = arr[j];
					arr[j] = arr[j - 1];
					arr[j - 1] = temp;
				}
			}
		}

		t_1 = System.nanoTime();

		System.out.println("\n\nMålt tid i ns: " + (t_1 - t_0));

		return arr;
	}

	public T[] selectionSort() {
		T[] arr = ((T[]) new Comparable[length]);

		for (int i = 0; i < length; i++) {
			arr[i] = table[i];
		}

		long t_0, t_1;

		t_0 = System.nanoTime();

		for (int i = 0; i < arr.length - 1; i++) {
			int cur = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j].compareTo(arr[cur]) < 0) {
					cur = j;
				}
			}
			T less = arr[cur];
			arr[cur] = arr[i];
			arr[i] = less;
		}

		t_1 = System.nanoTime();

		System.out.println("\n\nMålt tid i ns: " + (t_1 - t_0));

		return arr;
	}

	public T[] bubbleSort() {
		T[] arr = ((T[]) new Comparable[length]);

		for (int i = 0; i < length; i++) {
			arr[i] = table[i];
		}

		long t_0, t_1;

		t_0 = System.nanoTime();

		T temp;
		for (int i = 0; i < length; i++) {
			for (int j = 1; j < (length - i); j++) {
				if (arr[j - 1].compareTo(arr[j]) > 0) {
					temp = arr[j - 1];
					arr[j - 1] = arr[j];
					arr[j] = temp;
				}
			}
		}

		t_1 = System.nanoTime();

		System.out.println("\n\nMålt tid i ns: " + (t_1 - t_0));

		return arr;
	}

	private T[] quickSortRecursive(T[] arr, int l, int r) {
		int i = l, j = r;
		T tmp;
		T pivot = arr[(l + r) / 2];

		while (i <= j) {
			while (arr[i].compareTo(pivot) < 0)
				i++;
			while (arr[j].compareTo(pivot) > 0)
				j--;
			if (i <= j) {
				tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
				i++;
				j--;
			}
		}
		;

		if (l < j) {
			quickSortRecursive(arr, l, j);
		}

		if (i < r) {
			quickSortRecursive(arr, i, r);
		}

		return arr;
	}

	public T[] quickSort() {
		T[] arr = ((T[]) new Comparable[length]);

		for (int i = 0; i < length; i++) {
			arr[i] = table[i];
		}

		long t_0, t_1;
		t_0 = System.nanoTime();

		T[] result = quickSortRecursive(arr, 0, arr.length - 1);

		t_1 = System.nanoTime();
		System.out.println("\n\nMålt tid i ns: " + (t_1 - t_0));

		return result;
	}

	private T[] msMerge(T[] arr, int l, int m, int r) {
		int n1 = m - l + 1;
		int n2 = r - m;

		T[] L = ((T[]) new Comparable[n1]);
		T[] R = ((T[]) new Comparable[n2]);

		for (int i = 0; i < n1; ++i) {
			L[i] = arr[l + i];
		}

		for (int j = 0; j < n2; ++j) {
			R[j] = arr[m + 1 + j];
		}

		int i = 0, j = 0;
		int k = l;
		while (i < n1 && j < n2) {
			if (L[i].compareTo(R[j]) <= 0) {
				arr[k] = L[i];
				i++;
			} else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}

		while (i < n1) {
			arr[k] = L[i];
			i++;
			k++;
		}

		while (j < n2) {
			arr[k] = R[j];
			j++;
			k++;
		}

		return arr;
	}

	private T[] mergeSortRecursive(T[] arr, int l, int r) {
		if (l < r) {
			int m = (l + r) / 2;

			mergeSortRecursive(arr, l, m);
			mergeSortRecursive(arr, m + 1, r);

			return msMerge(arr, l, m, r);
		}

		return arr;
	}

	public T[] mergeSort() {
		T[] arr = ((T[]) new Comparable[length]);

		for (int i = 0; i < length; i++) {
			arr[i] = table[i];
		}

		long t_0, t_1;
		t_0 = System.nanoTime();

		T[] result = mergeSortRecursive(arr, 0, arr.length - 1);

		t_1 = System.nanoTime();
		System.out.println("\n\nMålt tid i ns: " + (t_1 - t_0));

		return result;
	}

	// Fungerer bare med ínt
	public int[] radixSort() {
		int[] arr = new int[length];

		try {
			for (int i = 0; i < length; i++) {
				arr[i] = ((int) table[i]);
			}
		} catch (Exception ex) {
			return null;
		}

		long t_0, t_1;

		t_0 = System.nanoTime();

		int i, m = arr[0], exp = 1, n = arr.length;
        int[] b = new int[length];
        for (i = 1; i < n; i++) {
            if (arr[i] > m) {
				m = arr[i];
			}
		} 

        while (m / exp > 0) {
            int[] temp = new int[length];
 
            for (i = 0; i < n; i++)
                temp[(arr[i] / exp) % 10]++;
            for (i = 1; i < 10; i++)
                temp[i] += temp[i - 1];
            for (i = n - 1; i >= 0; i--)
                b[--temp[(arr[i] / exp) % 10]] = arr[i];
            for (i = 0; i < n; i++)
                arr[i] = b[i];
            exp *= 10;        
		}

		t_1 = System.nanoTime();

		System.out.println("\n\nMålt tid i ns: " + (t_1 - t_0));

		return arr;
	}
	
	public static <T extends Comparable<T>> void quickSortNew(T[] data) {
        quickSort2(data, 0, data.length-1);
        insertionSort2(data, 0, data.length-1);
    }

    public static final int MIN = 20;

    public static <T extends Comparable<T>> void quickSort2(T[] data, int min, int maks) {
        int posPartisjon;
        if(maks - min + 1 > MIN) {
            posPartisjon = finnPartisjon(data, min, maks);
            quickSort2(data, min, posPartisjon - 1);
            quickSort2(data, posPartisjon + 1, maks);
        }
    }

    public static <T extends Comparable<T>> void insertionSort2(T[] data, int forste, int siste) {
        for (int indeks = forste + 1; indeks <= siste; indeks++) {
            T nokkel = data[indeks];
            int p = indeks;
            while (p > 0 && data[p-1].compareTo(nokkel) > 0) {
                data[p] = data[p-1];
                p--;
            }
            data[p] = nokkel;
        }
    }
    
    private static <T extends Comparable<T>> int finnPartisjon(T[] tab, int min, int maks) {
        int venstre = min;
        int hogre = maks;
        T pivot = tab[min];

        while (venstre < hogre) {
            while (venstre <= maks && tab[venstre].compareTo(pivot) <= 0) {
                venstre++;
            }
            while (hogre >= min && tab[hogre].compareTo(pivot) > 0) {
                hogre--;
            }

            if(venstre < hogre) {
                T temp = tab[hogre];
                tab[hogre] = tab[venstre];
                tab[venstre] = temp;
            }
        }

        tab[min] = tab[hogre];
        tab[hogre] = pivot;

        return hogre;
    }
}