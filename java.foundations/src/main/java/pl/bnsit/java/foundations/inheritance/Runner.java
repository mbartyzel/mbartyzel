package pl.bnsit.java.foundations.inheritance;

public class Runner {

	public static void main(String[] args) {
		Person person = new Person();
	}
	
	public static void wyplacWynagrodzenie( Person person ) {
		double payment = 0d;
		
		//oblicz dla niej wynagrodzenie
		
		System.out.println( "Wypłacam = " + payment + " rupii.");
	}
}
