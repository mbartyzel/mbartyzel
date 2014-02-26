package pl.bnsit.java.foundations.inheritance;

import java.util.HashSet;
import java.util.Set;

public class Person {

	private Set<Address> addresses = new HashSet<>();
	
	public void addAddress( Address address ) {
		addresses.add( address );
	}
}
