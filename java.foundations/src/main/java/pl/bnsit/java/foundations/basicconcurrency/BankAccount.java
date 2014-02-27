package pl.bnsit.java.foundations.basicconcurrency;

class BankAccount {
	private int from = 100;
	private int to = 0;

	public void transfer(int amout) {
		from -= amout;
		to += amout;
	}

	@Override
	public String toString() {
		return "from = " + from + " , to = " + to;
	}
}