package no.hvl.dat102.oppgave1;

public class Metoder {

	public static int sumNaturlige(int n) {
		
		if(n != 0) {
			return n + sumNaturlige(n - 1);
		} else {
			return n;
		}
		
	}
	
	public static int tallfolge(int n) {
		if (n == 0) return 2;
		if (n == 1) return 5;
		
		return 5 * tallfolge(n-1) - 6 * tallfolge(n -2) + 2;
	}
	
	public static long hanoiTid(int n) {
		TowersOfHanoi p = new TowersOfHanoi(n);
		long t1, t2;
		
		t1 = System.nanoTime();
		p.solve();
		t2 = System.nanoTime();
		
		return t2 - t1;
	}
	
}
