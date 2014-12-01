package pl.bnsit.java.foundations.inheritance.simple;

import java.util.Scanner;

public class Runner {

	public static void main(String[] args) {
		System.out.println( "Podaj ssaka: DOG, COW, CAT" );
		Scanner scanner = new Scanner(System.in);
		
		String mammalType = scanner.nextLine();
		if( mammalType.equals("DOG") ) {
			
			System.out.println( "Dog is waking up..." );
			System.out.println( "Wolf, wolf!" );
			
		} else if ( mammalType.equals( "COW" ) ) {
			
			System.out.println( "Cow is waking up..." );
			System.out.println( "Muuuuuuuuuuu!" );
			
		} else if ( mammalType.equals( "CAT" )) {
			
			System.out.println( "Cat is waking up..." );
			System.out.println( "Miaaaaauuuuu!" );
		}
		
		scanner.close();
	}
}
