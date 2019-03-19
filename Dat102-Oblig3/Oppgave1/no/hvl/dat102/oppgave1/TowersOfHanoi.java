package no.hvl.dat102.oppgave1;

public class TowersOfHanoi {
	private int totalDisks;
	private long moves;

	public TowersOfHanoi(int disks) {
		totalDisks = disks;
	}

	public long solve() {
		moveTower(totalDisks, 1, 3, 2);
		return moves;
	}

	private void moveTower(int numDisks, int start, int end, int temp) {
		if (numDisks == 1)
			moveOneDisk(start, end);
		else {
			moveTower(numDisks - 1, start, temp, end);
			moveOneDisk(start, end);
			moveTower(numDisks - 1, temp, end, start);
		}
	}

	private void moveOneDisk(int start, int end) {
		moves++;
	}
}
