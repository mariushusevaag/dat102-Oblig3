package no.hvl.dat102.oppgave1;

public class Main {

	public static void main(String[] args) {
		//Oppgave 1a)
		System.out.println("\nOppgave 1a)\n");
		System.out.println("Sum av de 100 første naturlige tall:");
		System.out.println(Metoder.sumNaturlige(100));
		
		//Oppgave 1b)
		System.out.println("\nOppgave 1b)\n");
		System.out.println("10 første ledd i tallfølgen:");
		for (int i = 0; i < 10; i++) {
			System.out.print(Metoder.tallfolge(i) + " ");
		}
		System.out.println();
		
		//Oppgave 1c)
		System.out.println("\nOppgave 1c)\n");
		System.out.println(String.format("24 ringer: %8s µs", Metoder.hanoiTid(24) / 1000));
		System.out.println(String.format("28 ringer: %8s µs", Metoder.hanoiTid(28) / 1000));
		System.out.println(String.format("32 ringer: %8s µs", Metoder.hanoiTid(32) / 1000));
	}
}
