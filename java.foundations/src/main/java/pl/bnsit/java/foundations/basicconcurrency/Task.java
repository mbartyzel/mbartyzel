package pl.bnsit.java.foundations.basicconcurrency;

class Task implements Runnable {

	private int id;

	private BankAccount account;

	public Task(BankAccount account, int id) {
		this.account = account;
		this.id = id;
	}

	@Override
	public void run() {
		System.out.println("Thread #" + id + " is working");
		for(int i = 0; i < 10; ++i ) {
			account.transfer(1);
			sleep(i * 50);
		}
	}
	
	private void sleep( int millis ) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}