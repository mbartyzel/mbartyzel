package pl.bnsit.java.foundations.inheritance.simple;

import java.util.Scanner;

public class Runner {

	public static void main(String[] args) {
		System.out.println( "Podaj wydające dźwięk: DOG, COW, CAT, KOPARKA, DRUKARKA" );
		Scanner scanner = new Scanner(System.in);
		String wydajaceDzwiek = scanner.nextLine();
		
		WydajaceDzwiek obiekt = utworzWydajaceDzwiek(wydajaceDzwiek);
		obiekt.wydajDzwiek();
		
		scanner.close();
	}

	private static WydajaceDzwiek utworzWydajaceDzwiek(String type) {
		if( type.equals("DOG") ) {
			return new Dog();		
		} else if ( type.equals( "COW" ) ) {
			return new Cow();					
		} else if ( type.equals( "CAT" )) {
			return new Cat();
		} else if ( type.equals("KOPARKA")) {
			return new Koparka();
		} else if ( type.equals("DRUKARKA") ) {
			return new Drukarka();
		}
		return null;
	}
	
	private static Mammal utworzSsaka(String mammalType) {
		if( mammalType.equals("DOG") ) {
			return new Dog();		
		} else if ( mammalType.equals( "COW" ) ) {
			return new Cow();					
		} else if ( mammalType.equals( "CAT" )) {
			return new Cat();
		}
		return null;
	}
}
