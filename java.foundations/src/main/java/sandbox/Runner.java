package sandbox;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Runner {

	public static void main(String[] args) throws IOException {
		
		Person person = new Person("name");
		Person name = person.setName( "Updated name" );
	
	}
	
	public static class Person {
		private String name;
		
		private List<String> addresses;
		
		public Person(String name2) {
			// TODO Auto-generated constructor stub
		}

		private Person setName( String name ) {
			return new Person( name );
		}
		
		private List<String> getAddresses() {
			return Collections.unmodifiableList(addresses);
		}
	}
}
