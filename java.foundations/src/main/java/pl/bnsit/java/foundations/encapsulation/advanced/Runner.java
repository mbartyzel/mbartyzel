package pl.bnsit.java.foundations.encapsulation.advanced;

public class Runner {
	
	public static void main(String[] args) {
		
		//Wybieranie numeru
		Phone phone = new Phone();
		phone.pressFive();
		phone.pressZero();
		phone.pressThree();
		phone.pressZero();
		phone.pressSix();
		phone.pressTwo();
		phone.pressFour();
		phone.pressTwo();
		phone.pressOne();
		
		PhoneNumber phoneNumber = phone.getSelectedNumber();
		System.out.print( phoneNumber.getCountry() );
		System.out.println( phoneNumber.getNumber() );
		System.out.println( phoneNumber.getFormattedNumber(	) );
		
		phone.clear();
		System.out.println( phoneNumber.getFormattedNumber(	) );
		/*
		 * Na konsoli powinno pojawić się:
		 * 48503062421
		 * +48 503 062 421
		 * <pusta linia>
		 */
		
	}
}
