package pl.bnsit.java.foundations.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class ExecutorExample {

	public static void main(String[] args) throws InterruptedException {
		
		BankAccount account = new BankAccount();

		ExecutorService executor = Executors.newFixedThreadPool( 10 );
		
		executor.execute( new Task(account, 0) );
		executor.execute( new Task(account, 1) );
		
		executor.shutdown();
		executor.awaitTermination(10000000, TimeUnit.HOURS);
		
		System.out.println( "Stan konta:" + account );
	}
}
