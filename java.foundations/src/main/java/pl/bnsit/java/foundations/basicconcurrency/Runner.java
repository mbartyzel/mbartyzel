package pl.bnsit.java.foundations.basicconcurrency;


public class Runner {

	public static void main(String[] args) throws InterruptedException {
		final int THREADS_NUM = 1;
		
		BankAccount account = new BankAccount();
		Thread[] threads = new Thread[ THREADS_NUM ];
		
		int i = 0;
		for (; i < THREADS_NUM; ++i) {
			Thread aThread = new Thread(new Task(account, i));
			threads[ i ] = aThread;
			aThread.start();
		}

		for (Thread thread : threads) {
			thread.join();
		}
		
		System.out.println( "Stan konta:" + account );
	}
}
