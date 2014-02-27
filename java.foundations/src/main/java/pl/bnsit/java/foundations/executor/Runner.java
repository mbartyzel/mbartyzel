package pl.bnsit.java.foundations.executor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class Runner {

	public static void main(String[] args) {
		List<String> strings = createStrings();
		
		long before = System.currentTimeMillis();
		oneThreadSorting( strings );
		long after = System.currentTimeMillis();
		System.out.println( "Sortowanie jednowątkowe: " + (after - before) + "ms" );
		
		before = System.currentTimeMillis();
		multiThreadSorting( strings );
		after = System.currentTimeMillis();
		System.out.println( "Sortowanie wielowątkowe: " + (after - before) + "ms" );
		
	}

	private static void multiThreadSorting(List<String> strings) {
		//Napisz implementację
	}

	private static void oneThreadSorting(List<String> strings) {
		Collections.sort(strings);
	}

	private static List<String> createStrings() {
		List<String> strings = new ArrayList<>();
		for( int i = 0; i < 1000000; ++i ) {
			strings.add( UUID.randomUUID().toString() );
		}
		
		return strings;
	}
}
