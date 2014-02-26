package pl.bnsit.java.foundations.mapiterator;

import java.util.HashMap;
import java.util.Map;

public class Runner {

	public static void main(String[] args) {
	
		Map<Long, String> cities = new HashMap<>(); 
		cities.put(1L, "Uć");
		cities.put(2L, "Bedoń");
		cities.put(3L, "Poświętne");
		
		MapIterator<Long, String> mapIterator = new MapIterator<>(cities);
		while( mapIterator.hasNext() ) {
			mapIterator.moveNext();
			
			System.out.println( mapIterator.key() );
			System.out.println( mapIterator.value() );
		}
	}
}
